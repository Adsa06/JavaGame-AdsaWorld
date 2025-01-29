import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Interfaz extends Application {

    /**
     * @param stage La etapa principal para esta aplicación, 
     * en la que se puede establecer la escena de la aplicación. 
     * Las aplicaciones pueden crear otras etapas si es necesario, 
     * pero no serán etapas principales.  
     */
    @Override
    public void start(Stage stage) {
        
        Pane root = new Pane();
        String imagePath = getClass().getResource("Sprites/map.png").toExternalForm(); // Reemplaza con la ruta de tu imagen
        Image image = new Image(imagePath); // Ruta de la imagen
        ImageView spriteBackGround = new ImageView(image);
        spriteBackGround.setFitWidth(768); // spriteBackGround.getFitWidth() * 2
        spriteBackGround.setFitHeight(512); // spriteBackGround.getFitHeight() * 2
        root.getChildren().add(spriteBackGround);  // Añadir el sprite a la escena


        // Establezco la escena
        Scene scene = new Scene(root, 256, 256);
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

}
