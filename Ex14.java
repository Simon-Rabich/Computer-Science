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
            
            System.out.println( max1 + " " + max2 + " " + max3);
            return possible1;
            
            
        }
        
        System.out.print( max1 + " " + min2 + " " + min1);
        return possible2;
   

    }


  // -----------------------------------------------question 3------------------------------------------------------------
  
     /**
      * Recursive static method, which returns the number of times,
      * the pattern string appears inside
      * The string str as a subset.
       * Thereby, dividing the recursion approach into two cases i.e. base case and the recursive case.
      * In this particular problem, the base case involves the fact that if the length of str is less than that of pattern.
      * There is use with overloadind.
      * 
      * @ param str and pattern string and substring is accepeted 
      * @ return zero if the length of string is less then length of patten
      * @return // Recursive function to find the number of times 
      *  the second string occurs in the first string, 
      *  whether continuous or discontinuous. 
      */
     public static int count (String str, String pattern) {
         
         return count(str, pattern, str.length(), pattern.length());
     }
     
     //overloading
     private static int count(String a, String b, int m, int n) {
         
        //Base Case 
        if ((m == 0 && n == 0) || n == 0) 
            return 1; 
      
                                                              
        //exact match                                        
        if (m == 0) 
            return 0;
            
        // Recursive Case to          
        // count the number of  
        // occurrences of "pattern" in str
        if (a.charAt(m - 1) == b.charAt(n - 1)) 
            return count(a, b, m - 1, n - 1) + 
                   count(a, b, m - 1, n); 
        else    
                                                                                                                   
                                                        
            return count(a, b, m - 1, n); 
    } 



    // -----------------------------------------------question 4------------------------------------------------------------
  
      /**
       * 
       * A recursive static method to plan the path that will bring 
       * the Prince to evil in the number of lowest squares with out being disqualified.
       * 
       * To find shortest path in maze like this, we search for all possible paths
       * in maze from starting psition to the goal position until all possibillities
       * are exhausted. and we are going use with backtarcking.
       *
       */ 
    public static int prince(int[][] drm, int i, int j)
    {
    	if(i>=0 && i<drm.length && j>=0 && j<drm[0].length)
    		return prince(drm,i,j,1);
    	
    	return -1;
    }

    private static int prince(int[][] drm,int i, int j, int moves) {
        if (drm[i][j] == -1)
            return moves;

 
        int leftRoute = 0, rightRoute = 0, upRoute = 0, downRoute = 0;

     
        	if (i+1<=drm.length-1 && drm[i+1][j] == -1)
        		return moves+1;
        	if(i+1<=drm.length-1 && (Math.abs(drm[i+1][j] - drm[i][j]) <= 1 || drm[i+1][j] + 2 == drm[i][j])) {
            	int temp = drm[i][j];
            	drm[i][j] = Integer.MAX_VALUE;
            	rightRoute = prince(drm, i + 1, j, moves + 1);
            	drm[i][j] = temp;
        	}
        
        else
            rightRoute = -1;
        

        	if (i-1>=0 && drm[i-1][j] == -1)
        		return moves+1;
        	if(i-1>=0 && (Math.abs(drm[i-1][j] - drm[i][j]) <= 1 || drm[i-1][j] + 2 == drm[i][j])) {
            	int temp = drm[i][j];
            	drm[i][j] = Integer.MAX_VALUE;
            	leftRoute = prince(drm, i - 1, j, moves + 1);
            	drm[i][j] = temp;
        	}
        
        else
            leftRoute = -1;
        
        	if (j+1<=drm.length-1 && drm[i][j+1] == -1)
        		return moves+1;
        	if(j+1<=drm.length-1 && (Math.abs(drm[i][j+1] - drm[i][j]) <= 1 || drm[i][j+1] + 2 == drm[i][j])) {
            	int temp = drm[i][j];
            	drm[i][j] = Integer.MAX_VALUE;
            	downRoute = prince(drm, i, j+1, moves + 1);
            	drm[i][j] = temp;
        	}
        else
            downRoute = -1;
        

        	if (j-1>=0 && drm[i][j-1] == -1)
        		return moves+1;
        	if(j-1>=0 && (Math.abs(drm[i][j-1] - drm[i][j]) <= 1 || drm[i][j-1] + 2 == drm[i][j])) {
            	int temp = drm[i][j];
            	drm[i][j] = Integer.MAX_VALUE;
            	upRoute = prince(drm, i, j-1, moves + 1);
            	drm[i][j] = temp;
        	}
   
        else
            upRoute = -1;
        
        int shortRoute=Integer.MAX_VALUE;	
        
        if(rightRoute!=-1 && rightRoute<shortRoute)
        	shortRoute=rightRoute;
        if(leftRoute!=-1 && leftRoute<shortRoute)
        	shortRoute=leftRoute;
        if(downRoute!=-1 && downRoute<shortRoute)
        	shortRoute=downRoute;
        if(upRoute!=-1 && upRoute<shortRoute)
        	shortRoute=upRoute;
        if(shortRoute==Integer.MAX_VALUE)
        	shortRoute=-1;
        
        return shortRoute;

    }
} 
  
