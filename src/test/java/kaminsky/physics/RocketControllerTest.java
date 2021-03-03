package kaminsky.physics;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class RocketControllerTest {

    @BeforeClass
    public static void beforeClass() {
        com.sun.javafx.application.PlatformImpl.startup(()->{});
    }


    @Test
    public void calculateRocket()
    {
        // given
        RocketController controller = new RocketController();

        controller.velocityField = mock(TextField.class);
        doReturn("71").when(controller.velocityField).getText();

        controller.angleField = mock(TextField.class);
        doReturn("35").when(controller.angleField).getText();

        controller.secondsField = mock(TextField.class);
        doReturn("3").when(controller.secondsField).getText();

        controller.rocketCanvas = mock(RocketCanvas.class);
        controller.xLabel = mock(Label.class);
        controller.yLabel = mock(Label.class);
        controller.flightTimeLabel = mock(Label.class);
        controller.errorMessageLabel = mock(Label.class);
        ActionEvent event = mock(ActionEvent.class);

        // when
        controller.calculateRocket(null);

        // then
        verify(controller.xLabel).setText("174.48");
        verify(controller.yLabel).setText("78.07");

        verify(controller.rocketCanvas).draw(any(Rocket.class));

    }
}