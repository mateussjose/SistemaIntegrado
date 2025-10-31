package model;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Evento {
    private String id;
    private String titulo;
    private String tipo; // PALESTRA, OFICINA, SHOW
    private LocalDate data;
    private double receita;
    private List<String> participantes; // lista dinâmica (vetor dinâmico)


    public Evento(String id, String titulo, String tipo, LocalDate data) {
        this.id = id;
        this.titulo = titulo;
        this.tipo = tipo;
        this.data = data;
        this.participantes = new ArrayList<>();
        this.receita = 0.0;
    }


    public String getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getTipo() { return tipo; }
    public LocalDate getData() { return data; }
    public double getReceita() { return receita; }
    public void setReceita(double receita) { this.receita = receita; }


    public List<String> getParticipantes() { return participantes; }
    public void addParticipante(String pacienteId) { participantes.add(pacienteId); }


    @Override
    public String toString() { return titulo + " (" + tipo + ") - " + data; }
}