/*
 * An exception used to signal that attempted to get a value from an empty queue.
 * 
 * @author Charles Hoot
 * @version 4.0
 */

package QueuePackage;

public final class EmptyQueueException extends RuntimeException {

	public EmptyQueueException(String s)
	{
		super(s);
	}
}
   
