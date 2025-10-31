package model;


public class Paciente extends Pessoa {
    private boolean fezConsultaNutricional;
    private String id; // id simples (pode ser UUID se desejar)


    public Paciente(String id, String nome, int idade, boolean fezConsultaNutricional) {
        super(nome, idade);
        this.fezConsultaNutricional = fezConsultaNutricional;
        this.id = id;
    }


    public boolean isFezConsultaNutricional() { return fezConsultaNutricional; }
    public void setFezConsultaNutricional(boolean fezConsultaNutricional) { this.fezConsultaNutricional = fezConsultaNutricional; }


    public String getId() { return id; }


    @Override
    public String getTipo() { return "Paciente"; }


    @Override
    public String toString() {
        return getId() + " - " + getNome() + " (" + getIdade() + ")";
    }
}