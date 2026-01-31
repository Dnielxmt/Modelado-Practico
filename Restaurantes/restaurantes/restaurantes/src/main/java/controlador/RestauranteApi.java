package controlador;

import java.util.List;

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

import modelo.Direccion;
import modelo.DireccionDTO;
import modelo.Login;
import modelo.Registro;
import modelo.Restaurante;
import modelo.RestauranteDTO;
import repositorio.RestauranteRepo;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping({"/restaurantes", "/Restaurantes"})
public class RestauranteApi {

    private final RestauranteRepo restauranteRepository;

    public RestauranteApi(RestauranteRepo restauranteRepository) {
        this.restauranteRepository = restauranteRepository;
    }

    /**
     * Obtener todos los restaurantes
     * @return
     */
    @GetMapping(produces = "application/json")
    public List<Restaurante> getRestaurantes() {
        return restauranteRepository.findAll();
    }

    /**
     * Obtener restaurante por correo
     * @param correo: correo del restaurante
     * @return
     */
    @GetMapping(value = "/email/{correo}", produces = "application/json")
    public Restaurante getRestauranteByCorreo(@PathVariable("correo") String correo) {
        return restauranteRepository.findByCorreo(correo)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Restaurante no encontrado"));
    }

    /**
     * Registrar nuevo restaurante
     * @param dto: restaurante a registrar con valores mínimos
     * @return
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public String registrarRestaurante(@RequestBody Registro dto) {
        try {
            // Crear objeto Restaurante
            String passwordCodificada = Restaurante.convertirSHA256(dto.getContrasena());
            Restaurante restaurante = new Restaurante();

            restaurante.setNombre(dto.getNombre());
            restaurante.setCorreo(dto.getCorreo());
            restaurante.setContrasena(passwordCodificada);

            restauranteRepository.saveAndFlush(restaurante);
            return "Restaurante registrado correctamente";

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Error al registrar restaurante");
        }
    }

    /**
     * Modificar restaurante existente
     * @param id: Id del restaurante a modificar
     * @param dto: Nuevos datos del restaurante
     * @return
     */
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String modificarRestaurante(@PathVariable("id") int id, @RequestBody RestauranteDTO dto) {
        Restaurante restaurante = restauranteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Restaurante no encontrado"));

        try {

            if (dto.getNombre() != null && !dto.getNombre().isEmpty()) {
                restaurante.setNombre(dto.getNombre());
            }

            if (dto.getCorreo() != null && !dto.getCorreo().isEmpty()) {
                restaurante.setCorreo(dto.getCorreo());
            }

            if (dto.getContrasena() != null && !dto.getContrasena().isEmpty()) {
                restaurante.setContrasena(Restaurante.convertirSHA256(dto.getContrasena()));
            }

            if (dto.getCapacidad() > 0) {  
                restaurante.setCapacidad(dto.getCapacidad());
            }

            if (dto.getInfoAdicional() != null && !dto.getInfoAdicional().isEmpty()) {
                restaurante.setInfoAdicional(dto.getInfoAdicional());
            }

            if (dto.getLinkWeb() != null && !dto.getLinkWeb().isEmpty()) {
                restaurante.setLinkWeb(dto.getLinkWeb());
            }


            // Modificar dirección
            DireccionDTO dDto = dto.getDireccion();
            Direccion direccion = restaurante.getDireccion();
            if (direccion == null) {
                direccion = new Direccion();
            }
            if (dDto.getNombreVia() != null && !dDto.getNombreVia().isEmpty()) {
                direccion.setNombreVia(dDto.getNombreVia());
            }

            if (dDto.getTipoVia() != null && !dDto.getTipoVia().isEmpty()) {
                direccion.setTipoVia(dDto.getTipoVia());
            }

            if (dDto.getNumero() > 0) { // solo actualizar si el número no es 0
                direccion.setNumero(dDto.getNumero());
            }

            if (dDto.getCodigoPostal() != null && !dDto.getCodigoPostal().isEmpty()) {
                direccion.setCodigoPostal(dDto.getCodigoPostal());
            }

            if (dDto.getOtraInfo() != null && !dDto.getOtraInfo().isEmpty()) {
                direccion.setOtraInfo(dDto.getOtraInfo());
            }

            restaurante.setDireccion(direccion);

            restauranteRepository.save(restaurante);
            return "Restaurante modificado correctamente";

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Error al modificar restaurante");
        }
    }

    /**
     * Iniciar sesión de restaurante
     * @param login: Objeto Login con correo y contraseña
     * @return: Contraseña codificada del restaurante
     */
    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean iniciarSesion(@RequestBody Login login) {
        Restaurante restaurante = restauranteRepository.findByCorreo(login.getCorreo())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Restaurante no encontrado"));


        if (restaurante==null) return false;
        String hashInput = Restaurante.convertirSHA256(login.getContrasena());

        return restaurante.getContrasena().equals(hashInput);
    }
}
