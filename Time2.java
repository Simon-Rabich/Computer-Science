
/**
 * The Time2 class represents time, by the number of minutes that have passed since midnight to the time it represents
 *  The object.
 *
 * @author (Simon Rbich))
 * @version (Maman12 question2 2020b)
 */
public class Time2 {
    // instance variables 
    private int _minFromMid;
    
    
      /** Constructors for objects of class Time2 & initialise instance variables.
     if the currnet hour and minute will be under The Limit so we will init them to zero.
     @param h The hour of Time2.
     @param m The minuts of Time2.
     */
    
    public Time2(int h, int m) {
        // initialise instance variable
        if (h > 23 || h < 0 ) 
            h = 0;
        if (m > 59 || m < 0 )
            m = 0; 
            
       _minFromMid = h * 60 + m;
    }
    
    /** Constructor for objects of class Time2. Copy constructor, construct a time using another time.
     * @param t The time object from which to construct the new time.
     */
    
    public Time2(Time2 other) {
        
        _minFromMid = other._minFromMid;        
    }
    
    /**
     * This method returns the hour.
   l  * @return the hour of instance variables. 
     */
    
    public int getHour() {
        
        return _minFromMid / 60;
    }
    
     /**
     * This method returns the minute.
     * @return minute of instance variables. 
     */
    
    public int getMinute() {
        
        return _minFromMid % 60;
    }
    
    /**
     * This method is set the Hour.
     * @param num value is settle by the hour instance variables. 
     */
    
    public void setHour(int num ) {
        
        if (num >= 0 && num <= 23)
        _minFromMid = (_minFromMid - (getHour() * 60)) + num * 60; 
        
    }
    
    /**
     * This method is set the Minute.
     * @param num settle by the minute instance variables. 
     */
    
    public void setMinute(int num) {
        
        if (num >= 0 && num <= 59)
         _minFromMid = (_minFromMid - getMinute()) + num;
    }
    
     /**
     * This method is represents a string by the hh&mm names for the hour&minute.
     * Check if the hour and minute is avaible to the terms.
     * * @return hour and minute represents by string.
     */
    
    public int minFromMidnight() {
       
        return _minFromMid;
    }
    
    /**
     * This method is represents a minutes from the last mid night.
     * @return minutes from midnight.
     */
    
    public boolean equals (Time2 other) {
        
        return _minFromMid == other._minFromMid;     
    }
    
    /**
    * Check if the parametres of time1 is equals to time1 other.
    * @param other The time1 to check if this time1 and the other is equals.
    * @return True if this time1 is equals to other time1
    */
    
    public boolean before(Time2 other) {
        
        return (_minFromMid < other._minFromMid);
        
    }
    
    /**
    * This method is sets if the current time is  before other time
    * @param Time1 other to implemintion the bofore mhtod by boolean .
    * @return True if this time1 is brfore of the other time1 and either she return invalid param.
    */
    
    
    public boolean after(Time2 other) {
        
        return other.before(this);
    }
    
    /**
    * Calculates the difference (in minutes) between two times. Assumption: this time is after other time.
    * @param Time1 other to implemintion the after mhtod by boolean .
    * @return True if this time1 is after of the other time1 and either she return invalid param by this.
    */
    
    public int difference (Time2 other) { 
     
        return (_minFromMid - other._minFromMid);
        
    }
    
    /**
     * This method is represents a string by the hh&mm names for the hour&minute.
     * Check if the hour and minute is avaible to the terms.
     * @return hour and minute represents by string.
     */
    
    public String toString() {
        
        int hour = getHour();
        int minute = getMinute();
        String hh = "";
        String mm = "";
        
        if ( 0 <= hour &&  hour <= 9)
            hh = "0" + hour;
        else 
            hh = hh + hour;
        
        if ( 0 <= minute &&  minute <= 9)
            mm = "0" + minute;
        else 
            mm = mm + minute;
         
    return hh + ":" + mm ;
    
    }
    
    /**A method that accepts as an integer parameter representing a number
    *  Minutes, and adds it to the time represented by the object
    *  This method is invoked
    *  New from the Time2 class representing the new time.
    *  @ param num goes through calculations and initialization to bring new value to time2.  
    *  @ return new time after the end cases about the hour and minute.
    */
    public Time2 addMinutes(int num) {
     
        int hours = ((num / 60) + getHour());
        
        if (hours >= 0)
            hours = hours % 24;
        else
            hours = (hours + 24) % 24;
        
        int minutes = (num % 60) + getMinute();
        
        if (minutes > 59)
            hours++;   
            
        minutes = minutes % 60;
        
        return new Time2(hours, minutes);
       
    }
       
}
