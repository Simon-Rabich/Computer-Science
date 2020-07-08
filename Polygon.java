/**
 * The representation is made by a list that stores the vertices of the polygon in order
 * You appear in a polygon. No matter who the first vertex is.
 * Each vertex is represented by a point on a plane.
 *
 * @author (Simon Rabich)
 * @version (27.06.20)
 */
public class Polygon
{
    // instance variables
    private PointNode _head;
    
    /**
     * Constructor for objects of class Polygon
     */
    public Polygon()
    {
        // initialise instance variables
        _head = null;
    }
    

   /**
     * Inserts a vertex in the polygon. 
     * It gets as P-dot parameters and the pos integer that marks anywhere in the list.
     * @param Point p and int pos.
     * @return false in end case && true if its got it.
     */
    public boolean addVertex(Point p, int pos) {
        
        if (pos < 1)
            return false;
        
        PointNode temp = _head;    
        PointNode newNode = new PointNode(p);
        
        if (pos == 1) {
            
            newNode.setNext(_head);
            _head = newNode;
            
                return true;
            
        } else {
            
            while (pos-- != 0) {
                
                
                if (pos == 1) { 
                    
                    
                    newNode.setNext(temp.getNext());
                    temp.setNext(newNode);
                    
                        return true;
                }
            
                temp = temp.getNext();   
                
            }
        
            
    }
         return false;
} //End of method
    
    
    /**
     * Returns a copy of the vertex that is highest in the polygon.
     * If there is more than one at the highest altitude.
     * @return null when the head is empty && retrun highest.
     */
    public Point highestVertex() {
        
        if (_head == null)
            return null;
            
        PointNode temp = _head; 
        Point highest = new Point(_head.getPoint()); //return copy
        
        //Check loop while head not equal to null
        while (temp != null) {
            
            if (temp.getPoint().isAbove(highest))
                highest = new Point(temp.getPoint());
            
            temp = temp.getNext();
        }
        return highest;
        
    }
    
    /**
     * The mhtod toString returns a string of characters that represents the polygon.
     * @return txt as represent by the Nodes.
     */
 
    public String toString() {
        
        String txt = "";        //Initial
        int count=0;
        PointNode temp = _head;
        if(_head==null)
        	return "The polygon has 0 vertices.";
        while ( temp != null)
            
        {
        	count++;
        	if(count==1)
        		txt += temp.getPoint().toString();
        	else
        		txt += ","+temp.getPoint().toString();
            temp = temp.getNext();     
        }
        return "The polygon has "+count+" vertices:" + "\n" +"("+txt+")";
    }
    
    
    /**
     * That returns a double real number that represents the circumference of the polygon.
     * @return the Scope io polygon.
     */
    public double calcPerimeter() {
        
        double calcPerimeter = 0;
        
        PointNode temp = _head;
        
        while (temp != null)
            {
                if (temp.getNext() != null) 
                	calcPerimeter += temp.getPoint().distance(temp.getNext().getPoint());
                else
                	calcPerimeter += temp.getPoint().distance(_head.getPoint());
                temp=temp.getNext();
            }
        
        return calcPerimeter;
        
    }
    
     /**
     * That returns a double-real number that represents the area of the polygon.
     * @return sum that represents the area.
     */
    
    public double calcArea() {
        
        double area = 0; //Intiail
        
        PointNode temp1 = _head;
        PointNode temp2 = _head.getNext();
        int count=0;
        double a=0;
        double b=0;
        double c=0;
        double s=0;
        while (temp1 != null)
        {
        	count++;
        	temp1 = temp1.getNext();
        }
        
        if(count<3)
        	return 0;
        count=0;
        while (temp2 != null)
        {
        	
        	if(temp2.getNext()!=null)
        	{
        		a = _head.getPoint().distance(temp2.getPoint());
        		b = temp2.getPoint().distance(temp2.getNext().getPoint());	
        		c = _head.getPoint().distance(temp2.getNext().getPoint());
        		s = (a+b+c)/2;
                area += Math.sqrt(s*(s-a))*(s-b)*(s-c);
        	}
            
        }
        
        
        return area;
        
        
        
      
    }
    
     /**
     * Isbigger Boolean method that accepts another polygon and returns true if the polygon on which the system is large.
     * @return the bigger polygon by the calcaulate area.
     */
    
    public boolean isBigger(Polygon other) {
        if(this.calcArea()>other.calcArea())
        	return true;
        return false;
    }
    
    /**
     * That accepts a point as a parameter and returns its location in the list if it is.
     * @param Point p.
     * @return if doesnt exist return -1 and if not return the place in the list of him.
     */
    public int findVertex(Point p) {
        
        int pos =0;        
        PointNode temp = _head;
        while (temp != null){
        	pos++;
        	if(temp.getPoint().equals(p))
        		return pos;
        	temp= temp.getNext();
        }
        return -1;
    }
    
     /**
     * That accepts a point as a parameter and returns a copy of the point that represents the following vertex in a polygon.
     * @param Point p.
     * @return the next follow vertex that mentioned.
     */
    public Point getNextVertex(Point p) {
        int pos=findVertex(p);
        int count=0;
        if(pos!=-1)
        {
        	PointNode temp = _head;
        	if(temp.getNext()==null)
        		return new Point(p);
        	while (temp != null)
        	{
        		count++;
        		if(count==pos)
        			if(temp.getNext()!=null)
        				return new Point(temp.getNext().getPoint());
        			else
        				return new Point(_head.getPoint());
        		temp= temp.getNext();
        	}
        }
        return null;
    }
    
     /**
     * The mhtod rectangle as a polygon corresponding to the axes that blocks the polygon
     * @return the four points to bulid the the new polygon.
     */
    public Polygon getBoundingBox() {
    	Point upperRight = null;
        Point upperleft = null;
        Point lowerleft = null;
        Point lowerRight = null;
        PointNode temp = _head; 
        Point up = this.highestVertex();
        Point down = new Point(temp.getPoint());
        Point left = new Point(temp.getPoint());
        Point right = new Point(temp.getPoint());
        while(temp!=null)
        {
        	  if (temp.getPoint().isUnder(down))
        		  down = new Point(temp.getPoint());
        	  if (temp.getPoint().isRight(right))
        		  right = new Point(temp.getPoint());
        	  if (temp.getPoint().isLeft(left))
        		  left = new Point(temp.getPoint());
              temp = temp.getNext();
        }
        upperRight = new Point(up.getY(), right.getX());
        upperleft = new Point(up.getY(), left.getX());
        lowerleft = new Point(down.getY(), left.getX());
        lowerRight = new Point(down.getY(), right.getX());
        Polygon BoundingBox = new Polygon();
        BoundingBox.addVertex(upperRight, 1);
        BoundingBox.addVertex(upperleft, 2);
        BoundingBox.addVertex(lowerleft, 3);
        BoundingBox.addVertex(lowerRight, 4);
        return BoundingBox;
    } 
    
}