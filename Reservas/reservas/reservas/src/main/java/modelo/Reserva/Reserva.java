package modelo.Reserva;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Reserva")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Reserva {

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Reserva other = (Reserva) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    int id;

    @Basic(optional = false)
    @Column(name = "fecha")
    LocalDate fecha;

    @Basic(optional = false)
    @Column(name = "hora")
    LocalTime hora;

    @Column(name = "numeroParticipantes")
    int numeroParticipantes;

    @Column(name = "idUsuario")
    int idUsuario;

    @Column(name = "idRestaurante")
    int idRestaurante;

    @Column(name = "estadoReserva", nullable = false)
    boolean estadoReserva;

    public Reserva() {}

    public Reserva(LocalDate fecha, LocalTime hora, int numeroParticipantes) {
        this.fecha = fecha;
        this.hora = hora;
        this.numeroParticipantes = numeroParticipantes;
        this.estadoReserva = true;
    }

    public Reserva(ReservaDTO dto) {
        this.fecha = dto.getFecha();
        this.hora = dto.getHora();
        this.numeroParticipantes = dto.getNumeroParticipantes();
        this.idUsuario = dto.getIdUsuario();
        this.idRestaurante = dto.getIdRestaurante();
        this.estadoReserva = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean isEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(boolean estadoReserva) {
        this.estadoReserva = estadoReserva;
    }
}
