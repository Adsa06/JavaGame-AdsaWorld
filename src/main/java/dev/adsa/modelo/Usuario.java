package dev.adsa.modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import dev.adsa.utils.Utilidades;

public class Usuario implements Serializable {

    /** Serial ID */
    private static final long serialVersionUID = 1L;

    /** El nombre del usuario */
    private String nombre;

    /** La contraseña del usuario */
    private String idiomaPreferido;

    /** Constructor */
    public Usuario(String nombre, String idiomaPreferido) {
        this.nombre = nombre;
        this.idiomaPreferido = idiomaPreferido;
    }

    /** Constructor por defecto */
    public Usuario() {
        this.nombre = "";
        this.idiomaPreferido = "es";
    }

    /** Devuelve el nombre del usuario */
    public String getNombre() {
        return nombre;
    }

    /** Devuelve la contraseña del usuario */
    public String getIdiomaPreferido() {
        return idiomaPreferido;
    }

    /** Establece el nombre del usuario */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /** Establece la contraseña del usuario */
    public void setIdiomaPreferido(String idiomaPreferido) {
        this.idiomaPreferido = idiomaPreferido;
    }

    /**
     * Guarda un objeto Player en un archivo especificado.
     * 
     * @param player El objeto Player que se desea guardar.
     */

    public static void guardarUsuario(Usuario usuario) {

        File file = new File(Utilidades.conseguirPath() + "Profiles");
        if (!file.exists()) {
            file.mkdirs();
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(file + "/" + usuario.getNombre() + ".dat"))) {
            oos.writeObject(usuario);
            System.out.println("Usuario guardado correctamente");
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Carga un objeto Player desde un archivo especificado.
     * 
     * @param nombreJugador La ruta del archivo desde donde se cargará el objeto
     *                      Player.
     * @return El objeto Player cargado desde el archivo, o null si ocurre un error.
     */
    public static Usuario cargarUsuario(String nombreUsuario) {
        File file = new File(Utilidades.conseguirPath() + "Profiles/" + nombreUsuario + ".dat");
        Usuario usuario = null;
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                usuario = (Usuario) ois.readObject();
                System.out.println("Usuario cargado correctamente");
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            usuario = new Usuario(nombreUsuario, "es");
        }

        return usuario;
    }

    /**
     * Cargar idioma preferido del usuario
     * 
     * @param nombreJugador El nombre del usuario
     * 
     * @return El idioma preferido del usuario
     *
     */
    public static String cargarIdiomaPreferido(String nombreUsuario) {
        File file = new File(Utilidades.conseguirPath() + "Profiles/" + nombreUsuario + ".dat");
        String idiomaPreferido = "es";
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                Usuario usuario = (Usuario) ois.readObject();
                idiomaPreferido = usuario.getIdiomaPreferido();
                System.out.println("Idioma preferido cargado correctamente");
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return idiomaPreferido;
    }
}
