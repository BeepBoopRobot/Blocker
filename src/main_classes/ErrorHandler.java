package main_classes;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

import java.io.PrintWriter;
import java.io.StringWriter;

class ErrorHandler {
    void nullFeature() {
        Alert al = new Alert(AlertType.INFORMATION);
        al.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        al.setTitle("Doesn't work");
        al.setHeaderText("This feature hasn't been implemented yet");
        al.setContentText("It doesn't work m8, press ok to continue");
        al.showAndWait();
    }

    void nullField() {
        Alert al = new Alert(AlertType.INFORMATION);
        al.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        al.setTitle("Need Input");
        al.setHeaderText("This field cannot be empty");
        al.setContentText("Please enter something to continue");
        al.showAndWait();
    }

    void explain() {
        Alert al = new Alert(AlertType.INFORMATION);
        al.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        al.setTitle("Not done");
        al.setHeaderText("The game isn't done yet");
        al.setContentText("Everything else is implemented but the main game. Sorry :/");
        al.showAndWait();
    }

    void dbErr() {
        Alert al = new Alert(AlertType.ERROR);
        al.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        al.setTitle("Database Error!");
        al.setHeaderText("There was a problem loading data from the database");
        al.setContentText("I'll configure this alert later");
        al.showAndWait();
    }

    void exception(Exception ex) {
        Alert al = new Alert(AlertType.ERROR);
        al.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        al.setTitle("Exception!");
        al.setHeaderText("Something broke!");
        al.setContentText("Error message: " + ex.getMessage());

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        String exceptionText = sw.toString();

        Label label = new Label("Here's the details:");

        TextArea textArea = new TextArea(exceptionText);
        textArea.setEditable(false);
        textArea.setWrapText(true);

        textArea.setMinWidth(700);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);

        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(label, 0, 0);
        expContent.add(textArea, 0, 1);

        al.getDialogPane().setExpandableContent(expContent);
        al.getDialogPane().setExpanded(true);
        al.showAndWait();

    }
}
