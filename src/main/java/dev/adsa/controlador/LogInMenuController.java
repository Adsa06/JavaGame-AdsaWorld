package dev.adsa.controlador;

import dev.adsa.bbdd.GestorDB;
import dev.adsa.utils.GestorPantallas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;
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
     * Campos de texto para la ver la contraseña.
     */
    @FXML
    private TextField passwordTextField;

    
    @FXML
    private CheckBox showPasswordCheckbox;

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
        GestorPantallas.mostrarRegistro();
    }

    /**
     * Muestra u oculta la contraseña en función del estado del CheckBox.
     */
    @FXML
    private void mostrarContra(ActionEvent event) {
        if(showPasswordCheckbox.isSelected()) {
            passwordTextField.setText(passwordField.getText());
            passwordTextField.setVisible(true);
            passwordField.setVisible(false);
        } else {
            passwordField.setText(passwordTextField.getText());
            passwordTextField.setVisible(false);
            passwordField.setVisible(true);
        }
    }
}
