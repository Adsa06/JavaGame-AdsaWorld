/*
 * Autor: Aitor de Santos Amoros
 * Fecha de creacion: 31/01/2025
 * Descripcion: Clase Player, para inicializar el personaje y poder controlarlo
 */

package Clases.EntityScene;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class Player extends Entity {
    private ImageView spriteView;
    private int sheetIndex = 0;
    private int currentFrame = 0;
    private int frameCount;
    private int frameWidth;
    private int frameHeight;
    private Timeline animation;


    // Metodo constructor, Ruta de la imagen, anchura y altura de la imagen, cuantos frames hay, cuantos sheets hay, la escala y el panel
    public Player(String imagePath, int frameWidth, int frameHeight, int frameCount, int sheetCount, int scale, Pane gamePane) {
        this.frameWidth = frameWidth * scale;
        this.frameHeight = frameHeight * scale;
        this.frameCount = frameCount;

        // Cargar la imagen del sprite sheet (escalado multiplicado por el número de frames)
        Image spriteSheet = new Image(imagePath, this.frameWidth * frameCount, this.frameHeight * sheetCount, false, false);
        this.spriteView = new ImageView(spriteSheet);
        this.spriteView.setViewport(new Rectangle2D(0, sheetIndex * this.frameHeight, this.frameWidth, this.frameHeight));

        // Agregar al panel
        gamePane.getChildren().add(this.spriteView);

        /* https://openjfx.io/javadoc/21/javafx.graphics/javafx/animation/Timeline.html
         * https://openjfx.io/javadoc/21/javafx.graphics/javafx/animation/KeyFrame.html
         */
        // Crear la animación
        animation = new Timeline(
            new KeyFrame(Duration.millis(200), event -> updateFrame()) // Cambia de frame cada 0.2s
        );
        animation.setCycleCount(Timeline.INDEFINITE);
    }

    // Getters y Setters
    
    /**
     * Establece la posición del jugador en la pantalla.
     * 
     * @param x La posición horizontal del jugador.
     * @param y La posición vertical del jugador.
     */
    public void setPosition(double x, double y) {
        spriteView.setX(x);
        spriteView.setY(y);
    }

    /**
     * @return El ImageView que representa al jugador.
     */
    public ImageView getSpriteView() {
        return spriteView;
    }

    /**
     * @return El indice del sheet actual (entre 0 y el total de sheets).
     */
    public int getSheetIndex() {
        return sheetIndex;
    }

    /**
     * @return La posición horizontal del jugador en la pantalla.
     */
    public double getPositionX() {
        return spriteView.getX();
    }

    /**
     * @return La posición vertical del jugador en la pantalla.
     */
    public double getPositionY() {
        return spriteView.getX();
    }

    /**
     * Actualiza el frame actual del jugador.
     * 
     * Incrementa el contador de frame en 1 hasta el numero de frames totales
     * Luego actualiza la vista del ImageView para que muestre el nuevo frame.
     */
    private void updateFrame() {
        currentFrame = (currentFrame + 1) % frameCount;
        spriteView.setViewport(new Rectangle2D(currentFrame * frameWidth, sheetIndex * frameHeight, frameWidth, frameHeight));
    }

    /**
     * Comienza la animación actual.
     * 
     * Si se llama a este método cuando la animación ya esta en progreso, no hace nada.
     */
    public void startAnimation() {
        animation.play();
    }

    /**
     * Detiene la animación actual.
     * 
     * Si se llama a este método cuando la animación ya esta detenida, no hace nada.
     */
    public void stopAnimation() {
        animation.stop();
    }

    /**
     * Actualiza el sheet actual del jugador.
     * 
     * @param sheetIndex El nuevo sheet que se debe mostrar.
     */
    public void actualizarSheet(int sheetIndex) {
        this.sheetIndex = sheetIndex;
        spriteView.setViewport(new Rectangle2D(currentFrame * frameWidth, sheetIndex * frameHeight, frameWidth, frameHeight));
    }

}
