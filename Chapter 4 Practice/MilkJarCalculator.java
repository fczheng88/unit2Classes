public class MilkJarCalculator
{
   public static void main(String[] args)
   {
      double milk = 5.5; // gallons
      double jarCapacity = 0.75; // gallons
      int completelyFilledJars = (int) (milk / jarCapacity);
      
      System.out.println(completelyFilledJars);
   }
}

//(from supplementary labs provided with Java Concepts: Early Objects, 7e by Cay Horstmann)