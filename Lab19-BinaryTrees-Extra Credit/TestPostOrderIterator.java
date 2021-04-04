import TreePackage.*;
import java.util.*;

/**
 * This is a test class for the Tree/Binary Search tree classes
 * in the TreePackage
 * 
 * @author Charles Hoot
 * @version 4.0
 */

    
public class TestPostOrderIterator
{
    
    public static void main(String args[])
    {        
        testPostorderIterator();
    }

    public static void testPostorderIterator()
    {        
    
        int value;
        
        System.out.println("TESTING THE post order Iterator");
            
        System.out.println("Checking for an empty tree");                
        BinaryTree<String> b0 = new BinaryTree<String>();
        Iterator<String> iter = b0.getPostorderIterator();
        if(!iter.hasNext())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test -  should not have next");
            
        System.out.println("Checking a tree with one node");                
        BinaryTree<String> b1 = new BinaryTree<String>("1");
        iter = b1.getPostorderIterator();
        if(iter.hasNext())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test -  should have next");
        String s = (String) iter.next();
        if(s.equals("1"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been 1");
        if(!iter.hasNext())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test -  should not have next");        
        
        testLarge1();
        testLarge2();

        
   
 
        System.out.println();
    }


    public static void testLarge1()
    {        
    
        int value;
        
            
        System.out.println("Checking for a larger tree (case 1)");                
        BinaryTree<String> b0 = new BinaryTree<String>();
        BinaryTree<String> b1 = new BinaryTree<String>("1");
        BinaryTree<String> b2 = new BinaryTree<String>("2", b1, b0);
        BinaryTree<String> b3 = new BinaryTree<String>("3", b2, b0);
              
        b1 = new BinaryTree<String>("1");
        b2 = new BinaryTree<String>("2", b1, b1);
    
        BinaryTree<String> b4 = new BinaryTree<String>("4", b3, b3);
        BinaryTree<String> b5 = new BinaryTree<String>("5");
        BinaryTree<String> b6 = new BinaryTree<String>("6");
        BinaryTree<String> b7 = new BinaryTree<String>("7", b5, b6);

        BinaryTree<String> b8 = new BinaryTree<String>("8", b7, b4);

        Iterator<String> iter = b8.getPostorderIterator();
        if(iter.hasNext())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test -  should have next");
            
        String s = (String) iter.next();
        if(s.equals("5"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been 5");

        s = (String) iter.next();
        if(s.equals("6"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been 6"); 
 
        s = (String) iter.next();
        if(s.equals("7"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been 7");
            
        s = (String) iter.next();
        if(s.equals("1"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been 1");
            
            
        s = (String) iter.next();
        if(s.equals("2"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been 2");
            
        s = (String) iter.next();
        if(s.equals("3"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been 3");

        s = (String) iter.next();
        if(s.equals("1"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been 1");


        s = (String) iter.next();
        if(s.equals("2"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been 2");  
            
        s = (String) iter.next();
        if(s.equals("3"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been 3");
            
        s = (String) iter.next();
        if(s.equals("4"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been 4");

        s = (String) iter.next();
        if(s.equals("8"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been 8");
            
            
            
        if(!iter.hasNext())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test -  should not have next");        

        
   
 
        System.out.println();
    }


   public static void testLarge2()
    {        
    
        int value;
        
            
        System.out.println("Checking for a larger tree (case 2)");                
        BinaryTree<String> b1 = new BinaryTree<String>("1");
        BinaryTree<String> b2 = new BinaryTree<String>("2", b1, null);
        BinaryTree<String> b3 = new BinaryTree<String>("3", null, b2);    
        BinaryTree<String> b4 = new BinaryTree<String>("4");
        BinaryTree<String> b5 = new BinaryTree<String>("5", b3, b4);
        BinaryTree<String> b6 = new BinaryTree<String>("6", null, b5);
        BinaryTree<String> b7 = new BinaryTree<String>("7", b6, null);
        BinaryTree<String> b8 = new BinaryTree<String>("8");
        BinaryTree<String> b9 = new BinaryTree<String>("9", b8, null);
        BinaryTree<String> b10 = new BinaryTree<String>("10", null, b9);
        BinaryTree<String> b11 = new BinaryTree<String>("11", b7, b10);

        Iterator<String> iter = b11.getPostorderIterator();
        if(iter.hasNext())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test -  should have next");
            
        String s = (String) iter.next();
        if(s.equals("1"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been 1");

        s = (String) iter.next();
        if(s.equals("2"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been 2"); 
 
        s = (String) iter.next();
        if(s.equals("3"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been 3");
            
        s = (String) iter.next();
        if(s.equals("4"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been 4");
            
            
        s = (String) iter.next();
        if(s.equals("5"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been 5");
            
        s = (String) iter.next();
        if(s.equals("6"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been 6");

        s = (String) iter.next();
        if(s.equals("7"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been 7");


        s = (String) iter.next();
        if(s.equals("8"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been 8");  
            
        s = (String) iter.next();
        if(s.equals("9"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been 9");
            
        s = (String) iter.next();
        if(s.equals("10"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been 10");

        s = (String) iter.next();
        if(s.equals("11"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been 11");
            
            
            
        if(!iter.hasNext())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test -  should not have next");        

        
   
 
        System.out.println();
    }   
}
