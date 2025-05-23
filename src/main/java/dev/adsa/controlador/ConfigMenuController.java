package dev.adsa.controlador;

import dev.adsa.utils.GestorIdioma;
import dev.adsa.utils.GestorPantallas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

public class ConfigMenuController {

    @FXML
    private ChoiceBox<String> idiomaElegido;

    /**
     * Cambia el idioma actual de la aplicacion a español.
     * Despues de cambiar el idioma, muestra la pantalla de configuracion
     * para que el usuario pueda ver los cambios.
     * @param event El evento que desencadena el cambio de idioma.
     */
    @FXML
    private void cambiarIdiomaEs(ActionEvent event) {
        GestorIdioma.cambiarIdioma("es");
        GestorPantallas.mostrarConfiguracion();
    }

    /**
     * Cambia el idioma actual de la aplicacion a ingles.
     * Despues de cambiar el idioma, muestra la pantalla de configuracion
     * para que el usuario pueda ver los cambios.
     * @param event El evento que desencadena el cambio de idioma.
     */
    @FXML
    private void cambiarIdiomaEn(ActionEvent event) {
        GestorIdioma.cambiarIdioma("en");
        GestorPantallas.mostrarConfiguracion();
    }

    /**
     * Vuelve a la pantalla principal de la aplicacion.
     * @param event El evento que desencadena el regreso a la pantalla principal.
     */
    @FXML
    private void salir(ActionEvent event) {
        GestorPantallas.mostrarMenuPrincipal();
    }

    @FXML
    private void initialize() {
        // Agregar los idiomas al ChoiceBox
        idiomaElegido.getItems().addAll("Español", "English");

        // Establecer un valor predeterminado
        idiomaElegido.setValue("Español");
    }
}
