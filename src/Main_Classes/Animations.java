package Main_Classes;

import javafx.animation.*;
import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

class Animations {
    private static AnimationTimer at;

    Timeline bone(GraphicsContext gc, Group group) {
        Image image = new Image("images/test_images/skeleton-animated-gif-20.gif");
        ImageView img = new ImageView(image);
        group.getChildren().add(img);
        final Timeline tl = new Timeline();
        tl.setCycleCount(1);
        tl.setAutoReverse(false);
        tl.setCycleCount(Timeline.INDEFINITE);
        tl.getKeyFrames().addAll(
                new KeyFrame(Duration.ZERO, new KeyValue(img.translateXProperty(), 500), new KeyValue(img.translateYProperty(), 100)),
                new KeyFrame(Duration.millis(5000), new KeyValue(img.translateXProperty(), 500), new KeyValue(img.translateYProperty(), 100)),
                new KeyFrame(Duration.millis(9000), new KeyValue(img.translateXProperty(), 1800), new KeyValue(img.translateYProperty(), 100))
        );
        return tl;
    }

    Timeline sneakyMan(GraphicsContext gc, Group group) {
        gc.setFont(new Font("Arial", 30));
        final Text rect = new Text(-100, 100, "ᕙ( ͡° ͜ʖ ͡°)ᕗ");
        rect.setFont(new Font("Arial", 30));
        rect.setFill(Color.RED);

        group.getChildren().add(rect);
        final Timeline tl = new Timeline();
        tl.setCycleCount(Timeline.INDEFINITE);
        tl.setAutoReverse(false);
        tl.getKeyFrames().addAll(
                new KeyFrame(Duration.ZERO, new KeyValue(rect.translateXProperty(), -800), new KeyValue(rect.translateYProperty(), 100)),
                new KeyFrame(Duration.millis(1000), new KeyValue(rect.translateXProperty(), 50), new KeyValue(rect.translateYProperty(), 100)),
                new KeyFrame(Duration.millis(2000), new KeyValue(rect.translateXProperty(), 50), new KeyValue(rect.translateYProperty(), 100)),
                new KeyFrame(Duration.millis(3000), new KeyValue(rect.translateXProperty(), -800), new KeyValue(rect.translateYProperty(), 100)),
                new KeyFrame(Duration.millis(5000), new KeyValue(rect.translateXProperty(), 500), new KeyValue(rect.translateYProperty(), 100)),
                new KeyFrame(Duration.millis(9000), new KeyValue(rect.translateXProperty(), 1800), new KeyValue(rect.translateYProperty(), 100))
        );
        return tl;
    }
}
