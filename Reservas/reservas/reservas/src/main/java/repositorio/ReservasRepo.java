package repositorio;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import modelo.Reserva.Reserva;

public interface ReservasRepo extends JpaRepository<Reserva, Integer> {

    // Cliente
    List<Reserva> findByIdUsuario(int idUsuario);
    List<Reserva> findByIdUsuarioAndFecha(int idUsuario, LocalDate fecha);
    List<Reserva> findByIdUsuarioAndEstadoReservaTrue(int idUsuario);

    // Restaurante
    List<Reserva> findByIdRestaurante(int idRestaurante);
    List<Reserva> findByIdRestauranteAndFecha(int idRestaurante, LocalDate fecha);
    List<Reserva> findByIdRestauranteAndFechaAndEstadoReservaTrue(
            int idRestaurante, LocalDate fecha);

}