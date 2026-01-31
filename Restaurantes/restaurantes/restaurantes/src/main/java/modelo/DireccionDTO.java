package modelo;

public class DireccionDTO {

    private String nombreVia;
    private String tipoVia;
    private String codigoPostal;
    private int numero;
    private String otraInfo;

    public DireccionDTO() {}

    public DireccionDTO(String nombreVia, String tipoVia, int numero, String codigoPostal, String otraInfo) {
        this.nombreVia = nombreVia;
        this.tipoVia = tipoVia;
        this.numero = numero;
        this.codigoPostal = codigoPostal;
        this.otraInfo = otraInfo;
    }

    // ===== Getters y Setters =====
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
