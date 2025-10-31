package model;

public class ConsultaRecord {
    private Paciente paciente;
    private String tipoConsulta;

    public ConsultaRecord(Paciente paciente, String tipo) { this.paciente = paciente; this.tipoConsulta = tipo; }
    public Paciente getPaciente() { return paciente; }
    public String getTipoConsulta() { return tipoConsulta; }
}
