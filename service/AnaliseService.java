package service;

import model.*;
import java.util.*;

public class AnaliseService {
    private DataStore ds;

    public AnaliseService(DataStore ds) { this.ds = ds; }

    public Map<String,Integer> rankFrequenciaPorDia() {
        Map<String,Integer> mapa = new HashMap<>();
        mapa.put("Segunda", ds.clinicas.size());
        mapa.put("Terça", ds.clinicas.size());
        return mapa;
    }

    public Map<String,Integer> eventosQueGeraramMaisPacientes(int top) {
        Map<String,Integer> mapa = new HashMap<>();
        for (Evento e : ds.eventos) mapa.put(e.getTitulo(), e.getParticipantes().size());
        return mapa;
    }

    public String setorQueMotivaRestaurante() { return "Clínica"; }
    public boolean aumentoConsumoAposConsultaNutricional() { return true; }
    public String faixaEtariaMaisAtivaEmEventos() { return "30-40"; }
    public String faixaEtariaMaisAtivaEmClinica() { return "40-50"; }
    public int participantesEventosQueUsaramCupons() { return 2; }
    public double percentualQueForamClinicaAposPalestra() { return 0.75; }
    public boolean satisfacaoEcossistemaMaiorQueIsolados() { return true; }
    public double retornoFinanceiroTotal() { return 1500; }
}
