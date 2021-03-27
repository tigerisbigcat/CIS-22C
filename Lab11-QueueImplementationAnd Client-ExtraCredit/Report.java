import java.util.*;
import java.awt.*;

/**
 * A class that will be used to give a report for the bank line simulation.  
 * Since it may be accessed by user interface threads
 * (paint) and the application thread, make all methods synchronized
 * 
 * @author Charles Hoot
 * @version 4.0
 */
        
public class Report
    {
        private BankLine waiting;
        private java.util.List<Customer> served;
        private double timeNow;
        
        public Report(BankLine theLineToMonitor)
        {
            served = new ArrayList<Customer>();
            waiting = theLineToMonitor;
            timeNow = 0.0;
        }
        
        /**
         *  Update the current time for the report
         *
         * @param  newTime   The current time in the simulation.
         */   
        synchronized
        public void updateTime(double newTime)
        {
            timeNow = newTime;
        }
        
        /**
         *  Record that this customer has been served.
         *
         * @param  c   The customer that has been served.
         */
        synchronized 
        public void addServed(Customer c)
        {
            served.add(c);
        }
        
        
        /**
         *  Get average waiting time for customers in line.
         *
         * @return  The average time that customers in line have been waiting.
         */
        synchronized 
        public double averageOfLine()
        {
            double total = 0.0;
            int count = 0;
            Iterator<Customer> iter = waiting.iterator();
            while(iter.hasNext())
            {
                Customer c = iter.next();
                double waitSoFar = timeNow - c.arrivalTime();
                count++;
                total += waitSoFar;
            }
            
            return total/count;
        }
        
        /**
         *  Get the number of customer waiting in the bank line.
         *
         * @return  The number of customers in the queue.
         */
        synchronized 
        public int waitingCount()
        {
             int count = 0;
            Iterator<Customer> iter = waiting.iterator();
            while(iter.hasNext())
            {
                iter.next();
                count++;
            }
            
            return count;
        }  
        
        /**
         *  Get the average waiting time for customers that have been served.
         *
         * @return  The average time that customers which have been served have waited.
         */
        synchronized 
        public double averageOfServed()
        {
            double total = 0.0;
            int count = 0;
            Iterator<Customer> iter = served.iterator();
            while(iter.hasNext())
            {
                Customer c = iter.next();
                double waitSoFar = c.waitTime();
                count++;
                total += waitSoFar;
            }
            
            return total/count;
        }        
                
    public static final int LINE_HEIGHT = 15;

        
        
    /**
     * Draw a representation of the report at the given location
     * 
     * @param   g  the graphics context to draw on   
     * @param   leftX  x position of the left side of the report
     * @param   topY  y position of the top
     * 
     */
    synchronized 
    public void drawOn(Graphics g, int leftX, int topY)
    {
        String toDraw;
        // report the simulation time
        toDraw = "Simulation time is: " + timeNow;
        g.drawString(toDraw, leftX, topY+LINE_HEIGHT);
        
        // report the number of customers waiting in and their average time
        int count =  waitingCount();
        toDraw = "Customers waiting: " + count;
        g.drawString(toDraw, leftX, topY+2*LINE_HEIGHT);
        
        if(count < 1)
            toDraw = "    No average yet.";
        else
            toDraw = "    Average time spent waiting: " + averageOfLine();
        g.drawString(toDraw, leftX, topY+3*LINE_HEIGHT);

        // report the number of customers served and their average time
         count =  served.size();
        toDraw = "Customers served: " + count;
        g.drawString(toDraw, leftX, topY+4*LINE_HEIGHT);
        
        if(count < 1)
            toDraw = "    No average yet.";
        else
            toDraw = "    Average time spent waiting: " + averageOfServed();
        g.drawString(toDraw, leftX, topY+5*LINE_HEIGHT);

    }
        
}
