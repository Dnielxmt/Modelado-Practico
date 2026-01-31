package modelado.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import modelado.modelo.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    // Buscar cliente por correo
    Optional<Cliente> findByCorreo(String correo);
}
