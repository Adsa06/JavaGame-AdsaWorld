package dev.adsa.controlador;

import dev.adsa.modelo.SesionActual;
import dev.adsa.utils.GestorIdioma;
import dev.adsa.utils.GestorPantallas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

public class ConfigMenuController {

    /** El ChoiceBox para elegir el idioma */
    @FXML
    private ChoiceBox<String> idiomaElegido;

    /**
     * Lista de idiomas disponibles.
     * En este caso, solo se incluyen español e inglés.
     */
    private String[] idiomasDisponibles = {"Español", "English"};

    /**
     * Cambia el idioma actual de la aplicacion a español.
     * Despues de cambiar el idioma, muestra la pantalla de configuracion
     * para que el usuario pueda ver los cambios.
     */
    private void cambiarIdiomaEs() {
        GestorIdioma.cambiarIdioma("es");
        GestorPantallas.mostrarConfiguracion();
    }

    /**
     * Cambia el idioma actual de la aplicacion a ingles.
     * Despues de cambiar el idioma, muestra la pantalla de configuracion
     * para que el usuario pueda ver los cambios.
     */
    private void cambiarIdiomaEn() {
        GestorIdioma.cambiarIdioma("en");
        GestorPantallas.mostrarConfiguracion();
    }

    /**
     * Vuelve a la pantalla principal de la aplicacion.
     * @param event El evento que desencadena el regreso a la pantalla principal.
     */
    @FXML
    private void salir(ActionEvent event) {
        SesionActual.getUsuario().setIdiomaPreferido(GestorIdioma.getIdiomaActual());
        GestorPantallas.mostrarMenuPrincipal();
    }

    /** Inicializa el ChoiceBox con los idiomas disponibles. */
    @FXML
    private void initialize() {
        // Agregar los idiomas al ChoiceBox
        idiomaElegido.getItems().clear();
        idiomaElegido.getItems().addAll(idiomasDisponibles);

        // Establecer un valor predeterminado
        switch (GestorIdioma.getIdiomaActual()) {
            case "es" -> idiomaElegido.setValue("Español");
            case "en" -> idiomaElegido.setValue("English");
        }
        // Manejar el evento de selección de idioma
        idiomaElegido.setOnAction(e -> getSelectedLanguage());
    }

    /**
     * Maneja el evento de selección de idioma en el ChoiceBox.
     * Si el idioma seleccionado es español, llama a cambiarIdiomaEs.
     * Si el idioma seleccionado es inglés, llama a cambiarIdiomaEn.
     * Si el idioma seleccionado no es ninguno de los anteriores,
     * imprime un mensaje de idioma no soportado.
     */
    private void getSelectedLanguage() {
        String selectedLanguage = idiomaElegido.getValue();

        switch (selectedLanguage) {
            case "Español" -> cambiarIdiomaEs();
            case "English" -> cambiarIdiomaEn();
            default -> System.out.println("Idioma no soportado");
        }
    }
}
