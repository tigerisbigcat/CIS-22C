
/**
 * An exception used to signal that we want to kill the application thread.
 * 
 * @author Charles Hoot
 * @version 4.0
 */

public final class KillThreadException extends RuntimeException
{
	public KillThreadException(String s)
	{
		super(s);
	}
}
