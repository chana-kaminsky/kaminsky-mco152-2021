package kaminsky.physics;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Draws the Rocket to the Canvas
 */
public class RocketCanvas extends Canvas
{
    /**
     * Draws the path of the Rocket starting from time=0 to
     * the Rocket's flight time with one second intervals.
     * @param rocket object with velocity and angle
     */
    public void draw(Rocket rocket)
    {
        GraphicsContext context = getGraphicsContext2D();
        context.setFill(Color.VIOLET);
        context.fillRect(0,0,getWidth(), getHeight());

        context.translate(0,getHeight());
        context.setFill(Color.BLUE);
        context.setStroke(Color.DARKRED);
        context.setLineWidth(4);

        context.beginPath();
        for (double time = 0; time < rocket.getFlightTime()+1; time += 0.5)
        {
            double x = rocket.getX(time);
            double y = rocket.getY(time);
            // add 5 so the line goes in middle of the
            // dots which have a width and height of 10
            context.lineTo(x+5,-y+5);
            context.stroke();
            context.fillOval(x, -y, 10, 10);
        }
        context.translate(0, -getHeight());
    }

    public void clearCanvas()
    {
        GraphicsContext context = getGraphicsContext2D();
        context.clearRect(0,0,getWidth(), getHeight());
    }
}