package model;

public class MealRecord {
    private Paciente paciente;
    private boolean refeicaoSaudavel;

    public MealRecord(Paciente paciente, boolean refeicaoSaudavel) { this.paciente = paciente; this.refeicaoSaudavel = refeicaoSaudavel; }
    public boolean isRefeicaoSaudavel() { return refeicaoSaudavel; }
    public Paciente getPaciente() { return paciente; }
}
