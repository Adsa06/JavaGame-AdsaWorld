package dev.adsa.bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase para la conexion de la base de datos
 * Utilizo una sola clase para las colecciones 
 * ya que para los proyectos grandes, si hay mas de un servidor
 * es mas facil hacer la gestion de esa manera
 */
public class ConexionDB {
        /** URL de la base de datos a la que se conecta */
    private static final String URL = "jdbc:mysql://localhost:3306/adsaworldDB";
    /** Usuario con el cual se conecta */
    private static final String USER = "root";
    /** Contraseña con la que se conecta */
    private static final String PASSWORD = ""; /*Password1234 */

    /**
     * Metodo que devuelve la conexion a la base de datos
     * @return Connection, la conexion a la base de datos
     * @throws SQLException si no se puede conectar a la base de datos
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
