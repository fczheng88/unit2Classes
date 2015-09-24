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
    private int rings;
    

    /**
     * Constructor for objects of class Target
     * @param x the x-coordinate of the centre
     * @param y the y-coordinate of the centre 
     * @param radius the radius of the circle
     * 
     */
    public Target(double x, double y, double radius, int rings)
    {
        // initialise instance variables
        this.radius = radius;
        this.rings = rings;
        this.radiusPerCircle = radius/rings;
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
     * @param Graphics2D graphics thingy
     * 
     * 
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
     * Returns Ellipse2D
     *
     * @param int rings in the target
     * @param Color color1 centre color
     * @param Color color2 alternate color
     * @param radius radius of ellipse
     * @param ctrX X coordinate of centre
     * @param ctrY Y coordinate of centre
     * @param Graphics2D graphics thingy
     * 
     * 
     */
    public void makeOddRings(int rings, Color color1, Color color2, double radius, double ctrX, double ctrY, Graphics2D g2)
    {
        this.makeEllipse(color1, radius-radiusPerCircle*0, ctrX, ctrY, g2);
        for(int i=1; i<=rings-1; i=i+2)
        {
            this.makeEllipse(color2, radius-radiusPerCircle*(i), ctrX, ctrY, g2);
            this.makeEllipse(color1, radius-radiusPerCircle*(i+1), ctrX, ctrY, g2);
        }
        
    }
    
    
    /**
     * Returns Ellipse2D
     *
     * @param int rings in the target
     * @param Color color1 centre color
     * @param Color color2 alternate color
     * @param radius radius of ellipse
     * @param ctrX X coordinate of centre
     * @param ctrY Y coordinate of centre
     * @param Graphics2D graphics thingy
     * @param boolean oppColours - whether the centre ring colour should be reversed
     * 
     * 
     */
    public void makeEvenRings(int rings, Color color1, Color color2, double radius, double ctrX, double ctrY, Graphics2D g2, boolean oppColours)
    {
        if(oppColours)
        {
            for(int i=1; i<=rings; i=i+2)
            {   
                // color1 coloured inner ring - color scheme reversed
                this.makeEllipse(color1, radius-radiusPerCircle*(i-1), ctrX, ctrY, g2);
                this.makeEllipse(color2, radius-radiusPerCircle*(i), ctrX, ctrY, g2);
                
            }
        }
        else
        {
            for(int i=1; i<=rings; i=i+2)
            {   
                //color2 coloured circle for outer ring
                this.makeEllipse(color2, radius-radiusPerCircle*(i-1), ctrX, ctrY, g2);
                this.makeEllipse(color1, radius-radiusPerCircle*(i), ctrX, ctrY, g2);
                
            }
        }
        
        
    }
    
    /**
     * Draws the target
     * 
     * @param  g2   the graphics stuff
     * 
     */
    public void drawTarget(Graphics2D g2)
    {
        if(rings%2 == 0)
        {
            //see method above for details...
            this.makeEvenRings(this.rings, Color.BLACK, Color.WHITE, radius, ctrX, ctrY, g2, true);    
        }
        else
        {
            this.makeOddRings(this.rings, Color.BLACK, Color.WHITE, radius, ctrX, ctrY, g2);        
        
        }
        
    }
}
