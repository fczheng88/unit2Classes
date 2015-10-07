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
    
    private final static int MINUTES_IN_DAY = 24*60;
    /**
     * Constructor for objects of class Moon
     */
    public MoonSun()
    {
        this.hour = timeStuff.getHour();
        this.minute = timeStuff.getMinute();
        this.second = timeStuff.getSecond();
        
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
        int currentMinutes;
        int locHour = this.hour;
        if(hour>=6 && hour<18)
        {
            locHour-=6;
            currentMinutes = locHour*60 + minute;
        }
        else if(hour>=18&&hour<24)
        {
            locHour-=18;
            currentMinutes = locHour*60 + minute;
        }
        else
        {
            locHour+=6;
            currentMinutes = locHour*60 + minute;
        }
        System.out.println(currentMinutes);
        
        
        
        double x = (double) SCREEN_X*((double) currentMinutes)/((double) MINUTES_IN_DAY/2);
        double y = 0.5*(1.0/(double) SCREEN_X)*Math.pow((x-(SCREEN_X/2.0)), 2)+(0.125*SCREEN_Y);
        
        Point point = new Point((int) x, (int)  y);
        System.out.println(point);
        return point;
    }
    public void updateMoonSun(int minute)
    {
        
        this.minute = to60Minute(minute);
        System.out.println(this.minute);
        System.out.println(this.hour);
    }
    public int to24Hour(int hour)
    {
        if(hour>=24)
        {
            return hour%24;
        }
        else
        {
            return hour;
        }
    }
    public int to60Minute(int minute)
    {
        if(minute >= 60)
        {
            
            this.minute =-60;
            this.hour = to24Hour(this.hour+1);
            return minute%60;
        }
        else
        {
            return minute;
        }
        
    }
    public void drawMoonSun(Graphics2D g2, int screenX, int screenY)  
    {
        this.SCREEN_X = screenX;
        this.SCREEN_Y = screenY;
        int centerX = (int) this.positionCalc().getX();
        int centerY = (int) this.positionCalc().getY();
        if( hour>=6 && hour<18)
        {
            this.makeCircle(centerX, centerY, 50, true, g2);
            
        }
        else
        {
            this.makeCircle(centerX, centerY, 50, false, g2);
            
        }
    }
}
