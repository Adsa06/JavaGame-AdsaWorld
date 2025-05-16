package dev.adsa.modelo;

public class SesionActual {
    private static Usuario usuario;

    public static Usuario getUsuario() {
        return usuario;
    }

    public static void setUsuario(Usuario usuario) {
        SesionActual.usuario = usuario;
    }
    public static void cerrarSesion() {
        usuario = null;
    }

    public static String getNombreUsuario() {
        return usuario.getNombre();
    }
}
