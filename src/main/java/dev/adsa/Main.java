package dev.adsa;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Clase principal de la aplicación.
 * Esta clase contiene el método main que es el punto de entrada de la
 * aplicación.
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("¡Hola Mundo desde JavaFX!");

        StackPane root = new StackPane(label);
        Scene scene = new Scene(root, 300, 200);

        primaryStage.setTitle("Hola Mundo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
