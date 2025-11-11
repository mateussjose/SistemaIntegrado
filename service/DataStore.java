package service;

import model.*;
import java.util.ArrayList;
import java.util.List;

public class DataStore {
    public List<Pessoa> pessoas = new ArrayList<>();
    public List<Paciente> pacientes = new ArrayList<>();
    public List<Clinica> clinicas = new ArrayList<>();
    public List<Restaurante> restaurantes = new ArrayList<>();
    public List<Evento> eventos = new ArrayList<>();
    public List<MealRecord> mealRecords = new ArrayList<>();
    public List<ConsultaRecord> consultaRecords = new ArrayList<>();
}
