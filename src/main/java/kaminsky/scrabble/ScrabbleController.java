package kaminsky.scrabble;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import java.util.List;

public class ScrabbleController
{
    @FXML
    List<Label> topLabels;

    @FXML
    List<Label> bottomLabels;

    @FXML
    Label points;

    public void initialize()
    {
        for (Label label : bottomLabels) {
            label.setAlignment(Pos.CENTER);
            label.setText(letterBag.nextLetter());
        }
    }

    private final LetterBag letterBag = new LetterBag();
    private final Dictionary dictionary = new Dictionary("dictionary.txt");

//    public ScrabbleController()
//    {
//        Dictionary dictionary = new Dictionary("dictionary.txt");
//    }

    public void onBottomClicked(MouseEvent event)
    {
        Label label = (Label) event.getSource();
        for (Label topLabel : topLabels)
        {
            if (topLabel.getText().isEmpty())
            {
                topLabel.setText(label.getText());
                topLabel.setAlignment(Pos.CENTER);
                break;
            }
        }
        label.setText("");
    }

    public void onClear(ActionEvent event)
    {
        for (Label topLabel : topLabels)
        {
            for (Label bottomLabel : bottomLabels)
            {
                if (bottomLabel.getText().isEmpty())
                {
                    bottomLabel.setText(topLabel.getText());
                    topLabel.setText("");
                    break;
                }
            }
        }
    }

    public void onSubmit(ActionEvent event)
    {
        String word = "";
        int numLetters = 0;
        for (int i = 0; i < topLabels.size(); i++)
        {
            if (!topLabels.get(i).getText().isEmpty())
            {
                word += topLabels.get(i).getText();
            }
            else
            {
                numLetters = i;
                break;
            }
        }
        if (dictionary.search(word))
        {
            addPoints(numLetters);
            for (int i = 0; i < bottomLabels.size(); i++)
            {
                if (bottomLabels.get(i).getText().isEmpty())
                {
                    bottomLabels.get(i).setText(letterBag.nextLetter());
                }
                topLabels.get(i).setText("");
            }
        }
        else
        {
            onClear(event);
        }
    }

    public void addPoints(int numLetters)
    {
        // assume 6 letters = 9pt and 7 letters = 11pt
        int numPoints = Integer.parseInt(points.getText());
        if (numLetters > 1)
        {
            numPoints += 2 * numLetters - 3;
            points.setText(String.valueOf(numPoints));
        }
    }
}
