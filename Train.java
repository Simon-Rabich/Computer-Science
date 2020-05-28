
/**
 * This class represent traffic of train drive.
 *
 * @author (Simon Rabich)
 * @version (Maman12 question3 2020b)
 */
public class Train {
    // instance variables - 
    private String _destination;
    private Time1 _departure;
    private int _duration;
    private int _passengers;
    private int _seats;
    private int _price;

    /**
     * One constructor that accepts parameters: trip destination, two integers representing departure time,
     *  An integer representing the travel time in minutes, an integer representing the number of passengers
     *  On the trip, an integer representing the number of seats on the train and an integer representing ticket price
     *  Traveling per person.
     * @ param destination,departure,duration,passengers,price initialise them plus done end cases.
     */
        public Train(String destination,Time1 departure, int duration,int passengers, int seats, int price )
    {
        // initialise instance variables
        _destination = destination;
        _departure = departure;
        _duration = duration;
        
        // List of end cases 
        
        if (passengers < 0)
            _passengers = 0;
            
        if (seats < 0)
            _seats = 0;
        else _seats = seats;
   
        if (passengers > seats)
            _passengers = seats;  
        else _passengers = passengers;
        
        // end cases of during the time travel
        if (duration < 0)
            _duration = 0;
        else _duration = duration;

 
        if (price < 0)
            _price = 0;
        else _price = price;
      
        _departure = new Time1(departure);
        
    }
    
   /**
    * Copy constructor that receives another train ride, and copies its values.
    * @ param Train train is receives and copies its values.
    */
    
   public Train (Train train) {
     
        // initialise instance variables
        _destination = train._destination;
        _departure = new Time1(train._departure);
        _duration = train._duration;
        _passengers = train._passengers;
        _seats = train._seats;
        _price = train._price;
        
    }
    
   // getters  
   /**
    * This method is by string varible and get drstination
    * @ return a String representation by Destination.
    */
   public String getDestination() {
        
     return _destination;   
    }
    
   /**
    * This method Time1 will get Departure. 
    * @ return new Time1 and departure.
    */
   public Time1 getDeparture() {
        
        return new Time1(_departure);
    }
    
   /**
    * This method will get Duration. 
    * @ return duration.
    */
   public int getDuration() {
        
        return _duration;
        
    }
    
   /**
    * This method will gonna get Passengers.
    * @ return passengers.
    */
   public int getPassengers() {
        
        return _passengers;
        
    }
    
   /**
    * This method will get Seats. 
    * @ retuen seats.
    */
   public int getSeats() {
        
        return _seats;
        
    }
    
   /**
    * This method will get Price.
    * @ return price.
    */
   public int getPrice() {
        
        return _price;
         
    }
   
    // setter
   /**
    * This method settle destination by the param.
    * @ param String destination will be received. 
    */ 
   public void setDestination(String destination) {
        
      _destination = destination;
    }
    
   /**
    * This mathod set new value to departure.
    * @ param Time1 departure will be received.
    */
   public void setDeparture(Time1 departure) {
        
       _departure = new Time1(departure);
    }
    
   /**
    * This method will be set Duration by initializ.
    * @param int duration will be received.
    */
   public void setDuration(int duration) {
        
        _duration = duration;
        
    }
    
    /***
     * This method set the Passengers by initializ.
     * @param passengers will be received.
     */
   public void setPassengers(int passengers) {
        
       if (passengers > _seats)
           _passengers = _seats;
       
        if (passengers > 0)
          _passengers = passengers;
        
    }
    
   /**
    * This method will be set seats.
    * @param seats will be initialize by same value.
    */ 
   public void setSeats(int seats) {
      
      _seats = seats; 
    }

    
   /**
    * This method will set price.
    * @param price will recieve and init by the same value.
    */ 
   public void setPrice(int price) {

       if (price >= 0)
         _price = price;
         
    }
    
   /**
    * This method boolean is gonna to compare Train between Train other. 
    * @param Train other is will receive.
    * @return result of destination, seats and departure. 
    */
   public boolean equals (Train other) {
    
      return (_destination == other._destination && _seats == other._seats && _departure.equals(other._departure));
    } 
    
   /**
    * This method from Time1 is get arrival time.
    * @return the time leave and add to it the duration time by addMinute method.
    */ 
   public Time1 getArrivalTime() {
    
        return _departure.addMinutes(_duration); // returm a new instance of Time1
    }
    
   /**
    * This method addPassengers boolean is going to add passengers in case the seats is fix or above then num of pass.
    * @param numPass will recvie for the check if it is fix.
    * @return true when its get it and falls or not.
    */ 
   public boolean addPassengers(int numPass) {
        
       if (_passengers + numPass <= _seats) {
           
           _passengers =+ numPass;
           return true;
          
       }
                                               
        return false;
    
    }
    
   /**
    * This method isFull boolean is going to alert when the number of seats is full. 
    * The check is compare seats between passengers.
    * @ retrn true when the thing is right or in case the seats is not full return false
    */ 
   public boolean isFull() {
        
     if  (_seats == _passengers)
       return true;
     
     return false;
       
    }
    
   /**
    * This method isCheaper boolean he's maingoal is to check if the price is cheaper then the other price.
    * @ param Train other is gonna set in the method for the purpose to check the thing price.
    * @ returm true in case the price is low then the other price and the opposite return false.
    */
   public boolean isCheaper(Train other) {
       
     if(_price < other._price)     
        return true;
        
     return false; 
    
    }
    
   /**
    * This method totalPrice is going to show us the total price by per price and per passnger.    
    * @ return the result of total price by the calcultes per price on per passenger and its done to total.
    */ 
   public int totalPrice() {
    
    return _price * _passengers;
    
    }
    
   /**
    * A method that accepts another train ride as a parameter and returns true if traveling on it
    * The method enabled reaches its destination sooner than before the received parameter,
    * Otherwise false will be returned.
    * @ param Train other for the check arrival earleir time.
    * @ return we get true or flase from call of before method belong to Time1 class.  
    */ 
   public boolean arrivesEarlier(Train other) {
    
        return getArrivalTime().before(other.getArrivalTime()); // we get true or flase from call of before method belong to Time1 class    
            
        
    }
    
   /**
    * toString A method that returns a string containing the following trip data (only), in the following format:
    * if the trip is incomplete return full not is Train will be printed.
    * @ return the result txt bt string.
    */ 
   public String toString() {
 
      String txt = "Train to " + _destination + " departs at " + _departure + ".";
      
      if (isFull())
        txt = txt + "Train is full"; 
      else txt = txt + "Train is not full";
      
     return txt; 
  
    }
}  
