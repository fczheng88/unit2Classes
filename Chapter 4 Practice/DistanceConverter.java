public class DistanceConverter
{
   public static final int feetYard=3;
   public static final int inchFoot=12;
   public static void main(String[] args)
   {
       
      double yards = 10;
      
      double feet = yards * feetYard;
      double inches = yards * inchFoot;
      
      System.out.println(yards + "yards are" + feet + "feet");
      System.out.println(yards + "yards are" + inches + "inches");
   }
}