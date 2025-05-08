package dev.adsa;

import dev.adsa.modelo.MainController;
import dev.adsa.utils.GestorIdioma;
import dev.adsa.controlador.Contador;
import dev.adsa.vista.MainView;
import javafx.application.Application;
import javafx.stage.Stage;

/** Clase principal de la aplicación */
public class Main extends Application {

    /**
     * Punto de entrada principal de la aplicación. Crea las instancias del modelo
     * y la vista, inicializa la vista y crea el controlador que las conecta.
     * @param primaryStage El Stage principal de la aplicación.
     */
    @Override
    public void start(Stage primaryStage) {
        // Crear instancias del modelo y la vista
        Contador contador = new Contador();
        MainView view = new MainView();

        // Inicializar la vista
        view.initialize(primaryStage);

        // Crear el controlador y conectar todo
        new MainController(contador, view);
    }

    /**
     * Punto de entrada principal de la aplicación. Cambia el idioma por defecto a
     * español y lanza la aplicación con los argumentos pasados.
     * @param args Los argumentos pasados al ejecutar la aplicación.
     */
    public static void main(String[] args) {
        GestorIdioma.cambiarIdioma("es"); // Cambiar idioma por defecto a español
        launch(args);
    }
}
