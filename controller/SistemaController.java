package controller;


import service.AnaliseService;
import service.Seeder;
import service.DataStore;
import model.exception.AnaliseException;


public class SistemaController {
    private AnaliseService service;
    private DataStore dataStore;


    public SistemaController() throws AnaliseException {
        try {
            dataStore = new DataStore();
            Seeder.seed(dataStore);
            service = new AnaliseService(dataStore);
        } catch (Exception e) {
            throw new AnaliseException("Falha ao inicializar o sistema: " + e.getMessage(), e);
        }
    }


    public void exibirRelatorios() {
        try {
            System.out.println("==== RELATÓRIOS DO ECOSSISTEMA ====");


            System.out.println("\n1) Rank de frequência por dia da semana:");
            service.rankFrequenciaPorDia().forEach((d, r) -> System.out.println(d + " => " + r));


            System.out.println("\n2) Eventos que geraram mais pacientes na clínica:");
            service.eventosQueGeraramMaisPacientes(5).forEach((e, c) -> System.out.println(e + " -> " + c + " pacientes"));


            System.out.println("\n3) Setor que mais motiva ida ao restaurante:");
            System.out.println(service.setorQueMotivaRestaurante());


            System.out.println("\n4) Aumento no consumo de refeições saudáveis após consultas nutricionais?");
            System.out.println(service.aumentoConsumoAposConsultaNutricional() ? "Sim" : "Não detectado");


            System.out.println("\n5) Faixa etária mais ativa em eventos e clínicas:");
            System.out.println("Eventos: " + service.faixaEtariaMaisAtivaEmEventos());
            System.out.println("Clínicas: " + service.faixaEtariaMaisAtivaEmClinica());


            System.out.println("\n6) Participantes de eventos que usaram cupons:");
            System.out.println(service.participantesEventosQueUsaramCupons() + " participantes");


            System.out.println("\n7) Percentual que foram às clínicas após palestras:");
            System.out.printf("%.2f%%\n", service.percentualQueForamClinicaAposPalestra() * 100);


            System.out.println("\n8) Satisfação do ecossistema vs isolados:");
            System.out.println(service.satisfacaoEcossistemaMaiorQueIsolados());


            System.out.println("\n9) Retorno financeiro total:");
            System.out.printf("R$ %.2f\n", service.retornoFinanceiroTotal());


        } catch (AnaliseException ae) {
            System.out.println("Erro na geração de relatórios: " + ae.getMessage());
        } catch (NullPointerException ne) {
            System.out.println("Dados insuficientes (NPE): " + ne.getMessage());
        } catch (ArithmeticException ae) {
            System.out.println("Erro aritmético durante análises: " + ae.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado ao exibir relatórios: " + e.getMessage());
        }
    }
}