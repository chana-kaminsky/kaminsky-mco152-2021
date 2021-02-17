package kaminsky.scrabble;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class ScrabbleApplication extends Application
{
    public static Scrabble board = new Scrabble("");

    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("scrabble_application.fxml"));
        Scene scene = new Scene(root, 500, 400);

        stage.setTitle("Scrabble");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}


