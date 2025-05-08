package dev.adsa.controlador;

import dev.adsa.utils.GestorPantallas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;

public class LogInMenuController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private void iniciarSesion(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();
        // Ahora puedes trabajar con username y password
        System.out.println("Usuario: " + username + ", Contraseña: " + password);
        GestorPantallas.mostrarMenuPrincipal();
    }

    @FXML
    private void irARegistrarse(ActionEvent event) {
        System.out.println("Ir a registrarse presionado");
    }
}
