import TreePackage.*;
import java.util.*;

/**
 * This is a test class for the Tree/Binary Search tree classes
 * in the TreePackage.
 * 
 * @author Charles Hoot
 * @version 4.0
 */

    
public class TestBinaryTree
{
    
    public static void main(String args[])
    {        
        testGetRootData();
        testIsEmpty();
        testClear();
        testGetHeight();
        testGetNumberOfNodes();
        testSetTree();
        testInorderIterator();
    }

    public static void testGetRootData()
    {        
    
        System.out.println("TESTING TREE CONSTRUCTOR AND getRootData METHOD");            

        System.out.println("Checking to see an empty tree throws an exception when attempting to get data");
        BinaryTree<String> b1 = new BinaryTree<String>();
        
        boolean exceptionThrown = true;
        
        try{
            b1.getRootData();
            exceptionThrown = false;
        } catch(EmptyTreeException x) {
            exceptionThrown = true;
        }
        if(exceptionThrown)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - did not get an exception.");
       
                   
        System.out.println("Checking a tree with one element");

        BinaryTree<String> b2 = new BinaryTree<String>("XXX");
        
        if(b2.getRootData().equals("XXX"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - root data not equal to XXX");


        System.out.println("Checking a tree composed from two other trees");
        BinaryTree<String> b3 = new BinaryTree<String>("ZZZ");
        BinaryTree<String> b4 = new BinaryTree<String>("YYY", b2, b3);
            
        
        if(b4.getRootData().equals("YYY"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - root data not equal to YYY");
        
        // Checking that both b2 and b3 are now empty trees      
        try{
            b2.getRootData();
            exceptionThrown = false;
        } catch(EmptyTreeException x) {
            exceptionThrown = true;
        }
        if(exceptionThrown)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - tree b2 was not cleared in composition");
        
        try{
            b3.getRootData();
            exceptionThrown = false;
        } catch(EmptyTreeException x) {
            exceptionThrown = true;
        }
        if(exceptionThrown)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - tree b3 was not cleared in composition");

        System.out.println("Checking a tree composed using same tree as subtree");
        BinaryTree<String> b5 = new BinaryTree<String>("ZZZ", b4, b4);
        
        if(b5.getRootData().equals("ZZZ"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - root data not equal to ZZZ");
        
        try{
            b4.getRootData();
            exceptionThrown = false;
        } catch(EmptyTreeException x) {
            exceptionThrown = true;
        }
        if(exceptionThrown)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - tree b4 was not cleared in composition");

        System.out.println();
    }
    
    
    public static void testIsEmpty()
    {        
    
        System.out.println("TESTING THE isEmpty METHOD");
            
            
        System.out.println("Checking to an empty tree");
        BinaryTree<String> b1 = new BinaryTree<String>();
         
        if(b1.isEmpty())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - tree was not empty");
        
       
       
            
        System.out.println("Checking a tree with one element");
        BinaryTree<String> b2 = new BinaryTree<String>("XXX");
        
        if(!b2.isEmpty())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - tree should not have been empty");


            
        System.out.println("Checking a tree composed from two other trees");
        BinaryTree<String> b3 = new BinaryTree<String>("YYY", b1, b2);
        if(!b3.isEmpty())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - tree should not have been empty");
        if(b2.isEmpty())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - tree b2 was not cleared in composition");
           
            
        System.out.println();
    }
    
    
    public static void testClear()
    {        
    
        System.out.println("TESTING THE clear METHOD");
            
        BinaryTree<String> b1 = new BinaryTree<String>();
        BinaryTree<String> b2 = new BinaryTree<String>("XXX");
        BinaryTree<String> b3 = new BinaryTree<String>("YYY", b1, b2);
            
        System.out.println("Created tree b3 from b1 and b2 ");
        
        b3.clear();
        
        if(b3.isEmpty())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - b3 should be empty");
            

        System.out.println();
    }
    
    public static void testGetHeight()
    {        
        int value;
        
        System.out.println("TESTING THE getHeight METHOD");
            
            
        System.out.println("Checking height of an empty tree");                
        BinaryTree<String> b0 = new BinaryTree<String>();
        value = b0.getHeight();
        if(value == 0)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + value + "; height should be 0");
            
        System.out.println("Checking height of a tree with a single node");                
        BinaryTree<String> b1 = new BinaryTree<String>("1");
        value = b1.getHeight();
        if(value == 1)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + value + "; height should be 1");
       
        System.out.println("Checking height of a tree with two nodes");                
        BinaryTree<String> b2 = new BinaryTree<String>("2", b1, b0);
        value = b2.getHeight();
        if(value == 2)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + value + "; height should be 2");
        
        value = b1.getHeight();
        if(value == 0)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + value + "; after compostion height of b1 should be 0");


        System.out.println("Checking height of a tree with three nodes (linear)");                
        BinaryTree<String> b3 = new BinaryTree<String>("3", b2, b0);
        value = b3.getHeight();
        if(value == 3)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + value + "; height should be 3");
        
        System.out.println("Checking height of a tree with three nodes (balanced)");                
        b1 = new BinaryTree<String>("1");
        b2 = new BinaryTree<String>("2", b1, b1);
        value = b2.getHeight();
        if(value == 2)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + value + "; height should be 2");

        System.out.println("Checking height of a tree b4");                
        BinaryTree<String> b4 = new BinaryTree<String>("4", b3, b3);
        value = b4.getHeight();
        if(value == 4)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + value + "; height should be 4");
 
 
        System.out.println("Checking height of a tree b7");                
        BinaryTree<String> b5 = new BinaryTree<String>("5");
        BinaryTree<String> b6 = new BinaryTree<String>("6");
        BinaryTree<String> b7 = new BinaryTree<String>("7", b5, b6);
        value = b7.getHeight();
        if(value == 2)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + value + "; height should be 2");


        System.out.println("Checking height of a tree b8");                
        BinaryTree<String> b8 = new BinaryTree<String>("8", b4, b7);
        value = b8.getHeight();
        if(value == 5)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + value + "; height should be 5");

            
 

        System.out.println();
    }


    public static void testGetNumberOfNodes()
    {        
        int value;
        System.out.println("TESTING THE getNumberOfNodes METHOD");
        
        System.out.println("Checking # nodes in an empty tree");                
        BinaryTree<String> b0 = new BinaryTree<String>();
        value = b0.getNumberOfNodes();
        if(value == 0)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + value + "; # nodes should be 0");
            
        System.out.println("Checking # nodes in a tree with a single node");                
        BinaryTree<String> b1 = new BinaryTree<String>("1");
        value = b1.getNumberOfNodes();
        if(value == 1)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + value + "; # nodes should be 1");
       
        System.out.println("Checking # nodes in a tree with two nodes");                
        BinaryTree<String> b2 = new BinaryTree<String>("2", b1, b0);
        value = b2.getNumberOfNodes();
        if(value == 2)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + value + "; # nodes should be 2");
        
        value = b1.getNumberOfNodes();
        if(value == 0)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + value + "; after compostion # nodes of b1 should be 0");


        System.out.println("Checking # nodes in a tree with three nodes (linear)");                
        BinaryTree<String> b3 = new BinaryTree<String>("3", b2, b0);
        value = b3.getNumberOfNodes();
        if(value == 3)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + value + "; # nodes should be 3");
        
        System.out.println("Checking # nodes in a tree with three nodes (balanced)");                
        b1 = new BinaryTree<String>("1");
        b2 = new BinaryTree<String>("2", b1, b1);
        value = b2.getNumberOfNodes();
        if(value == 3)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + value + "; # nodes should be 3");

        System.out.println("Checking # nodes in a tree b4");                
        BinaryTree<String> b4 = new BinaryTree<String>("4", b3, b3);
        value = b4.getNumberOfNodes();
        if(value == 7)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + value + "; # nodes should be 7");
 
 
        System.out.println("Checking # nodes in a tree b7");                
        BinaryTree<String> b5 = new BinaryTree<String>("5");
        BinaryTree<String> b6 = new BinaryTree<String>("6");
        BinaryTree<String> b7 = new BinaryTree<String>("7", b5, b6);
        value = b7.getNumberOfNodes();
        if(value == 3)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + value + "; # nodes should be 3");


        System.out.println("Checking # nodes in a tree b8");                
        BinaryTree<String> b8 = new BinaryTree<String>("8", b4, b7);
        value = b8.getNumberOfNodes();
        if(value == 11)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + value + "; # nodes should be 11");

            
 

        System.out.println();
    }



    public static void testSetTree()
    {        
    
        int value;
        
        System.out.println("TESTING THE setTree METHOD");
            
        BinaryTree<String> b0 = new BinaryTree<String>();
        BinaryTree<String> b1 = new BinaryTree<String>("1");
                            
        BinaryTree<String> b2 = new BinaryTree<String>("2", b1, b0);
          
        BinaryTree<String> b3 = new BinaryTree<String>("3", b2, b0);
        
        System.out.println("Checking setTree with just a data value");                
        b3.setTree("XXX");
        
        if(b3.getRootData().equals("XXX"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - root data not equal to XXX");


        value = b3.getNumberOfNodes();
        if(value == 1)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + value + "; # nodes should be 1");

        value = b3.getHeight();
        if(value == 1)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + value + "; height should be 1");

              
        b1 = new BinaryTree<String>("1");
        b2 = new BinaryTree<String>("2", b1, b1);
    
        BinaryTree<String> b4 = new BinaryTree<String>("4", b3, b3);
           
        BinaryTree<String> b5 = new BinaryTree<String>("5");
        BinaryTree<String> b6 = new BinaryTree<String>("6");
        BinaryTree<String> b7 = new BinaryTree<String>("7", b5, b6);

        BinaryTree<String> b8 = new BinaryTree<String>("8", b2, b2);

        System.out.println("Checking setTree with just a data value and two trees");                
        b8.setTree("XXX", b4, b7);
        
        if(b8.getRootData().equals("XXX"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - root data not equal to XXX");


        value = b8.getNumberOfNodes();
        if(value == 7)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + value + "; # nodes should be 7");

        value = b8.getHeight();
        if(value == 3)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + value + "; height should be 3");
        
 
        System.out.println();
    }




    public static void testInorderIterator()
    {        
    
        int value;
        
        System.out.println("TESTING THE inorder Iterator");
            
        System.out.println("Checking for an empty tree");                
        BinaryTree<String> b0 = new BinaryTree<String>();
        Iterator<String> iter = b0.getInorderIterator();
        if(!iter.hasNext())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test -  should not have next");
            
        System.out.println("Checking a tree with one node");                
        BinaryTree<String> b1 = new BinaryTree<String>("1");
        iter = b1.getInorderIterator();
        if(iter.hasNext())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test -  should have next");
        String s =  iter.next();
        if(s.equals("1"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been 1");
        if(!iter.hasNext())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test -  should not have next");        
        
                                   
        BinaryTree<String> b2 = new BinaryTree<String>("2", b1, b0);
          
        BinaryTree<String> b3 = new BinaryTree<String>("3", b2, b0);
        

              
        b1 = new BinaryTree<String>("1");
        b2 = new BinaryTree<String>("2", b1, b1);
    
        BinaryTree<String> b4 = new BinaryTree<String>("4", b3, b3);
           
        BinaryTree<String> b5 = new BinaryTree<String>("5");
        BinaryTree<String> b6 = new BinaryTree<String>("6");
        BinaryTree<String> b7 = new BinaryTree<String>("7", b5, b6);

        BinaryTree<String> b8 = new BinaryTree<String>("8", b7, b4);

        System.out.println("Checking a larger tree");                
        iter = b8.getInorderIterator();
        if(iter.hasNext())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test -  should have next");
            
        s =  iter.next();
        if(s.equals("5"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been 5");

        s =  iter.next();
        if(s.equals("7"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been 7"); 
 
        s =  iter.next();
        if(s.equals("6"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been 6");
            
        s =  iter.next();
        if(s.equals("8"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been 8");
            
            
        s =  iter.next();
        if(s.equals("1"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been 1");
            
        s =  iter.next();
        if(s.equals("2"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been 2");

        s =  iter.next();
        if(s.equals("3"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been 3");


        s =  iter.next();
        if(s.equals("4"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been 4");  
            
        s =  iter.next();
        if(s.equals("1"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been 1");
            
        s =  iter.next();
        if(s.equals("2"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been 2");

        s =  iter.next();
        if(s.equals("3"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been 3");
            
            
            
        if(!iter.hasNext())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test -  should not have next");        
        
        
        System.out.println("Showing values");                
        iter = b8.getInorderIterator();
        while(iter.hasNext())
            System.out.print(iter.next() + " ");
        System.out.println();

 
        System.out.println();
    }


    
}
