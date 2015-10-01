import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.Color;

/**
 * Sun class
 * 
 * @author Felix Zheng 
 * @version 1
 */
public class Sun
{
    // instance variables - replace the example below with your own
    private double centerX;
    private double centerY;
    private double radius;
    private Color color;
    private Ellipse2D.Double ellipse = new Ellipse2D.Double(1.0, 1.0, 1.0, 1.0);
    private Graphics2D g2;
    

    /**
     * Constructor for objects of class Sun
     */
    public Sun(double topLeftCornerX, double topLeftCornerY, double radius, Color color, Graphics2D g2 )
    {
        // initialise instance variables
        this.centerX = topLeftCornerX+radius;
        this.centerY = topLeftCornerY+radius;
        this.radius = radius;
        this.color = color;
        this.g2 = g2;
    }

    /**
     * Returns Ellipse2D
     *
     * @param Color Color of ellipse
     * @param  radius  radius of ellipse
     * @param ctrX X coordinate of centre
     * @param ctrY Y coordinate of centre
     * @param Graphics2D graphics thingy
     * 
     * 
     */
    public void makeEllipse(Color color, double radius, double centerX, double centerY, Ellipse2D.Double ellipse)
    {
        // make corner x, y according to radius
        double cornerX = centerX-radius/2;
        double cornerY = centerY-radius/2;
        ellipse = new Ellipse2D.Double(cornerX, cornerY, radius, radius);
        g2.setPaint(color);
        g2.fill(ellipse);
    }
    
    /**
     * Draws the sun 
     * 
     * @param g2 the graphics componenet
     */
    public void drawSun()
    {   
        this.makeEllipse(color, radius, centerX, centerY, ellipse);
    }
    /**
     * Updates the sun
     * 
     * @param g2 the graphics component
     * @param newColor the new color of the sun
     * 
     */
    public void updateSun(double newRadius, double newCenterX, double newCenterY, Color newColor)
    {
        this.color = newColor;
        this.radius = newRadius;
        this.centerX = newCenterX;
        this.centerY = newCenterY;
        this.makeEllipse(color, radius, centerX, centerY, ellipse);
    }
}
