import java.util.Calendar;
/**
 * Write a description of class TimeOfDay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TimeOfDay
{
    // instance variables - replace the example below with your own
    private int hour, minute, second;
    private Calendar calendar = Calendar.getInstance();
    /**
     * Constructor for objects of class TimeOfDay
     */
    public TimeOfDay()
    {
        calendar = Calendar.getInstance();
        this.hour = calendar.get(Calendar.HOUR_OF_DAY);
        this.minute = calendar.get(Calendar.MINUTE);
        this.second = calendar.get(Calendar.SECOND);
    }
    
    public TimeOfDay(int hours, int minutes, int seconds)
    {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void updateTime()
    {
        calendar = Calendar.getInstance();
        this.hour = calendar.get(Calendar.HOUR_OF_DAY);
        this.minute = calendar.get(Calendar.MINUTE);
        this.second = calendar.get(Calendar.SECOND);
    }
    
    public int getHour()
    {
        return this.hour;
    }
    public int getMinute()
    {
        return this.minute;
    }
    public int getSecond()
    {
        return this.second;
    }
}
