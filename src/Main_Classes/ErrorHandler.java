package Main_Classes;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.WindowEvent;

import java.awt.event.InputEvent;
import java.util.Optional;

public class ErrorHandler {
    public void nullFeature() {
        Alert al = new Alert(AlertType.INFORMATION);
        al.setTitle("Doesn't work");
        al.setHeaderText("This feature hasn't been implemented yet");
        al.setContentText("It doesn't work m8, press ok to continue");
        al.showAndWait();
    }

    public void nullField() {
        Alert al = new Alert(AlertType.INFORMATION);
        al.setTitle("Need Input");
        al.setHeaderText("This field cannot be empty");
        al.setContentText("Please enter something to continue");
        al.showAndWait();
    }
}
