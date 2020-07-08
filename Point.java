
/**
 * The point department represents a point in
 * a plane based on the Cartesian axis system.
 *
 * @author (Simon Rabich)
 * @version (Maman 15 2020b)
 */
public class Point
{
    // instance variables - replace the example below with your own
    private double _x;
    private double _y;

    /**
     * Constructor for objects of class Point.
     * @param x and y also Point other.
     */
    public Point(double x, double y) {
    
       // initialise instance variables
        _x = x;
        _y = y;
    }
    
    public Point(Point other) {
    
        _x = other._x;
        _y = other._y;
    }
    
    /**
     * Getx Double returning the x-coordinate.
     * @return _x.
     */
    public double getX() {
        return _x;
    }
    
    /**
     * Gety Double returns the y-coordinate.
     * @return _y.
     */
    public double getY() {
        return _y;
    }
    
    /**
     * num double setx void that changes the x-coordinate set to be Num.
     * @param num.
     */
    public void setX(double num) {
        _x = num;
    }
    
    /**
     * num double sety void that changes the y-coordinate set to be Num.
     * @param num.
     */
    public void setY(double num) {
        _y = num;
    }
    
    /**
     * That returns the contents of the object as a string of characters based on the mathematical representation.
     * @return the representation.
     */
    public String toString() {
         
        return "(" + _x + "," + _y + ")";
    }
    
    /**
     * A method that takes a point as a parameter and returns 
     * whether the point on which the method and the point that was received as this parameter.
     * @param Point other.
     * @return x and y.
     */
    public boolean equals(Point other) {
      
        return (_x == other._x && _y == other._y); // exp can be return as a boolean value
    }
    
    /**
     * A method that accepts a point as a parameter and returns whether the point on 
     * which the method is activated is above the received point.
     * @param Point other.
     * @return y that is bigger.
     */
    public boolean isAbove(Point other) {
        
        return _y > other._y;
    }
    
    /**
     * A method that accepts a point as a parameter and returns whether the point on
     * which the method is started is under the received point.
     * @param Point other.
     * @return the smallest.
     */
    public boolean isUnder(Point other) {
        
        return other.isAbove(this);
        
    }
    
    /**
     * A method that accepts a point as a parameter and returns whether the point on
     * which the method is started is left the received point.
     * @param Point other.
     * @return the left point.
     */
    public boolean isLeft(Point other) {
        
        return _x < other._x;
    }
    
     /**
     * A method that accepts a point as a parameter and returns whether the point on
     * which the method is started is right the received point.
     * @param Point other.
     * @return the left point.
     */
    public boolean isRight(Point other) {
        
        return other.isLeft(this);
    }
    
    /**
     * A method that accepts a point as a parameter and returns the 
     * distance between the point on which it was started and the point that was received as a parameter.
     * @param Point p.
     * @return the distance.
     */
     
    public double distance(Point p) {
        
        return Math.sqrt(Math.pow(p._y - _y, 2) + Math.pow(p._x - _x, 2));
    }

    /**
     * The point is moving on the pivot x and y.
     * @param the point as dx and dy.
     */
    public void move(double dx, double dy) {
     
        _x += dx;
        _y += dy;
    }
    
    
}