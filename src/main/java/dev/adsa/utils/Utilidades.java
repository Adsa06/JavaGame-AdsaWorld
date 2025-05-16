package dev.adsa.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utilidades {
    /**
     * Devuelve la ruta del directorio de la aplicación en el sistema
     * del usuario. La ruta var a dependiendo del sistema operativo.
     * En Windows ser a "C:\Users\<usuario>\Documents\AdsaWorld\"
     * y en macOS o GNU/Linux ser a "/Users/<usuario>/Documents/AdsaWorld/"
     * 
     * @return La ruta del directorio de la aplicación en el sistema del usuario.
     */
    public static String conseguirPath() {
        // Para diferenciar entre sistemas operativos
        // String os = System.getProperty("os.name").toLowerCase();

        String userHome = System.getProperty("user.home");
        String nombreApp = "AdsaWorld";
        String path = userHome + "/Documents/" + nombreApp + "/";
        return path;
    }

    /**
     * Valida si una cadena coincide con un patrón especificado.
     * Patron para validar nombre: ".*[\\\\/:*?\"<>|\\s].*"
     * 
     * @param patron El patrón de expresión regular a utilizar para la validación.
     * @param cadena La cadena de texto que se va a verificar contra el patrón.
     * @return true si la cadena coincide con el patrón, false en caso contrario.
     */
    public static boolean validarPatron(String patron, String cadena) {
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(cadena);
        return matcher.find();
    }

    /**
     * Formatea una fecha en un formato específico.
     * 
     * @param fecha La fecha a formatear.
     * @return La fecha formateada como una cadena de texto.
     */
    public static String formatFecha(LocalDateTime fecha) {
        return fecha.format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss"));
    }
}
