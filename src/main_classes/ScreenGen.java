package main_classes;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;

class ScreenGen {

    static ErrorHandler e = new ErrorHandler();

    static Pane getMenu(Group extGroup) {

        String soundFile = "sounds/Half - Life 2 Soundtrack- Intro.mp3";
        GridPane menuPane = new GridPane();
     //   Group group = new Group();
    //    Scene menuScene = new Scene(group, 1000, 562, Color.FORESTGREEN);
        menuPane.setId("menu-pane");
        menuPane.setStyle("-fx-background-size: 1000 562;");
        menuPane.getStylesheets().add("files/stylesheet.css");

        MediaPlayer mp = null;
        try {
      //      Media media = new Media(new File(soundFile).toURI().toString());
       //     mp = new MediaPlayer(media);
        } catch (Exception ex) {
            e.exception(ex);
        }
        if (mp == null) {
            e.medErr();
         //   System.exit(0);
        }

        VBox vb = new VBox();
        vb.setPrefWidth(1000);
        vb.setPrefHeight(562);
        vb.setSpacing(10);
        vb.setAlignment(Pos.CENTER);

        /*Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(2),
                        new KeyValue(mp.volumeProperty(), 0)));*/
        Button butt = new Button("Play");
        Button butt2 = new Button("test");
        butt.setOnAction((ActionEvent) -> {
            e.explain();
            //timeline.play();
        });
        butt2.setOnAction((ActionEvent) -> {
            Transition.screenChange(menuPane, getSettingScreen(extGroup), extGroup, 1000, 562, 0);
        });
        vb.getChildren().addAll(butt, butt2);


       // mp.setAutoPlay(true);
      //  mp.setCycleCount(MediaPlayer.INDEFINITE);
      //  MediaView mv = new MediaView(mp);
        menuPane.getChildren().addAll(vb);
        return menuPane;
    }

    static Pane getSettingScreen(Group extGroup) {
        Pane settingPane = new Pane();
        Group group = new Group();
        Scene settingScene = new Scene(group, 1000, 562, Color.FORESTGREEN);
        settingScene.getStylesheets().add("files/stylesheet.css");
        settingPane.setStyle("-fx-background-size: 1000 562;");
        settingPane.setId("setting-pane");

        VBox vb = new VBox();
        vb.setPrefWidth(1000);
        vb.setPrefHeight(562);
        vb.setSpacing(10);
        vb.setAlignment(Pos.CENTER);

        Button butt = new Button("test");
        butt.setOnAction((ActionEvent) -> e.dbErr());
        vb.getChildren().add(butt);

        settingPane.getChildren().add(vb);
        return settingPane;

    }

}