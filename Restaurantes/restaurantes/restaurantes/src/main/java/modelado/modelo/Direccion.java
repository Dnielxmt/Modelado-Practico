package modelado.modelo;

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
@Table(name = "Direccion")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private int id;

    @Basic(optional = false)
    @Column(name = "nombreVia")
    private String nombreVia;

    @Basic(optional = false)
    @Column(name = "tipoVia")
    private String tipoVia;

    @Basic(optional = false)
    @Column(name = "codigoPostal")
    private String codigoPostal;

    @Basic(optional = false)
    @Column(name = "numero")
    private int numero;

    @Column(name = "otraInfo")
    private String otraInfo;

    public Direccion() {}

    public Direccion(String nombreVia, String tipoVia, int numero, String codigoPostal, String otraInfo) {
        this.nombreVia = nombreVia;
        this.tipoVia = tipoVia;
        this.numero = numero;
        this.codigoPostal = codigoPostal;
        this.otraInfo = otraInfo;
    }

    // ======= Getters y Setters =======
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombreVia() { return nombreVia; }
    public void setNombreVia(String nombreVia) { this.nombreVia = nombreVia; }
    public String getTipoVia() { return tipoVia; }
    public void setTipoVia(String tipoVia) { this.tipoVia = tipoVia; }
    public String getCodigoPostal() { return codigoPostal; }
    public void setCodigoPostal(String codigoPostal) { this.codigoPostal = codigoPostal; }
    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }
    public String getOtraInfo() { return otraInfo; }
    public void setOtraInfo(String otraInfo) { this.otraInfo = otraInfo; }
}
