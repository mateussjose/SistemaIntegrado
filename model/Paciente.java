package model;

public class Paciente extends Pessoa {
    private String id;
    private boolean fezConsultaNutricional;

    public Paciente(String id, String nome, int idade, boolean fezConsulta) {
        super(nome, idade);
        this.id = id;
        this.fezConsultaNutricional = fezConsulta;
    }

    public String getId() { return id; }
    public boolean isFezConsultaNutricional() { return fezConsultaNutricional; }

    @Override
    public String getTipo() { return "Paciente"; }

    @Override
    public String toString() { return id + " - " + getNome() + " (" + getIdade() + ")"; }

    @Override
public String getDescricao() {
    return "Paciente " + getNome() + " (" + getIdade() + " anos) - ID: " + id;
}
}
