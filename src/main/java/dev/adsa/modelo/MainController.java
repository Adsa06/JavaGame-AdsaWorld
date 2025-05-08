package dev.adsa.modelo;

import dev.adsa.controlador.Contador;
import dev.adsa.utils.GestorIdioma;
import dev.adsa.vista.MainView;
import javafx.application.Platform;

/** 
 * Controlador de la vista principal de la aplicación. 
 * Esta clase se encarga de gestionar la interacción entre la vista y el modelo.
 */
public class MainController {
    /** Instancias del contrlador */
    private Contador contador;
    /** Instancia de la vista */
    private MainView view;

    /** 
     * Constructor de la clase MainController.
     * @param contador Instancia del modelo Contador.
     * @param view Instancia de la vista MainView.
     * 
     * Asocia la acción del botón de incremento del contador a la función incrementarContador().
     */
    public MainController(Contador contador, MainView view) {
        this.contador = contador;
        this.view = view;

        // Asociar acción del botón
        view.getBtnIncrementCounter().setOnAction(event -> incrementarContador());
        // Asociar acción del botón de salida
        view.getBtnExit().setOnAction(event -> salir());
        // Asociar acción del botón de cambio de idioma
        view.getBtnChangeLanguage().setOnAction(event -> cambiarIdioma());
    }

    /**
     * Incrementa el contador en 1, actualiza la vista y alterna el idioma
     * cada dos clicks.
     */
    private void incrementarContador() {
        contador.incrementar();
        view.getLblTitle().setText(GestorIdioma.getTexto("label.main.counter") + contador.getCount());
    }

    /**
     * Actualiza los textos de la vista principal con los valores actuales
     * del contador y el idioma actual.
     */
    public void actualizarVista() {
        view.getBtnExit().setText(GestorIdioma.getTexto("button.main.exit"));
        view.getBtnIncrementCounter().setText(GestorIdioma.getTexto("button.main.incrementcounter"));
        view.getLblTitle().setText(GestorIdioma.getTexto("label.main.counter") + contador.getCount());
        view.getBtnChangeLanguage().setText(GestorIdioma.getTexto("button.main.changelanguage"));
    }

    /**
     * Cierra la aplicación.
     */
    public void salir() {
        System.out.println("Saliendo de la aplicacion...");
        Platform.exit();
        System.exit(0);
    }

    /**
     * Funcion para cambiar el idioma de la vista.
     */
    public void cambiarIdioma() {
        GestorIdioma.cambiarIdioma(GestorIdioma.getLocaleActual().getLanguage().equals("es") ? "en" : "es");
        actualizarVista();
    }
}
