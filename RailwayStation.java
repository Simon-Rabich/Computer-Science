
/**
 * The representation is made by the array who contain the train board.
 * @author (Eden siton)
 */
public class RailwayStation
{
    // instance variables - 
    Train [] _station; //Array of trains
    
    int _noOfTrs; //The number of trains leaving the station
    
    final int MAX_TRAINS = 100; //Specifies the maximum number of trains 24 hours a day


    /**
     * Constructor for objects of class RailwayStation
     */
    public RailwayStation()
    {
        // initialise instance variables
        _station = new Train[MAX_TRAINS]; // init the array with 100 cells.
        _noOfTrs = 0;  // maintain 
        
    }

    /**
     * Method addTrain boolean kind is add drive to the array train as by param.
     * @param Train f is accepted to be add.
     * @return false if the amount of trains is bigger or equal then the limit cusae then theres no space.
     * @return false in case the array of trains is equals to the ride train either true.
     * @return true which means establish the method when the size of array trains is the same as new ride train and added to it.
     */
    public boolean addTrain(Train f) {
            
        if (_noOfTrs == MAX_TRAINS) 
            return false;                         
            
        for(int i = 0; i < _noOfTrs; i++) 
           if (_station[i].equals(f))
            return false;
             
        _station[_noOfTrs] = new Train(f); 
        
        _noOfTrs++;
        
        return true;
        
    }
    
    /**
     * Method removeTrain is accepted a ride train to remove her.
     * @param Train f is accepted to be removed.
     * @return false in case that the numberOfTrs is zero cause theres no one to remove.
     * @return true activate method when found the ride to be renoved and either return false.
     */
    public boolean removeTrain(Train f) { //Boolean remove a ride to the train board
        
       if (_noOfTrs == 0)  
        return false;  
       
       for(int i = 0; i< _noOfTrs; i++) 
       
           if (_station[i].equals(f)) {
               
              for(int j = i + 1; j < _noOfTrs; j++)
                  _station[j-1] = new Train(_station[j]);
                  
              _noOfTrs--; // ma
              return true; 
                  
           }
                
       return false; // Train not exists 
       
     }
    
    /**
     * The firstDepartureToDestiation method that gets a new city a place, returns the time it leaves
     *  Or no empty array trips will be returned null.
     *  @param string place kind is accepted
     *  @return false when the num of trains that is equals to zero then there's no one that handle departure 
     *  @return minium time if the func got it
     */ 
    public Time1 firstDepartureToDestination (String place) {

        if(_noOfTrs == 0) // trains does not exsist in station so we return false 
           return null;
        
        // Array of times . size like the number of trains in station
        Time1[] timeArr = new Time1[_noOfTrs]; // to find the minimum
        int noOfTimes = 0;
        
        for (int i = 0; i < _noOfTrs; i++) { // 
        
            if (_station[i].getDestination() == place) {
                
                timeArr[noOfTimes] = new Time1(_station[i].getDeparture()); // use copy constrot of time 
                noOfTimes++;
            }
        }
        
        // Find the minmun time by use after method
        
        Time1 minTime = new Time1(timeArr[0]);
        
        for (int i = 1; i < noOfTimes; i++) //  J he is an array that found their the places are equlas to destination with time departure  
            if (minTime.after(timeArr[i]))
                minTime = new Time1(timeArr[i]);
        
        return minTime; // return minimum time from the array that hndle the rides that arrived to same destination city place 
           
 
    }
    
    /**
     * Returns a number that says how many full trains there are that day
     * @return counter and add to it just in case the trians is full
     */
    public int howManyFullTrains() {
        
        int counter = 0;
        
        for (int i = 0; i < _noOfTrs; i++)
            if (_station[i].isFull())
                counter++;
            
        return counter; 
    }
    
    /**
     *That returns to the most popular city that day,
     *To which most trains come
     *@return most popular destination in both cases.
     */
      public String mostPopularDestination() { 
       
       if (_noOfTrs == 0)
        return null;   
          
       String  mostPopularDestination = "";
       int counter = 0;
       
       int tmpcounter; 
       
       for (int i = 0; i < _noOfTrs; i++) {
           
           tmpcounter = 0; // resret to temp counter 
           
           for (int j = 0; j < _noOfTrs; j++) 
               if (_station[i].getDestination() == _station[j].getDestination())
                   tmpcounter++ ;
                   
         
           if (tmpcounter > counter) {
           
              counter = tmpcounter;
              mostPopularDestination = _station[i].getDestination();
        }
       
     }
        
        
     return mostPopularDestination;
        
   }
   
   /**
    * This mathod will be represent the most expensive ticket by useing the ceaper method.
    * @return most expensive ticket.
    */
   public Train mostExpensiveTicket() { 
       
       if (_noOfTrs == 0)
        return null;

       Train mostExpensive = new Train(_station[0]);
       
       for (int i = 1; i < _noOfTrs; i++) {
         
           if (mostExpensive.isCheaper(_station[i]))
              mostExpensive = new Train(_station[i]);
           
        }
       
       return mostExpensive;
       
   }
   
   /**
    * This method goona shows us the longest ride train in the array trains.
    * @return the longest ride train after the terms.
    */
   public Train longestTrain() {
    
       if (_noOfTrs == 0)
        return null;
       
       Train longestRide = new Train(_station[0]);
       
       for (int i = 1; i < _noOfTrs; i++)
           if(_station[i].getDuration() > longestRide.getDuration())
              longestRide = new Train(_station[i]);
              
       return longestRide;
   }
   
   /**
    * This kind string method will be rpersent a bunch of sentences if the trains list are fully or not.
    * @return txt that contain if the trians is full or not each ride train to destination.
    */
    public String toString() {
        
        if (_noOfTrs == 0)
            return "There are no trains today.";
        
        String txt = "The Trains today are: \n";
        
        for (int i = 0; i < _noOfTrs; i++)
            txt = txt + _station[i] + "\n";
           
        return txt; 
    }
    
} 