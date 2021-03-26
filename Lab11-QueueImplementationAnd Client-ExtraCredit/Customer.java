import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
    
/**
 * A class to represent customer in a bank line.  
 * 
 * It will be displayable so all methods must be synchronized.
 * 
 * @author Charles Hoot 
 * @version 4.0
 */

public class Customer
{
    private String myName;
    private double arrivedInLine;
    private double leftLine;
    private boolean hasLeftLine;
    
    public Customer(String name, double inTime)
    {
        myName = name;
        arrivedInLine = inTime;
        leftLine = 0;           // this does not matter until customer leaves line
        hasLeftLine = false;       
    } // end constructor
    
    /**
     * The customer has been served
     *
     * @param  time   The time the customer was served at.
     */
    public void servedAt(double time)
    {
        hasLeftLine = true;
        leftLine = time;
    }
    
    /**
     * When did the customer arrive in line?
     *
     * @return  The time the customer arrived in the line.
     */    
    public double arrivalTime()
    {
       return  arrivedInLine;
    }
    
    /**
     * How long did the customer wait?
     *
     * @return  The time the customer left the line minus the arrival time.
     */    
    public double waitTime()
    {
       return leftLine - arrivedInLine;
    }
    
    /**
     * What is the customers name?
     *
     * @return  The name of the customer.
     */    
    public String getName()
    {
       return myName;
    }
    

    
    
    public static final int LINE_HEIGHT = 15;
    
    public static final int TORSO_HEIGHT = 18;
    public static final int NECK_HEIGHT = 3;
    public static final int LEG_HEIGHT = 18;
    public static final int ARM_WIDTH = 13;
    public static final int HEAD_SIZE = 6;
        
        
    /**
     * Draw a representation of the customer at the given location.
     * 
     * @param   g  The graphics context to draw on.  
     * @param   leftX  The x position of the left end of the customer.
     * @param   baseY  The y position of the base of the customer stick figure
     *                  text will go below.
     * 
     */
    synchronized 
    public void drawOn(Graphics g, int leftX, int baseY)
    {
       
        g.setColor(Color.blue);
        int totalHeight = TORSO_HEIGHT + NECK_HEIGHT + LEG_HEIGHT + 2*HEAD_SIZE;
        int totalWidth =  2*ARM_WIDTH ;

        // Draw the head
        int headX = leftX + ARM_WIDTH - HEAD_SIZE;
        int headY = baseY - totalHeight;
        g.fillOval(headX, headY, 2*HEAD_SIZE, 2*HEAD_SIZE);
        
        // Draw the torso and neck
        int bodyX = leftX + ARM_WIDTH;
        int topBodyY = baseY - totalHeight + 2*HEAD_SIZE;
        int bottomBodyY = baseY - LEG_HEIGHT;
        g.drawLine(bodyX, topBodyY, bodyX, bottomBodyY);
        
        // Draw the arms
        int leftArmX = leftX ;
        int rightArmX = leftX + 2*ARM_WIDTH;
        int armY = baseY - TORSO_HEIGHT - LEG_HEIGHT;
        g.drawLine(leftArmX, armY, rightArmX, armY);
        
        // Draw the legs
        int topLegX = leftX + ARM_WIDTH;
        int topLegY = baseY - LEG_HEIGHT;
        int leftLegBottomX = leftX;
        int leftLegBottomY = baseY;
        int rightLegBottomX = leftX + 2*ARM_WIDTH;
        int rightLegBottomY = baseY;
        g.drawLine(topLegX, topLegY, leftLegBottomX, leftLegBottomY);
        g.drawLine(topLegX, topLegY, rightLegBottomX, rightLegBottomY);
        
        // Draw the name
        if(myName != null)
            g.drawString(myName, leftX, baseY+LINE_HEIGHT);
        
        // Draw the arrival time
        Font savedFont = g.getFont();
        Font timeFont = new Font("monospaced", Font.PLAIN, 10);
        g.setFont(timeFont);
        String toDraw = (new Double(arrivedInLine)).toString();
        if(hasLeftLine)
            g.setColor(Color.black);
        else
            g.setColor(Color.red);
        g.drawString(toDraw, leftX, baseY+2*LINE_HEIGHT);
        
        // Draw the served time
        
        if(hasLeftLine)
        {
            toDraw = (new Double(leftLine)).toString();
            g.setColor(Color.black);
            g.drawString(toDraw, leftX, baseY+3*LINE_HEIGHT);
         }
         
        g.setFont(savedFont);

    }
}
