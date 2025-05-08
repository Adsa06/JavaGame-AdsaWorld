package dev.adsa.modelo;

import dev.adsa.controlador.Contador;
import dev.adsa.utils.GestorIdioma;
import dev.adsa.vista.MainView;

public class MainController {
    private Contador contador;
    private MainView view;

    public MainController(Contador contador, MainView view) {
        this.contador = contador;
        this.view = view;

        // Asociar acción del botón
        view.getBtnExit().setOnAction(event -> incrementarContador());
    }

    private void incrementarContador() {
        contador.incrementar();
        view.getLblTitle().setText(GestorIdioma.getTexto("label.main.counter") + contador.getCount());
        if(contador.getCount() % 2 == 0)
            GestorIdioma.cambiarIdioma("es");
        else
            GestorIdioma.cambiarIdioma("en");
            actualizarVista();
    }

    public void actualizarVista() {
        view.getBtnExit().setText(GestorIdioma.getTexto("button.main.exit"));
        view.getLblTitle().setText(GestorIdioma.getTexto("label.main.counter") + contador.getCount());
    }
}
