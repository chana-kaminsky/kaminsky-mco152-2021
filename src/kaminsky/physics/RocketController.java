package kaminsky.physics;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class RocketController
{
    @FXML
    TextField angleField;
    @FXML
    TextField secondsField;
    @FXML
    TextField velocityField;
    @FXML
    Label flightTimeLabel;
    @FXML
    Label errorMessageLabel;
    @FXML
    Label xLabel;
    @FXML
    Label yLabel;
    @FXML
    RocketCanvas rocketCanvas;

    public void calculateRocket(ActionEvent actionEvent)
    {
       try
       {
           errorMessageLabel.setText("");
           double velocity = Double.parseDouble(velocityField.getText());
           double angle = Double.parseDouble(angleField.getText());
           double seconds = Double.parseDouble(secondsField.getText());

           Rocket rocket = new Rocket(velocity, angle);
           // three decimal places
           flightTimeLabel.setText(String.format("%.3f", rocket.getFlightTime()));
           xLabel.setText(String.format("%.3f", rocket.getX(seconds)));
           yLabel.setText(String.format("%.3f", rocket.getY(seconds)));

           rocketCanvas.draw(rocket);
       }
       catch (Exception exception)
       {
           errorMessageLabel.setText("Error: Please try again");
       }

    }

    public void clear(ActionEvent actionEvent)
    {
        angleField.setText("");
        velocityField.setText("");
        secondsField.setText("");
        flightTimeLabel.setText("");
        errorMessageLabel.setText("");
        xLabel.setText("");
        yLabel.setText("");

    }
}
