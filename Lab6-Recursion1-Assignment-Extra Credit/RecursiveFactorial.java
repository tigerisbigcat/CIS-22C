
/**
 * Two implementations of the factorial function.
 * This is just a place holder class for the two functions
 * 
 * @author Charles Hoot 
 * @version 4.0
 */
public class RecursiveFactorial
{

    /**
     * The basic recursive factorial. 
     * 
     * @param  n   The number to compute factorial of.
     * @return     n factorial.
     */
    public long basic(long n)
    {
        long result = 1;
        if (n > 1) 
            result = n * basic(n - 1);
        
        return result;
    }
    
    
    
    /**
     * The tail recursive version of factorial.
     * 
     * @param  n   The number to compute factorial of.
     * @return     n factorial.
     */
    public long tailRecursive(long n)
    {
        // IMPLEMENT THIS METHOD USING THE RECURSIVE HELPER FUNCTION
        // AND RETURN SOMETHING APPROPRIATE
        return helper(n, 1);
    }

    /**
     * The tail recursive helper function for factorial. 
     * 
     * @param  n   The number to compute factorial of.
     * @param  partial   The partial result that is being built up.
     * @return     n factorial.
     */

    private long helper(long n, long partial) {
        // IMPLEMENT THIS TAIL RECURSIVE METHOD
        if(n <= 0) {
            return partial;
        }
        return helper(n - 1, partial * n);
    }
}
