// 22C
// TTh 9:30-11:15
// Name : Lei Hao
// find the prime number in this program.

package com.company;
import java.io.*;
import java.util.*;

/**
 * Primes is a program that will compute prime numbers using the sieve of Eratosthenes.
 * 
 * @author Charles Hoot
  * @version 4.0
 */

    
public class Primes
{

    public static void main(String args[])
    {
        ListInterface<Integer> candidates;

        int max;
        System.out.println("Please enter the maximum value to test for primality");
        max = getInt("   It should be an integer value greater than or equal to 2.");

        // COMPLETE THE MAIN
        // In main declare and create the candidates list. Add in the values.
        candidates = new AList<Integer>(max);
        for (int i = 1; i <= max - 1; i++) {
            candidates.add(i, i + 1);
        }
        System.out.println("Candidates list is: " + candidates);

        // In main declare and create the primes and composites lists.
        ListInterface<Integer> primes = new AList<Integer>(max);
        ListInterface<Integer> composites = new AList<Integer>(max);

        // Remove the first value from the primes list and remember it in a variable.
        int removedNumber = candidates.remove(1);

        // Print out the prime that was discovered.
        System.out.println("We removed the prime number: " + removedNumber);

        // Add it to the primes list.
        primes.add(1, removedNumber);

        // call getComposites()
        getComposites(candidates, composites,removedNumber);

        // Print out all three lists.
        System.out.println("Now candidate list is: " + candidates);
        System.out.println("Now prime list is: " + primes);
        System.out.println("Now composites list is: " + composites);
    }

    /**
     * getComposites - Remove the composite values from possibles list and
     * put them in the composites list.
     *
     * @param  candidates   A list of integers holding the possible values.
     * @param  composites   A list of integers holding the composite values.
     * @param  prime   An Integer that is prime.
     */
    public static void getComposites(ListInterface<Integer> candidates, ListInterface<Integer> composites, Integer prime)
    {
        for (int index = 1; index <= candidates.getLength(); index++) {
            if (candidates.getEntry(index) % prime == 0 ) {
                composites.add(composites.getLength() + 1, candidates.getEntry(index));
                candidates.remove(index);
            }
        }
    }

    /**
     * Get an integer value.
     *
     * @return     An integer. 
     */
    private static int getInt(String rangePrompt)
    {
        Scanner input;
        int result = 10;        //Default value is 10
        try
        {
            input = new Scanner(System.in);
            System.out.println(rangePrompt);
            result = input.nextInt();
            
        }
        catch(NumberFormatException e)
        {
            System.out.println("Could not convert input to an integer");
            System.out.println(e.getMessage());
            System.out.println("Will use 10 as the default value");
        }        
        catch(Exception e)
        {
            System.out.println("There was an error with System.in");
            System.out.println(e.getMessage());
            System.out.println("Will use 10 as the default value");
        }
        return result;
    }    
    
}
