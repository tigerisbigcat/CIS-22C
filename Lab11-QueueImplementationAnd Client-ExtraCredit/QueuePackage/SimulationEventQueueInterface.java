package QueuePackage;


/**
 * An interface for a priority queue that will be used to hold events for a simulation.
 * 
 * @author Charles Hoot
 * @version 4.0
 */

public interface SimulationEventQueueInterface
{
    
	/** Adds a new event to this event queue.  If the time of the event to be added
	 * is earlier the the time for this event queue, do not add the event.
	* @param newEntry An event. 
        */
	public void add(SimulationEvent newEntry);

	/** Removes and returns the item with the earliest time.
	 * @return The event with the earliest time or,
	 * if the event queue was empty before the operation, null. 
         */
	public SimulationEvent remove();
	
	/** Retrieves the item with the earliest time.
	 * @return The event with the earliest time or, 
	 * if the event queue was empty was empty before the operation, null. 
         */
	public SimulationEvent peek();
	
	/** Detects whether this event queue is empty.
	 * @return True if the event queue is empty. 
         */
	public boolean isEmpty();
	
	/** Gets the size of this event queue.
	 * @return The number of entries currently in the event queue. 
         */
	public int getSize();
	
	/** Removes all entries from this event queue. 
         */
	public void clear();
	
	
	/**
	 * The current time of the simulation
	 * 
	 * @return The time for the first event on the queue.
	 */
	public double getCurrentTime();
}
