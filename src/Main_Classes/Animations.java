package Main_Classes;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Animations {
    public static AnimationTimer at;
    public AnimationTimer bone(GraphicsContext gc, Image image) {

        at = new AnimationTimer() {
            @Override
            public void handle(long now) {
                gc.setFill(Color.CYAN);
                gc.fillRect(0, 0, 1000, 1000);
                gc.drawImage(image, 200, 200);
            }
        };
        return at;
    }
}
