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
    Label boardLabel;
    @FXML
    Label errorMessageLabel;
    @FXML
    TextField filenameField;

    public void addWord(ActionEvent actionEvent)
    {
        if (ScrabbleApplication.board.getDictionary().isEmpty())
        {
            errorMessageLabel.setText("Error: no board");
        }
        else
        {
            if (ScrabbleApplication.board.search(wordField.getText()))
            {
                errorMessageLabel.setText("");

                ArrayList<String> boardWords = ScrabbleApplication.board.getWords();
                boardLabel.setText(boardLabel.getText() + "\n" + boardWords.get(boardWords.size()-1));
            }
            else
            {
                errorMessageLabel.setText("Sorry, that is not a word");
            }
        }
        wordField.setText("");
    }

    public void newBoard()
    {
        boardLabel.setText("Scrabble Board:");
        ScrabbleApplication.board = new Scrabble(filenameField.getText());

        if (ScrabbleApplication.board.getDictionary().isEmpty())
        {
            errorMessageLabel.setText("Error: file not found");
        }
        else
        {
            errorMessageLabel.setText("");
        }
    }
}
