package kaminsky.scrabble;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ScrabbleApplication extends Application
{
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("scrabble_application.fxml"));
        Scene scene = new Scene(root, 450, 250);

        stage.setTitle("Scrabble");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}


