package controlador;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import modelo.Reserva.Reserva;
import modelo.Reserva.ReservaDTO;
import repositorio.ReservasRepo;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping({   "/Reserva",     "/Reserva",
                    "/Reserva/",    "/Reserva/",
                    "Reserva/",     "Reserva/",
                    "Reserva",      "Reserva"})
public class ReservaApi {

    private final ReservasRepo ReservasRepo;

    public ReservaApi(ReservasRepo ReservasRepo) {
        this.ReservasRepo = ReservasRepo;
    }
    /**
     * obtiene una o varias reservas segun los parametros recibidos
     * @param idRestaurante: Id del restaurante
     * @param idUsuario: Id del usuario
     * @param fecha: Fecha de la reserva
     * @return
     */
    @GetMapping(produces = "application/json")
    public List<Reserva> getReserva(
            @RequestParam(required = false) Integer idRestaurante,
            @RequestParam(required = false) Integer idUsuario,
            @RequestParam(required = false) LocalDate fecha) {

        if (idRestaurante != null && fecha != null) {
            return ReservasRepo.findByIdRestauranteAndFecha(idRestaurante, fecha);
        }
        else if (idUsuario != null && fecha != null) {
            return ReservasRepo.findByIdUsuarioAndFecha(idUsuario, fecha);
        }
        else if (idRestaurante != null) {
            return ReservasRepo.findByIdRestaurante(idRestaurante);
        }
        else if (idUsuario != null) {
            return ReservasRepo.findByIdUsuario(idUsuario);
        }
        else {
            return ReservasRepo.findAll();
        }
    }

    /**
     * Obtiene una reserva por el id
     * @param id: Id de la reserva buscada
     * @return
     */
    @GetMapping(value = "/{id}", produces = "application/json")
    public Reserva getReservaById(@PathVariable("id") int id) {
        return ReservasRepo.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Reserva no encontrada"));
    }

    /**
     * Crea una nueva reserva
     * @param dto: Reserva que se quiere crear
     * @return
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public String crearReserva(@RequestBody ReservaDTO dto) {

        try {
            Reserva nueva = new Reserva(dto); // estadoReserva = true

            ReservasRepo.saveAndFlush(nueva);
            return "Reserva creada correctamente";

        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.UNPROCESSABLE_ENTITY,
                    "No se pudo crear la reserva");
        }
    }

    /**
     * Modifica una reserva existente
     * @param id: Id de la reserva
     * @param dto: Reserva con los nuevos datos
     * @return
     */
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String modificarReserva(
            @PathVariable("id") int id,
            @RequestBody ReservaDTO dto) {

        Reserva reserva = ReservasRepo.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Reserva no encontrada"));

        try {
            reserva.setFecha(dto.getFecha());
            reserva.setHora(dto.getHora());
            reserva.setNumeroParticipantes(dto.getNumeroParticipantes());
            reserva.setIdUsuario(dto.getIdUsuario());
            reserva.setIdRestaurante(dto.getIdRestaurante());

            ReservasRepo.save(reserva);
            return "Reserva modificada correctamente";

        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.UNPROCESSABLE_ENTITY,
                    "No se pudo modificar la reserva");
        }
    }

    /**
     * Cancela una reserva existente
     * @param id: Id de la reserva existente
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public String cancelarReserva(@PathVariable("id") int id) {

        Reserva reserva = ReservasRepo.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Reserva no encontrada"));

        reserva.setEstadoReserva(false);
        ReservasRepo.save(reserva);

        return "Reserva cancelada correctamente";
    }
}
