import java.util.HashSet;
import java.util.Set;

import Clases.Player;
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

    private int velocidad = 5;

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
     */
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
        Pane backgraundPane = new Pane();
        
        // Creo una imagen con los siguientes parametros: Ruta, ancho, alto, preserveRatio, smooth (Aunque piendo que esta bug las 2 ultimas)
        // https://openjfx.io/javadoc/21/javafx.graphics/javafx/scene/image/Image.html
        // https://openjfx.io/javadoc/21/javafx.graphics/javafx/scene/image/ImageView.html
        Image imageLimits = new Image("file:Sprites/LimitsMap.png", 480*4.5, 320*4.5, false, false);
        ImageView spriteLimits = new ImageView(imageLimits);
        // De esta manera consigo contener en un solo panel todo el fondo para manejarlo mas facilmente (Aqui puedo incluir los npc)
        backgraundPane.getChildren().add(spriteLimits);
         
        Image imageBackGround = new Image("file:Sprites/Map.png", 480*4.5, 320*4.5, false, false);
        ImageView spriteBackGround = new ImageView(imageBackGround);
        // De esta manera consigo contener en un solo panel todo el fondo para manejarlo mas facilmente (Aqui puedo incluir los npc)
        backgraundPane.getChildren().add(spriteBackGround);
        gamePane.getChildren().add(backgraundPane);

        Player jugador = new Player("file:Sprites/PlayerSheets.png", 16, 32, 4, 4, 4, gamePane);
        jugador.startAnimation();
        jugador.setPosition(608, 296);

        // Establezco la escena
        Scene scene = new Scene(gamePane, 1280, 720);

        // Timeline que se ejecuta 60 veces por segundo (Esto me viene de lujo ya que puedo tener un flujo constante)
        Timeline timelineMovment = new Timeline(
            new KeyFrame(Duration.seconds(1.0 / 60), event -> {
                // Esto hace que se ejecute una vez cada 60 seg
                moveBackground(backgraundPane, keysPressed.toString().charAt(1), jugador);
            })
        );
        // Esto hace que se ejecute indefinidamente
        timelineMovment.setCycleCount(Timeline.INDEFINITE);
        
        // Manejo de teclas, se ejecuta cuando se presiona una tecla y si es (W, A, S, D) empieza o termina la animación
        scene.setOnKeyPressed(event -> {
            if("WASD".contains(event.getCode().toString())) {
                keysPressed.add(event.getCode().toString());
                timelineMovment.play();
            }
        });
        scene.setOnKeyReleased(event -> {
            if("WASD".contains(event.getCode().toString())) {
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
    public void moveBackground(Pane backgraundPane, char key, Player jugador) {
        switch (key) {
            case 'A':
                if(jugador.getSheetIndex() != 3) jugador.actualizarSheet(3);
                // Y hago que se mueva el fondo y todo lo que este en backgraundPane como los npc
                backgraundPane.setTranslateX(backgraundPane.getTranslateX() + velocidad);
                break;
            case 'D':
                if(jugador.getSheetIndex() != 1) jugador.actualizarSheet(1);
                backgraundPane.setTranslateX(backgraundPane.getTranslateX() - velocidad);
                break;
            case 'W':
                if(jugador.getSheetIndex() != 2) jugador.actualizarSheet(2);
                backgraundPane.setTranslateY(backgraundPane.getTranslateY() + velocidad);
                break;
            case 'S':
                if(jugador.getSheetIndex() != 0) jugador.actualizarSheet(0);
                backgraundPane.setTranslateY(backgraundPane.getTranslateY() - velocidad);
                break;
            default:
                break;
        }
    }

}
