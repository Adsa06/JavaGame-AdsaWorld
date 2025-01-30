import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

public class Interfaz extends Application {

    /**
     * @param stage La etapa principal para esta aplicación, 
     * en la que se puede establecer la escena de la aplicación. 
     * Las aplicaciones pueden crear otras etapas si es necesario, 
     * pero no serán etapas principales.  
     */
    @Override
    public void start(Stage stage) {
        
        Pane gamePane = new Pane();
        
        // Creo una imagen con los siguientes parametros: Ruta, ancho, alto, preserveRatio, smooth (Aunque piendo que esta bug las 2 ultimas)
        // https://openjfx.io/javadoc/21/javafx.graphics/javafx/scene/image/Image.html
        // https://openjfx.io/javadoc/21/javafx.graphics/javafx/scene/image/ImageView.html
        Image image = new Image("file:Sprites/map.png", 480*4.5, 320*4.5, false, false);
        ImageView spriteBackGround = new ImageView(image);
        gamePane.getChildren().add(spriteBackGround);  // Añadir el sprite a la escena

        // Crear el sprite del jugador (se mantiene estático en pantalla)
        Image jugadorImage = new Image("file:Sprites/player.png", 16*16, 32*16, false, false);
        ImageView jugador = new ImageView(jugadorImage);
        // Desactivar suavizado para mantener los píxeles nítidos
        gamePane.getChildren().add(jugador);

        // Establezco la escena
        Scene scene = new Scene(gamePane, 1280, 720);
        scene.setOnKeyPressed(event -> {
            moveBackground(spriteBackGround, event.getCode().toString());
        });

        stage.setScene(scene);
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

    public static void moveBackground(ImageView spriteBackGround, String key) {
        switch (key) {
            case "A":
                spriteBackGround.setX(spriteBackGround.getX() + 10);
                break;
            case "D":
                spriteBackGround.setX(spriteBackGround.getX() - 10);
                break;
            case "W":
                spriteBackGround.setY(spriteBackGround.getY() + 10);
                break;
            case "S":
                spriteBackGround.setY(spriteBackGround.getY() - 10);
                break;
            default:
                break;
        }
    }

}
