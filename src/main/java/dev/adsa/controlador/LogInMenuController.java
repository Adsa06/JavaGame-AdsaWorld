package dev.adsa.controlador;

import dev.adsa.utils.GestorPantallas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class LogInMenuController {

    @FXML
    private void iniciarSesion(ActionEvent event) {
        GestorPantallas.mostrarMenuPrincipal();
    }

    @FXML
    private void irARegistrarse(ActionEvent event) {
        // Lógica para ir a la pantalla de registro
        System.out.println("Ir a registrarse presionado");
    }
}
