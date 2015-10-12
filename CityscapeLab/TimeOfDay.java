import java.util.Calendar;
/**
 * Class to keep track of time operations
 * 
 * @author Felix Zheng
 * @version 1
 */
public class TimeOfDay
{
    // instance variables - replace the example below with your own
    private int hour, minute, second;
    private int prevHour;
    private Calendar calendar = Calendar.getInstance();
    /**
     * Constructor for objects of class TimeOfDay
     */
    public TimeOfDay()
    {
        calendar = Calendar.getInstance();
        this.hour = calendar.get(Calendar.HOUR_OF_DAY);
        this.prevHour = this.hour-1;
        this.minute = calendar.get(Calendar.MINUTE);
        this.second = calendar.get(Calendar.SECOND);
    }
    /**
     * Alternate constructor for TimeOfDay
     * @param hours sets the hour
     * @param minutes sets the minute
     * @param seconds sets the second
     */
    public TimeOfDay(int hours, int minutes, int seconds)
    {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }
    /**
     * Method to find sunrise/sunset time (currently fixed values, returns hour)
     * @param isSunrise If time of sunrise is needed, true should be passed. For sunset, false should be given.
     * @return The hour of sunrise or sunset
     */
    public int getRiseSet(boolean isSunrise)
    {
        if(isSunrise)
        {
            return 6;
        }
        else
        {
            return 18;
        }
    }
    /**
     * Called to synce time in TimeOfDay with real-world time 
     */
    public void updateTime()
    {
        calendar = Calendar.getInstance();
        this.hour = calendar.get(Calendar.HOUR_OF_DAY);
        this.minute = calendar.get(Calendar.MINUTE);
        this.second = calendar.get(Calendar.SECOND);
    }
    /**
     * Called to update the time before repaint() is called. Adds one minute.
     */
    public void addMinute()
    {
        int minute = this.minute +1;
        this.minute = minute%60;
        if(minute >= 60)
        {
            this.hour = (this.hour+1)%24;
        }
               
    }
    /**
     * Method to say whether 0601 or 1801 has been reached(symbolizes change of night=>day or day=> night)
     * @return true if the conditions are met and false if the conditions are not met
     */
    public boolean isSwitchedDayNight()
    {
        if(hour == 6 && minute == 1)
        {return true;}
        else if(hour == 18 && minute == 1)
        {return true;}
        else
        {return false;}
    }
    /**
     * Method to return whether it is day or night
     * @return true if it is day, false if it is night
     */
    public boolean isDay()
    {
        if( hour>=6 && hour<18)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    /**
     * same as isDay() but return values are reversed
     * @return true if it is night, false if it is day
     */
    public boolean isNight()
    {
        if( hour>=6 && hour<18)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    /**
     * Method to find the hour
     * @return the current hour
     */
    public int getHour()
    {
        return this.hour;
    }
    /**
     * Method to find the minute
     * @return the current minute
     */
    public int getMinute()
    {
        return this.minute;
    }
    /**
     * Method to find the second
     * @return the current second
     */
    public int getSecond()
    {
        return this.second;
    }
    
}
