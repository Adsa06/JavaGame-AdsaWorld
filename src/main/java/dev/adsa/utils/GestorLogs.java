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


    /**
     * Crea un log con el mensaje especificado en el parametro "mensaje".
     * El log se guardara en un archivo de texto en la carpeta "Logs" 
     * con el nombre de la fecha en formato "yyyy-MM-dd_HH-mm-ss-SSS.log"
     * La estructura del log es la siguiente:
     * [fecha] [nombre de usuario o Desconocido] mensaje
     * @param mensaje El mensaje que se quiere guardar en el log
     */
    public static void crearLog(String mensaje) {

        File file = new File(Utilidades.conseguirPath() + "Logs");
        if (!file.exists()) {
            file.mkdirs();
        }
        String fecha = Utilidades.formatFecha(LocalDateTime.now());
        String fileLog = file + "/" + fecha + ".log";
        try (BufferedWriter fr = new BufferedWriter(new FileWriter(fileLog, true))) {
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
