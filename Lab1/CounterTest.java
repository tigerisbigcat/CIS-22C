package com.company;

/**
 * CounterTest - A class that tests the Counter class.
 * 
 * @author Charles Hoot
 * @version 4.0
 */
public class CounterTest
{
    public static void main (String args[])
    {
        testConstructor();
//        testToString();
//        testEquals();
        testIncrease();
        testDecrease();
        testCombined();
    }
    
    
    /**
     * testConstructor - test if the appropriate exception is thrown
     */

    public static void testConstructor()
    {
        System.out.println("TESTING the constructor");
        System.out.println("Trying min < max");
        try{
            Counter c1 = new Counter(10, 11);
            System.out.println("     Passes");
        }
        catch(CounterInitializationException e)
        {
            System.out.println("**** Fails - exception thrown");
        }


        System.out.println("Trying min = max");
        try{
            Counter c1 = new Counter(10, 10);
            System.out.println("**** Fails - no exception thrown");
        }
        catch(CounterInitializationException e)
        {
            System.out.println("     Passes");
        }


        System.out.println("Trying min > max");
        try{
            Counter c1 = new Counter(11, 10);
            System.out.println("**** Fails - no exception thrown");
        }
        catch(CounterInitializationException e)
        {
            System.out.println("     Passes");
        }
        System.out.println("Finished constructor testing");

    }
    
    /**
     * testEquals - test the equals method
     */

    public static void testEquals()
    {
        Counter c1 = new Counter(10,20);
        Counter c2 = new Counter(10,20);        
        Counter c3 = new Counter(11,20);
        Counter c4 = new Counter(10,21);
        System.out.println();
        System.out.println();
        System.out.println("TESTING the equals method");
        System.out.println("trying two counters that should be in the same state");
        if(c1.equals(c2))
        {
            System.out.println("     passes");
        }
        else
        {
            System.out.println("**** fails");
        }

        System.out.println("trying two counters that should be in a different state");
        if(c1.equals(c3))
        {
            System.out.println("**** fails");
        }
        else
        {
            System.out.println("     passes");
        }

        System.out.println("trying two counters that should be in a different state");
        if(c1.equals(c4))
        {
            System.out.println("**** fails");
        }
        else
        {
            System.out.println("     passes");
        }
        
        System.out.println("Finished equals testing");
    
    }
    

    /**
     * testToString - test the toString method
     */
    public static void testToString()
    {
        System.out.println();
        System.out.println();
        System.out.println("TESTING the toString method");
        Counter c1 = new Counter(1, 9);
        System.out.println("Displaying the counter using toString:");
        System.out.println(c1);
        System.out.println("The counter should have the value 1");
        System.out.println("    the minimum should be 1, the maximum should be 9");
        System.out.println("    it should not have rolled over");
            
        System.out.println("Finished toString testing");
    
    }
    
    /**
     * testIncrease - verify that the increase method works
     */

    public static void testIncrease()
    {
        Counter c1 = new Counter(10,11);
        Counter c2 = new Counter(-1,1);
        Counter c3 = new Counter(-10,30);
        System.out.println();
        System.out.println();
        System.out.println("TESTING the increase method");
        System.out.println("Increasing counter 1 once"); 
        c1.increase();
        if(c1.value() != 11)
        {
            System.out.println("**** fails - bad value");
        }
        else
        {
            System.out.println("     passes");
        }
        
        if(c1.rolledOver())
        {
            System.out.println("**** fails - should not roll over");
        }
        else
        {
            System.out.println("     passes");
        }

        System.out.println("Increasing counter 1 again"); 
        c1.increase();
        if(c1.value() != 10)
        {
            System.out.println("**** fails - bad value");
        }
        else
        {
            System.out.println("     passes");
        }
        
        if(!c1.rolledOver())
        {
            System.out.println("**** fails - should roll over");
        }
        else
        {
            System.out.println("     passes");
        }
 
        System.out.println("Increasing counter 1 a third time"); 
        c1.increase();
        if(c1.value() != 11)
        {
            System.out.println("**** fails - bad value");
        }
        else
        {
            System.out.println("     passes");
        }
        
        if(c1.rolledOver())
        {
            System.out.println("**** fails - should not roll over");
        }
        else
        {
            System.out.println("     passes");
        }
        
        System.out.println("Increasing counter 2 until it rolls over"); 
        int count = 0;
        while(!c2.rolledOver())
        {
            c2.increase();
            count++;
        }
            
        if(c2.value() != -1)
        {
            System.out.println("**** fails - bad value");
        }
        else
        {
            System.out.println("     passes");
        }
        
        if(count != 3)
        {
            System.out.println("**** fails - wrong number of increases; count was " + count);
        }
        else
        {
            System.out.println("     passes");
        }

        System.out.println("Increasing counter 3 until it rolls over"); 
        count = 0;
        while(!c3.rolledOver())
        {
            c3.increase();
            count++;
        }
            
        if(c3.value() != -10)
        {
            System.out.println("**** fails - bad value");
        }
        else
        {
            System.out.println("     passes");
        }
        
        if(count != 41)
        {
            System.out.println("**** fails - wrong number of increases; count was " + count);
        }
        else
        {
            System.out.println("     passes");
        }
        System.out.println("Finished increase testing");

    }
    
    /**
     * testDecrease - verify that the decrease method works
     */

    public static void testDecrease()
    {
        Counter c1 = new Counter(10,11);
        Counter c2 = new Counter(-1,1);
        Counter c3 = new Counter(-10,30);
        System.out.println();
        System.out.println();
        System.out.println("TESTING the decrase method");
        System.out.println("Decreasing the counter once"); 
        c1.decrease();
        if(c1.value() != 11)
        {
            System.out.println("**** fails - bad value");
        }
        else
        {
            System.out.println("     passes");
        }
        
        if(!c1.rolledOver())
        {
            System.out.println("**** fails - should roll over");
        }
        else
        {
            System.out.println("     passes");
        }

        System.out.println("Decreasing the counter again"); 
        c1.decrease();
        if(c1.value() != 10)
        {
            System.out.println("**** fails - bad value");
        }
        else
        {
            System.out.println("     passes");
        }
        
        if(c1.rolledOver())
        {
            System.out.println("**** fails - should not roll over");
        }
        else
        {
            System.out.println("     passes");
        }
 
        System.out.println("Decreasing the counter a third time"); 
        c1.decrease();
        if(c1.value() != 11)
        {
            System.out.println("**** fails - bad value");
        }
        else
        {
            System.out.println("     passes");
        }
        
        if(!c1.rolledOver())
        {
            System.out.println("**** fails - should roll over");
        }
        else
        {
            System.out.println("     passes");
        }
        
        
        System.out.println("Decrease counter 2 twice, then decrease counter 2 until it rolls over again"); 
        int count = 0;
        c2.decrease();
        c2.decrease();
        while(!c2.rolledOver())
        {
            c2.decrease();
            count++;
        }
            
        if(c2.value() != 1)
        {
            System.out.println("**** fails - bad value");
        }
        else
        {
            System.out.println("     passes");
        }
        
        if(count != 2)
        {
            System.out.println("**** fails - wrong number of decreases; count was " + count);
        }
        else
        {
            System.out.println("     passes");
        }

        System.out.println("Decrease counter 3 twice, then decrease counter 3 until it rolls over again"); 
        count = 0;
        c3.decrease();
        c3.decrease();
        while(!c3.rolledOver())
        {
            c3.decrease();
            count++;
        }
            
        if(c3.value() != 30)
        {
            System.out.println("**** fails - bad value");
        }
        else
        {
            System.out.println("     passes");
        }
        
        if(count != 40)
        {
            System.out.println("**** fails - wrong number of decreases; count was " + count);
        }
        else
        {
            System.out.println("     passes");
        }
        System.out.println("Finished decrease testing");

    }
    
    
    /**
     * testCombined - test combinations of the increase and decrease methods
     */

    public static void testCombined()
    {
        Counter c1 = new Counter(10,20);
        Counter c2 = new Counter(10,20);
        Counter c3 = new Counter(10,20);
        System.out.println();
        System.out.println();
        System.out.println("TESTING combinations of the increase and decrease methods");
        System.out.println("Increasing counter 2 once"); 
        c2.increase();
        if(c1.equals(c2))
        {
            System.out.println("**** fails - bad state");
        }
        else
        {
            System.out.println("     passes");
        }
        
        System.out.println("Decreasing counter 2 once"); 
        c2.decrease();
        if(!c1.equals(c2))
        {
            System.out.println("**** fails - should be back in the initial state");
        }
        else
        {
            System.out.println("     passes");
        }

        System.out.println("Decreasing then increasing counter 3"); 
        c3.decrease();
        c3.increase();
        if(c1.equals(c3))
        {
            System.out.println("**** fails - state should differ in rollover");
        }
        else
        {
            System.out.println("     passes");
        }
        System.out.println("Finished combined testing");

    }
}
