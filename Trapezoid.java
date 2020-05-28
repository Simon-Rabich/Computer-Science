import java.util.Scanner;
/**
 * The function of the program is to absorb coordinates from the user and return value of space and scope of trapezius. 
 * My name: Simon Raviz.
 */ 

public class Trapezoid {
    
    public static void main (String [] args) {
      
            System.out.println("Please enter the left point of the coordinates of the base followed by its length: ");     
            // Get Coordinates value from the user. 
            Scanner scan = new Scanner(System.in);
            int leftPointX1 = scan.nextInt();
            int leftPointY1 = scan.nextInt();
            int length1 = scan.nextInt();
            
            System.out.println("Please enter the left point of the coordinates of the other base followed by its length: ");
            // Get Coordinates value from the user. 
            int leftPointX2 = scan.nextInt();
            int leftPointY2 = scan.nextInt();
            int length2 = scan.nextInt();
            
            // compute the height of left side of the trapazoid. 
            double Height = Math.sqrt(Math.pow(leftPointY1 - leftPointY2,2));
            
           // compute the area of the crtein trapzoid.
            double Area = (Height * (length1 + length2)) / 2 ; 
            
            // compute the distance between point X1 to X2 an
            double DA = Math.sqrt(Math.pow( leftPointX1 - leftPointX2 , 2) + Math.pow( leftPointY1 - leftPointY2 , 2));
            
            double rightPointX1 = leftPointX1 + length1 ; 
            double rightPointX2 = leftPointX2 + length2 ; 
                
            double CB = Math.sqrt(Math.pow(rightPointX1 - rightPointX2  , 2) + Math.pow( leftPointY1 - leftPointY2 , 2));

             
            double perimeter = length1 + length2 + DA + CB ;
            
            System.out.println("The area of the trapezoid is " + Area);
            System.out.println("The perimeter of the trapzoid is " + perimeter);
            
    }
 
      

}