package dev.adsa.bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;

/**
 * Clase para la gestion de la base de datos
 */
public class GestorDB {
    /**
     * Registra un usuario en la base de datos
     * @param username nombre de usuario
     * @param password contraseña
     * @return true si el usuario se registro exitosamente, false en caso contrario
     */
    public static boolean registrarUsuario(String username, String password) {
        boolean existe = false;
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        String sqlInsertarUsuarios = "INSERT INTO usuarios (username, password) VALUES (?, ?)";
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sqlInsertarUsuarios)) {

            stmt.setString(1, username);
            stmt.setString(2, hashedPassword);
            stmt.executeUpdate();
            existe = true;

        } catch (SQLException e) {
            System.out.println("Error al registrar: " + e.getMessage());
        }
        return existe;
    }

    /**
     * Inicia una sesión en la base de datos
     * @param username nombre de usuario (String)
     * @param password contraseña (String)
     * @return "exitoso" si el usuario se inicio correctamente, "errorCredential" si la contraseña es incorrecta, "errorNotFound" si el usuario no existe (String)
     */
    public static String login(String username, String password) {
        String resultado = "";
        String sqlSelectPassword = "SELECT password FROM usuarios WHERE username = ? LIMIT 1";
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sqlSelectPassword)) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String hashedPassword = rs.getString("password");
                if (hashedPassword.startsWith("$2y$"))
                    hashedPassword = "$2a$" + hashedPassword.substring(4);
                resultado = BCrypt.checkpw(password, hashedPassword) ? "exitoso" : "errorCredential";
            } else {
                resultado = "errorNotFound";
            }

        } catch (SQLException e) {
            System.out.println("Error al iniciar sesión: " + e.getMessage());
            resultado = "errorNotFound";
        }
        return resultado;
    }

    public static boolean existeUsuario(String username) {
        boolean existe = false;
        String sqlSelectUsuario = "SELECT * FROM usuarios WHERE username = ?";
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sqlSelectUsuario)) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next())
                existe = true;


        } catch (SQLException e) {
            System.out.println("Error al comprobar si existe el usuario: " + e.getMessage());
        }
        return existe;
    }

}
