package modelado.controlador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import modelado.modelo.Login;
import modelado.modelo.Registro;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/login")
public class LoginApi {

    @Autowired
    private RestTemplate restTemplate;

    private static final String NOMBRE_TOKEN = "ModeladoDistribuido";

    
    /**
     * Iniciar sesión
     * @param login: datos de login
     * @param restaurante: indica si es restaurante o cliente
     * @return Token de sesión o mensaje de error
    */
    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> login(@RequestBody Login login,
                                        @RequestParam boolean restaurante) {

        // Decide a qué API enviar el login
        String ruta = restaurante
            ? "http://Restaurante-API:8082/restaurantes/login"
            : "http://Cliente-API:8083/clientes/login";

        Boolean valido;
        try {
            // Manda el JSON tal cual y recibe true/false
            valido = restTemplate.postForObject(ruta, login, Boolean.class);
        } catch (Exception e) {
            throw new ResponseStatusException(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "Error al validar credenciales"
            );
        }

        if (Boolean.TRUE.equals(valido)) {
            // Genera token con nombre fijo
            String token = login.conseguirToken(NOMBRE_TOKEN);

            // Valida token antes de devolverlo
            if (login.validarToken(token, NOMBRE_TOKEN)) {
                return ResponseEntity.ok(token);
            }
        }

        return ResponseEntity
            .status(HttpStatus.FORBIDDEN)
            .body("correo o contraseña incorrectos");
    }

    /**
     * Registrar nuevo usuario (cliente o restaurante)
     * @param dto: datos de registro
     * @return Mensaje de éxito o error
    */
    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> registrar(@RequestBody Registro dto) {

        // Decide a qué API enviar el registro
        String ruta = dto.isRestaurante()
            ? "http://Restaurante-API:8082/restaurantes/registro"
            : "http://Cliente-API:8083/clientes/registro";

        try {
            restTemplate.postForObject(ruta, dto, String.class);
        } catch (Exception e) {
            throw new ResponseStatusException(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "Error al registrar usuario"
            );
        }

        return ResponseEntity.ok("Usuario registrado correctamente");
    }
}