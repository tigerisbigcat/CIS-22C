package QueuePackage;

/** An interface for the priority queue ADT. 
* 
* This code is from Chapter 10 of 
* Data Structures and Abstractions with Java 4/e
*      by Carrano
*/
public interface PriorityQueueInterface<T extends Comparable<? super T>>
{
	/** Adds a new entry to this priority queue.
	* @param newEntry An object to be added. 
        */
	public void add(T newEntry);
	
	/** Removes and returns the entry having the highest priority.
	* @return  The object with the highest priority.
        * @throws EmptyQueueException if the queue was empty before the operation. 
        */
	public T remove();
	
	/** Retrieves the entry having the highest priority.
	* @return The object having the highest priority. 
        * @throws EmptyQueueException if the queue was empty before the operation. 
        */
	public T peek();
	
	/** Detects whether this priority queue is empty.
	 * @return True if the priority queue is empty, or false otherwise.
         */
	public boolean isEmpty();
	
	/** Gets the size of this priority queue.
	 * @return The number of entries currently in the priority queue.
         */
	public int getSize();
	
	/** Removes all entries from this priority queue 
         */
	public void clear();
	
} // end PriorityQueueInterface
