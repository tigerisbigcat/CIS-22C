import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import QueuePackage.*;
import java.util.Random;

/**
 * A class to represent teller in a bank 
 * 
 * It will be displayable so all methods must be synchronized.
 * 
 * @author Charles Hoot 
 * @version 4.0
 */

    
public class Teller {
    private String myName;
    private Customer serving;
    private int maxForHelp;
    private SimulationEventQueue theEventQueue;
    private Random sharedRandomGenerator;
    private String lastNameWas;
    private BankLine theLine;
    private Report reportServices;


    public Teller(String name, int maxTimeToHelpCustomer, SimulationEventQueue simulationEventQueue,
                  Random simulationRandomGenerator, BankLine servicesLine,
                  Report toReportTo) {
        myName = name;
        serving = null;
        maxForHelp = maxTimeToHelpCustomer;
        theEventQueue = simulationEventQueue;
        sharedRandomGenerator = simulationRandomGenerator;
        theLine = servicesLine;
        reportServices = toReportTo;

        //ADD CODE HERE TO GENERATE THE INITIAL EVENT
        //int timeToNext = sharedRandomGenerator.nextInt(maxTimeToHelpCustomer);
        SimulationEvent firstServing = new CheckForCustomerEvent
                (theEventQueue.getCurrentTime() + 1, "Serving the first customer.");
        theEventQueue.add(firstServing);

    } // end constructor

    /**
     * Start serving a customer.
     *
     * @param c The customer being serviced.
     */
    synchronized
    public void serve(Customer c) {
        serving = c;
        c.servedAt(theEventQueue.getCurrentTime());
        reportServices.addServed(c);
    }

    // Inherit from the abstract SimulationEvent.  Only the constructor and process need to be defined.
    public class CheckForCustomerEvent extends SimulationEvent {
        public CheckForCustomerEvent(double theTime, String action) {
            super(theTime, action);
        }

        /**
         * Process the event.
         */
        synchronized
        public void process() {
            // ADD CODE HERE FOR PROCESSING A CUSTOMER
            if (theLine.isEmpty()) {
                serving = null;
                String action = "Checking the line for customer to serve";
                SimulationEvent nextServing = new CheckForCustomerEvent
                        (theEventQueue.getCurrentTime() + 1, action);
                theEventQueue.add(nextServing);
            }
            else {
                Customer customerBeingProcessed = theLine.dequeue();
                serve(customerBeingProcessed);
                postActionReport = "Serving customer" + customerBeingProcessed.getName();
                int timeToNext = sharedRandomGenerator.nextInt(maxForHelp);
                String action = "Serving the next customer";
                SimulationEvent nextServing = new CheckForCustomerEvent
                        (theEventQueue.getCurrentTime() + timeToNext, action);
                theEventQueue.add(nextServing);
            }
        }

        @Override
        public int compareTo(SimulationEvent simulationEvent) {
            return (int)(this.getTime() - simulationEvent.getTime());
        }
    }// end of GenerateCustomerEvent

        //            while (theEventQueue.getSize() > 0) {
//                if (serving != null) {
//                    Customer customer = new Customer(serving.getName(), theEventQueue.getCurrentTime());
//                    serve(customer);
//                    SimulationEvent servedCustomer = theEventQueue.remove();
//                    servedCustomer.getPostActionReport();
//                }
//            }
//        }

    public static final int LINE_HEIGHT = 15;
    public static final int TORSO_HEIGHT = 18;
    public static final int NECK_HEIGHT = 3;
    public static final int LEG_HEIGHT = 18;
    public static final int ARM_WIDTH = 13;
    public static final int HEAD_SIZE = 6;

    public static final int BARRIER_SIZE = 4;


    /**
     * Draw a representation of the Teller at the given location.
     *
     * @param g     The graphics context to draw on.
     * @param leftX The x position of the left end of the customer.
     * @param baseY The y position of the base of the customer stick figure.
     *              text will go below
     */
    synchronized
    public void drawOn(Graphics g, int leftX, int baseY) {

        g.setColor(Color.blue);
        int totalHeight = TORSO_HEIGHT + NECK_HEIGHT + LEG_HEIGHT + 2 * HEAD_SIZE;
        int totalWidth = 2 * ARM_WIDTH;

        // Draw the head
        int headX = leftX + ARM_WIDTH - HEAD_SIZE;
        int headY = baseY - totalHeight;
        g.fillOval(headX, headY, 2 * HEAD_SIZE, 2 * HEAD_SIZE);

        // Draw the torso and neck
        int bodyX = leftX + ARM_WIDTH;
        int topBodyY = baseY - totalHeight + 2 * HEAD_SIZE;
        int bottomBodyY = baseY - LEG_HEIGHT;
        g.drawLine(bodyX, topBodyY, bodyX, bottomBodyY);

        // Draw the arms
        int leftArmX = leftX;
        int rightArmX = leftX + 2 * ARM_WIDTH;
        int armY = baseY - TORSO_HEIGHT - LEG_HEIGHT;
        g.drawLine(leftArmX, armY, rightArmX, armY);

        // Draw the legs
        int topLegX = leftX + ARM_WIDTH;
        int topLegY = baseY - LEG_HEIGHT;
        int leftLegBottomX = leftX;
        int leftLegBottomY = baseY;
        int rightLegBottomX = leftX + 2 * ARM_WIDTH;
        int rightLegBottomY = baseY;
        g.drawLine(topLegX, topLegY, leftLegBottomX, leftLegBottomY);
        g.drawLine(topLegX, topLegY, rightLegBottomX, rightLegBottomY);

        // Draw the name
        if (myName != null)
            g.drawString(myName, leftX, baseY + LINE_HEIGHT);

        // Draw the service barrier
        g.setColor(Color.black);
        int leftBarrierX = leftX + totalWidth + BARRIER_SIZE;
        int topBarrierY = baseY - TORSO_HEIGHT - LEG_HEIGHT;
        // counter top
        g.fillRect(leftBarrierX, topBarrierY, 2 * BARRIER_SIZE, BARRIER_SIZE);
        // pedestal
        leftBarrierX = leftX + totalWidth + 2 * BARRIER_SIZE;
        g.fillRect(leftBarrierX, topBarrierY, BARRIER_SIZE, TORSO_HEIGHT + LEG_HEIGHT);

        // Draw the customer
        int serveX = leftX + totalWidth + 4 * BARRIER_SIZE;
        if (serving != null)
            serving.drawOn(g, serveX, baseY);
    }
}
