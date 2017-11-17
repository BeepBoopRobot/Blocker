package Main_Classes;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;

public class AnimationTest {
    public AnimationTimer at;

    public static void main(String[] args) {
        new JFXPanel();
        Platform.runLater(AnimationTest::Launch);
        Platform.runLater(AnimationTest::Control);
    }

    private static void Launch() {
        Stage stage = new Stage();
        stage.setTitle("I actually wanna fuckin die");

    }

    private static void Control() {
        Stage stage = new Stage();
    }
}
