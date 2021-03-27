import QueuePackage.*;
import java.util.*;

/**
 * A class that will be used to generate Customers in the simulation.  
 * It will not be displayed.
 * 
 * @author Charles Hoot
 * @version 4.0
 */

        
public class CustomerGenerator
{
    
    
    private int maxForNext;
    private SimulationEventQueue theEventQueue;
    private Random sharedRandomGenerator;
    private String lastNameWas;
    private BankLine theLine;
    public int count;
    
    
    public CustomerGenerator(int maxTimeToNextCustomer, SimulationEventQueue simulationEventQueue,
                            Random simulationRandomGenerator, BankLine putInLine)
    {
        maxForNext = maxTimeToNextCustomer;
        theEventQueue = simulationEventQueue;
        sharedRandomGenerator = simulationRandomGenerator;
        theLine = putInLine;
        lastNameWas = "";
        count = 0;
        
        // Put the first event on the queue
	   int timeToNext = sharedRandomGenerator.nextInt(maxForNext);
	   SimulationEvent nextGeneration = new GenerateCustomerEvent(
	                   theEventQueue.getCurrentTime()+timeToNext,
	                   "Generate the first customer.");
	   theEventQueue.add(nextGeneration);
        
    }
      
    /**
     * Get the name of the next customer. 
     *
     * @return  A string containing the name.
     */
    private String getName()
    {
        count++;
        lastNameWas = Integer.toString(count);
        return lastNameWas;
    }
    
    // Inherit from the abstract SimulationEvent.  Only the constructor and process need to be defined.
    public class GenerateCustomerEvent extends SimulationEvent
    {
        public GenerateCustomerEvent (double theTime, String action)
        {
            super(theTime,action);
        }
         	
    	/**
    	 * Process the event.
    	 */
    	public void process()
    	{
    	   Customer generated = new Customer(getName(), theEventQueue.getCurrentTime());
    	   theLine.enqueue(generated);
    	   postActionReport = "Generated customer " + lastNameWas;
    	   //System.out.println("generated customer " + lastNameWas);
    	   
    	   int timeToNext = sharedRandomGenerator.nextInt(maxForNext);
           //System.out.println("Time to next is " + timeToNext);
    	   SimulationEvent nextGeneration = new GenerateCustomerEvent(
    	                   theEventQueue.getCurrentTime()+timeToNext,
    	                   "Generate the next customer");
    	   theEventQueue.add(nextGeneration);
    	}

        @Override
        public int compareTo(SimulationEvent simulationEvent) {
            return (int)(this.getTime() - simulationEvent.getTime());
        }
    }  // end of GenerateCustomerEvent
        
}
