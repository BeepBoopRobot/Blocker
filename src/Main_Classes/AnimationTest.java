package Main_Classes;

import javafx.animation.AnimationTimer;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class AnimationTest {
    public static AnimationTimer at;

    public static void main(String[] args) {
        new JFXPanel();
        Platform.runLater(AnimationTest::Launch);
        Platform.runLater(AnimationTest::Control);
    }

    private static void Launch() {
        Stage stage = new Stage();
        stage.setTitle("Animation Test");
        stage.setWidth(1000);
        stage.setHeight(1000);
        stage.setResizable(false);
        stage.show();

        Group group = new Group();
        Scene scene = new Scene(group);
        Canvas canvas = new Canvas();
        canvas.setWidth(1000);
        canvas.setHeight(1000);
        group.getChildren().add(canvas);
        stage.setScene(scene);

        ErrorHandler e = new ErrorHandler();
        GraphicsContext gc = canvas.getGraphicsContext2D();

        Image image = new Image("images/test_images/skeleton-animated-gif-20.gif");
        ImageView iv = new ImageView(image);
        Animations a = new Animations();

        Timeline at = a.sneakyMan(gc, group);
        at.play();
        Timeline at2 = a.bone(gc, group);
        at2.play();

    }


    private static void Control() {
        Stage stage = new Stage();
        stage.setTitle("Controller");
        stage.setWidth(323);
        stage.setHeight(200);
        stage.setResizable(false);
        stage.show();

        Group group= new Group();
        Scene scene = new Scene(group);
        stage.setScene(scene);

        Button close = new Button("Close");
        close.setOnAction((ActionEvent) -> System.exit(0));
        group.getChildren().add(close);
    }
}
