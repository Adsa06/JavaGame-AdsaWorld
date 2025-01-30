import java.util.HashSet;
import java.util.Set;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

public class Interfaz extends Application {

    // TOODO ESTE BLOQUE ES PARA LA ANIMACION DEL PLAYER
    private int frameIndex = 0; // Índice del fotograma actual
    private int SheetIndex = 0; // Índice del Sheet actual
    private final int SheetCount = 4; // Cantidad de Sheets
    private final int frameCount = 4; // Cantidad de fotogramas en la animación
    private final int frameWidth = 16*4; // Ancho de cada fotograma en píxeles
    private final int frameHeight = 32*4; // Alto del fotograma

    private final Set<String> keysPressed = new HashSet<>();

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

        // Cargar el sprite sheet (una imagen con múltiples fotogramas en fila) (ancho de la imagen * cuanto quiero que se agrande * cantidad de fotogramas)
        Image spritePlayerSheet = new Image("file:Sprites/PlayerSheets.png", 16*4*frameCount, 32*4*SheetCount, false, false);

        // Crear un ImageView y solo mostrar el primer fotograma
        ImageView spritePlayer = new ImageView(spritePlayerSheet);
        spritePlayer.setX(608);
        spritePlayer.setY(296);
        spritePlayer.setViewport(new javafx.geometry.Rectangle2D(0, SheetIndex*frameHeight, frameWidth, frameHeight));
        gamePane.getChildren().add(spritePlayer);

        // Crear una animación para cambiar los fotogramas cada 200ms
        Timeline animationPlayer = new Timeline(
            new KeyFrame(Duration.millis(200), event -> {
                frameIndex = (frameIndex + 1) % frameCount; // Cambiar el índice del fotograma
                spritePlayer.setViewport(new javafx.geometry.Rectangle2D(frameIndex * frameWidth, SheetIndex*frameHeight, frameWidth, frameHeight));
            })
        );
        animationPlayer.setCycleCount(Timeline.INDEFINITE); // Repetir indefinidamente
        animationPlayer.play(); // Hago que la animacion del jugador este siempre activa

        // Establezco la escena
        Scene scene = new Scene(gamePane, 1280, 720);

        // Timeline que se ejecuta 60 veces por segundo (Esto me viene de lujo ya que puedo tener un flujo constante)
        Timeline timelineMovment = new Timeline(
            new KeyFrame(Duration.seconds(1.0 / 60), event -> {
                // Esto hace que se ejecute una vez cada 60 seg
                moveBackground(spriteBackGround, keysPressed.toString().charAt(1), spritePlayer);
            })
        );
        // Esto hace que se ejecute indefinidamente
        timelineMovment.setCycleCount(Timeline.INDEFINITE);
        
        // Manejo de teclas, se ejecuta cuando se presiona una tecla y si es (W, A, S, D) empieza o termina la animación
        scene.setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.W || event.getCode() == KeyCode.A || event.getCode() == KeyCode.S || event.getCode() == KeyCode.D) {
                keysPressed.add(event.getCode().toString());
                timelineMovment.play();
            }
        });
        scene.setOnKeyReleased(event -> {
            if(event.getCode() == KeyCode.W || event.getCode() == KeyCode.A || event.getCode() == KeyCode.S || event.getCode() == KeyCode.D) {
                keysPressed.remove(event.getCode().toString());
                timelineMovment.pause();
            }
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

    /**
     * Mueve el fondo de la escena segun la tecla que se pulse.
     * Cambia la direccion del player segun la tecla que se pulse.
     * 
     * @param spriteBackGround El ImageView que representa el fondo.
     * @param key La tecla que se ha pulsado, puede ser 'A', 'D', 'W', 'S'.
     * @param spritePlayer El ImageView que representa al jugador.
     */
    public void moveBackground(ImageView spriteBackGround, char key, ImageView spritePlayer) {
        switch (key) {
            case 'A':
                // Si la direcion del sprite no es la correcta la cambio
                if(SheetIndex != 3){
                    SheetIndex = 3;
                    spritePlayer.setViewport(new javafx.geometry.Rectangle2D(frameIndex * frameWidth, SheetIndex*frameHeight, frameWidth, frameHeight));
                }
                // Y hago que se mueva el fondo
                spriteBackGround.setX(spriteBackGround.getX() + 10);
                break;
            case 'D':
                if(SheetIndex != 1){
                    SheetIndex = 1;
                    spritePlayer.setViewport(new javafx.geometry.Rectangle2D(frameIndex * frameWidth, SheetIndex*frameHeight, frameWidth, frameHeight));
                }
                spriteBackGround.setX(spriteBackGround.getX() - 10);
                break;
            case 'W':
                if(SheetIndex != 2){                  
                    SheetIndex = 2;
                    spritePlayer.setViewport(new javafx.geometry.Rectangle2D(frameIndex * frameWidth, SheetIndex*frameHeight, frameWidth, frameHeight));
                }
                spriteBackGround.setY(spriteBackGround.getY() + 10);
                break;
            case 'S':
                if(SheetIndex != 0){
                    SheetIndex = 0;
                    spritePlayer.setViewport(new javafx.geometry.Rectangle2D(frameIndex * frameWidth, SheetIndex*frameHeight, frameWidth, frameHeight));
                }
                spriteBackGround.setY(spriteBackGround.getY() - 10);
                break;
            default:
                break;
        }
    }

}
