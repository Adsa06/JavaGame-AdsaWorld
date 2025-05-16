package dev.adsa.utils;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * GestorIdioma es una clase que gestiona la localización de la aplicación.
 * Permite cambiar el idioma y obtener los textos localizados.
 */
public class GestorIdioma {
    /** La instancia del gestor de idiomas */
    private static ResourceBundle bundle;
    /** El locale actual */
    private static Locale currentLocale;

    /**
     * Establece el locale actual y carga el bundle de recursos correspondiente.
     * @param locale El locale a establecer.
     */
    public static void setIdioma(Locale locale) {
        currentLocale = locale;
        bundle = ResourceBundle.getBundle("i18n.messages", currentLocale);
    }

    /**
     * Devuelve el texto localizado asociado a la clave especificada.
     * @param clave La clave del texto a localizar.
     * @return El texto localizado correspondiente.
     * @throws NullPointerException si el bundle no ha sido cargado previamente.
     * @see #setIdioma(Locale)
     */
    public static String getTexto(String clave) {
        return bundle.getString(clave);
    }

    /**
     * Obtiene el locale actual configurado en la aplicación.
     * @return El locale actual.
     */
    public static Locale getLocaleActual() {
        return currentLocale;
    }

    /**
     * Cambia el idioma actual de la aplicación.
     * @param idioma El idioma a cambiar. Puede ser "es" o "en". Si se
     * proporciona cualquier otro valor, se establecer el idioma predeterminado
     * ("es").
     */
    public static void cambiarIdioma(String idioma) {
        switch (idioma) {
            case "es" -> setIdioma(Locale.of("es", "ES"));
            case "en" -> setIdioma(Locale.of("en", "US"));
            default -> setIdioma(Locale.of("es", "ES"));
        }
    }

    /**
     * Obtiene el idioma actual de la aplicación.
     * @return El idioma actual.
     */
    public static String getIdiomaActual() {
        return currentLocale.getLanguage();
    }
}