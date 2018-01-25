package main_classes;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import models.Game;
import services.DatabaseConnectionService;
import services.GameService;

import java.util.ArrayList;
import java.util.Objects;


public class Main {
    private static int screenWidth = 1000;
    private static int screenHeight = 562;
    private static Group group;
    private static Pane root;
    private int instance;

    private static DatabaseConnectionService database;

    public static void main(String[] args) {
        new JFXPanel();
        Platform.runLater(Main::launch);
    }

    private static void launch() {
        database = new DatabaseConnectionService("database/Workspace.db");

        ErrorHandler e = new ErrorHandler();
        Stage stage = new Stage();
        stage.setTitle("Avoid Death");
        stage.setResizable(false);
        stage.setWidth(screenWidth);
        stage.setHeight(screenHeight);
        stage.show();

        ArrayList<Game> al = new ArrayList<>();
        GameService.selectAll(al, database);
        System.out.println(al);

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
        try {
            System.out.println(3 / 0);
        } catch (Exception ex) {
            e.exception(ex);
        }

        vb.getChildren().addAll(label, text, butt);
        rect.setFill(Color.LIGHTGRAY);
        root.getChildren().addAll(rect, vb);
        group.getChildren().add(root);
        stage.setScene(scene);
    }

    public static void enterMenu(TextField text, ErrorHandler e) {
        if (!Objects.equals(text.getText(), "")) {
            Transition.screenChange(root, ScreenGen.getMenu(group), group, screenWidth, screenHeight, 1);
        } else {
            e.nullField();
        }
    }
}
