package Clases;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class Player {
    private ImageView spriteView;
    private int sheetIndex = 0;
    private int currentFrame = 0;
    private int frameCount;
    private int frameWidth;
    private int frameHeight;
    private Timeline animation;

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

        // Crear la animación
        animation = new Timeline(
            new KeyFrame(Duration.millis(200), event -> updateFrame()) // Cambia de frame cada 0.2s
        );
        animation.setCycleCount(Timeline.INDEFINITE);
    }

    // Método para actualizar la animación
    private void updateFrame() {
        currentFrame = (currentFrame + 1) % frameCount;
        spriteView.setViewport(new Rectangle2D(currentFrame * frameWidth, sheetIndex * frameHeight, frameWidth, frameHeight));
    }

    // Métodos para controlar la animación
    public void startAnimation() {
        animation.play();
    }

    public void stopAnimation() {
        animation.stop();
    }

    public ImageView getSpriteView() {
        return spriteView;
    }

    public int getSheetIndex() {
        return sheetIndex;
    }

    public void actualizarSheet(int sheetIndex) {
        this.sheetIndex = sheetIndex;
        spriteView.setViewport(new Rectangle2D(currentFrame * frameWidth, sheetIndex * frameHeight, frameWidth, frameHeight));
    }

    public void setPosition(double x, double y) {
        spriteView.setX(x);
        spriteView.setY(y);
    }
}
