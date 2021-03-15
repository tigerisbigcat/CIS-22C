package com.company;

/**
 * This class performs tests on the extensions to the LList class.
 * 
 * @author Charles Hoot
 * @version 4.0
 */
public class LinkedListExtensionsTest
{
    private static LList<String> testList1 = new LList<String>();
    private static LList<String> testList2 = new LList<String>();
    private static LList<String> testList3 = new LList<String>();
    private static LList<String> testList4 = new LList<String>();
    private static LList<String> testList5 = new LList<String>();
    private static LList<String> testList6 = new LList<String>();
    private static LList<String> testList7 = new LList<String>();
    private static LList<String> testList8 = new LList<String>();
    private static LList<String> testList9 = new LList<String>();
    private static LList<String> testList10 = new LList<String>();
    private static LList<String> testList11 = new LList<String>();
    private static LList<String> testList12 = new LList<String>();
    private static LList<String> testList13 = new LList<String>();
    private static LList<String> testList14 = new LList<String>();
    private static LList<String> testList15 = new LList<String>();
    private static LList<String> testList16 = new LList<String>();
    private static LList<String> testList17 = new LList<String>();


    public static void main(String args[])
    {
        checkReverse();
        checkCycle();
    }
        
    public static void initializeLists()
    {
        testList1.clear();
        testList1.add("Jack");
        testList1.add("Jill");
        testList1.add("John");

        testList2.clear();
        testList2.add("Jack");
        testList2.add("Jill");
        testList2.add("John");

        testList3.clear();
        testList3.add("Jill");
        testList3.add("John");
        testList3.add("Jack");
        
        testList4.clear();
        testList4.add("Jack");
        testList4.add("Jill");
        
        testList5.clear();
        testList5.add("Jack");
        testList5.add("John");
        testList5.add("Jill");
        
        testList6.clear();
        testList6.add("John");
        testList6.add("Jack");
        testList6.add("Jill");
        
        testList7.clear();
        testList7.add("A");
        testList7.add("B");
        testList7.add("C");
        testList7.add("D");
        testList7.add("E");
        testList7.add("F");
        
        testList8.clear();
        testList8.add("F");
        testList8.add("E");
        testList8.add("D");
        testList8.add("C");
        testList8.add("B");
        testList8.add("A");

        testList9.clear();
        testList9.add("A");
        testList9.add("B");
        testList9.add("C");
        testList9.add("D");
        testList9.add("E");
        testList9.add("F");
        testList9.add("G");
 
        testList10.clear();
        testList10.add("G");
        testList10.add("F");
        testList10.add("E");
        testList10.add("D");
        testList10.add("C");
        testList10.add("B");
        testList10.add("A");
        
        testList11.clear();
        testList11.add("Jill");
        testList11.add("John");
        testList11.add("Jack");
        testList11.add("Jerry");
        
        testList12.clear();
        testList12.add("Jill");
        testList12.add("Jack");
        testList12.add("John");
        testList12.add("Jerry");

        testList13.clear();
        testList13.add("Jill");
        testList13.add("Jack");
        testList13.add("Jerry");
        testList13.add("John");

        testList14.clear();
        testList15.clear();

        testList16.clear();
        testList16.add("Jill");
        testList17.clear();
        testList17.add("Jill");

        
        System.out.println();
    }
    
    
    

    public static void checkReverse()
    {
        initializeLists();
        
        System.out.println("TESTING REVERSE");
        
        System.out.println("List 1 is ");
        testList1.display();
        System.out.println("Reversing list one");
        testList1.reverse();
        System.out.println("List 1 is now");
        testList1.display();
        
        System.out.println("Reversing list one a second time");       
        testList1.reverse();
        if(testList1.equals(testList2))
            System.out.println("    Passed test");
        else
        {
            System.out.println("*** Failed test (bad list result)");
            testList1.display();
        }
        System.out.println();
        

        System.out.println("Reversing a list twice");
        testList1.reverse();
        testList1.reverse();
        if(testList1.equals(testList2))
            System.out.println("    Passed test");
        else
        {
            System.out.println("*** Failed test (bad list result)");
            testList1.display();
        }
        System.out.println();
        
        System.out.println("Reversing list 7 of even length");
        testList7.reverse();
        if(testList7.equals(testList8))
            System.out.println("    Passed test");
        else
        {
            System.out.println("*** Failed test (bad list on reverse)");
            testList7.display();
        }
        System.out.println();


        System.out.println("Reversing list 9 of odd length");
        testList9.reverse();
        if(testList9.equals(testList10))
            System.out.println("    Passed test");
        else
        {
            System.out.println("*** Failed test (bad list on reverse)");
            testList10.display();
        }
        System.out.println();


        System.out.println("Reversing a list of length 0");
        testList14.reverse();
        if(testList15.equals(testList14))
            System.out.println("    Passed test");
        else
        {
            System.out.println("*** Failed test (bad list on reverse)");
            testList14.display();
        }
        System.out.println(); 
        
        
        System.out.println("Reversing a list of length 1");
        testList16.reverse();
        if(testList17.equals(testList16))
            System.out.println("    Passed test");
        else
        {
            System.out.println("*** Failed test (bad list on reverse)");
            testList16.display();
        }
        System.out.println();
    }


    public static void checkCycle()
    {
        initializeLists();
        
        System.out.println("TESTING CYCLE");

        System.out.println("Cycling list 1 once");
        testList1.cycle();
        if(testList1.equals(testList3))
            System.out.println("    Passed test");
        else
        {
            System.out.println("*** Failed test (bad list result)");
            testList1.display();
        }
        System.out.println();
        
        System.out.println("Cycling list 3 three times");
        testList3.cycle();
        testList3.cycle();
        testList3.cycle();
        if(testList1.equals(testList3))
            System.out.println("    Passed test");
        else
        {
            System.out.println("*** Failed test (bad list result)");
            testList3.display();
        }
        System.out.println();
        
        
        System.out.println("Cycle a list of length 0");
        testList14.reverse();
        if(testList15.equals(testList14))
            System.out.println("    Passed test");
        else
        {
            System.out.println("*** Failed test (bad list on cycle)");
            testList14.display();
        }
        System.out.println(); 
        
        
        System.out.println("Cylce a list of length 1");
        testList16.reverse();
        if(testList17.equals(testList16))
            System.out.println("    Passed test");
        else
        {
            System.out.println("*** Failed test (bad list on cycle)");
            testList16.display();
        }
        System.out.println();
    }


}
