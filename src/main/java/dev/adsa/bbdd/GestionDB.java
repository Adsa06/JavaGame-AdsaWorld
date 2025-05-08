package dev.adsa.bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;

/**
 * Clase para la gestion de la base de datos
 */
public class GestionDB {
    public boolean registrarUsuario(String username, String password) {
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

    public boolean login(String username, String password) {
        boolean existe = false;
        String sqlSelectContra = "SELECT password FROM usuarios WHERE username = ?";
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sqlSelectContra)) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String storedHash = rs.getString("password");
                existe = BCrypt.checkpw(password, storedHash);
            }

        } catch (SQLException e) {
            System.out.println("Error al iniciar sesión: " + e.getMessage());
        }
        return existe;
    }

}
