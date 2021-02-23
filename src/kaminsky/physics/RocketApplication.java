package kaminsky.physics;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import kaminsky.scrabble.Scrabble;

public class RocketApplication extends Application
{
    public void start(Stage stage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("rocket_application.fxml"));

        Scene scene = new Scene(root, 400, 500);

        stage.setTitle("Rocket Calculator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
