import java.util.Scanner;


public class Annuity
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        double PMT, i, n;
        
        System.out.print("Payment amount: ");
        PMT = s.nextDouble();
        
        System.out.print("Interest rate in percent: ");
        i = 0.01*s.nextDouble();
        
        System.out.print("Number of years: ");
        n = s.nextDouble();
        
        double PV = PMT*(((Math.pow((1+i), (n-1))-1)/i)/(Math.pow((1+i), (n-1)))+1);
    
        System.out.println(PV);
    
    
    }




}