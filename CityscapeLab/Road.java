import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;
/**
 * For drawing the road
 * 
 * @author Felix Zheng 
 * @version 1
 */
public class Road
{
    // instance variables - replace the example below with your own
    private int SCREEN_X, SCREEN_Y;
    /**
     * Constructor for objects of class Road
     * @param screenX The width of the frame/screen
     * @param screenY The height of the frame/screen
     */
    public Road(int screenX, int screenY)
    {
        // initialise instance variables
        this.SCREEN_X = screenX;
        this.SCREEN_Y = screenY;
    }
    /**
     * Draws the road when called
     * @param  g2   the graphics object
     */
    public void draw(Graphics2D g2)
    {
               
        Rectangle background = new Rectangle(0,SCREEN_Y*3/4,SCREEN_X,SCREEN_Y/4);
        g2.setPaint(Color.BLACK);
        g2.fill(background);
        g2.draw(background);        
    }
}
