package model;

import java.time.LocalDate;
import java.util.Random;

public class ConsultaRecord {
    private Paciente paciente;
    private String tipoConsulta;
    private LocalDate data;

    public ConsultaRecord(Paciente paciente, String tipo) {
        this.paciente = paciente;
        this.tipoConsulta = tipo;

        this.data = LocalDate.now().minusDays(new Random().nextInt(7));
    }

    public Paciente getPaciente() { return paciente; }
    public String getTipoConsulta() { return tipoConsulta; }
    public LocalDate getData() { return data; }
}

