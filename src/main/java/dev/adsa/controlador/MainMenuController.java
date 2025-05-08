package dev.adsa.controlador;

import dev.adsa.utils.GestorPantallas;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MainMenuController {
    @FXML
    private void irAJugar(ActionEvent event) {
        System.out.println("Entrando a jugar...");
    }

    @FXML
    private void irAConfiguracion(ActionEvent event) {
        GestorPantallas.mostrarConfiguracion();
    }

    @FXML
    private void salir(ActionEvent event) {
        System.out.println("Saliendo de la aplicacion...");
        Platform.exit();
        System.exit(0);
    }
}
