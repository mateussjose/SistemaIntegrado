package service;


import model.*;
import java.time.LocalDate;


public class Seeder {
    public static void seed(DataStore ds) {
// criar pacientes (ids simples)
        Paciente p1 = new Paciente("P1","Ana", 30, true);
        Paciente p2 = new Paciente("P2","Bruno", 45, false);
        Paciente p3 = new Paciente("P3","Carlos", 68, false);
        Paciente p4 = new Paciente("P4","Daniela", 22, true);
        Paciente p5 = new Paciente("P5","Eduardo", 50, true);


        ds.getPacientes().add(p1);
        ds.getPacientes().add(p2);
        ds.getPacientes().add(p3);
        ds.getPacientes().add(p4);
        ds.getPacientes().add(p5);


// clinicas
        Clinica c1 = new Clinica("C1", "Clínica Central");
        Clinica c2 = new Clinica("C2", "Clínica Especial");
        ds.getClinicas().add(c1);
        ds.getClinicas().add(c2);


// restaurantes
        Restaurante r1 = new Restaurante("R1", "Rest Fit");
        Restaurante r2 = new Restaurante("R2", "Sabor Saudável");
        ds.getRestaurantes().add(r1);
        ds.getRestaurantes().add(r2);