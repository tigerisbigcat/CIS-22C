
/**
 * Write a description of class Small here.
 */

public class Small
{
    // Instance variables - Replace the example below with your own.
    private int x,y;    
    public String s = "aaa";

    /**
     * Constructor for objects of class Small
     */
    public Small()
    {
        // Initialise instance variables
        x = 0;
        s = "oops";
    }

    /**
     * An example of a method - Replace this comment with your own.
     * 
     * @param  y   A sample parameter for a method.
     * @return     The sum of x and y.
     */
    public int sampleMethod(int y)
    {
        String extra = s + " a bit more.";
        s = extra;
        return x + y + TO_ADD_20;
    }
    
    public static final int TO_ADD_20 = 20;
    
    public static void main (String args[])
    {
        Small obj = new Small();
        System.out.println("s is " + obj.s);
        int  kk = obj.sampleMethod(3);
        System.out.println("s is now " + obj.s);
        System.out.println("kk is the value " + kk);
        System.out.println("Bye");
    }
    
}
