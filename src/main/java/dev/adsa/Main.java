package dev.adsa;

import dev.adsa.modelo.MainController;
import dev.adsa.utils.GestorIdioma;
import dev.adsa.controlador.Contador;
import dev.adsa.vista.MainView;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

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

    public static void main(String[] args) {
        GestorIdioma.cambiarIdioma("es"); // Cambiar idioma por defecto a español
        launch(args);
    }
}
