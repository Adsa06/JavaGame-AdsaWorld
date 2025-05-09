package dev.adsa.controlador;

import dev.adsa.bbdd.GestorDB;
import dev.adsa.utils.GestorPantallas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;

public class RegisterMenuController {

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
     * Campos de texto para la confirmación de la contraseña.
     */
    @FXML
    private PasswordField confirmPasswordField;

    /**
     * Maneja el evento de inicio de sesión.
     * Obtiene el nombre de usuario y la contraseña de los campos de texto.
     * Después de procesar los datos de inicio de sesión, muestra el menú principal.
     * 
     * @param event El evento que desencadena el inicio de sesión.
     */
    @FXML
    private void registrarse(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();
        // Ahora puedes trabajar con username y password
        if(username.isEmpty() || password.isEmpty())
            System.out.println("Por favor, completa todos los campos.");
        else if(username.length() > 50 || password.length() > 255)
            System.out.println("El nombre de usuario o la contraseña son demasiado largos.");
        else if(!password.equals(confirmPassword))
            System.out.println("Las contraseñas no coinciden.");
        else if(GestorDB.registrarUsuario(username, password))
            GestorPantallas.mostrarMenuPrincipal();
        else
            System.out.println("Usuario o contraseña incorrectos.");
    }

    /**
     * Maneja el evento de ir a login.
     * Muestra la pantalla de login.
     * 
     * @param event El evento que desencadena el registro.
     */
    @FXML
    private void irALogin(ActionEvent event) {
        GestorPantallas.mostrarInicioSesion();
    }
}
