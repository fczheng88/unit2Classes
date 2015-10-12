import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Point;
/**
 * Write a description of class TimeDisplay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TimeDisplay
{
    // instance variables - replace the example below with your own
    private int hour, minute, second;
    private String timeToDraw;
    private Point location;

    /**
     * Constructor for objects of class TimeDisplay
     */
    public TimeDisplay()
    {
        // initialise instance variables
        hour = minute = second = 0;
        timeToDraw = Integer.toString(hour) + ":" + Integer.toString(minute);
        location = new Point(0,0);
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  g2 the graphics object
     */
    public void drawTimeInSun(Graphics2D g2)
    {
        g2.setColor(Color.WHITE);
        g2.drawString(timeToDraw, (int) location.getX(), (int) location.getY());//adlfjasldsfjklaskjdflkasf);
    }
    /**
     * Updates the object before repaint()
     * @param currentTime for recalling the time
     * @param moonSun to place the object correctly
     */
    public void updateByTime(TimeOfDay currentTime, MoonSun moonSun)
    {
        hour = currentTime.getHour();
        minute = currentTime.getMinute();
        timeToDraw = Integer.toString(hour) + ":" + Integer.toString(minute);
        timeToDraw = String.format("%02d", hour)+ ":" +String.format("%02d", minute);
        location = moonSun.getCenter();
    }
}
