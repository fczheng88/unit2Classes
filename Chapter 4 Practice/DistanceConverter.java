///GITHUB SCREWED UP FILE



public class DistanceConverter
{

   public static final double YD_TO_FT = 3.0;
   public static final double FT_TO_IN = 12.0;
   public static void main(String[] args)
   {
    
       
      double yards = 10;
      
      double feet = yards * YD_TO_FT;
      double inches = yards * FT_TO_IN;

      
      System.out.println(yards + "yards are" + feet + "feet");
      System.out.println(yards + "yards are" + inches + "inches");
   }
}