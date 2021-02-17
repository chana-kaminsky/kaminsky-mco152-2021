package kaminsky.physics;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.Button;
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

        scene.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>()
        {
            @Override
            public void handle(KeyEvent keyEvent)
            {
                // I can't figure out how to make this work
                if (keyEvent.getCode() == KeyCode.ENTER)
                {
                    System.out.println("calculate rocket....");
                }

                if (keyEvent.getCode() == KeyCode.ESCAPE)
                {
                    stage.close();
                }

                if (keyEvent.getCode() == KeyCode.DELETE)
                {
                    System.out.println("clear....");
                }
            }
        });
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
