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

    public void initialize()
    {
        setTopLabels();
        setBottomLabels();
    }

    private void setTopLabels()
    {
        for (int i = 0; i < topLabels.size(); i++)
        {
            topLabels.get(i).setMinWidth(50);
            topLabels.get(i).setMinHeight(50);

            GridPane.setColumnIndex(topLabels.get(i), i);
            GridPane.setRowIndex(topLabels.get(i), 0);

            BorderStroke stroke = new BorderStroke(null,
                                  BorderStrokeStyle.SOLID,
                             null, BorderStroke.THIN);
            Border border = new Border(stroke);
            topLabels.get(i).setBorder(border);
        }
    }

    private void setBottomLabels()
    {
        for (int i = 0; i < bottomLabels.size(); i++)
        {
            bottomLabels.get(i).setMinWidth(50);
            bottomLabels.get(i).setMinHeight(50);

            GridPane.setColumnIndex(bottomLabels.get(i), i);
            GridPane.setRowIndex(bottomLabels.get(i), 2);

            BorderStroke stroke = new BorderStroke(null,
                                  BorderStrokeStyle.SOLID,
                             null, BorderStroke.THIN);
            Border border = new Border(stroke);
            bottomLabels.get(i).setBorder(border);
            bottomLabels.get(i).setAlignment(Pos.CENTER);
            bottomLabels.get(i).setText(letterBag.nextLetter());
        }
    }

    LetterBag letterBag = new LetterBag();

    public ScrabbleController()
    {
        Dictionary dictionary = new Dictionary("dictionary.txt");
    }

    public void onAnswerClicked(MouseEvent event)
    {
        Label label = (Label) event.getSource();
    }

    public void onClear(ActionEvent event)
    {

    }

    public void onSubmit(ActionEvent event)
    {

    }
}
