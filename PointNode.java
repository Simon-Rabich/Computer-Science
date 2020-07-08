
/**
 *The PointNode class will represent one vertex in the polygon.
 *
 * @author (Simon Rabich)
 * @version (27.06.20)
 */
public class PointNode
{
    // instance variables - 
    Point _point; 
    PointNode _next;

    /**
     * Constructor for objects of class PointNode.
     * Constructor that receives a point, the next field will initialize to null.
     * && Copy Constructor.
     * @param Point p + p and PointNode n && PointNode p.
     */
    public PointNode (Point p) {
        
        _point = p; //aliasing
        _next = null;
    }
    

    public PointNode (Point p, PointNode n) {
        
    _point = p;
    _next = n;
    }
    
    public PointNode (PointNode p) {
        
        _point = p._point;
        _next =  p._next;
    }
    
    /**
     * A method that returns a copy of the point in the code.
     * @return Point.
     */
    public Point getPoint() {
          
        return new Point(_point);
    }
    
    /**
     * The method that returns points to the next member.
     * @return _next.
     */
    public PointNode getNext() {
        
        return _next;
        
    }
    
    /**
     * A method that accepts a point and updates the point attribute in the code.
     * @param Point p.
     * @return Point p.
     */
    public void setPoint(Point p) {
        
        _point = new Point(p);
    }
    
    /**
     * Mhtod that updates a pointer that accepts a feature that points to the next member.
     * @param PointNode next.
     * @return next.
     */    
    public void setNext(PointNode next) {
        
        _next = next;
    }
}