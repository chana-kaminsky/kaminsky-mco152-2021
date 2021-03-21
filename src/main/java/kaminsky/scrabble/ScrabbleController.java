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

    @FXML
    Label invalid;

    private final Dictionary dictionary;
    private final LetterBag letterBag;
    private int numPoints = 0;

    public ScrabbleController(Dictionary dictionary, LetterBag letterBag)
    {
        this.dictionary = dictionary;
        this.letterBag = letterBag;
    }

    public void initialize()
    {
        for (Label label : bottomLabels)
        {
            label.setAlignment(Pos.CENTER);
            label.setText(letterBag.nextLetter());
        }
    }

    public void onBottomClicked(MouseEvent event)
    {
        Label label = (Label) event.getSource();
        invalid.setText("");
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
        invalid.setText("");
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
        int numLetters = getNumLetters();
        if (numLetters != 0)
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
            invalid.setText("invalid word");
        }
    }

    public int getNumLetters()
    {
        StringBuilder stringBuilder = new StringBuilder();
        int numLetters = 0;
        for (int i = 0; i < topLabels.size(); i++)
        {
            if (!topLabels.get(i).getText().isEmpty())
            {
                stringBuilder.append(topLabels.get(i).getText());
            }
            else
            {
                numLetters = i;
                break;
            }
        }
        String word = stringBuilder.toString();
        if (!dictionary.search(word))
        {
            return 0;
        }
        return numLetters;
    }

    public void addPoints(int numLetters)
    {
        switch (numLetters)
        {
            case 2 -> numPoints += 1;
            case 3 -> numPoints += 3;
            case 4 -> numPoints += 5;
            case 5 -> numPoints += 7;
            case 6 -> numPoints += 11;
            case 7 -> numPoints += 13;
        }
        points.setText(String.valueOf(numPoints));
    }
}
