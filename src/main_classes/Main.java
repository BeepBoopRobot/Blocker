package main_classes;

import services.*;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.geometry.Pos;
import javafx.scene.*;

import java.io.*;
import java.util.Objects;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class Main {
    public static int screenWidth = 1000;
    public static int screenHeight = 562;
    public static Group group;
    public static Pane root;

    public static DatabaseConnectionService database;

    public static void main(String[] args) {
        new JFXPanel();
        Platform.runLater(Main::launch);
    }


    private static void launch() {
        database = new DatabaseConnectionService("src/Workspace.db");
        ErrorHandler e = new ErrorHandler();
        Image image = new Image(new File("files/images/test_images/main_images/Menu_Image.jpg").toURI().toString());
        Stage stage = new Stage();
        stage.setTitle("Avoid Death");
        stage.setResizable(false);
        stage.setWidth(screenWidth);
        stage.setHeight(screenHeight);
        stage.show();

        group = new Group();
        Scene scene = new Scene(group);
        scene.getStylesheets().add("files/stylesheet.css");
        root = new Pane();
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
        butt.setOnAction(event -> enterMenu(text, e));
        text.setOnKeyPressed(ke -> {
            if (ke.getCode().equals(KeyCode.ENTER)) {
                enterMenu(text, e);
            }
        });

        vb.getChildren().addAll(label, text, butt);
        rect.setFill(Color.LIGHTGRAY);
       // vb.setId("pane");
        root.getChildren().addAll(rect, vb);
        group.getChildren().add(root);
        stage.setScene(scene);
    }

    public static void enterMenu(TextField text, ErrorHandler e) {
        if (!Objects.equals(text.getText(), "")) {
            e.nullFeature();
            System.out.println(text.getText());
            Transition.screenChange(root, ScreenGen.getMenu(), group, screenWidth, screenHeight);
        } else {
            e.nullField();
        }
    }
}