package dev.adsa.controlador;

import dev.adsa.modelo.SesionActual;
import dev.adsa.utils.GestorPantallas;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MainMenuController {
    /**
     * Muestra la pantalla de juego.
     *
     * @param event El evento que se produce al hacer clic en el boton de jugar.
     */
    @FXML
    private void irAJugar(ActionEvent event) {
        System.out.println("Entrando a jugar...");
    }

    /**
     * Muestra la pantalla de configuracion y permite al usuario
     * cambiar el idioma o salir de la aplicacion.
     *
     * @param event El evento que se produce al hacer clic en el boton de
     * configuracion.
     */
    @FXML
    private void irAConfiguracion(ActionEvent event) {
        GestorPantallas.mostrarConfiguracion();
    }

    /**
     * Cierra la aplicacion y sale del juego.
     *
     * @param event El evento que se produce al hacer clic en el boton de salir.
     */
    @FXML
    private void salir(ActionEvent event) {
        System.out.println("Saliendo de la aplicacion...");
        SesionActual.getUsuario().guardarUsuario();
        Platform.exit();
        System.exit(0);
    }
}
