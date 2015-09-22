import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

/**
 * Target Class
 * 
 * @author Felix
 * @version 1
 */
public class Target
{
    // instance variables - replace the example below with your own
    private int x;
    private int y;
    private double radius;
    private double radiusPerCircle;
    

    /**
     * Constructor for objects of class Target
     * @param x the x-coordinate of the centre
     * @param y the y-coordinate of the centre 
     * @param radius the radius of the circle
     * 
     */
    public Target(int x, int y, double radius)
    {
        // initialise instance variables
        this.x = x;
        this.y = y;
        this.radiusPerCircle = radius/5;
    }

    /**
     * Draws the car
     * 
     * @param  g2   the graphics stuff
     * 
     */
    public void draw(Graphics2D g2)
    {
        Ellipse2D.Double outerBlack = new Ellipse2D.Double(x, y, radius, radius);
        Ellipse2D.Double bigWhite = new Ellipse2D.Double(x, y, radius-radiusPerCircle, radius-radiusPerCircle);
        Ellipse2D.Double midBlack = new Ellipse2D.Double(x, y, radius-radiusPerCircle*2, radius-radiusPerCircle*2);
        Ellipse2D.Double smallBlack = new Ellipse2D.Double(x, y, radius-radiusPerCircle*3, radius-radiusPerCircle*3);
        Ellipse2D.Double innerBlack = new Ellipse2D.Double(x, y, radius-radiusPerCircle*4, radius-radiusPerCircle*4);
        
        g2.draw(outerBlack);
        g2.draw(bigWhite);
        g2.draw(midBlack);
        g2.draw(smallBlack);
        g2.draw(innerBlack);
    }
}
