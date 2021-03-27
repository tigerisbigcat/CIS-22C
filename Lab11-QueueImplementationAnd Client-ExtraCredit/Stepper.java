import javax.swing.*;
import java.awt.*;

/**
 * A class that allows an animated application to make a single step.
 * 
 * @author Charles Hoot 
 * @version 4.0
 */
    
public final class Stepper 
{
    
    private Object dispatcher;
    private Component display;
    
    private int onStep;
    private State status;
    
    public enum State {SETUP, INITIAL, STEPPING, FINAL};
    
    
    public Stepper(Object d, Component x)
    {
        dispatcher = d;
        display = x;
        onStep = 0;
        status = State.SETUP;
    }
    
    public int getStep()
    {
        return onStep;
    }
    
    public State getStatus()
    {
        return status;
    }
    
    public void setupStep(){
        status = State.SETUP;
        //System.out.println("Waiting in setup");
        display.repaint();                  // Make sure we display the most recent step
        try
        {
            synchronized(dispatcher)         // Get the lock
            {
                dispatcher.wait();          // Wait for the next step
                
            }
        }
        catch(InterruptedException e)
        { // Just continue on
        }
    }
    


    public void initialStateStep(){
        status = State.INITIAL;
        onStep = 0;
        //System.out.println("Waiting in initial");
        display.repaint();                  // Make sure we display the most recent step
        try
        {
            synchronized(dispatcher)         // Get the lock
            {
                dispatcher.wait();          // Wait for the next step
                
            }
        }
        catch(InterruptedException e)
        { // just continue on
        }
    }
    
    public void animationStep(){
        status = State.STEPPING;
        //System.out.println("Waiting in step");
        onStep++;
        display.repaint();                  // Make sure we display the most recent step
        try
        {
            synchronized(dispatcher)         // Get the lock
            {
                dispatcher.wait();          // Wait for the next step
                
            }
        }
        catch(InterruptedException e)
        { // just continue on
        }
    }


    public void finalStep(){
        status = State.FINAL;
        //System.out.println("Waiting in final");
        display.repaint();                  // Make sure we display the most recent step
        try
        {
            synchronized(dispatcher)         // Get the lock
            {
                dispatcher.wait();          // Wait for the next step
                
            }
        }
        catch(InterruptedException e)
        { // Just continue on
        }
    }
    
    
}
