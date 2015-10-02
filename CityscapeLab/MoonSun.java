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
    private int hour, minute, second;
    private int SCREEN_X, SCREEN_Y;
    private TimeOfDay timeStuff = new TimeOfDay();
    
    private final static int SECONDS_IN_DAY = 24*60*60;
    /**
     * Constructor for objects of class Moon
     */
    public MoonSun(int screenX, int screenY)
    {
        this.hour = timeStuff.getHour();
        this.minute = timeStuff.getMinute();
        this.second = timeStuff.getSecond();
        this.SCREEN_X = screenX;
        this.SCREEN_Y = screenY;
        System.out.println("MoonSun Init");
        System.out.println(SCREEN_X);
        System.out.println(SCREEN_Y);
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void makeCircle(int centerX, int centerY, int radius, boolean isSun, Graphics2D g2)
    {
        int cornerX = centerX - radius;
        int cornerY = centerY - radius;
        Ellipse2D.Double circle = new Ellipse2D.Double(cornerX, cornerY, radius, radius);
        if(isSun == true)
        {
            g2.setPaint(Color.YELLOW);
            System.out.println("yellow");
        }
        else
        {
            g2.setPaint(Color.BLACK);
        }
        g2.fill(circle);
        g2.draw(circle);
        System.out.println("drawn");
    }
    public Point positionCalc()
    {   
        int hour = timeStuff.getHour();
        int minute = timeStuff.getMinute();
        int second = timeStuff.getSecond();
        
        int secondDisplacement = Math.abs(12-hour)*60*60+(60-minute)*60+second;
        long xPixelsPerMove = SCREEN_X/SECONDS_IN_DAY/2;
        long yPixelsPerMove = SCREEN_Y/4/SECONDS_IN_DAY/2;
        int x = (int) xPixelsPerMove*secondDisplacement;
        int y;
        if(secondDisplacement <= SECONDS_IN_DAY/4)
        {
            y = (int) yPixelsPerMove*secondDisplacement;
        }
        else
        {
            y = (int) (SCREEN_Y/4-yPixelsPerMove*secondDisplacement);
        }
        Point point = new Point(x, y);
        return point;
    }
    public void drawMoonSun(Graphics2D g2)  
    {
        System.out.println("DrawMoonSun");
        System.out.println(timeStuff.getHour());
        int hour = timeStuff.getHour();
        int centerX = (int) this.positionCalc().getX();
        int centerY = (int) this.positionCalc().getY();
        if(hour<18 && hour>6)
        {
            this.makeCircle(centerX, centerY, 500, true, g2);
            System.out.println("Sun");
        }
        else
        {
            this.makeCircle(centerX, centerY, 500, false, g2);
            System.out.println("Moon");
        }
    }
}
