package service;

import java.time.LocalDate;
import java.util.List;
import model.*;

public class Seeder {
    public static void seed(DataStore ds) {

        Paciente p1 = new Paciente("P1", "Ana", 9, true);
        Paciente p2 = new Paciente("P2", "Bruno", 47, false);
        Paciente p3 = new Paciente("P3", "Carlos", 37, true);
        Paciente p4 = new Paciente("P4", "Duda", 22, true);

        ds.pacientes.addAll(List.of(p1, p2, p3, p4));
        ds.pessoas.addAll(ds.pacientes);

        Clinica c1 = new Clinica("C1", "Clínica Central");
        ds.clinicas.add(c1);

        Restaurante r1 = new Restaurante("R1", "Rest Fit");
        ds.restaurantes.add(r1);

        Evento palestra = new Evento("E1", "Palestra Saúde", "Palestra", LocalDate.now().minusDays(10));
        palestra.addParticipante("P1");
        palestra.addParticipante("P3");
        palestra.setReceita(300);

        Evento corrida = new Evento("E2", "Corrida Solidária", "Esportivo", LocalDate.now().minusDays(5));
        corrida.addParticipante("P2");
        corrida.addParticipante("P3");
        corrida.addParticipante("P4");
        corrida.setReceita(900);

        ds.eventos.add(palestra);
        ds.eventos.add(corrida);

        ds.consultaRecords.add(new ConsultaRecord(p1, "Nutricional"));
        ds.consultaRecords.add(new ConsultaRecord(p3, "Clínica"));

        ds.mealRecords.add(new MealRecord(p1, true));
        ds.mealRecords.add(new MealRecord(p1, true));
        ds.mealRecords.add(new MealRecord(p3, false));
        ds.mealRecords.add(new MealRecord(p3, true));

        r1.adicionarFaturamento(500);
        r1.adicionarFaturamento(250);

        ds.cupons.add(new CupomRecord("P1", "E1"));
        ds.cupons.add(new CupomRecord("P4", "E2"));
    }
}
