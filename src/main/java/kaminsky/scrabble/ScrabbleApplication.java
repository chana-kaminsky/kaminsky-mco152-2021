package kaminsky.scrabble;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ScrabbleApplication extends Application
{
    @Override
    public void start(Stage stage) throws Exception {

        Dictionary dictionary = new Dictionary("dictionary.txt");
        LetterBag letterBag = new LetterBag();
        ScrabbleController controller = new ScrabbleController(dictionary, letterBag);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/scrabble_application.fxml"));
        loader.setController(controller);

        Parent parent = loader.load();
        Scene scene = new Scene(parent, 500, 300);

        stage.setTitle("Scrabble Game");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
