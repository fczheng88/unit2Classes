import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.Color;

/**
 * Target Class
 * 
 * @author Felix
 * @version 1
 */
public class Target
{
    // instance variables - replace the example below with your own
    private double ctrX;
    private double ctrY;
    private double radius;
    private double radiusPerCircle;
    

    /**
     * Constructor for objects of class Target
     * @param x the x-coordinate of the centre
     * @param y the y-coordinate of the centre 
     * @param radius the radius of the circle
     * 
     */
    public Target(double x, double y, double radius)
    {
        // initialise instance variables
        this.radius = radius;
        this.radiusPerCircle = radius/5;
        this.ctrX = x;
        this.ctrY = y;
    }

    /**
     * Returns Ellipse2D
     *
     * @param Color Color of ellipse
     * @param  radius  radius of ellipse
     * @param ctrX X coordinate of centre
     * @param ctrY Y coordinate of centre
     * @return  Ellipse2D Object
     */
    public void makeEllipse(Color color, double radius, double ctrX, double ctrY, Graphics2D g2)
    {
        // make corner x, y according to radius
        double cornerX = ctrX-radius/2;
        double cornerY = ctrY-radius/2;
        Ellipse2D.Double ellipse = new Ellipse2D.Double(cornerX, cornerY, radius, radius);
        g2.setPaint(color);
        g2.fill(ellipse);
    }
    
    /**
     * Draws the car
     * 
     * @param  g2   the graphics stuff
     * 
     */
    public void draw(Graphics2D g2)
    {

        this.makeEllipse(Color.BLACK, radius-radiusPerCircle*0, ctrX, ctrY, g2);
        this.makeEllipse(Color.WHITE, radius-radiusPerCircle*1, ctrX, ctrY, g2);
        this.makeEllipse(Color.BLACK, radius-radiusPerCircle*2, ctrX, ctrY, g2);
        this.makeEllipse(Color.WHITE, radius-radiusPerCircle*3, ctrX, ctrY, g2);
        this.makeEllipse(Color.BLACK, radius-radiusPerCircle*4, ctrX, ctrY, g2);
        
        
    }
}
