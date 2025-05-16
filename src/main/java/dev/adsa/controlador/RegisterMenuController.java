package dev.adsa.controlador;

import dev.adsa.bbdd.GestorDB;
import dev.adsa.modelo.SesionActual;
import dev.adsa.modelo.Usuario;
import dev.adsa.utils.GestorPantallas;
import dev.adsa.utils.Utilidades;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.text.Text;

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
     * Checkbox para mostrar u ocultar la contraseña.
     */
    @FXML
    private CheckBox showPasswordCheckbox;

    /** Campos de texto para la contraseña. */
    @FXML
    private TextField passwordTextField;

    /** Campos de texto para la confirmación de la contraseña. */
    @FXML
    private TextField confirmPasswordTextField;

    /**
     * Mensaje de error cuando el usuario no es valido.
     */
    @FXML
    private Text errorNotValidUser;

    /**
     * Mensaje de error cuando hay campos vacíos.
     */
    @FXML
    private Text errorEmpty;

    /**
     * Mensaje de error cuando las contraseñas no coinciden.
     */
    @FXML
    private Text errorPassword;

    /**
     * Mensaje de error cuando el usuario ya existe.
     */
    @FXML
    private Text errorUserExists;

    /**
     * Mensaje de error inesperado.
     */
    @FXML    
    private Text UnexpectedError;

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
            mostrarError("errorEmpty");
        else if(Utilidades.validarPatron(".*[\\\\/:*?\"<>|\\s].*", username) || username.length() > 50 || password.length() > 255)
            mostrarError("errorNotValidUser");
        else if(!password.equals(confirmPassword))
            mostrarError("errorPassword");
        else if(GestorDB.existeUsuario(username))
            mostrarError("errorUserExists");
        else if(GestorDB.registrarUsuario(username, password)) {
            SesionActual.setUsuario(new Usuario(username, "es"));
            GestorPantallas.mostrarMenuPrincipal();
        } else
            mostrarError("UnexpectedError");
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

    @FXML
    private void mostrarContra(ActionEvent event) {
        if (showPasswordCheckbox.isSelected()) {
            // Mostrar contraseñas
            passwordTextField.setText(passwordField.getText());
            passwordTextField.setVisible(true);
            passwordField.setVisible(false);

            confirmPasswordTextField.setText(confirmPasswordField.getText());
            confirmPasswordTextField.setVisible(true);
            confirmPasswordField.setVisible(false);
        } else {
            // Ocultar contraseñas
            passwordField.setText(passwordTextField.getText());
            passwordField.setVisible(true);
            passwordTextField.setVisible(false);

            confirmPasswordField.setText(confirmPasswordTextField.getText());
            confirmPasswordField.setVisible(true);
            confirmPasswordTextField.setVisible(false);
        }
    }

    /**
     * Muestra el mensaje de error correspondiente segun el parametro "mensaje".
     * 
     * @param mensaje El mensaje de error a mostrar.
     */
    private void mostrarError(String mensaje) {
        errorEmpty.setVisible(false);
        errorNotValidUser.setVisible(false);
        errorUserExists.setVisible(false);
        errorPassword.setVisible(false);
        UnexpectedError.setVisible(false);

        switch (mensaje) {
            case "errorNotValidUser" -> errorNotValidUser.setVisible(true);
            case "errorUserExists" -> errorUserExists.setVisible(true);
            case "errorEmpty" -> errorEmpty.setVisible(true);
            case "errorPassword" -> errorPassword.setVisible(true);
            case "UnexpectedError" -> UnexpectedError.setVisible(true);
            default -> {}
        }
    }
}
