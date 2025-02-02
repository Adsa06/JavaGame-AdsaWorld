import java.util.HashSet;
import java.util.Set;

import Clases.Player;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
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

    private int velocidad = 1;
    private String keyPressed = "";
    private String NewkeyPressed = "";
    private int contadorMovimiento = 0;
    private boolean isWalking = false;

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

        Pane gamePane = new Pane();
        Pane backgroundPane = new Pane();

        // Creo una imagen con los siguientes parametros: Ruta, ancho, alto, preserveRatio, smooth (Aunque piendo que esta bug las 2 ultimas)
        // https://openjfx.io/javadoc/21/javafx.graphics/javafx/scene/image/Image.html
        // https://openjfx.io/javadoc/21/javafx.graphics/javafx/scene/image/ImageView.html
        Image imageLimits = new Image("file:Sprites/LimitsMap.png", 480*4.5, 320*4.5, false, false);
        ImageView spriteLimits = new ImageView(imageLimits);
        // De esta manera consigo contener en un solo panel todo el fondo para manejarlo mas facilmente (Aqui puedo incluir los npc)
        backgroundPane.getChildren().add(spriteLimits);

        Image imageBackGround = new Image("file:Sprites/Map.png", 480*4.5, 320*4.5, false, false);
        ImageView spriteBackGround = new ImageView(imageBackGround);
        // De esta manera consigo contener en un solo panel todo el fondo para manejarlo mas facilmente (Aqui puedo incluir los npc)
        backgroundPane.getChildren().add(spriteBackGround);
        gamePane.getChildren().add(backgroundPane);

        Player jugador = new Player("file:Sprites/PlayerSheets.png", 16, 32, 4, 4, 4, gamePane);
        jugador.startAnimation();
        jugador.setPosition(724, 328);

        // Establezco la escena
        Scene scene = new Scene(gamePane, 1280, 720);

        // Para leer los píxeles de la imagen
        PixelReader pixelReader = imageLimits.getPixelReader();

        // Timeline que se ejecuta 60 veces por segundo (Esto me viene de lujo ya que puedo tener un flujo constante)
        Timeline timelineMovment = new Timeline(
            new KeyFrame(Duration.millis(5), event -> { // Esto hace que se ejecute cada 5ms
                if(contadorMovimiento % 72 == 0) NewkeyPressed = keyPressed;
                if(isWalking || contadorMovimiento % 72 != 0) {
                    moveBackground(backgroundPane, NewkeyPressed, jugador, pixelReader);
                    System.out.println(keyPressed);
                    this.contadorMovimiento++;
                }
            })
        );
        // Esto hace que se ejecute indefinidamente
        timelineMovment.setCycleCount(Timeline.INDEFINITE);
        timelineMovment.play();

        scene.setOnKeyPressed(event -> {
            if("WASD".contains(event.getCode().toString())) {
                keyPressed = event.getCode().toString();
                isWalking = true;
            }
        });
        scene.setOnKeyReleased(event -> {
            isWalking = false;
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
    public void moveBackground(Pane backgroundPane, String key, Player jugador, PixelReader pixelReader) { // 36 pixeles

        final int PLAYER_CENTER_X = 760;
        final int PLAYER_CENTER_Y = 400;
        final int OFFSET = 36;
        final Color COLOR_COLISION = Color.web("#FF00FF");
        
        double posicionX = backgroundPane.getTranslateX();
        double posicionY = backgroundPane.getTranslateY();

        // Obtener el color del píxel en la nueva posición
        Color pixelColor;
        

        switch (key) {
            case "A":
                pixelColor = pixelReader.getColor(
                    (-1 * (int) posicionX) + PLAYER_CENTER_X - OFFSET,
                    (-1 * (int) posicionY) + PLAYER_CENTER_Y
                );
                if (jugador.getSheetIndex() != 3) jugador.actualizarSheet(3);
                if (!pixelColor.equals(COLOR_COLISION)) backgroundPane.setTranslateX(posicionX + velocidad);
                break;
            case "D":
                pixelColor = pixelReader.getColor(
                    (-1 * (int) posicionX) + PLAYER_CENTER_X + OFFSET,
                    (-1 * (int) posicionY) + PLAYER_CENTER_Y
                );
                if (jugador.getSheetIndex() != 1) jugador.actualizarSheet(1);
                if (!pixelColor.equals(COLOR_COLISION)) backgroundPane.setTranslateX(posicionX - velocidad);
                break;
            case "W":
                pixelColor = pixelReader.getColor(
                    (-1 * (int) posicionX) + PLAYER_CENTER_X,
                    (-1 * (int) posicionY) + PLAYER_CENTER_Y - OFFSET
                );
                if (jugador.getSheetIndex() != 2) jugador.actualizarSheet(2);
                if (!pixelColor.equals(COLOR_COLISION)) backgroundPane.setTranslateY(posicionY + velocidad);
                break;
            case "S":
                pixelColor = pixelReader.getColor(
                    (-1 * (int) posicionX) + PLAYER_CENTER_X,
                    (-1 * (int) posicionY) + PLAYER_CENTER_Y + OFFSET
                );
                if (jugador.getSheetIndex() != 0) jugador.actualizarSheet(0);
                if (!pixelColor.equals(COLOR_COLISION)) backgroundPane.setTranslateY(posicionY - velocidad);
                break;
            default:
                break;
        }        
    }
}
