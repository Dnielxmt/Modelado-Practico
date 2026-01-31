package modelado.modelo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Restaurante")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false, unique = true)
    private int id;

    @Basic(optional = false)
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Basic(optional = false)
    @Column(name = "correo", nullable = false, unique = true)
    private String correo;

    @Basic(optional = false)
    @Column(name = "contrasena", nullable = false)
    private String contrasena;

    // Campos opcionales
    @Column(name = "capacidad", nullable = true)
    private Integer capacidad;

    @Column(name = "infoAdicional", nullable = true)
    private String infoAdicional;

    @Column(name = "linkWeb", nullable = true)
    private String linkWeb;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "direccionId", referencedColumnName = "id")
    private Direccion direccion;

    // ================== Constructores ==================

    // Constructor vacío requerido por JPA
    public Restaurante() {}

    public Restaurante(String nombre, String correo, String contrasena,
                       int capacidad, String infoAdicional, String linkWeb, Direccion direccion) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.capacidad = capacidad;
        this.infoAdicional = infoAdicional;
        this.linkWeb = linkWeb;
        this.direccion = direccion;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }

    public Integer getCapacidad() { return capacidad; }
    public void setCapacidad(Integer capacidad) { this.capacidad = capacidad; }

    public String getInfoAdicional() { return infoAdicional; }
    public void setInfoAdicional(String infoAdicional) { this.infoAdicional = infoAdicional; }

    public String getLinkWeb() { return linkWeb; }
    public void setLinkWeb(String linkWeb) { this.linkWeb = linkWeb; }

    public Direccion getDireccion() { return direccion; }
    public void setDireccion(Direccion direccion) { this.direccion = direccion; }

    // Convertir contraseña a SHA-256
    public static String convertirSHA256(String password) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
        byte[] hash = md.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : hash) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
