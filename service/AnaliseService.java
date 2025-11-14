package service;

import java.time.format.TextStyle;
import java.util.*;
import model.*;

public class AnaliseService {
    private DataStore ds;

    public AnaliseService(DataStore ds) { this.ds = ds; }

    public Map<String,Integer> rankFrequenciaPorDia() {
        Map<String,Integer> mapa = new LinkedHashMap<>();
        for (ConsultaRecord c : ds.consultaRecords) {
            String diaSemana = c.getData().getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("pt","BR"));
            mapa.put(diaSemana, mapa.getOrDefault(diaSemana, 0) + 1);
        }
        return mapa;
    }

    public Map<String,Integer> eventosQueGeraramMaisPacientes(int top) {
        return ds.eventos.stream()
                .sorted((a,b) -> Integer.compare(b.getParticipantes().size(), a.getParticipantes().size()))
                .limit(top)
                .collect(LinkedHashMap::new,
                         (m,e) -> m.put(e.getTitulo(), e.getParticipantes().size()),
                         LinkedHashMap::putAll);
    }

    public String setorQueMotivaRestaurante() {
        long nutricional = ds.consultaRecords.stream()
                .filter(c -> c.getTipoConsulta().equalsIgnoreCase("Nutricional"))
                .count();
        return nutricional > 0 ? "Clínica Nutricional" : "Eventos";
    }

    public boolean aumentoConsumoAposConsultaNutricional() {

        long antes = ds.mealRecords.stream()
                .filter(m -> !m.getPaciente().isFezConsultaNutricional())
                .filter(MealRecord::isRefeicaoSaudavel)
                .count();

        long depois = ds.mealRecords.stream()
                .filter(m -> m.getPaciente().isFezConsultaNutricional())
                .filter(MealRecord::isRefeicaoSaudavel)
                .count();

        return depois > antes;
    }

    private String faixaPorIdade(int idade) {
        if (idade < 18) return "<18";
        if (idade < 30) return "18-29";
        if (idade < 40) return "30-39";
        if (idade < 50) return "40-49";
        return "50+";
    }

    public String faixaEtariaMaisAtivaEmEventos() {
        Map<String,Integer> cont = new HashMap<>();

        for (Evento e : ds.eventos) {
            for (String id : e.getParticipantes()) {
                ds.pacientes.stream().filter(x -> x.getId().equals(id)).findFirst()
                        .ifPresent(p -> {
                            String faixa = faixaPorIdade(p.getIdade());
                            cont.put(faixa, cont.getOrDefault(faixa, 0) + 1);
                        });
            }
        }

        return cont.entrySet()
                .stream().max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey).orElse("Nenhuma");
    }

    public String faixaEtariaMaisAtivaEmClinica() {
        Map<String,Integer> cont = new HashMap<>();

        for (ConsultaRecord c : ds.consultaRecords) {
            String faixa = faixaPorIdade(c.getPaciente().getIdade());
            cont.put(faixa, cont.getOrDefault(faixa, 0) + 1);
        }

        return cont.entrySet()
                .stream().max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey).orElse("Nenhuma");
    }

    public int participantesEventosQueUsaramCupons() {

        return (int) ds.cupons.stream().map(CupomRecord::getPacienteId).distinct().count();
    }

    public double percentualQueForamClinicaAposPalestra() {

        Evento palestra = ds.eventos.stream()
                .filter(e -> e.getTipo().equalsIgnoreCase("Palestra"))
                .findFirst().orElse(null);

        if (palestra == null) return 0;

        long total = palestra.getParticipantes().size();
        long foramClinica = ds.consultaRecords.stream()
                .filter(c -> palestra.getParticipantes().contains(c.getPaciente().getId()))
                .count();

        return total == 0 ? 0 : (double) foramClinica / total;
    }

    public boolean satisfacaoEcossistemaMaiorQueIsolados() {
        long ecossistema = ds.pacientes.stream()
                .filter(p -> participouDeEventos(p) && fezConsulta(p))
                .count();

        long isolados = ds.pacientes.stream()
                .filter(p -> !(participouDeEventos(p) && fezConsulta(p)))
                .count();

        return ecossistema > isolados;
    }

    private boolean participouDeEventos(Paciente p) {
        return ds.eventos.stream().anyMatch(e -> e.getParticipantes().contains(p.getId()));
    }

    private boolean fezConsulta(Paciente p) {
        return ds.consultaRecords.stream().anyMatch(c -> c.getPaciente().getId().equals(p.getId()));
    }

    public double retornoFinanceiroTotal() {
        double eventos = ds.eventos.stream().mapToDouble(Evento::getReceita).sum();
        double restaurantes = ds.restaurantes.stream().mapToDouble(Restaurante::getFaturamento).sum();
        double consultas = ds.consultaRecords.size() * 80; // preço fictício por consulta

        return eventos + restaurantes + consultas;
    }
}
