import QueuePackage.*;
import java.util.*;
import java.awt.Graphics;
import java.awt.Color;

/**
 * A class to represent a bank line.  
 * 
 * It will be displayable so all methods must be synchronized.
 * 
 * @author Charles Hoot 
 * @version 4.0
 */

    
public class BankLine implements QueueInterface<Customer>
{
    private Vector<Customer> queue;// queue front is first in the vector

    /**
     * Constructor for objects of class BankLine
     */
    public BankLine()
    {
        queue = new Vector<Customer>();
    } // end constructor
    
    synchronized
    public void enqueue(Customer newEntry)
    {
        queue.add(newEntry);
    } // end enqueue

    synchronized
    public Customer getFront()
    {
        Customer front = null;
        if (!isEmpty())
            front = queue.get(0);
        return front;
    } // end getFront
    

    synchronized
    public Customer dequeue()
    {
        Customer front = null;
        if (!isEmpty())
        {
            front = queue.remove(0);
        } // end if
        return front;
    } // end dequeue

    synchronized
    public boolean isEmpty()
    {
        return queue.isEmpty();
    } // end isEmpty
    
    synchronized
    public void clear()
    {
        queue.clear();
    } // end clear
    
    
    /*
     * Provide an iterator for the customers in line.
     * 
     * @return An object of type Iterator.
     */
    synchronized
    public Iterator<Customer> iterator()
    {
        return queue.iterator();
    }

                
    public static final int LINE_SPACE = 60;
    public static final int CUSTOMERS_TO_DRAW = 5;
        
        
    /**
     * Draw a representation of the bank line at the given location
     * 
     * @param   g  The graphics context to draw on.   
     * @param   leftX  The x position of the left end of the line.
     * @param   baseY  The y position of the base line.
     * 
     */
    synchronized 
    public void drawOn(Graphics g, int leftX, int baseY)
    {
       
        if(queue.size() == 0)
        {
            String toDraw = "No customers in line";
            g.drawString(toDraw, leftX, baseY);
        }
        else
        {
            // Draw the first customers in line
            int positionX = leftX;
            Iterator iter = queue.iterator();
            for(int i=0; i<CUSTOMERS_TO_DRAW && iter.hasNext(); i++)
            {
                ((Customer)iter.next()).drawOn(g, positionX, baseY);
                positionX += LINE_SPACE;
            }
            if(iter.hasNext())
            {
                int remaining = queue.size() - CUSTOMERS_TO_DRAW;
                String toDraw = ". . . " + remaining + " more customers";
                g.drawString(toDraw, positionX, baseY);
            }
             
        }           
       
    }
        
}
