
/**
 * A class to test the recursive fibonacci function.
 * 
 * @author Charles Hoot 
 * @version 4.0
 */
public class TestFibonacci
{



    public static void main(String args[])
    {
        testBetter();
        testTailRecursive();
    }
    
    public static void testBetter()
    {
        RecursiveFibonacci fibonacci = new RecursiveFibonacci();
        long result;
        System.out.println("TESTING BETTER RECURSIVE FIBONACCI");
        
        System.out.println("Confirm we get a result for a negative value");
        result = fibonacci.better(-5);
        System.out.println("    Passed - got result");
        
        System.out.println("Testing fibonacci(0)");
        result = fibonacci.better(0);
        if(result == 0)
        {
            System.out.println("     Passed");
        }
        else
        {
            System.out.println("**** Fails " + result + " is not the expected result of 0");
        }
        
        
        System.out.println("Testing fibonacci(1)");
        result = fibonacci.better(1);
        if(result == 1)
        {
            System.out.println("     Passed");
        }
        else
        {
            System.out.println("**** Fails " + result + " is not the expected result of 1");
        }
        
        
        System.out.println("Testing fibonacci(3)");
        result = fibonacci.better(3);
        if(result == 2)
        {
            System.out.println("     Passed");
        }
        else
        {
            System.out.println("**** Fails " + result + " is not the expected result of 2");
        }
                
        System.out.println("Testing fibonacci(9)");
        result = fibonacci.better(9);
        if(result == 34)
        {
            System.out.println("     Passed");
        }
        else
        {
            System.out.println("**** Fails " + result + " is not the expected result of 34");
        }
        
        
        System.out.println("Testing fibonacci(10)");
        result = fibonacci.better(10);
        if(result == 55)
        {
            System.out.println("     Passed");
        }
        else
        {
            System.out.println("**** Fails " + result + " is not the expected result of 55");
        }
                
        System.out.println("Testing fibonacci(48)");
        result = fibonacci.better(48);
        if(result == 4807526976l)
        {
            System.out.println("     Passed");
        }
        else
        {
            System.out.println("**** Fails " + result + " is not the expected result of 4807526976");
        }
                
        System.out.println("Testing fibonacci(49)");
        result = fibonacci.better(49);
        if(result == 7778742049l)
        {
            System.out.println("     Passed");
        }
        else
        {
            System.out.println("**** Fails " + result + " is not the expected result of 7778742049");
        }
                

        System.out.println("Testing fibonacci(50)");
        result = fibonacci.better(50);
        if(result == 4807526976l+7778742049l)
        {
            System.out.println("     Passed");
        }
        else
        {
            System.out.println("**** Fails " + result + " is not the expected result of 12586269025");
        }
                

    }
  
  
  
  
  
  
    public static void testTailRecursive()
    {
        RecursiveFibonacci fibonacci = new RecursiveFibonacci();
        long result;
        System.out.println("TESTING TAIL RECURSIVE FIBONACCI");
        
    System.out.println("Confirm we get a result for a negative value");
        result = fibonacci.tailRecursive(-5);
        System.out.println("    Passed - got result");
        
        System.out.println("Testing fibonacci(0)");
        result = fibonacci.tailRecursive(0);
        if(result == 0)
        {
            System.out.println("     Passed");
        }
        else
        {
            System.out.println("**** Fails " + result + " is not the expected result of 0");
        }
        
        
        System.out.println("Testing fibonacci(1)");
        result = fibonacci.tailRecursive(1);
        if(result == 1)
        {
            System.out.println("     Passed");
        }
        else
        {
            System.out.println("**** Fails " + result + " is not the expected result of 1");
        }
        
        
        System.out.println("Testing fibonacci(3)");
        result = fibonacci.tailRecursive(3);
        if(result == 2)
        {
            System.out.println("     Passed");
        }
        else
        {
            System.out.println("**** Fails " + result + " is not the expected result of 2");
        }
                
        System.out.println("Testing fibonacci(9)");
        result = fibonacci.tailRecursive(9);
        if(result == 34)
        {
            System.out.println("     Passed");
        }
        else
        {
            System.out.println("**** Fails " + result + " is not the expected result of 34");
        }
        
        
        System.out.println("Testing fibonacci(10)");
        result = fibonacci.tailRecursive(10);
        if(result == 55)
        {
            System.out.println("     Passed");
        }
        else
        {
            System.out.println("**** Fails " + result + " is not the expected result of 55");
        }
                
        System.out.println("Testing fibonacci(48)");
        result = fibonacci.tailRecursive(48);
        if(result == 4807526976l)
        {
            System.out.println("     Passed");
        }
        else
        {
            System.out.println("**** Fails " + result + " is not the expected result of 4807526976");
        }
                
        System.out.println("Testing fibonacci(49)");
        result = fibonacci.tailRecursive(49);
        if(result == 7778742049l)
        {
            System.out.println("     Passed");
        }
        else
        {
            System.out.println("**** Fails " + result + " is not the expected result of 7778742049");
        }
                

        System.out.println("Testing fibonacci(50)");
        result = fibonacci.tailRecursive(50);
        if(result == 4807526976l+7778742049l)
        {
            System.out.println("     Passed");
        }
        else
        {
            System.out.println("**** Fails " + result + " is not the expected result of 12586269025");
        }
                
    }
}
