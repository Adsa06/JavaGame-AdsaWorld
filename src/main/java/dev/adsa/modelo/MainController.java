package dev.adsa.modelo;

import dev.adsa.controlador.Contador;
import dev.adsa.vista.MainView;

public class MainController {
    private Contador contador;
    private MainView view;

    public MainController(Contador contador, MainView view) {
        this.contador = contador;
        this.view = view;

        // Asociar acción del botón
        view.getBtnIncrementar().setOnAction(event -> incrementarContador());
    }

    private void incrementarContador() {
        contador.incrementar();
        view.getLblContador().setText("Contador: " + contador.getCount());
    }
}
