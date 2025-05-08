package dev.adsa.vista;

import dev.adsa.utils.GestorIdioma;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainView {
    private Button btnExit;
    private Label lblTitle;

    public MainView() {
        lblTitle = new Label(GestorIdioma.getTexto("label.main.title"));
        btnExit = new Button(GestorIdioma.getTexto("button.main.exit"));
    }

    public void initialize(Stage primaryStage) {
        StackPane root = new StackPane();
        root.getChildren().addAll(btnExit, lblTitle);
        StackPane.setAlignment(lblTitle, javafx.geometry.Pos.TOP_CENTER);
        StackPane.setAlignment(btnExit, javafx.geometry.Pos.CENTER);

        Scene scene = new Scene(root, 300, 250);

        // Cargar archivo CSS
        String css = getClass().getResource("/estilos/estilo.css").toExternalForm();
        
        scene.getStylesheets().add(css);

        primaryStage.setTitle("Ejemplo MVC con CSS");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public Button getBtnExit() {
        return btnExit;
    }

    public Label getLblTitle() {
        return lblTitle;
    }
}
