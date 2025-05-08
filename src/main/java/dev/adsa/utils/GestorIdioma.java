package dev.adsa.utils;

import java.util.Locale;
import java.util.ResourceBundle;

public class GestorIdioma {
    private static ResourceBundle bundle;
    private static Locale currentLocale;

    public static void setIdioma(Locale locale) {
        currentLocale = locale;
        bundle = ResourceBundle.getBundle("i18n.messages", currentLocale);
    }

    public static String getTexto(String clave) {
        return bundle.getString(clave);
    }

    public static Locale getLocaleActual() {
        return currentLocale;
    }

    public static void cambiarIdioma(String idioma) {
        switch (idioma) {
            case "es":
                setIdioma(Locale.of("es", "ES"));
                break;
            case "en":
                setIdioma(Locale.of("en", "US"));
                break;
            default:
                setIdioma(Locale.of("es", "ES"));
        }
    }
}