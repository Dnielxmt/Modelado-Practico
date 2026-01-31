package modelado.modelo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class Login {
    String correo;
    String contrasena;

    public Login(String contrasena, String correo) {
        this.contrasena = contrasena;
        this.correo = correo;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String conseguirToken(String nombre) {
        return Jwts.builder()
            .setHeaderParam("kid", "q94E28rpSFwk4nUyVfQWcgyzTYgJLYhF") // Agrega el Key ID
            .setSubject(correo) // El subject puede ser el correo del usuario
            .claim("nombre", nombre)  // Puedes incluir más datos en el token (como nombre)
            .setIssuedAt(new Date()) // Fecha de creación del token
            .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // Fecha de expiración del token
            .signWith(Keys.hmacShaKeyFor(("Una_clave_secreta_de_32_caracteres_super!").getBytes()), SignatureAlgorithm.HS256) // Firma el token con la clave secreta usando HS256
            .compact(); // Construye el token como un String
    }

    public boolean validarToken(String token, String nombre) {
        boolean valido = false;
        Claims claims = Jwts.parser()  // Nueva API en la versión 0.12.6
                .setSigningKey(("Una_clave_secreta_de_32_caracteres_super!").getBytes()) // La misma clave secreta
                .build()
                .parseClaimsJws(token)  // Analiza el JWT y obtiene los claims
                .getBody(); // Devuelve los claims del cuerpo del token

        String tokencorreo = claims.getSubject();  // El correo se guarda en el subject
        String tokenName = claims.get("nombre", String.class);  // El nombre del usuario es un claim adicional

        if (tokencorreo != null && tokencorreo.equals(getCorreo()) && tokenName != null && tokenName.equals(nombre)) {
            valido=true;
        } else {
            valido =false;
        }
        return valido;
    }
    
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