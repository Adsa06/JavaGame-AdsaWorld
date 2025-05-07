package dev.adsa.controlador;

public class Contador {
    private int count;

    public Contador() {
        this.count = 0;
    }

    public int getCount() {
        return count;
    }

    public void incrementar() {
        count++;
    }
}
