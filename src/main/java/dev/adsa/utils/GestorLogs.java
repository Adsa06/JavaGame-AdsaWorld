package dev.adsa.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

import dev.adsa.modelo.SesionActual;

/**
 * Clase para la gestion de los logs
 * que se guardaran en un archivo de texto
 */
public class GestorLogs {


    public static void crearLog(String mensaje) {

        File file = new File(Utilidades.conseguirPath() + "Logs");
        if (!file.exists()) {
            file.mkdirs();
        }
        String fecha = Utilidades.formatFecha(LocalDateTime.now());
        File fileLog = new File(file, fecha + ".log");

        try (BufferedWriter fr = new BufferedWriter(new FileWriter(fileLog))) {
            StringBuilder sb = new StringBuilder();
            sb.append("[").append(fecha).append("] ");
            sb.append("[").append(SesionActual.isLoggedIn() ? SesionActual.getNombreUsuario() : "/Desconocido/").append("] ");
            sb.append(mensaje);
            fr.write(sb.toString());
            System.out.println("Log creado correctamente");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
