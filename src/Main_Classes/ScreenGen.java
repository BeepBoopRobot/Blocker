package Main_Classes;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;


import java.io.File;

public class ScreenGen {
    public static void menuScreen(Stage stage, Group group) {
        String soundFile = "src/Sounds/Half - Life 2 Soundtrack- Intro.mp3";
        String imageBak = "images/test_images/City17.jpg";
        Scene menuScene = new Scene(group, 500, 312, Color.FORESTGREEN);
        GridPane menuPane = new GridPane();
        Image image = new Image(imageBak);

        VBox vb = new VBox();
        Button butt = new Button("hah");
        butt.setOnAction((ActionEvent) -> System.out.println("Hello!"));

        ImagePattern pat = new ImagePattern(image);
        menuScene.setFill(pat);

        Media media = new Media(new File(soundFile).toURI().toString());
        MediaPlayer mp = new MediaPlayer(media);
        //mp.setAutoPlay(true);
        mp.setCycleCount(MediaPlayer.INDEFINITE);
        MediaView mv = new MediaView(mp);

        group.getChildren().add(menuPane);
        stage.setScene(menuScene);
        group.getChildren().addAll(mv, butt);
    }

    static Pane getMenu() {
        Group group = new Group();
        String soundFile = "src/Sounds/Half - Life 2 Soundtrack- Intro.mp3";
        String imageBak = "images/test_images/City17.jpg";
        Scene menuScene = new Scene(group, 500, 312, Color.FORESTGREEN);
        GridPane menuPane = new GridPane();
        Image image = new Image(imageBak);

        VBox vb = new VBox();
        Button butt = new Button("hah");
        butt.setOnAction((ActionEvent) -> System.out.println("Hello!"));
        vb.getChildren().add(butt);

        ImagePattern pat = new ImagePattern(image);
        menuScene.setFill(pat);

        Media media = new Media(new File(soundFile).toURI().toString());
       // MediaPlayer mp = new MediaPlayer(media);
        //mp.setAutoPlay(true);
        //mp.setCycleCount(MediaPlayer.INDEFINITE);
        //MediaView mv = new MediaView(mp);
        menuPane.getChildren().addAll(vb);
        return menuPane;
    }

}

