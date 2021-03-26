import java.awt.*;
import javax.swing.*;

/**
 * This is an animated application for a simulation of a bank line
 *  
 * @author Charles Hoot 
 * @version 4.0
 */
    
public class BankApplication 
{
    
    public static void main (String args[]) 
    {
        JPanel myPanel;
        Stepper myStepper;
        ActionThread myThread;
        Object dispatcher;
        String title;
        
        myThread = new BankActionThread();     //Change this line for different applications
        myPanel =  myThread.getAnimationPanel();
 
        dispatcher = new Object();
        AnimatedApplicationFrame myFrame = 
            new AnimatedApplicationFrame(myThread.getApplicationTitle(),
                                        dispatcher, myPanel, 
                                        myThread);
        myStepper = myFrame.getStepper();
        
        // must set the stepper before we start the thread
        myThread.setStepper(myStepper);
        myThread.start();
    }
    
    
 
}
