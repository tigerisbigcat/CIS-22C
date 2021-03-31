package QueuePackage;


/** An interface for the queue ADT
 * 
* This code is from Chapter 10 of 
* Data Structures and Abstractions with Java 4/e
*      by Carrano
*/
    
public interface QueueInterface<T>
    {
    
    /** Adds a new entry to the back of this queue.
    * @param newEntry An object to be added. 
    * */
    public void enqueue(T newEntry);
    
    /** Removes and returns the entry at the front of this queue.
    * @return The object at the front of the queue.
    * @throws EmptyQueueException if the queue was empty before the operation.
    * */
    public T dequeue();
    
    /** Retrieves the front of this queue.
    * @return The object at the front of the queue. 
    * @throws EmptyQueueException if the queue is empty.
    * */
    public T getFront();
    
    /** Detects whether the queue is empty.
    * @return True if the queue is empty, or false otherwise.
    * */
    public boolean isEmpty();
    
    /** Removes all entries from this queue. 
     * */
    public void clear();
} // end QueueInterface

