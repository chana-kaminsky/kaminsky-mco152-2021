package kaminsky.scrabble;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

public class ScrabbleController
{
    @FXML
    Label top0Label, top1Label, top2Label,
          top3Label, top4Label, top5Label, top6Label;

    @FXML
    Label bottom0Label, bottom1Label, bottom2Label,
          bottom3Label, bottom4Label, bottom5Label, bottom6Label;


    public void initialize()
    {
        setTopLabels();
        setBottomLabels();
    }

    private void setTopLabels()
    {
        Label[] labelList = {top0Label, top1Label, top2Label,
                             top3Label,top4Label, top5Label, top6Label};

        for (int i = 0; i < labelList.length; i++)
        {
            labelList[i].setMinWidth(50);
            labelList[i].setMinHeight(50);

            GridPane.setColumnIndex(labelList[i], i);
            GridPane.setRowIndex(labelList[i], 0);

            BorderStroke stroke = new BorderStroke(null,
                                  BorderStrokeStyle.SOLID,
                             null, BorderStroke.THIN);
            Border border = new Border(stroke);
            labelList[i].setBorder(border);
        }
    }

    private void setBottomLabels()
    {
        Label[] labelList = {bottom0Label, bottom1Label, bottom2Label,
                             bottom3Label, bottom4Label, bottom5Label, bottom6Label};

        for (int i = 0; i < labelList.length; i++)
        {
            labelList[i].setMinWidth(50);
            labelList[i].setMinHeight(50);

            GridPane.setColumnIndex(labelList[i], i);
            GridPane.setRowIndex(labelList[i], 2);

            BorderStroke stroke = new BorderStroke(null,
                                  BorderStrokeStyle.SOLID,
                             null, BorderStroke.THIN);
            Border border = new Border(stroke);
            labelList[i].setBorder(border);
        }
    }
}
