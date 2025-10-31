package model;


public class Clinica {
    private String id;
    private String nome;
    private int consultas;


    public Clinica(String id, String nome) {
        this.id = id;
        this.nome = nome;
        this.consultas = 0;
    }


    public void registrarConsulta() { consultas++; }


    public String getId() { return id; }
    public String getNome() { return nome; }
    public int getConsultas() { return consultas; }


    @Override
    public String toString() { return nome + " (" + consultas + " consultas)"; }
}