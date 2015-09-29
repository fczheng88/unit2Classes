public class DistanceConverter
{
<<<<<<< HEAD
   public static final double YD_TO_FT = 3.0;
   public static final double FT_TO_IN = 12.0;
   public static void main(String[] args)
   {
      
      double yards = 3.5;
      double feet = yards * YD_TO_FT;
      double inches = feet * FT_TO_IN;
=======
   public static final int feetYard=3;
   public static final int inchFoot=12;
   public static void main(String[] args)
   {
       
      double yards = 10;
      
      double feet = yards * feetYard;
      double inches = yards * inchFoot;
>>>>>>> origin/master
      
      System.out.println(yards + "yards are" + feet + "feet");
      System.out.println(yards + "yards are" + inches + "inches");
   }
}