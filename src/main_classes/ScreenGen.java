package main_classes;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.util.Duration;


import java.io.File;

public class ScreenGen {

    static Pane getMenu() {
        Group group = new Group();
        String soundFile = "src/Sounds/Half - Life 2 Soundtrack- Intro.mp3";
        Scene menuScene = new Scene(group, 1000, 562, Color.FORESTGREEN);
        GridPane menuPane = new GridPane();
        menuPane.setId("menu-pane");
        menuPane.setStyle("-fx-background-size: 1000 562;");
        menuScene.getStylesheets().add("files/stylesheet.css");
        Media media = new Media(new File(soundFile).toURI().toString());
        MediaPlayer mp = new MediaPlayer(media);

        VBox vb = new VBox();
        vb.setPrefWidth(1000);
        vb.setPrefHeight(562);
        vb.setAlignment(Pos.CENTER);
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(2),
                        new KeyValue(mp.volumeProperty(), 0)));
        Button butt = new Button("hah");
        butt.setOnAction((ActionEvent) -> {
            System.out.println("Hello!");
            timeline.play();
        });
        vb.getChildren().add(butt);


        mp.setAutoPlay(true);
        mp.setCycleCount(MediaPlayer.INDEFINITE);
        MediaView mv = new MediaView(mp);
        menuPane.getChildren().addAll(vb);
        return menuPane;
    }

}