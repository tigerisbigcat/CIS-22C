
/**
 * A class to test the recursive factorial function.
 * 
 * @author Charles Hoot 
 * @version 4.0
 */
public class TestFactorial
{



    public static void main(String args[])
    {
        testBasic();
        testTailRecursive();
    }
    
    public static void testBasic()
    {
        RecursiveFactorial factorial = new RecursiveFactorial();
        long result;
        System.out.println("TESTING BASIC RECURSIVE FACTORIAL");
        
        System.out.println("Confirm we get a result for a negative value");
        result = factorial.basic(-5);
        System.out.println("    Passed - got result");
        
        System.out.println("Testing factorial(0)");
        result = factorial.basic(-5);
        if(result == 1)
        {
            System.out.println("     Passed");
        }
        else
        {
            System.out.println("**** Fails " + result + " is not the expected result of 1");
        }
        
        
        System.out.println("Testing factorial(1)");
        result = factorial.basic(1);
        if(result == 1)
        {
            System.out.println("     Passed");
        }
        else
        {
            System.out.println("**** Fails " + result + " is not the expected result of 1");
        }
        
        
        System.out.println("Testing factorial(3)");
        result = factorial.basic(3);
        if(result == 6)
        {
            System.out.println("     Passed");
        }
        else
        {
            System.out.println("**** Fails " + result + " is not the expected result of 6");
        }
                
        System.out.println("Testing factorial(10)");
        result = factorial.basic(10);
        if(result == 3628800)
        {
            System.out.println("     Passed");
        }
        else
        {
            System.out.println("**** Fails " + result + " is not the expected result of 3628800");
        }
                
                
    }
  
  
  
  
  
  
    public static void testTailRecursive()
    {
        RecursiveFactorial factorial = new RecursiveFactorial();
        long result;
        System.out.println("TESTING TAIL RECURSIVE FACTORIAL");
        
        System.out.println("Confirm we get a result for a negative value");
        result = factorial.tailRecursive(-5);
        System.out.println("    Passed - got result");
        
        System.out.println("Testing factorial(0)");
        result = factorial.tailRecursive(0);
        if(result == 1)
        {
            System.out.println("     Passed");
        }
        else
        {
            System.out.println("**** Fails " + result + " is not the expected result of 1");
        }
        
        
        System.out.println("Testing factorial(1)");
        result = factorial.tailRecursive(1);
        if(result == 1)
        {
            System.out.println("     Passed");
        }
        else
        {
            System.out.println("**** Fails " + result + " is not the expected result of 1");
        }
        
        
        System.out.println("Testing factorial(3)");
        result = factorial.tailRecursive(3);
        if(result == 6)
        {
            System.out.println("     Passed");
        }
        else
        {
            System.out.println("**** Fails " + result + " is not the expected result of 6");
        }
                
        System.out.println("Testing factorial(10)");
        result = factorial.tailRecursive(10);
        if(result == 3628800)
        {
            System.out.println("     Passed");
        }
        else
        {
            System.out.println("**** Fails " + result + " is not the expected result of 3628800");
        }
                
                
    }

}
