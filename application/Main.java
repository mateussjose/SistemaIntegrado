package application;

import controller.SistemaController;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SistemaController controller = new SistemaController();
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        while(opcao != 0) {
            System.out.println("\n=== MENU DE RELATÓRIOS ===");
            System.out.println("1 - Frequência por dia");
            System.out.println("2 - Eventos que geraram mais pacientes");
            System.out.println("3 - Setor que motiva restaurante");
            System.out.println("4 - Aumento consumo refeições saudáveis");
            System.out.println("5 - Faixa etária mais ativa em eventos");
            System.out.println("6 - Faixa etária mais ativa em clínicas");
            System.out.println("7 - Participantes que usaram cupons");
            System.out.println("8 - Percentual clínicas após palestras");
            System.out.println("9 - Satisfação ecossistema vs isolados");
            System.out.println("10 - Retorno financeiro total");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch(Exception e) {
                System.out.println("Opção inválida!");
                continue;
            }

            switch(opcao) {
                case 1 -> controller.relatorioFrequenciaPorDia();
                case 2 -> controller.relatorioEventosMaisPacientes();
                case 3 -> controller.relatorioSetorRestaurante();
                case 4 -> controller.relatorioAumentoRefSaudavel();
                case 5 -> controller.relatorioFaixaEtariaEventos();
                case 6 -> controller.relatorioFaixaEtariaClinicas();
                case 7 -> controller.relatorioParticipantesCupons();
                case 8 -> controller.relatorioPercentualClinicas();
                case 9 -> controller.relatorioSatisfacao();
                case 10 -> controller.relatorioRetornoFinanceiro();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        }

        scanner.close();
    }
}
