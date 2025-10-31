package application;


import controller.SistemaController;
import model.exception.AnaliseException;


public class Main {
    public static void main(String[] args) {
        try {
            SistemaController controller = new SistemaController();
            controller.exibirRelatorios();
        } catch (AnaliseException ae) {
            System.out.println("Erro de análise: " + ae.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }
    }
}