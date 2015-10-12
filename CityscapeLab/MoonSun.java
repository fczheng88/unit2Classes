import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.Point;
import java.awt.Color;
/**
 * Creates, draws and animates moon/sun
 * 
 * @author Felix Zheng 
 * @version 1
 */
public class MoonSun
{
    // instance variables - replace the example below with your own
    
    private int SCREEN_X, SCREEN_Y;
    private boolean isSun;
    
    private Point ctrPosition;
    
    
    private final static int MINUTES_IN_DAY = 24*60;
    /**
     * Constructor for objects of class Moon
     * @param screenX the width of the screen
     * @param screenY the height of the screen
     */
    public MoonSun(int screenX, int screenY)
    {
        this.SCREEN_X = screenX;
        this.SCREEN_Y = screenY;
        ctrPosition = new Point(10000,10000);
    }

    /**
     * Draws a circle based on parameters
     * 
     * @param  ctrPos the point to use as the center of the circle
     * @param radius the radius of the circle
     * @param g2 the graphics stuff
     * 
     */
    public void makeCircle(Point ctrPos, int radius, Graphics2D g2)
    {
        
        int cornerX = (int) ctrPos.getX() - radius;
        int cornerY = (int) ctrPos.getY() - radius;
        Ellipse2D.Double circle = new Ellipse2D.Double(cornerX, cornerY, radius, radius);
        if(isSun == true)
        {
            g2.setPaint(Color.YELLOW);
        }
        else
        {
            g2.setPaint(Color.WHITE);
        }
        g2.fill(circle);
        g2.draw(circle);
            
    }
    /**
     * Calculates the position of the moon/sun based on the time - 0600 sunrise and 1800 sunset
     * @param currentTime the time object that sets times
     */
    public Point positionCalc(TimeOfDay currentTime)
    {   
        int currentMinutes;
        int locHour = currentTime.getHour();
        //the following if structure converts 24 hour time to 12 hour time and has an offset for sunrise/sunset
        if(currentTime.isDay())
        {
            locHour-=6;
            currentMinutes = locHour*60 + currentTime.getMinute();
        }
        else if(currentTime.getHour()>=currentTime.getRiseSet(false)&&currentTime.getHour()<24)
        {
            locHour-=18;
            currentMinutes = locHour*60 + currentTime.getMinute();
        }
        else
        {
            locHour+=6;
            currentMinutes = locHour*60 + currentTime.getMinute();
        }
                
        double x = (double) SCREEN_X*((double) currentMinutes)/((double) MINUTES_IN_DAY/2);
        double y = 0.5*(1.0/(double) SCREEN_X)*Math.pow((x-(SCREEN_X/2.0)), 2)+(0.125*SCREEN_Y);
        
        Point point = new Point((int) x, (int)  y);
        
        return point;
    }
    /**
     * Calls the makeCircle function to draw the circle, passing necessary params
     * @param g2 the graphics stuff
     */
    public void drawMoonSun(Graphics2D g2)  
    {
               
        makeCircle(ctrPosition, 50, g2);
       
    }
    /**
     * Updates the object based on time set by currentTime
     * @param currentTime supplies the time object for calculations
     */
    public void updateByTime(TimeOfDay currentTime)
    {
        isSun = currentTime.isDay();
        ctrPosition = positionCalc(currentTime);
    }
    /**
     * Returns center position of sun/moon as point
     * @return Point the center (x,y) of the sun or moon
     */
    public Point getCenter()
    {
        return ctrPosition;
    }
}


