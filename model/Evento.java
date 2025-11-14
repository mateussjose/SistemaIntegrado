package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Evento {
    private String id, titulo, tipo;
    private LocalDate data;
    private List<String> participantes = new ArrayList<>();
    private double receita = 0;

    public Evento(String id, String titulo, String tipo, LocalDate data) {
        this.id = id; this.titulo = titulo; this.tipo = tipo; this.data = data;
    }

    public void addParticipante(String pacienteId) { participantes.add(pacienteId); }
    public List<String> getParticipantes() { return participantes; }
    public String getTitulo() { return titulo; }
    public double getReceita() { return receita; }
    public void setReceita(double receita) { this.receita = receita; }
    public String getTipo() { return tipo; }
    public String getId() { return id; }

    @Override
    public String toString() { return titulo + " (" + tipo + ") - " + data; }
}
