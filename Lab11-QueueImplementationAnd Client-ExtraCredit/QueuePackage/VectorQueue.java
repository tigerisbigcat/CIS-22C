package QueuePackage;

import java.util.Vector;
import java.util.List;

/** A queue implemented using a Vector.  Since it only uses  methods
 * from the List interface, we can use other classes like ArrayList 
 * or LinkedList instead of Vector.
* 
* This code is loosely based on the implementations of a Queue from Chapter 11 of 
* Data Structures and Abstractions with Java 4/e
*      by Carrano
*      
*/

public class VectorQueue<T> implements QueueInterface<T>, java.io.Serializable
    {
    private List<T> queue;// Queue's front entry is first in the vector
    
    public VectorQueue()
    {
        queue = new Vector<T>(); // Vector expands in size if necessary.
    } // end default constructor
    
   /** Adds a new entry to the back of this queue.
    * @param newEntry An object to be added. 
    * */
    public void enqueue(T newEntry)
    {
        queue.add(newEntry);
    } // end enqueue


    /** Removes and returns the entry at the front of this queue.
    * @return The object at the front of the queue.
    * @throws EmptyQueueException if the queue was empty before the operation.
    * */
    public T dequeue()
    {
        T front = null;
        if (isEmpty())
            throw new EmptyQueueException("Attempting to access entries on an empty queue.");
        else
            front = queue.remove(0);
        return front;
    } // end dequeue

    /** Retrieves the front of this queue.
    * @return The object at the front of the queue. 
    * @throws EmptyQueueException if the queue is empty.
    * */
    public T getFront()
    {
        T front = null;
        if (isEmpty())
            throw new EmptyQueueException("Attempting to access entries on an empty queue.");
        else
            front = queue.get(0);
        return front;
    } // end getFront
    

   /** Detects whether the queue is empty.
    * @return True if the queue is empty, or false otherwise.
    * */
    public boolean isEmpty()
    {
        return queue.isEmpty();
    } // end isEmpty
    
    /** Removes all entries from this queue. 
     * */
    public void clear()
    {
        queue.clear();
    } // end clear
}
