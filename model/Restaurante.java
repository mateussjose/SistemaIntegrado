package model;


public class Restaurante {
    private String id;
    private String nome;
    private double faturamento;


    public Restaurante(String id, String nome) {
        this.id = id;
        this.nome = nome;
        this.faturamento = 0.0;
    }


    public String getId() { return id; }
    public String getNome() { return nome; }
    public double getFaturamento() { return faturamento; }


    public void adicionarFaturamento(double valor) {
        faturamento += valor;
    }


    @Override
    public String toString() { return nome + " (R$ " + faturamento + ")"; }
}