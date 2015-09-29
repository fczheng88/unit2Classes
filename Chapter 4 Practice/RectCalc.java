
import java.util.Scanner;

public class RectCalc
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        double l, w;
        
        System.out.print("Side 1: ");
        l = s.nextDouble();
        
        System.out.print("Side 2: ");
        w = s.nextDouble();
    
        System.out.println("The perimeter of the rectangle is: "+2*(l+w));
        System.out.println("The area of the rectangle is: "+l*w);
        System.out.println("The diagonal of the rectangle is: "+ Math.sqrt(l*l+w*w));
    
    
    }
}
