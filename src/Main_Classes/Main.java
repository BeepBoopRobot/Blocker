package Main_Classes;

import Models.*;
import Services.*;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.*;

import java.io.*;
import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;


public class Main {

    public static DatabaseConnectionService database;

    public static void main(String[] args) {
        new JFXPanel();
        Platform.runLater(Main::launch);
    }


    private static void launch() {
        database = new DatabaseConnectionService("src/Workspace.db");

        Stage stage = new Stage();
        stage.setTitle("Avoid Death");
        stage.setResizable(false);
        stage.show();
        Group group = new Group();
        ScreenGen.menuScreen(stage, group);
        ErrorHandler e = new ErrorHandler();
        e.nullFeature();
    }
}
