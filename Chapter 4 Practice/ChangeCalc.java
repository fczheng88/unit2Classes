import java.util.Scanner;




public class ChangeCalc
{
    public static final int PENNY = 1;
    public static final int NICKEL = 5*PENNY;
    public static final int DIME = 2*NICKEL;
    public static final int QUARTER = 5*NICKEL;
    public static final int ONE = 4*QUARTER;
    public static final int FIVE = 5*ONE;
    public static final int TEN = 2*FIVE;
    public static final int TWENTY = 2*TEN;
    public static final int FIFTY = 5*TEN;
    public static final int HUNDRED = 5*TWENTY;
    public int change;
    
    
    public static void main(String[] args)
    {
        long[] changeArr = {0,0,0,0,0,0,0,0,0,0};
        
        Scanner s = new Scanner(System.in);
        System.out.print("Enter amount due in pennies: ");
        long due = s.nextLong();
        
        System.out.print("\nEnter amount received in pennies: ");
        long given = s.nextLong();
        
        long change = given-due;
        
        ChangeCalc c = new ChangeCalc();
        if(change >= 0){
            
            long stuff = c.addArray(change, HUNDRED);
            changeArr[0] = stuff;
            change -= stuff*HUNDRED;
            stuff = c.addArray(change, FIFTY);
            changeArr[1] = stuff;
            change -= stuff*FIFTY;
            stuff = c.addArray(change, TWENTY);
            changeArr[2] = stuff;
            change -= stuff*TWENTY;
            stuff = c.addArray(change, TEN);
            changeArr[3] = stuff;
            change -= stuff*TEN;
            stuff = c.addArray(change, FIVE);
            changeArr[4] = stuff;
            change -= stuff*FIVE;
            stuff = c.addArray(change, ONE);
            changeArr[5] = stuff;
            change -= stuff*ONE;
            stuff = c.addArray(change, QUARTER);
            changeArr[6] = stuff;
            change -= stuff*QUARTER;
            stuff = c.addArray(change, DIME);
            changeArr[7] = stuff;
            change -= stuff*DIME;
            stuff = c.addArray(change, NICKEL);
            changeArr[8] = stuff;
            change -= stuff*NICKEL;
            stuff = c.addArray(change, PENNY);
            changeArr[9] = stuff;
            
            
            
            System.out.println(
                "Hundreds: " + changeArr[0] +
                "\nFifties: " + changeArr[1] +
                "\nTwenties: " + changeArr[2] +
                "\nTens: "  + changeArr[3] +
                "\nFives: " + changeArr[4] +
                "\nOnes: " + changeArr[5] +
                "\nQuarters: " + changeArr[6] +
                "\nDimes: "  + changeArr[7] +
                "\nNickles: " + changeArr[8] +
                "\nPennies: " + changeArr[9] + "\n");
            
        }
        else
        {
            System.out.println("\nYou did not give enough money. Stop trying to rob me!\n\n\n".toUpperCase());
        }
        //String[] args = {};
        c.main(args);
    
    }
    public long addArray(long change, long denomination)
    {
        long amtChange = change/denomination;
        return amtChange;
        
    }
}