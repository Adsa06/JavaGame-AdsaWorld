/*
 * Autor: Aitor de Santos Amoros
 * Fecha de creacion: 29/01/2025
 * Descripcion: Es el archivo principal el que inicia el videojuego
 */

import java.util.HashSet;
import java.util.Set;

import Clases.EntityScene.Player;
import Clases.EscenasClases.WorldScene;
import javafx.application.Application;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.input.KeyCode;

public class Interfaz extends Application {
    /*
     * Creo una variable Set, que es un conjunto de elementos no duplicados. 
     * Esto me ayuda a no añadirle la misma letra si mantengo presionado.
     * 
     * Y lo guardo en un HashSet. Que es una implementación de la interfaz Set 
     * HashSet almacena elementos en una tabla hash, lo que permite búsquedas rápidas.
     * El operador <> (diamante) se usa para inferir el tipo genérico (String en este caso), evitando repetirlo.
     * 
     * https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Set.html
     * https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/HashSet.html
     * private final Set<String> keysPressed = new HashSet<>();
     */
    /**
     * @param stage La etapa principal para esta aplicación,
     * en la que se puede establecer la escena de la aplicación.
     * Las aplicaciones pueden crear otras etapas si es necesario,
     * pero no serán etapas principales.
     */
    @Override
    public void start(Stage stage) {

        WorldScene WorldScene = new WorldScene();

        //https://openjfx.io/javadoc/21/javafx.graphics/javafx/stage/Stage.html
        /* El stage muestra la scena que quieras
        stage.setMaxWidth(1280);
        stage.setMinWidth(1280);
        stage.setMaxHeight(720);
        stage.setMinHeight(720);
        stage.close(); */ 

        stage.setScene(WorldScene.getScene());
        stage.setTitle("Adsa World");
        stage.show();
    }

    /**
     * Lanza la interfaz de usuario para esta aplicación.
     * Es un wrapper para Application.launch() que es el método que
     * realmente inicia la interfaz.
     */
    public static void iniciarInterfaz() {
        launch();
    }
}
