import java.util.Scanner;


public class StringParsing
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        
        System.out.print("Please enter an integer between 1,000 and 999,999: ");
        String input = s.next();
        
        
        String withoutComma = input.replace(",", "");
        System.out.println(withoutComma);
        
        
        String withComma = withoutComma.substring(0, withoutComma.length()-3)+","+withoutComma.substring(withoutComma.length()-3, withoutComma.length());
        System.out.println(withComma);
    }





}