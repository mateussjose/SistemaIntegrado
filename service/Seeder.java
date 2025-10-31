package service;

import model.*;
import java.time.LocalDate;

public class Seeder {
    public static void seed(DataStore ds) {
        Paciente p1 = new Paciente("P1", "Ana", 30, true);
        Paciente p2 = new Paciente("P2", "Bruno", 45, false);
        ds.pacientes.add(p1); ds.pacientes.add(p2);

        Clinica c1 = new Clinica("C1", "Clínica Central");
        ds.clinicas.add(c1);

        Restaurante r1 = new Restaurante("R1", "Rest Fit");
        ds.restaurantes.add(r1);

        Evento e1 = new Evento("E1", "Palestra Saúde", "Palestra", LocalDate.now());
        ds.eventos.add(e1);
    }
}
