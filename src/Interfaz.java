import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;

public class Interfaz extends Application {

    /**
     * @param stage La etapa principal para esta aplicación, 
     * en la que se puede establecer la escena de la aplicación. 
     * Las aplicaciones pueden crear otras etapas si es necesario, 
     * pero no serán etapas principales.  
     */
    @Override
    public void start(Stage stage) {
        
        // Creo un objeto Label y un objeto Button 
        Label label = new Label("Bienvenido a Adsa World");
        Button button = new Button("Click me");

        // Agrego los objetos al VBox
        VBox VBox = new VBox(10, label, button);
        // Se puede hacer tambien asi:
        // VBox.getChildren().addAll(label, button);


        // Establezco la escena
        Scene scene = new Scene(VBox, 300, 250);
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
