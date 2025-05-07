package dev.adsa.vista;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainView {
    private Button btnIncrementar;
    private Label lblContador;

    public MainView() {
        btnIncrementar = new Button("Incrementar");
        lblContador = new Label("Contador: 0");
    }

    public void initialize(Stage primaryStage) {
        StackPane root = new StackPane();
        root.getChildren().addAll(btnIncrementar, lblContador);
        StackPane.setAlignment(lblContador, javafx.geometry.Pos.TOP_CENTER);
        StackPane.setAlignment(btnIncrementar, javafx.geometry.Pos.CENTER);

        Scene scene = new Scene(root, 300, 250);

        // Cargar archivo CSS
        String css = getClass().getResource("/estilos/estilo.css").toExternalForm();
        
        scene.getStylesheets().add(css);

        primaryStage.setTitle("Ejemplo MVC con CSS");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public Button getBtnIncrementar() {
        return btnIncrementar;
    }

    public Label getLblContador() {
        return lblContador;
    }
}
