package dev.adsa.vista;

import dev.adsa.utils.GestorIdioma;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * MainView es la clase que representa la vista principal de la aplicación.
 * Contiene los elementos visuales y su inicialización.
 */
public class MainView {
    /* Elementos de la vista */
    /** Botón de salida */
    private Button btnExit;
    /** Botón de salida */
    private Button btnIncrementCounter;
    /** Botón para cambiar el idioma */
    private Button btnChangeLanguage;
    /** Etiqueta de título */
    private Label lblTitle;

    /** Constructor */
    public MainView() {
        lblTitle = new Label(GestorIdioma.getTexto("label.main.title"));
        btnExit = new Button(GestorIdioma.getTexto("button.main.exit"));
        btnIncrementCounter = new Button(GestorIdioma.getTexto("button.main.incrementcounter"));
        btnChangeLanguage = new Button(GestorIdioma.getTexto("button.main.changelanguage"));
    }

    
    /**
     * Inicializa la vista principal y la muestra en la pantalla.
     * Se crea un StackPane como contenedor principal y se le agregan los
     * elementos visuales (botón de salida y etiqueta de título). Se configura
     * la posición de cada elemento en el contenedor. Luego se crea una
     * Scene y se configura su tamaño y estilos. Finalmente, se muestra
     * la escena en la pantalla.
     * @param primaryStage El Stage principal de la aplicación.
     */
    public void initialize(Stage primaryStage) {
        VBox root = new VBox(10); // VBox con un espacio de 10 píxeles entre elementos
        root.setAlignment(javafx.geometry.Pos.CENTER); // Centrar los elementos en el VBox

        btnExit.setTranslateY(30); // Mover hacia abajo
        lblTitle.setTranslateY(-20); // Mover hacia arriba

        // Agregar los elementos al VBox
        root.getChildren().addAll(lblTitle, btnIncrementCounter, btnChangeLanguage, btnExit);

        Scene scene = new Scene(root, 300, 250);

        // Cargar archivo CSS
        String css = getClass().getResource("/estilos/estilo.css").toExternalForm();
        
        scene.getStylesheets().add(css);

        primaryStage.setTitle("Adsa World");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Devuelve el botón de salida de la vista principal.
     * @return El botón de salida.
     */
    public Button getBtnExit() {
        return btnExit;
    }

    /**
     * Devuelve la etiqueta de título de la vista principal.
     * @return La etiqueta de título.
     */
    public Label getLblTitle() {
        return lblTitle;
    }

    /**
     * Devuelve el botón de incremento del contador de la vista principal.
     * @return El botón de incremento del contador.
     */
    public Button getBtnIncrementCounter() {
        return btnIncrementCounter;
    }

    /**
     * Devuelve el botón de cambio de idioma de la vista principal.
     * @return El botón de cambio de idioma.
     */
    public Button getBtnChangeLanguage() {
        return btnChangeLanguage;
    }
}
