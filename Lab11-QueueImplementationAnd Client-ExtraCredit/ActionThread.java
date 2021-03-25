import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
    
/**
 * The abstract framework for a thread that animates an application
 * 
 * @author Charles Hoot 
 * @version 4.0
 */

    
abstract class ActionThread extends Thread
{
    
    // These methods must be defined in a concrete subclass.
    
     /**
     * Create the specialized animation panel that the application will use.
     * @return A new animation panel.
     */
    abstract JPanel createAnimationPanel();

    
     /**
     * Create and place the GUI components for the application in the specialized
     * animation panel.
     */
    abstract void setUpApplicationSpecificControls();
    
     /**
     * Initialize the variables that the application will use.
     */
    abstract void init();
    
     /**
     * Execute the application a single time.
     */
    abstract void executeApplication();
    
     /**
     * What is the title to use for the application window.
     * @return A title string.
     */
    abstract String getApplicationTitle();
    
    
    /**
     * The constructor for objects of class ActionThread
     */
    public ActionThread()
    {
        
        myPanel =  createAnimationPanel();
        resetApplicationInThread = false;
        killTheThread = false;
        changesAllowed = true;
       
        setUpApplicationSpecificControls();       
    }
    
    
    // **************************************************************************
    // This code handles the mechanics of running the application in the thread
    // It should not depend on the actual application being run
    // **************************************************************************
    
    private boolean resetApplicationInThread;
    private boolean killTheThread;
    private boolean changesAllowed;
    private Stepper myStepper;
    private JPanel myPanel;



     /**
     * Time to wait for the user.  Make it well behaved too.
     */
    public final void animationPause()
    {
        myStepper.animationStep();
        makeThreadWellBehaved();
    }

     /**
     * Time to wait for the user.  Force to the last step.
     */
    public final void forceLastPause()
    {
        myStepper.finalStep();
        makeThreadWellBehaved();
    }

     
     /**
     * Check to see if the thread should kill itself or reset the execution of
     * the application.
     */
    public final void makeThreadWellBehaved()
    {
        if(killTheThread)
            throw new KillThreadException("Thread is being killed");
        if(resetApplicationInThread)
            throw new ResetApplicationException("Application is being reset");
    }
    
     /**
     * Return the specialized panel so the animation frame can include it.
     * @return The animation panel.
     */
    public final JPanel getAnimationPanel()
    {
        return myPanel;
    }
    
    
    
     /**
     * Determine if the application specific controls should be active.
     * @return True if the controls should be active, false otherwise.
     */
    public final boolean applicationControlsAreActive()
    {
        return changesAllowed;
    }
        
    
    
    
     /**
     * Use the given stepper to control the animation.
     */
    public final void setStepper(Stepper s)
    {
        myStepper = s;
    }
    
     /**
     * Signals that the thread should reset the execution of the application.
     */
    public final void resetExecution()
    {
        resetApplicationInThread = true;
    }
    
     /**
     * Signals that the thread should kill itself at the first opportunity.
     */
    public final void killThread()
    {
        killTheThread = true;
    }
  
     /**
     * Run the application multiple times.  This satisfies Thread responsibilities.
     */
    public final void run()
    {
        boolean keepGoing = true;
        //This will allow many executions of the application
        
        while(keepGoing)
        {
            // basic initialization for application
            init();
            changesAllowed = true;
            
            //This is the setup animation step.  The user can make changes beyond the
            // basic initialization before starting the using private controls.
            myStepper.setupStep();
            
            // No changes allowed now
            changesAllowed = false;

            try
            {            
                // This will be the initial state display
                init();
                myStepper.initialStateStep();
                makeThreadWellBehaved();
                
                // Start up the application
                    executeApplication();
                
                //This is the finish animation step.  
                //Nothing should happen until reset is pressed
                myStepper.finalStep();

            }
            catch(KillThreadException e)
            {
                keepGoing = false;
            }
            catch(ResetApplicationException e)
            {
                //We got reset; go around again!
            }                        
            resetApplicationInThread = false;
        }
    }
    
            
} // end abstract class ActionThread

