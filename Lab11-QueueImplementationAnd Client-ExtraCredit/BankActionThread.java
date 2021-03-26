import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import QueuePackage.*;

/**
 * A Thread for the Bank simulation using queus
 * 
 * @author Charles Hoot 
 * @version 4.0
 */

    
    
public class BankActionThread extends ActionThread {
    /**
     * Constructor for objects of class ActionThread
     */
    public BankActionThread()
    {
        super();      
    }
    
    public String getApplicationTitle()
    {
        return "Bank Simulation (Skeleton)";
    }    
    

    // **************************************************************************
    // This is application specific code
    // **************************************************************************    

    // These are the variables that are parameters of the application and can be
    // set via the application specific GUI
    // Make sure they are initialized
    private int maxForService = 20;
    private int maxForInterval = 20;
    private int stopSimulationAt = 1000;
   
    
    // Displayed items
    private BankLine myLine;
    private Teller myTeller;
    private String nextEventAction;
    private String lastEventReport;
    private Report myReport;
 

    // Not displayed, but still used in the simulation
    private SimulationEventQueue theEvents;
    private CustomerGenerator myCG;
    private Random sharedRandom;
    
    
    public void init() 
    {
        theEvents = new SimulationEventQueue();
        sharedRandom = new Random();
        myLine = new BankLine();

        myReport = new Report(myLine);
        myTeller = new Teller("Fred",maxForService, theEvents, sharedRandom, myLine, myReport);       
        myCG = new CustomerGenerator(maxForInterval, theEvents, sharedRandom, myLine );
        lastEventReport = "No events have been processed";
        
        SimulationEvent next = theEvents.peek();
        if(next != null)
            nextEventAction = next.getDescription();
        else
            nextEventAction = "No events to process";
        
    }

    public void executeApplication()
    {
        //ADD CODE HERE TO RUN THE EVENT SIMULATION

        //  Initialize the starting time.
        // double time = theEvents.getCurrentTime();

        while (theEvents.getCurrentTime() < stopSimulationAt) {
            SimulationEvent first = theEvents.remove();
            // System.out.println(first);
            first.process();
            lastEventReport = first.getPostActionReport();

            SimulationEvent next = theEvents.peek();
            if(next != null) {
                nextEventAction = next.getDescription();
            }
            else {
                nextEventAction = "No events to process";
            }

            myReport.updateTime(theEvents.getCurrentTime());
            animationPause();
        }

    }


    private static int DISPLAY_HEIGHT = 500;
    private static int DISPLAY_WIDTH = 500;

    public JPanel createAnimationPanel()
    {
        return new AnimationPanel();
    }
    
    private static int LINE_OFFSET_X = 50;
    private static int LINE_Y_TO_BASE = 100;   
    private static int TELLER_Y_TO_BASE = 200;
    private static int REPORT_Y_TO_TOP = 250;

    // This privately defined class does the drawing the application needs
    public class AnimationPanel extends JPanel
    {
        public AnimationPanel()
        {
            super();
            setSize(DISPLAY_WIDTH, DISPLAY_HEIGHT);
        }
        
        public void paintComponent(Graphics g)
        {
            String toDraw;
            super.paintComponent(g);

            if(lastEventReport != null)
            {
                g.drawString(lastEventReport, 20, 20);
            }

            if(nextEventAction != null)
            {
                toDraw = "Next event: " + nextEventAction;
                g.drawString(toDraw, 20, 35);
            }
            
            // Now draw the line if it is available
            if(myLine != null)
                myLine.drawOn(g, LINE_OFFSET_X, LINE_Y_TO_BASE);
                
            // Draw the teller if it is available
            if(myTeller != null)
                myTeller.drawOn(g, 20, TELLER_Y_TO_BASE);
            
            // Draw the report if it is available
            if(myReport != null)
                myReport.drawOn(g, 20, REPORT_Y_TO_TOP);
            
        }
    }
    
    // **************************************************************************
    // This is the application specific GUI code
    // **************************************************************************    

    private JTextField maxIntervalTextField;
    private JTextField maxServiceTextField;
    private JTextField endSimulationTextField;
    private JLabel setupStatusLabel;
    private JPanel setupPanel;
    
    public void setUpApplicationSpecificControls()
    {
        getAnimationPanel().setLayout(new BorderLayout());
        
        
        maxIntervalTextField = new JTextField("20");
        maxIntervalTextField.addActionListener(
            new ActionListener() 
            {
                public void actionPerformed(ActionEvent event) 
                {
                    maxIntervalTextFieldHandler();
                    getAnimationPanel().repaint();
                }
            }
        );

        maxServiceTextField = new JTextField("20");
        maxServiceTextField.addActionListener(
            new ActionListener() 
            {
                public void actionPerformed(ActionEvent event) 
                {
                    maxServiceTextFieldHandler();
                    getAnimationPanel().repaint();
                }
            }
        );
 
        endSimulationTextField = new JTextField("1000");
        endSimulationTextField.addActionListener(
            new ActionListener() 
            {
                public void actionPerformed(ActionEvent event) 
                {
                    endSimulationTextFieldHandler();
                    getAnimationPanel().repaint();
                }
            }
        );
 
        setupStatusLabel = new JLabel("");
        
        setupPanel = new JPanel();
        setupPanel.setLayout(new GridLayout(4,2));
        
        setupPanel.add(new JLabel("Max customer interval (integer > 0):"));
        setupPanel.add(maxIntervalTextField);
        setupPanel.add(new JLabel("Max service time (integer > 0):"));
        setupPanel.add(maxServiceTextField);
        setupPanel.add(new JLabel("Max simulation time (integer > 0):"));
        setupPanel.add(endSimulationTextField);
        setupPanel.add(setupStatusLabel);
        
        getAnimationPanel().add(setupPanel,BorderLayout.SOUTH);
               
    }



    private void maxIntervalTextFieldHandler()
    {
    try
        {
            if(applicationControlsAreActive())   // Only change if we are in the setup phase
            {
                String input = maxIntervalTextField.getText().trim();
                int value = Integer.parseInt(input);
                if(value>0)
                {
                    maxForInterval = value;
                    setupStatusLabel.setText("Maximum customer interval set to " + maxForInterval);
                }
                else
                {
                    setupStatusLabel.setText("Need a positive value for interval ");
                }
                
            }
        }
        catch(Exception e)
        {
            // don't change the delta if we had an exception
            setupStatusLabel.setText("Need integer value for interval");
        }
    
    }
    
    

    
    private void maxServiceTextFieldHandler()
    {
    try
        {
            if(applicationControlsAreActive())   // Only change if we are in the setup phase
            {
                String input = maxServiceTextField.getText().trim();
                int value = Integer.parseInt(input);
                if(value>0)
                {
                    maxForService = value;
                    setupStatusLabel.setText("Maximum service time set to " + maxForService);
                }
                else
                {
                    setupStatusLabel.setText("Need a positive value for service ");
                }
                
            }
        }
        catch(Exception e)
        {
            // don't change the delta if we had an exception
            setupStatusLabel.setText("Need integer value for service");
        }
    
    }


    private void endSimulationTextFieldHandler()
    {
    try
        {
            if(applicationControlsAreActive())   // Only change if we are in the setup phase
            {
                String input = endSimulationTextField.getText().trim();
                int value = Integer.parseInt(input);
                if(value>0)
                {
                    stopSimulationAt = value;
                    setupStatusLabel.setText("Ending at time " + stopSimulationAt);
                }
                else
                {
                    setupStatusLabel.setText("Need a positive value for stop ");
                }
                
            }
        }
        catch(Exception e)
        {
            // don't change the delta if we had an exception
            setupStatusLabel.setText("Need integer value for stop");
        }
    
    }    
   
            
} // end class ActionThread

