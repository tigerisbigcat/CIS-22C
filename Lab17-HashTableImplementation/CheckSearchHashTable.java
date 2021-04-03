// 22C
// TTh 9:30-11:15
// Name : Lei Hao
// Lab17 Hash Table Implementation

import java.util.*;
import java.io.*;

/**
 * A class for checking to see if searches in a Hash table behave correctly.
 * 
 * @author Charles Hoot
 * @version 4.0
 */


        
public class CheckSearchHashTable
{
    
    
    public static void main(String args[])
    {
        int arraySize;
        int trials;
        int seed;
        Integer data[];
        DictionaryInterface<Integer,Integer> table;
        TreeMap<Integer,Integer> reference;
                
        
        System.out.println("How many sets of data should be used (number of trials)?");
        trials = getInt("   It should be an integer value greater than or equal to 1.");

        System.out.println("How many data values in each set?");
        arraySize = getInt("   It should be an integer value greater than or equal to 1.");
        
        System.out.println("What seed should be used?");
        seed = getInt("   It should be an integer value greater than or equal to 1.");
        
        for(int i = 0; i<trials; i++)
        {
            table = new HashedDictionaryOpenAddressingLinearInstrumented<Integer,Integer>(10);
            data = generateRandomArray(arraySize, seed);
            insertFirstHalfIntoDictionary(table, data);
            
            reference = new TreeMap<Integer,Integer>();
            insertFirstHalfIntoReference(reference, data);
           
            System.out.println("The initial data is: " + reference);            
            
            // search for all possible values in the data set 
            // and a few guaranteed not to be in the set           
            boolean failed = false;
            for(int k =-2; k<arraySize+2; k++)
            {
                
                Integer lookFor = new Integer(k);
                //System.out.println("Looking for: " + lookFor);            
                
                Object found = table.getValue(lookFor);
                //System.out.println("The returned value is: " + found);
                
                Object referenceResult  = reference.get(lookFor);
                
                if (referenceResult == null)
                {
                    if(found != null)
                    {
                        failed = true;
                        System.out.println("    fails - item: " + k +
                                        " should not have been found");
                    }
                }
                else 
                {
                     if(!referenceResult.equals(found))
                     {
                        failed = true;
                        System.out.println("    fails - item: " + k +
                                        " should have been found; got " + found + " instead");

                    }
                }
                        
            }
            
            if(! failed )
                System.out.println("    passes searching after initial insertion" );

            // Remove the first quarter of the data values (more or less)
            removeQuarterFromDictionary(table, data);
            removeQuarterFromReference(reference, data);
           
            System.out.println("The data after removal is: " + reference);            
            
        
            // Repeat the searches
            failed = false;
            for(int k =-2; k<arraySize+2; k++)
            {
                
                data = generateRandomArray(arraySize, seed);
                Integer lookFor = new Integer(k);
                //System.out.println("Looking for: " + lookFor);            
                
                Object found = table.getValue(lookFor);
                //System.out.println("The returned value is: " + found);
                
                Object referenceResult  = reference.get(lookFor);
                
                if (referenceResult == null)
                {
                    if(found != null)
                    {
                        failed = true;
                        System.out.println("    fails - item: " + k +
                                        " should not have been found");
                    }
                }
                else 
                {
                     if(!referenceResult.equals(found))
                     {
                        failed = true;
                        System.out.println("    fails - item: " + k +
                                        " should have been found; got " + found + " instead");

                    }
                }
                        
            }
            
            if(! failed )
                System.out.println("    passes after removing data" );


            // Add in the last half of the data
            insertSecondHalfIntoDictionary(table, data);
            insertSecondHalfIntoReference(reference, data);
           
            System.out.println("The data after addition inserts is: " + reference);            
            
        
            // Repeat the searches
            failed = false;
            for(int k =-2; k<arraySize+2; k++)
            {
                
                data = generateRandomArray(arraySize, seed);
                Integer lookFor = new Integer(k);
                //System.out.println("Looking for: " + lookFor);            
                
                Object found = table.getValue(lookFor);
                //System.out.println("The returned value is: " + found);
                
                Object referenceResult  = reference.get(lookFor);
                
                if (referenceResult == null)
                {
                    if(found != null)
                    {
                        failed = true;
                        System.out.println("    fails - item: " + k +
                                        " should not have been found");
                    }
                }
                else 
                {
                     if(!referenceResult.equals(found))
                     {
                        failed = true;
                        System.out.println("    fails - item: " + k +
                                        " should have been found; got " + found + " instead");

                    }
                }
                        
            }
            
            if(! failed )
                System.out.println("    passes after inserting more data" );
                
            seed++;
        } //end for            
        
    }


    /**
     * Generate an array of random integer values.  The values will be between 0 and size.
     *
     * @param   size    The size of the array to generate.
     * @return  The array of integers. 
     */
    private static Integer[] generateRandomArray(int size, int seed)
    {
        Integer result[] = new Integer[size];
        Random generator = new Random(seed);

        for(int i = 0; i< size; i++)
        {
            int value = generator.nextInt(size);
            result[i] = new Integer(value);
        }
        
        return result;
    }



    /**
     * Insert the first half of the data values from an array of objects into a dictionary.  
     * 
     * @param   aDictionary    The dictionary that the values will be inserted into.
     * @param   keys    An array of objects that will be the keys for insertion into the dictionary.
     * The value will just be the key itself.
     */
    private static void insertFirstHalfIntoDictionary(DictionaryInterface<Integer,Integer> aDictionary, Integer[] keys)
    {
 
        for(int i = 0; i< keys.length/2; i++)
        {
            aDictionary.add(keys[i], keys[i]);
        }
    }


    /**
     * Insert the first half of the data values from an array of objects into a tree map.  
     * 
     * @param   referenceMap    A tree map that the values will be inserted into.
     * @param   keys    An array of integers that will be the keys for insertion into the map.
     * The value will just be the key itself.     
     */
    private static void insertFirstHalfIntoReference(TreeMap<Integer,Integer> referenceMap, Integer[] keys)
    {
 
        for(int i = 0; i< keys.length/2; i++)
        {
            referenceMap.put(keys[i], keys[i]);
        }
    }



    /**
     * Insert the second half of the data values from an array of objects into a dictionary.  
     * 
     * @param   aDictionary    The dictionary that the values will be inserted into.
     * @param   keys    An array of integers that will be the keys for insertion into the dictionary.
     * The value will just be the key itself.
     */
    private static void insertSecondHalfIntoDictionary(DictionaryInterface<Integer,Integer> aDictionary, Integer[] keys)
    {
 
        for(int i = keys.length/2+1; i< keys.length; i++)
        {
            aDictionary.add(keys[i], keys[i]);
        }
    }


    /**
     * Insert the second half of the data values from an array of objects into a tree map.  
     * 
     * @param   referenceMap    A tree map that the values will be inserted into.
     * @param   keys    An array of Integers that will be the keys for insertion into the map.
     * The value will just be the key itself.     
     */
    private static void insertSecondHalfIntoReference(TreeMap<Integer,Integer> referenceMap, Integer[] keys)
    {
 
        for(int i = keys.length/2+1; i< keys.length; i++)
        {
            referenceMap.put(keys[i], keys[i]);
        }
    }


    /**
     * Remove the first quarter of the data values from the dictionary.  
     * 
     * @param   aDictionary    The dictionary that the values will be deleted from.
     * @param   keys    Ab array of integers that will be the keys for deletion from the dictionary.
     */
    private static void removeQuarterFromDictionary(DictionaryInterface<Integer,Integer> aDictionary, Integer[] keys)
    {
 
        for(int i = 0; i< keys.length/4; i++)
        {
            aDictionary.remove(keys[i]);
        }
    }


    /**
     * Remove the first quarter of the data values from the tree map.  
     * 
     * @param   referenceMap    A tree map that the values will be deleted from.
     * @param   keys    An array of objects that will be the keys for deletion the map.
     */
    private static void removeQuarterFromReference(TreeMap<Integer,Integer> referenceMap, Integer[] keys)
    {
 
        for(int i = 0; i< keys.length/4; i++)
        {
            referenceMap.remove(keys[i]);
        }
    }



    /**
     *  A displayable representation of an array of Objects where toString is 
     *  applied on each object in the array.
     *
     * @param   data    The array to display,
     * @return  A printable string.
     */
    private static String getString(Object [] data)
    {
        String result = new String("[ ");
        
        for(int i = 0; i< data.length; i++)
        {
            result = result + data[i].toString() + " ";
        }
        
        result = result + "]";
        
        return result;
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
