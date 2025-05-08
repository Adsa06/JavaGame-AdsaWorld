package dev.adsa.controlador;

/**
 * Contador es una clase que representa un contador simple.
 */
public class Contador {
    /** Variable para almacenar el contador */
    private int count;

    /** Constructor de la clase */
    public Contador() {
        this.count = 0;
    }

    /** Devuelve el valor del contador
     * @return El valor del contador
     * @see #incrementar()
     */
    public int getCount() {
        return count;
    }

    /** Incrementa el contador en 1 */
    public void incrementar() {
        count++;
    }
}
