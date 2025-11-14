package model;

public class CupomRecord {
    private String pacienteId;
    private String eventoId;

    public CupomRecord(String pacienteId, String eventoId) {
        this.pacienteId = pacienteId;
        this.eventoId = eventoId;
    }

    public String getPacienteId() { return pacienteId; }
    public String getEventoId() { return eventoId; }
}
