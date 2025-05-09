package dev.adsa.utils;

import java.io.IOException;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Clase que gestiona las pantallas de la aplicación.
 */
public class GestorPantallas {
    /** Instancia de la escena principal */
    private static Scene scene;

    /**
     * Inicializa la escena principal y la muestra en la pantalla.
     * Crea una escena vacía con un StackPane como contenedor principal y
     * la asigna al Stage principal. Luego la muestra en la pantalla.
     * 
     * @param primaryStage El Stage principal de la aplicación.
     */
    public static void inicializar(Stage primaryStage) {

        scene = new Scene(new StackPane(), 300, 250);
        primaryStage.setTitle("Adsa World");
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.setMinWidth(800);
        primaryStage.setMinHeight(600);
        primaryStage.show();
    }

    /**
     * Muestra la pantalla principal de la aplicación.
     * Carga la pantalla principal, la localiza con el idioma actual y la muestra en la escena principal.
     */
    public static void mostrarMenuPrincipal() {
        try {
            ResourceBundle bundle = ResourceBundle.getBundle("i18n.messages", GestorIdioma.getLocaleActual());
            FXMLLoader loader = new FXMLLoader(GestorPantallas.class.getResource("/vista/MainMenu.fxml"), bundle);
            Parent root = loader.load();
            scene.setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Muestra la pantalla de configuración de la aplicación.
     * Carga la pantalla de configuración, la localiza con el idioma actual y la muestra en la escena principal.
     */

    public static void mostrarConfiguracion() {
        try {
            ResourceBundle bundle = ResourceBundle.getBundle("i18n.messages", GestorIdioma.getLocaleActual());
            FXMLLoader loader = new FXMLLoader(GestorPantallas.class.getResource("/vista/ConfigMenu.fxml"), bundle);
            Parent root = loader.load();
            scene.setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Muestra la pantalla de inicio de sesión de la aplicación.
     * Carga la pantalla de inicio de sesión, la localiza con el idioma actual y la muestra en la escena principal.
     */
    public static void mostrarInicioSesion() {
        try {
            ResourceBundle bundle = ResourceBundle.getBundle("i18n.messages", GestorIdioma.getLocaleActual());
            FXMLLoader loader = new FXMLLoader(GestorPantallas.class.getResource("/vista/LogInMenu.fxml"), bundle);
            Parent root = loader.load();
            scene.setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Muestra la pantalla de registro de la aplicación.
     * Carga la pantalla de registro, la localiza con el idioma actual y la muestra en la escena principal.
     */
    public static void mostrarRegistro() {
        try {
            ResourceBundle bundle = ResourceBundle.getBundle("i18n.messages", GestorIdioma.getLocaleActual());
            FXMLLoader loader = new FXMLLoader(GestorPantallas.class.getResource("/vista/RegisterMenu.fxml"), bundle);
            Parent root = loader.load();
            scene.setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // public static void mostrarGameplay(String ciudad) {
    // // Crear por código el nodo raíz del gameplay
    // Pane juego = new JuegoCiudad(ciudad); // Clase personalizada
    // scene.setRoot(juego);
    // }

}
