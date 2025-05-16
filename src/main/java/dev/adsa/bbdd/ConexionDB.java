package dev.adsa.bbdd;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import dev.adsa.utils.GestorLogs;

/**
 * Clase para la conexion de la base de datos
 * Utilizo una sola clase para las colecciones
 * ya que para los proyectos grandes, si hay mas de un servidor
 * es mas facil hacer la gestion de esa manera
 */
public class ConexionDB {

    /**
     * Metodo que devuelve la conexion a la base de datos
     * 
     * @return Connection, la conexion a la base de datos
     * @throws SQLException si no se puede conectar a la base de datos
     */
    public static Connection getConnection() throws SQLException {
        String url = "";
        String user = "";
        String password = "";
        try {
            Properties props = new Properties();
            InputStream input = ConexionDB.class.getClassLoader().getResourceAsStream("config.properties");
            if (input == null) {
                throw new RuntimeException("No se encontró el archivo config.properties");
            }

            props.load(input);

            url = props.getProperty("db.url");
            user = props.getProperty("db.user");
            password = props.getProperty("db.password");

        } catch (RuntimeException e) {
            GestorLogs.crearLog("Error al cargar la configuración de la base de datos: " + e.getMessage());
        
        } catch (Exception e) {
            GestorLogs.crearLog("Error al cargar el archivo de propiedades: " + e.getMessage());
        }

        return DriverManager.getConnection(url, user, password);
    }
}
