 /**
 * Maman 14 2020a
 * 
 * @author Simon Rabich 
 *
 */
public class Ex14 {
    // -----------------------------------------------question 1------------------------------------------------------------
    /**
     * The method calculates to Amir a possible action of the game so that he necessarily does not losing it.
     * The method accepts the currency array as a parameter and 
     * prints the choices of the players at each stage of the game.
     * At the end of the process, 
     * the total amount of Amir and the total amount of Tamar will be printed.
     * 
     *   Time efficiency - O(N)  
     *   Space efficiency - O(1) 
     * 
     * @param arr - The array of coins
     */
    public static void win(int arr[]) {

        int evenNumSum = arr[0]; // initial
        int oddNumSum = arr[arr.length - 1]; // initial

        int sumAmir = 0;
        int sumTamar = 0;

        // Calculate the sum of even numbers and the sum of odd numbers.
        for (int i = 1; i < arr.length - 1; i++){

            if (i % 2 == 0)
                evenNumSum += arr[i];
            else
                oddNumSum += arr[i];
        }

        int i = 0;
        int j = arr.length - 1;
        while (j > i) {

            if (evenNumSum >= oddNumSum){

                if (i % 2 == 0) { // One of the indexes must be even number
                    
                    sumAmir += arr[i];
                    System.out.println("Amir took " + arr[i]);
                    i++;
                    
                } else {

                    sumAmir += arr[j];
                    System.out.println("Amir took " + arr[j]);
                    j--;

                }

                if (arr[i] >= arr[j]){
                    
                    sumTamar += arr[i];
                    System.out.println("Tamar took " + arr[i]);
                    i++;
                    
                } else {
                    
                    sumTamar += arr[j];
                    System.out.println("Tamar took " + arr[j]);
                    j--;
                    
                }
            }

            if (evenNumSum <= oddNumSum){

                if (j % 2 != 0) { // Some index must be odd number
                    
                    sumAmir += arr[j];
                    System.out.println("Amir took " + arr[j]);
                    j--;
                    
                } else {

                    sumAmir += arr[i];
                    System.out.println("Amir took " + arr[i]);
                    i++;

                }

                if (arr[i] >= arr[j]) {
                    
                    sumTamar += arr[i];
                    System.out.println("Tamar took " + arr[i]);
                    i++;
                    
                } else {
                    
                    sumTamar += arr[j];
                    System.out.println("Tamar took " + arr[j]);
                    j--;
                    
                }

            }

        } // End while

        System.out.println("Final Score:");
        System.out.println("Amir total " + sumAmir);
        System.out.println("Tamar total " + sumTamar);

    }// End win method
    
    // -----------------------------------------------question 2------------------------------------------------------------

    /**
     *    
     * A static method that receives as an arr array parameter filled with integers, positive and negative.
     * The method should find a triad of numbers in the array not necessarily adjacent to each other's multiplication
     * Is the maximum. 
     *    
     * I chose this way because I thought of five loops and nothing more - three positive ones
     * And two negative, then one of the two options collected will be returned.
     * There is use with the constants of the whole - I found much more effective than the way
     * The traditional way of finding min / max.
     * The concept chosen stemmed from efficiency and generosity.
     *     
     *   Time efficiency - O(N)
     *          
     *   Space efficiency - O(1) 
     * 
     * @param arr - array of integers filled with positive and negative
     * @return a triplet of ,either two negative and one double 
     */
    
    public static int findTriplet(int[] arr) {
        
        
         int min1 = Integer.MAX_VALUE;  //find first min using by the constant of Integer
         int indMin1 = 0;
         
         for (int i = 0; i < arr.length; i++) {
             
             if (arr[i] < min1) {
                 
                 min1 = arr[i];
                 indMin1 = i;
              }
        }

         int min2 = Integer.MAX_VALUE;  //find second min using by the constant of Integer
         int indMin2 = 0;
         
         for (int i = 0; i < arr.length; i++) {
             
             if (i == indMin1) continue;
             
             if (arr[i] < min2) {
                 
                 min2 = arr[i];
                 indMin2 = i;
              }
              
        }
        
        
        int max1 = Integer.MIN_VALUE;   //find first max using by the constant of Integer
        int indMax1 = 0;
         
         for (int i = 0; i < arr.length; i++) {
            
  
             if (arr[i] > max1) {
                 
                 max1 = arr[i];
                 indMax1 = i;
                 
              }
              
        }
        
        int max2 = Integer.MIN_VALUE;  //find second max using by the constant of Integer
        int indMax2 = 0;
         
         for (int i = 0; i < arr.length; i++) {
            
             if (i == indMax1) 
                continue;
             
             if (arr[i] > max2) {
                 
                 max2 = arr[i];
                 indMax2 = i;
                 
              }
              
        }
        
         
         int max3 = Integer.MIN_VALUE;  //find the thierd max by using
         int indMax3 = 0 ;
         
         for (int i = 0; i < arr.length; i++) {
            
             if (i != indMax2 && i != indMax1) { 
                
                 if (arr[i] > max3) {
                     
                     max3 = arr[i];
                     indMax3 = i;
                     
                  
                 }
                    
            }
              
        }
        
        
        int possible1 = max1 * max2 * max3;
        int possible2 = max1 * min1 * min2;
        
        if (possible1 >= possible2) {
            
            System.out.print( max1 + " " + max2 + " " + max3);
            return possible1;
            
            
        }
        
        System.out.print( max1 + " " + min2 + " " + min1);
        return possible2;
   

    }

}
     // -----------------------------------------------question 3------------------------------------------------------------
  
     /**
      * Recursive static method, which returns the number of times,
      * the pattern string appears inside
      * The string str as a subset.
      * Thereby, dividing the recursion approach into two cases i.e. base case and the recursive case.
      * In this particular problem, the base case involves the fact that if the length of str is less than that of pattern.
      * 
      * @ param str and pattern string and substring is accepeted 
      * @ return zero if the length of string is less then length of patten
      * @
      * 
      */
     
       // Recursive function to  
       // count the number of  
       // occurrences of "pattern" in str.
      
     public static int count (String str, String pattern) {
         
         
         int n1 = str.length();
         int n2 = pattern.length();
         
                                                                    //sreacing first char pattern in string
         //Base Case 
         if (n1 == 0 || n1 < n2)                                    //and cut the head when were sreaced already 
            return 0;                                            
                                                                  // and keeps moving to reach the last charter
            
         //exact match  
         if (n1 == n2)  
            return n1;
                                                                                     
            
         //Recursive Case
         if(str.charAt(str.length() -1 != a)
            return count(str.substring(0, str.length() -1), a); // here we send the string - the last character which has been already checked.
                                               
          else
                return 1 + count(str.substring(0, str.length() -1), a);
     }
                
          //Otherwise, return the count from the remainig index

         //print in up order
         if (str > 0) {        
             
             printUp (num - 1);
             System.out.println(num); }
           
        
         if (str.charAt(0) == pattern)
                return 1 + numberOfChars(str.substring(1), pattern);
          
          else 
          
                 return numberOfChars(str.substring(1). pattern);
                
     
     // return(str.charAt(0) == str.charAt(length - 1) &&
            
     //  isPattern(str.substring(1, length - 1)));   
     
     
    
       
    }
*/
   
  public static int prince(int[] [] drm, int i, int j) {
      
      

          









        