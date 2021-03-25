import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This is a GUI shell for an animated application with go/stop/pause/step controls.
 * 
 * @author Charles Hoot 
 * @version 4.0
 */
    
    
public final class AnimatedApplicationFrame extends JFrame
{
    
    public static final int INITIAL_DELAY = 100;

    private Object dispatcher;
    private Stepper myStepper;
    private Timer myTimer;
    private ActionThread myThread;


    
    private static final int CONTROL_HEIGHT = 160;
    private static final int CONTROL_WIDTH = 400;
    
    
    // the animation control components
    private JButton resetButton;
    private JButton goButton;
    private JButton pauseButton;
    private JButton stepButton;
    private JLabel statusLabel;
    private JLabel delayLabel;
    private JLabel delayFeedbackLabel;
    private JTextField delayTextField;
    
    private JPanel buttonPanel;
    private JPanel delayPanel;
    private JPanel controlPanel;
    
    private JPanel drawingPanel;
    
    /**
     * Constructor for objects of class AnimatedApplication.

    *  @param title The title of the window.
    *  @param d An object that will be used for wait/notify.
    *  @param dPanel A panel that the application will be drawing on.
    *  @param t The application thread.
    */     
    public AnimatedApplicationFrame(String title, Object d, JPanel dPanel, ActionThread t)
    {
        dispatcher = d;
        myStepper = new Stepper(dispatcher, this);
        drawingPanel = dPanel;
        myThread = t;
        
        int apWidth = drawingPanel.getWidth();
        int apHeight = drawingPanel.getHeight();
       
        createControls();
        startControls();
        setControlActions();
        if(apWidth < CONTROL_WIDTH)
            apWidth = CONTROL_WIDTH;
        setWindow(apWidth, apHeight+CONTROL_HEIGHT, title);
        setUpTimer();
        repaint();
    }
 
 
   /** Create and set up the timer.
    */
    private void setUpTimer()
    {
        myTimer = new Timer(INITIAL_DELAY*10,
            new ActionListener() 
            {
                public void actionPerformed(ActionEvent event) 
                {
                    doStep();           // take a step
                }
            }
        );
    }
 
    
    
   /** Create and place the control components.
    */
    private void createControls()
    {
         // create the control components
        resetButton = new JButton("Reset");
        goButton = new JButton("Go");
        pauseButton = new JButton("Pause");
        stepButton = new JButton("Step");
        
        statusLabel = new JLabel("Setup Phase");
        delayFeedbackLabel = new JLabel("");
        delayLabel = new JLabel("Step delay (units of 0.01 second) ");
        delayLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        delayTextField = new JTextField( (new Integer(INITIAL_DELAY)).toString() );
        
        // create the panels
        controlPanel = new JPanel();
        buttonPanel = new JPanel();
        delayPanel = new JPanel();
        
        // add the controls to the button panel
        buttonPanel.setLayout(new GridLayout(1,4,10,1));
        buttonPanel.add(resetButton);
        buttonPanel.add(goButton);
        buttonPanel.add(pauseButton);
        buttonPanel.add(stepButton);
 
        // add components to the step delay panel
        delayPanel.setLayout(new GridLayout(1,2,5,1));
        delayPanel.add(delayLabel);
        delayPanel.add(delayTextField);
        
        // add panels to the control panel
        controlPanel.setLayout(new GridLayout(4,1,1,10));
        controlPanel.add(buttonPanel);
        controlPanel.add(delayPanel); 
        controlPanel.add(delayFeedbackLabel);
        controlPanel.add(statusLabel);
        
        delayFeedbackLabel.setText("Delay is " + INITIAL_DELAY/100.0 + " seconds");
 
        // add the control panel to the application
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(controlPanel, BorderLayout.NORTH);
        
        // add in the panel the user will be drawing on
        getContentPane().add(drawingPanel, BorderLayout.CENTER);
    }  // end createControls


 /** Set up listeners for each of the controller components.
    */
    private void setControlActions()
    {
        resetButton.addActionListener(
            new ActionListener() 
            {
                public void actionPerformed(ActionEvent event) 
                {
                    resetButtonHandler();
                }
            }
        );
        
        
        goButton.addActionListener(
            new ActionListener() 
            {
                public void actionPerformed(ActionEvent event) 
                {
                    goButtonHandler();
                }
            }
        );
        
        
        pauseButton.addActionListener(
            new ActionListener() 
            {
                public void actionPerformed(ActionEvent event) 
                {
                    pauseButtonHandler();
                }
            }
        );            
        
        
        stepButton.addActionListener(
            new ActionListener() 
            {
                public void actionPerformed(ActionEvent event) 
                {
                    stepButtonHandler();
                }
            }
        );
        
        
        delayTextField.addActionListener(
            new ActionListener() 
            {
                public void actionPerformed(ActionEvent event) 
                {
                    delayTextFieldHandler();
                }
            }
        );
       
    }  // end setControlActions
   
   
    // The following handlers are all invoked on event threads and therefore can
    // safely change the state of GUI components.
    
    /** Handler for the reset button press.
    */
    private void resetButtonHandler()
    {
        myTimer.stop();
        startControls();
        myThread.resetExecution();
        
        //step off from last hold point
        synchronized(dispatcher)         // get the lock
        {
            dispatcher.notify();         //step off from last hold point
        }
     }
    
    
    /** Handler for the go button press.
    */
    private void goButtonHandler()
    {
        myTimer.start();
        goControls();
        statusLabel.setText("Started");
        repaint();
    }


    /** Handler for the pause button press.
    */
    private void pauseButtonHandler()
    {
        myTimer.stop();
        stepControls();
        statusLabel.setText("Paused");
        repaint();
    }


    /** Handler for the step button press.
    */
    private void stepButtonHandler()
    {
        stepControls();           
        doStep();
    }


    /** general do Step used by both go and step.
    */
    private void doStep()
    {
            
        synchronized(dispatcher)         // get the lock
        {
            dispatcher.notify();         // notify another step can be taken
        }
    }


    /** Handler for the step delay text field enter.
    */
    private void delayTextFieldHandler()
    {
        try
        {
            String input = delayTextField.getText().trim();
            int newDelay = Integer.parseInt(input);
            myTimer.setDelay(newDelay*10);
            double delayInSeconds = newDelay/100.0;
            
            // If the delay is too short, there may be problems with the timer
            // generating events too quickly.
            
            if(newDelay < 10)
                delayFeedbackLabel.setText("Delay is " + delayInSeconds + " seconds: Warning not recommended");
            else
                delayFeedbackLabel.setText("Delay is " + delayInSeconds + " seconds");
            repaint();
        }
        catch(Exception e)
        {
            // Don't change the timer delay if we had an exception.
        }
    }
    
// Methods that set the button controls based on the state of the controller.  
    private void startControls()
    {
        goButton.setEnabled(true);
        pauseButton.setEnabled(false);
        stepButton.setEnabled(true);
        resetButton.setEnabled(false);

    }
    
    private void stepControls()
    {
        goButton.setEnabled(true);
        pauseButton.setEnabled(false);
        stepButton.setEnabled(true);
        resetButton.setEnabled(true);
    }

    private void goControls()
    {
        goButton.setEnabled(false);
        pauseButton.setEnabled(true);
        stepButton.setEnabled(false);
        resetButton.setEnabled(true);
    }

    private void finalControls()
    {
        goButton.setEnabled(false);
        pauseButton.setEnabled(false);
        stepButton.setEnabled(false);
        resetButton.setEnabled(true);
    }

    
    public Stepper getStepper()
    {
        return myStepper;
    }
    
    // Paint the stepper status 
    public void paint(Graphics g)
    {
        // Set messages before painting
        //get the state of the stepper
        Stepper.State state = myStepper.getStatus();
        
        switch (state)
        {
            case SETUP:
                statusLabel.setText("Setup Phase");
                break;
            case INITIAL:
                statusLabel.setText("Inital State");
                break;
            case STEPPING:
                statusLabel.setText("Step " + myStepper.getStep());
                break;
            case FINAL:
                myTimer.stop();
                statusLabel.setText("Finished");
                finalControls();
                break;
        }
        
        super.paint(g);
    }
    
    
    
    
    
    
 
    /** Creates the Animated Application Window
    *  @param width The desired width of the window.
    *  @param height The desired height of the window.
    *  @param title The title of the window.
    */
    private void setWindow(int width, int height, String title)
    {
        setTitle(title);                    //  We give a title to our frame
        setLocation(0, 0);                  //      along with an initial location
        setSize(width, height);             //      and an initial size
        setVisible(true);                   //  We make it visible (i.e., make it appear)

        WindowDestroyer myClose = new WindowDestroyer();
        addWindowListener(myClose);

    }  // end setWindow
    
    
    // A private class for handling the destruction of the windows.
    private class WindowDestroyer extends WindowAdapter
    {       
        // Make sure that if the window is closed, we kill off the application thread.

        public void windowClosing(WindowEvent event)
        {
            if(myThread != null)
                myThread.killThread();
            System.exit(0);
        }
    }   // end WindowDestroyer

}
