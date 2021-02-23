package kaminsky.scrabble;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class ScrabbleController
{
    @FXML
    TextField wordField;
    @FXML
    Label messageLabel;
    @FXML
    TextField filenameField;

    public void searchWord(ActionEvent actionEvent)
    {
        Scrabble dictionary = new Scrabble(filenameField.getText());
        if (dictionary.getDictionary().isEmpty())
        {
            messageLabel.setText("Error: file not found");
        }
        else
        {
            if (dictionary.search(wordField.getText()))
            {
                messageLabel.setText("");
                messageLabel.setText(wordField.getText() + " was found in the dictionary!");
            }
            else
            {
                messageLabel.setText("Sorry, that is not a word");
            }
        }
        wordField.clear();
    }

}
