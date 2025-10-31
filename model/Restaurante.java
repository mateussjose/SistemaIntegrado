package model;

public class Restaurante {
    private String id, nome;
    private double faturamento;

    public Restaurante(String id, String nome) { this.id = id; this.nome = nome; this.faturamento = 0; }

    public void adicionarFaturamento(double valor) { faturamento += valor; }
    public String getNome() { return nome; }
    public double getFaturamento() { return faturamento; }

    @Override
    public String toString() { return nome + " (R$ " + faturamento + ")"; }
}
