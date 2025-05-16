package dev.adsa.utils;

public class Utilidades {
    public static String conseguirPath() {
        // Para diferenciar entre sistemas operativos
        //String os = System.getProperty("os.name").toLowerCase();

        String userHome = System.getProperty("user.home");
        String nombreApp = "AdsaWorld";
        String path = userHome + "/Documents/" + nombreApp + "/";
        return path;
    }
}
