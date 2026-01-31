package repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import modelo.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    // Buscar cliente por correo
    Optional<Cliente> findByCorreo(String correo);
}
