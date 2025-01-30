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
        private int frameIndex = 0; // Índice del fotograma actual
        private int SheetIndex = 0; // Índice del Sheet actual
        private final int frameCount = 4; // Cantidad de fotogramas en la animación
        private final int frameWidth = 16*4; // Ancho de cada fotograma en píxeles
        private final int frameHeight = 32*4; // Alto del fotograma
    
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
    
            // Cargar el sprite sheet (una imagen con múltiples fotogramas en fila)
            Image spriteSheet = new Image("file:Sprites/PlayerSheets.png", 16*4*4, 32*4*4, false, false);
    
            // Crear un ImageView y solo mostrar el primer fotograma
            ImageView sprite = new ImageView(spriteSheet);
            sprite.setX(608);
            sprite.setY(296);
            sprite.setViewport(new javafx.geometry.Rectangle2D(0, SheetIndex*frameHeight, frameWidth, frameHeight));
            gamePane.getChildren().add(sprite);
    
            // Crear una animación para cambiar los fotogramas cada 200ms
            Timeline animation = new Timeline(
                new KeyFrame(Duration.millis(200), event -> {
                    frameIndex = (frameIndex + 1) % frameCount; // Cambiar el índice del fotograma
                    sprite.setViewport(new javafx.geometry.Rectangle2D(frameIndex * frameWidth, SheetIndex*frameHeight, frameWidth, frameHeight));
                })
            );
            animation.setCycleCount(Timeline.INDEFINITE); // Repetir indefinidamente
            animation.play();
    
    
    
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
    
        public void moveBackground(ImageView spriteBackGround, String key) {
            switch (key) {
                case "A":
                    spriteBackGround.setX(spriteBackGround.getX() + 10);
                    SheetIndex = 3;
                    break;
                case "D":
                    spriteBackGround.setX(spriteBackGround.getX() - 10);
                    SheetIndex = 1;
                    break;
                case "W":
                    spriteBackGround.setY(spriteBackGround.getY() + 10);
                    SheetIndex = 2;
                    break;
                case "S":
                    spriteBackGround.setY(spriteBackGround.getY() - 10);
                    SheetIndex = 0;
                break;
            default:
                break;
        }
    }

}
