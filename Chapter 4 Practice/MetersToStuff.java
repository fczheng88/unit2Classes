import java.util.Scanner;


/**
 * Write a description of class MetersToStuff here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MetersToStuff
{
    // instance variables - replace the example below with your own
    
    public static final double METERS_TO_MILES = 156.0;
    public static final double MILES_TO_FEET = (1.0/5280.0);
    public static final double FEET_TO_INCHES = (1.0/12.0);
    
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        double meters = s.nextDouble();
        
        double miles = meters*METERS_TO_MILES;
        double feet = miles * MILES_TO_FEET;
        double inches = feet * FEET_TO_INCHES;
        
        System.out.println("Miles: "+miles+"\nFeet: "+feet+"\nInches: "+inches);
        
        
        
        
    }
}
