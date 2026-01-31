package repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import modelo.Restaurante;

public interface RestauranteRepo extends JpaRepository<Restaurante, Integer> {

    // Buscar restaurante por email
    Optional<Restaurante> findByCorreo(String correo);

}
