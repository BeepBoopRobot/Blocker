package Main_Classes;

import javafx.animation.*;
import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Animations {
    private static AnimationTimer at;
    private static Timeline t;

    AnimationTimer bone(GraphicsContext gc, Image image) {

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

        Timeline sneakyMan(GraphicsContext gc, Group group) {
        gc.setFont(new Font("Arial", 30));
        final Text rect = new Text(100,100,"ᕙ( ͡° ͜ʖ ͡°)ᕗ");
        rect.setFont(new Font("Arial", 30));
        rect.setFill(Color.RED);
        group.getChildren().add(rect);
        /*at = new AnimationTimer() {
            @Override
            public void handle(long now) {
                gc.setStroke(Color.BLUE);
                gc.setFill(Color.RED);
                gc.fillRect(0,0,1000,1000);
                gc.strokeText("ᕙ( ͡° ͜ʖ ͡°)ᕗ",100,500);
            }
        };
        return at; */
        final Timeline tl = new Timeline();
        tl.setCycleCount(Timeline.INDEFINITE);
        tl.setAutoReverse(true);
        final KeyValue kv = new KeyValue(rect.xProperty(), 800, Interpolator.LINEAR);
        final KeyFrame kf = new KeyFrame(Duration.millis(5000), kv);
        tl.getKeyFrames().add(kf);
        return tl;
    }
}
