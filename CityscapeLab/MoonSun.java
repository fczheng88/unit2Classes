import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.Point;
import java.awt.Color;
/**
 * Write a description of class Moon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
     */
    public MoonSun(int screenX, int screenY)
    {
        this.SCREEN_X = screenX;
        this.SCREEN_Y = screenY;
        ctrPosition = new Point(10000,10000);
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
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
    public Point positionCalc(TimeOfDay timeStuff)
    {   
        int currentMinutes;
        int locHour = timeStuff.getHour();
        if(timeStuff.isDay())
        {
            locHour-=6;
            currentMinutes = locHour*60 + timeStuff.getMinute();
        }
        else if(timeStuff.getHour()>=18&&timeStuff.getHour()<24)
        {
            locHour-=18;
            currentMinutes = locHour*60 + timeStuff.getMinute();
        }
        else
        {
            locHour+=6;
            currentMinutes = locHour*60 + timeStuff.getMinute();
        }
                
        double x = (double) SCREEN_X*((double) currentMinutes)/((double) MINUTES_IN_DAY/2);
        double y = 0.5*(1.0/(double) SCREEN_X)*Math.pow((x-(SCREEN_X/2.0)), 2)+(0.125*SCREEN_Y);
        
        Point point = new Point((int) x, (int)  y);
        
        return point;
    }
    public void drawMoonSun(Graphics2D g2)  
    {
               
        makeCircle(ctrPosition, 50, g2);
       
    }
    public void updateByTime(TimeOfDay currentTime)
    {
        isSun = currentTime.isDay();
        ctrPosition = positionCalc(currentTime);
    }
    public Point getCenter()
    {
        return ctrPosition;
    }
}


