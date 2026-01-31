package modelo.Reserva;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservaDTO {

    private LocalDate fecha;
    private LocalTime hora;
    private int numeroParticipantes;
    private int idUsuario;
    private int idRestaurante;

    public ReservaDTO(LocalDate fecha, LocalTime hora, int numeroParticipantes, 
        int idUsuario, int idRestaurante) {

        this.fecha = fecha;
        this.hora = hora;
        this.numeroParticipantes = numeroParticipantes;
        this.idUsuario = idUsuario;
        this.idRestaurante = idRestaurante;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public int getNumeroParticipantes() {
        return numeroParticipantes;
    }

    public void setNumeroParticipantes(int numeroParticipantes) {
        this.numeroParticipantes = numeroParticipantes;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdRestaurante() {
        return idRestaurante;
    }

    public void setIdRestaurante(int idRestaurante) {
        this.idRestaurante = idRestaurante;
    }

}
