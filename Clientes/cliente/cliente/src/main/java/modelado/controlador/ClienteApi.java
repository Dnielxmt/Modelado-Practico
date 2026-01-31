package modelado.controlador;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import modelado.modelo.Cliente;
import modelado.modelo.ClienteDTO;
import modelado.modelo.Login;
import modelado.modelo.Registro;
import modelado.repositorio.ClienteRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping({"/clientes", "/Clientes"})
public class ClienteApi {

    private final ClienteRepository clienteRepository;

    public ClienteApi(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    /**
	 * Obtener cliente por ID
	 * @param id: id del cliente
	 * @return 	Cliente
	 */
    @GetMapping(value = "/{id}", produces = "application/json")
    public Cliente getClienteById(@PathVariable("id") int id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado"));
    }

    /**
	 * Registrar nuevo cliente
	 * @param dto: datos del cliente
	 * @return Mensaje de éxito o error
	 */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public String registrarCliente(@RequestBody Registro dto) {
        try {
                Cliente cliente = new Cliente(
                        dto.getNombre(),
                        dto.getCorreo(),
                        dto.getContrasena() // se convierte a SHA-256 en el setter/constructor
                );

            clienteRepository.saveAndFlush(cliente);
            return "Cliente registrado correctamente";

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Error al registrar cliente");
        }
    }

    /**
	 * Modificar cliente existente
	 * @param id: id del cliente a modificar
	 * @param dto: datos a modificar
	 * @return Mensaje de éxito o error
	 */
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String modificarCliente(@PathVariable("id") int id, @RequestBody ClienteDTO dto) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado"));

        try {
            if (dto.getNombre() != null && !dto.getNombre().isEmpty()) {
                cliente.setNombre(dto.getNombre());
            }
            if (dto.getCorreo() != null && !dto.getCorreo().isEmpty()) {
                cliente.setCorreo(dto.getCorreo());
            }
            if (dto.getContrasena() != null && !dto.getContrasena().isEmpty()) {
                cliente.setContrasena(dto.getContrasena()); // se convierte a SHA-256 en el setter
            }

            clienteRepository.save(cliente);
            return "Cliente modificado correctamente";

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Error al modificar cliente");
        }
    }

    /**
	 * Iniciar sesión
	 * @param correo: correo del cliente
	 * @param contrasena: contraseña del cliente
	 * @return true si las credenciales son correctas, false en caso contrario
	 */
    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean iniciarSesion(@RequestBody Login login) {
        Cliente cliente = clienteRepository.findByCorreo(login.getCorreo())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado"));

        if (cliente == null) return false;
        String hashInput = Cliente.convertirSHA256(login.getContrasena());
        return cliente.getContrasena().equals(hashInput);
    }
}
