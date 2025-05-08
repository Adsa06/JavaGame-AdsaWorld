package dev.adsa.controlador;

import dev.adsa.bbdd.GestorDB;
import dev.adsa.utils.GestorPantallas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;

public class LogInMenuController {

    /**
     * Campos de texto para el nombre de usuario.
     */
    @FXML
    private TextField usernameField;

    /**
     * Campos de texto para la contraseña.
     */
    @FXML
    private PasswordField passwordField;

    /**
     * Maneja el evento de inicio de sesión.
     * Obtiene el nombre de usuario y la contraseña de los campos de texto.
     * Después de procesar los datos de inicio de sesión, muestra el menú principal.
     * 
     * @param event El evento que desencadena el inicio de sesión.
     */
    @FXML
    private void iniciarSesion(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();
        // Ahora puedes trabajar con username y password
        if(username.isEmpty() || password.isEmpty())
            System.out.println("Por favor, completa todos los campos.");

        if(username.length() > 50 || password.length() > 255)
            System.out.println("El nombre de usuario o la contraseña son demasiado largos.");

        if(GestorDB.login(username, password))
            GestorPantallas.mostrarMenuPrincipal();
        else
            System.out.println("Usuario o contraseña incorrectos.");
    }

    /**
     * Maneja el evento de ir a registrarse.
     * Muestra la pantalla de registro.
     * 
     * @param event El evento que desencadena el registro.
     */
    @FXML
    private void irARegistrarse(ActionEvent event) {
        System.out.println("Ir a registrarse presionado");
    }
}
