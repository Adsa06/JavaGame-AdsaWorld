package dev.adsa.controlador;

import dev.adsa.utils.GestorIdioma;
import dev.adsa.utils.GestorPantallas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ConfigMenuController {

    @FXML
    private void cambiarIdiomaEs(ActionEvent event) {
        GestorIdioma.cambiarIdioma("es");
        GestorPantallas.mostrarConfiguracion();
    }

    @FXML
    private void cambiarIdiomaEn(ActionEvent event) {
        GestorIdioma.cambiarIdioma("en");
        GestorPantallas.mostrarConfiguracion();
    }

    @FXML
    private void salir(ActionEvent event) {
        GestorPantallas.mostrarMenuPrincipal();
    }
}
