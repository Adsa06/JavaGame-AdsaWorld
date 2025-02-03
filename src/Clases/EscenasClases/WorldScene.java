/*
 * Autor: Aitor de Santos Amoros
 * Fecha de creacion: 29/01/2025
 * Descripcion: Escena principal para el mundo
 */
package Clases.EscenasClases;

import Clases.EntityScene.Player;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class WorldScene {

   private Scene scene;
   private Pane gamePane = new Pane();
   private Pane backgroundPane = new Pane();

   private int velocidad = 1;
   private String keyPressed = "";
   private String NewkeyPressed = "";
   private int contadorMovimiento = 0;
   private boolean isWalking = false;

   public WorldScene() {
      // Creo una imagen con los siguientes parametros: Ruta, ancho, alto,
      // preserveRatio, smooth (Aunque piendo que esta bug las 2 ultimas)
      // https://openjfx.io/javadoc/21/javafx.graphics/javafx/scene/image/Image.html
      // https://openjfx.io/javadoc/21/javafx.graphics/javafx/scene/image/ImageView.html
      Image imageLimits = new Image("file:Sprites/LimitsMap.png", 480 * 4.5, 320 * 4.5, false, false);
      ImageView spriteLimits = new ImageView(imageLimits);
      // De esta manera consigo contener en un solo panel todo el fondo para manejarlo
      // mas facilmente (Aqui puedo incluir los npc)
      backgroundPane.getChildren().add(spriteLimits);

      Image imageBackGround = new Image("file:Sprites/Casillas.png", 480*4.5, 320*4.5, false, false);
      ImageView spriteBackGround = new ImageView(imageBackGround);
      // De esta manera consigo contener en un solo panel todo el fondo para manejarlo mas facilmente (Aqui puedo incluir los npc)
      backgroundPane.getChildren().add(spriteBackGround);
      gamePane.getChildren().add(backgroundPane);

      Player jugador = new Player("file:Sprites/PlayerSheets.png", 16, 32, 4, 4, 4, gamePane);
      jugador.startAnimation();
      jugador.setPosition(724, 328);

      // Establezco la escena
      scene = new Scene(gamePane, 1280, 720);

      // Para leer los píxeles de la imagen
      PixelReader pixelReader = imageLimits.getPixelReader();

      // Timeline que se ejecuta 60 veces por segundo (Esto me viene de lujo ya que
      // puedo tener un flujo constante)
      Timeline timelineMovment = new Timeline(
            new KeyFrame(Duration.millis(5), event -> { // Esto hace que se ejecute cada 5ms
               if (contadorMovimiento % 72 == 0)
                  NewkeyPressed = keyPressed;
               if (isWalking || contadorMovimiento % 72 != 0) {
                  moveBackground(backgroundPane, NewkeyPressed, jugador, pixelReader);
                  System.out.println(keyPressed);
                  this.contadorMovimiento++;
               }
            }));
      // Esto hace que se ejecute indefinidamente
      timelineMovment.setCycleCount(Timeline.INDEFINITE);
      timelineMovment.play();

      // https://openjfx.io/javadoc/21/javafx.graphics/javafx/scene/Scene.html
      // Define una función que se llamará cuando algún Nodo (algun panel) de esta
      // Escena tenga foco de entrada y se haya presionado una tecla.
      // La función se llama solo si el evento aún no se ha consumido durante su fase
      // de captura o difusión.
      // Es decir que no acaba hasta que no termina la accion (Tambien cuenta cuando
      // se llama a una funcion)
      scene.setOnKeyPressed(event -> {
         if ("WASD".contains(event.getCode().toString())) {
            keyPressed = event.getCode().toString();
            isWalking = true;
         }
      });
      scene.setOnKeyReleased(event -> {
         isWalking = false;
      });

   }

   public Scene getScene() {
      return scene;
   }

   /**
    * Mueve el fondo de la escena segun la tecla que se pulse.
    * Cambia la direccion del player segun la tecla que se pulse.
    * 
    * @param spriteBackGround El ImageView que representa el fondo.
    * @param key              La tecla que se ha pulsado, puede ser 'A', 'D', 'W',
    *                         'S'.
    * @param spritePlayer     El ImageView que representa al jugador.
    */
   public void moveBackground(Pane backgroundPane, String key, Player jugador, PixelReader pixelReader) { // 36 pixeles

      final int PLAYER_CENTER_X = 760;
      final int PLAYER_CENTER_Y = 400;      
      final int PLAYER_WIDTH_X = 8*4;
      final int PLAYER_HIGH_Y = 16*4;
      final int OFFSET = 36;
      final Color COLOR_COLISION = Color.web("#FF00FF");

      double posicionX = backgroundPane.getTranslateX();
      double posicionY = backgroundPane.getTranslateY();

      // Obtener el color del píxel en la nueva posición
      Color pixelColor;

      switch (key) {
         case "A":
            pixelColor = pixelReader.getColor(
                  (-1 * (int) posicionX) + PLAYER_CENTER_X - OFFSET,
                  (-1 * (int) posicionY) + PLAYER_CENTER_Y);
            if (jugador.getSheetIndex() != 3)
               jugador.actualizarSheet(3);
            if (!pixelColor.equals(COLOR_COLISION))
               backgroundPane.setTranslateX(posicionX + velocidad);
            break;
         case "D":
            pixelColor = pixelReader.getColor(
                  (-1 * (int) posicionX) + PLAYER_CENTER_X + OFFSET,
                  (-1 * (int) posicionY) + PLAYER_CENTER_Y);
            if (jugador.getSheetIndex() != 1)
               jugador.actualizarSheet(1);
            if (!pixelColor.equals(COLOR_COLISION))
               backgroundPane.setTranslateX(posicionX - velocidad);
            break;
         case "W":
            pixelColor = pixelReader.getColor(
                  (-1 * (int) posicionX) + PLAYER_CENTER_X,
                  (-1 * (int) posicionY) + PLAYER_CENTER_Y - OFFSET);
            if (jugador.getSheetIndex() != 2)
               jugador.actualizarSheet(2);
            if (!pixelColor.equals(COLOR_COLISION))
               backgroundPane.setTranslateY(posicionY + velocidad);
            break;
         case "S":
            pixelColor = pixelReader.getColor(
                  (-1 * (int) posicionX) + PLAYER_CENTER_X,
                  (-1 * (int) posicionY) + PLAYER_CENTER_Y + OFFSET);
            if (jugador.getSheetIndex() != 0)
               jugador.actualizarSheet(0);
            if (!pixelColor.equals(COLOR_COLISION))
               backgroundPane.setTranslateY(posicionY - velocidad);
            break;
         default:
            break;
      }
   }
}