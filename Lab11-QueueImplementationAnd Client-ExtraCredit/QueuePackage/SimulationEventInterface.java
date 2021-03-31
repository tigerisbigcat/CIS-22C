package QueuePackage;


/**
 * A description of the protocol that an event must respond to.
 * 
 * @author Charles Hoot
 * @version 4.0
 */

public interface SimulationEventInterface
{
	/**
	 * Get the time for the event.
	 * 
	 * @return	The time of the event. 
	 */
	public double getTime();
	
	/**
	 * Process the event.
	 */
	public void process();
	
	/**
	 * Get a string representing the action for the event.
	 * 
	 * @return	A description of the event. 
	 */
	public String getDescription();
	
    /**
     * Get a string representing reporting on the status of the event
     * after it has finished executing.
     * 
     * @return  A post event action report. 
     */
    public String getPostActionReport();
	
} // end SimulationEventInterface
