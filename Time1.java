/**
 * This program is going to be represent by a class which called Time1 her job is to extract the hour and
 * the minute both .get and set also be included and the maingoal is to carry and estblised a bunch of methdos.
 * 
 * Represent time in scale of hours and minutes  
 * 
 * @author (Simon Rabich)
 * @version (Maman12 question1 2020b)
 */
public class Time1 {
    
    // instance variables 
    
    private int _hour;     // Represents an hour out of 23 hours
    
    private int _minute;   //  Represents an minute out of 59 minutes
    
    /** Constructors for objects of class Time1 & initialise instance variables.
     if the currnet hour and minute will be under The Limit so we will init them to zero.
     @param h The hour of Time1.
     @param m The minuts of Time1.
     */
        public Time1(int h, int m)  { //initialise instance variables
     
        if (h < 0) // if hour smaller from zero then the instance variable equels to zero
         _hour = 0;        
        else _hour = h; // else instance variable equels to hour
        
         if (m < 0) // if minutes smaller from zero then instance variables of minute equels to zero
         _minute = 0;        
        else _minute = m; // else instance variables of minute equels to minutes
    }   
    
    /** Constructor for objects of class Time1. Copy constructor, construct a time using another time.
     * @param t The time object from which to construct the new time.
     */
        public Time1(Time1 t) //copy Constructors
    
    {
        _hour = t._hour;
        _minute = t._minute;
    }
    
    /**
     * This method returns the hour.
     * @return the hour of instance variables. 
     */
    public int getHour(){ // Get functions
        
     return _hour;
        
    }
    
     /**
     * This method returns the minute.
     * @return minute of instance variables. 
     */
    public int getMinute(){ //get func minute
    
        
     return _minute;
    
    }
    
    /**
     * This method is set the Hour.
     * @param num value is settle by the hour instance variables. 
     */

    public void setHour(int num) {     // Set function
     
     _hour = num;   
        
    }
    
    /**
     * This method is set the Minute.
     * @param num settle by the minute instance variables. 
     */
    
    public void setMinute(int num) { // Set function
    
     
     _minute = num;   
   
    }
    
    /**
     * This method is represents a string by the hh&mm names for the hour&minute.
     * Check if the hour and minute is avaible to the terms.
     * * @return hour and minute represents by string.
     */
    public String toString(){    // Func a shows an input in string represent kind by hour and minute.   
        
        String hh = "";
        String mm = "";
        
        if ( 0 <= _hour &&  _hour <= 9)
            hh = "0" + _hour;
        else 
            hh = hh + _hour;
        
        if ( 0 <= _minute &&  _minute <= 9)
            mm = "0" + _minute;
        else 
            mm = mm + _minute;
         
    return hh + ":" + mm ;
    
     }
     
    
    /**
     * This method is represents a minutes from the last mid night.
     * @return minutes from midnight.
     */
    
    public int minFromMidnight() {    
           
        return _hour * 60 + _minute;
     }
  
    
    /**
    * Check if the parametres of time1 is equals to time1 other.
    * @param other The time1 to check if this time1 and the other is equals.
    * @return True if this time1 is equals to other time1
    */
    
    public boolean equals (Time1 other) {
        
        return (other._hour == _hour && other._minute == _minute);
    
    }
    
    /**
    * This method is sets if the current time is before other time
    * @param Time1 other to implementation the before method by boolean .
    * @return True if this time 1 is before of the other time 1 and either she return invalid param.
    */
    
    public boolean before (Time1 other) {
     
        if (_hour < other._hour)
            return true;    
        if (_hour > other._hour)
            return false;
        if (_minute < other._minute) 
            return true;
        return false;
    }   
    
    /**
    * This method is check if param that receive Time1 other is after from this.
    * @param Time1 other to implementation the after method by boolean .
    * @return True if this time 1 is after of the other time 1 and either she return invalid param by this.
    */
    
    public boolean after (Time1 other) {
        
        return other.before(this);
    }
    
     /**
    * Calculates the difference (in minutes) between two times. Assumption: this time is after other time.
    * @param Time1 other to implemintion the after mhtod by boolean .
    * @return True if this time1 is after of the other time1 and either she return invalid param by this.
    */
    
    public int difference (Time1 other) {
        
       int diffHours = 60 * (_hour - other._hour);
       int diffMin = Math.abs(_minute - other._minute);
       return diffHours + diffMin; 
        
    }
    
    /**
     * This method gonna be shows the Adds num Minutes to time.
     * when the total num were over throgh casting by model calculte math
     * til the num gets his destny.
     * @param num will get new vaule after the adding to the total num.
     * @return new Time after the calculetion that done on total num.
     */
    
        public Time1 addMinutes(int num) {
     
        int t = minFromMidnight() + num ; // total minutes
        
        if (t < 0) {
             
            int x = (Math.abs(t / 1440));  
            
            if (Math.abs(t) % 1440 != 0)
                x++;
            
            t += 1440 * x;    
         
        }
       
        
        int nh = (t / 60) % 24;  // calculate new hours
        int nm = t % 60;         // calculate new minutes
         
       return new Time1(nh, nm);
       
    }
 }