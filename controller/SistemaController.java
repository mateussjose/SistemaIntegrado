package controller;

import service.AnaliseService;
import service.DataStore;
import service.Seeder;

public class SistemaController {
    private final AnaliseService service;

    public SistemaController() {
        DataStore ds = new DataStore();
        Seeder.seed(ds);
        service = new AnaliseService(ds);
    }

    public void relatorioFrequenciaPorDia() {
        System.out.println("Frequência por dia:");
        service.rankFrequenciaPorDia().forEach((d,r) -> System.out.println(d + " => " + r));
    }

    public void relatorioEventosMaisPacientes() {
        System.out.println("Eventos que geraram mais pacientes:");
        service.eventosQueGeraramMaisPacientes(3)
                .forEach((e,c) -> System.out.println(e + " -> " + c + " pacientes"));
    }

    public void relatorioSetorRestaurante() {
        System.out.println("Setor que mais motiva ida ao restaurante: " + service.setorQueMotivaRestaurante());
    }

    public void relatorioAumentoRefSaudavel() {
        System.out.println("Aumento consumo refeições saudáveis? " +
                (service.aumentoConsumoAposConsultaNutricional() ? "Sim" : "Não detectado"));
    }

    public void relatorioFaixaEtariaEventos() {
        System.out.println("Faixa etária eventos: " + service.faixaEtariaMaisAtivaEmEventos());
    }

    public void relatorioFaixaEtariaClinicas() {
        System.out.println("Faixa etária clínicas: " + service.faixaEtariaMaisAtivaEmClinica());
    }

    public void relatorioParticipantesCupons() {
        System.out.println("Participantes que usaram cupons: " + service.participantesEventosQueUsaramCupons());
    }

    public void relatorioPercentualClinicas() {
        System.out.printf("Percentual clínicas após palestras: %.2f%%\n", service.percentualQueForamClinicaAposPalestra() * 100);
    }

    public void relatorioSatisfacao() {
        System.out.println("Satisfação ecossistema vs isolados: " + service.satisfacaoEcossistemaMaiorQueIsolados());
    }

    public void relatorioRetornoFinanceiro() {
        System.out.printf("Retorno financeiro total: R$ %.2f\n", service.retornoFinanceiroTotal());
    }
}
