package modelado.modelo;

public class RestauranteDTO {

    private String nombre;
    private String correo;
    private String contrasena;
    private int capacidad;
    private String infoAdicional;
    private String linkWeb;
    private DireccionDTO direccion;

    public RestauranteDTO() {}

    public RestauranteDTO(String nombre, String correo, String contrasena, int capacidad,
                          String infoAdicional, String linkWeb, DireccionDTO direccion) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.capacidad = capacidad;
        this.infoAdicional = infoAdicional;
        this.linkWeb = linkWeb;
        this.direccion = direccion;
    }

    // ===== Getters y Setters =====
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }
    public int getCapacidad() { return capacidad; }
    public void setCapacidad(int capacidad) { this.capacidad = capacidad; }
    public String getInfoAdicional() { return infoAdicional; }
    public void setInfoAdicional(String infoAdicional) { this.infoAdicional = infoAdicional; }
    public String getLinkWeb() { return linkWeb; }
    public void setLinkWeb(String linkWeb) { this.linkWeb = linkWeb; }
    public DireccionDTO getDireccion() { return direccion; }
    public void setDireccion(DireccionDTO direccion) { this.direccion = direccion; }
}
