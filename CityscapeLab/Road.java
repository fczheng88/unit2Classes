import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.Point;
import java.awt.Color;
import java.awt.GradientPaint;
/**
 * Write a description of class Road here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Road
{
    // instance variables - replace the example below with your own
    private int SCREEN_X, SCREEN_Y;

    /**
     * Constructor for objects of class Road
     */
    public Road(int screenX, int screenY)
    {
        // initialise instance variables
        this.SCREEN_X = screenX;
        this.SCREEN_Y = screenY;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void drawRoad(Graphics2D g2)
    {
        
        
        Rectangle background = new Rectangle(0,SCREEN_Y*3/4,SCREEN_X,SCREEN_Y);
        g2.setPaint(Color.BLACK);
        
        g2.fill(background);
        g2.draw(background);
        
    }
}
