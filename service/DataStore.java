package service;


import model.*;
import java.util.ArrayList;
import java.util.List;


// DataStore usa listas (vetor dinâmico) para guardar dados em memória
public class DataStore {
    private List<Paciente> pacientes = new ArrayList<>();
    private List<Evento> eventos = new ArrayList<>();
    private List<Clinica> clinicas = new ArrayList<>();
    private List<Restaurante> restaurantes = new ArrayList<>();
    private List<model.MealRecord> mealRecords = new ArrayList<>(); // registros de refeições (classe interna simples criada no service)
    private List<model.ConsultaRecord> consultaRecords = new ArrayList<>(); // registros de consultas


    public List<Paciente> getPacientes() { return pacientes; }
    public List<Evento> getEventos() { return eventos; }
    public List<Clinica> getClinicas() { return clinicas; }
    public List<Restaurante> getRestaurantes() { return restaurantes; }


    public List<model.MealRecord> getMealRecords() { return mealRecords; }
    public List<model.ConsultaRecord> getConsultaRecords() { return consultaRecords; }
}