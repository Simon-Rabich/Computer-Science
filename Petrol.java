import java.util.Scanner;
/**
 * 
 * This program shows the amount of fuel measured by input obtained by dividing the mile / gallon, 
 * and converts the figure of liters per mile.
 * 
 * My name: Simon Raviz 
 */
//The classenvelopes
public class Petrol
{
    public static void main (String [] args)
    {
 
         //Declare variables
         final int MAX = 100;
         final double MILETOKM = 1.609;
         final double GALLONTOLITER = 3.785;
        
         System.out.println("Please enter the car's petrol consumtiom " +
                           "measured in miles/gallon:");
                           
                           
         // Get value from the user. 
         Scanner scan = new Scanner(System.in);
         double milesPerGallon = scan.nextDouble();
        
         // km for a gallon
         double  kmPerGallon = milesPerGallon * MILETOKM ;
        
         double ratio = MAX / kmPerGallon ; 
        
        
        
         // Do the necessary math and keep it variable

         double beforeRounding = GALLONTOLITER * ratio;
       
        
         // The required normalization with MAX
         double afterRounding = Math.round(beforeRounding * MAX) / (MAX * 1.0);
        
        
         System.out.println("The car's petrol consumption converted to liters/100km is: ");
         System.out.println(afterRounding);
        

            
 
    }  
   
}
