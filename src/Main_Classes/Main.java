package Main_Classes;

import Models.*;
import Services.*;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.geometry.Pos;
import javafx.scene.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class Main {
    public static int screenWidth = 1000;
    public static int screenHeight = 562;

    public static DatabaseConnectionService database;

    public static void main(String[] args) {
        new JFXPanel();
        Platform.runLater(Main::launch);
    }


    private static void launch() {
        database = new DatabaseConnectionService("src/Workspace.db");
        ErrorHandler e = new ErrorHandler();

        Stage stage = new Stage();
        stage.setTitle("Avoid Death");
        stage.setResizable(false);
        stage.setWidth(screenWidth);
        stage.setHeight(screenHeight);
        stage.show();

        Group group = new Group();
        Scene scene = new Scene(group);
        Pane root = new Pane();
        Rectangle rect = new Rectangle(0, 0, screenWidth, screenHeight);

        VBox vb = new VBox();
        vb.setPrefWidth(screenWidth);
        vb.setPrefHeight(screenHeight);
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(10);

        Label label = new Label("Enter a user name: ");
        TextField text = new TextField();
        text.setMaxWidth(200);
        Button butt = new Button("Enter");
        butt.setOnAction(event -> {
            if (!Objects.equals(text.getText(), "")) {
                e.nullFeature();
                System.out.println(text.getText());
                Transition.screenChange(root, ScreenGen.getMenu(), group, screenWidth, screenHeight);
            } else {
                e.nullField();
            }
        });
        vb.getChildren().addAll(label, text, butt);
        rect.setFill(Color.LIGHTGRAY);
        root.getChildren().addAll(rect, vb);
        group.getChildren().add(root);
        stage.setScene(scene);
    }
}
