import TreePackage.*;
import java.util.*;

/**
 * This is a test class for the Binary Search tree 
 * in the TreePackage.
 * 
 * @author Charles Hoot
 * @version 4.0
 */

    
public class TestBST
{
    
    public static void main(String args[])
    {        
        testGetRootData();
        testAdd();
        testInorderIterator();
        testIsEmpty();
        testClear();
        testGetHeight();
        testGetNumberOfNodes();
        testGetEntry();
        testRemove();
    }
    
    
    
    public static void testGetRootData()
    {        
    
        System.out.println("TESTING TREE CONSTRUCTOR AND getRootData METHOD");            

        System.out.println("Checking to see an empty tree has null for root data");
        BinarySearchTree<String> b1 = new BinarySearchTree<String>();
        
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

        BinaryTree b2 = new BinarySearchTree<String>("XXX");
        
        if(b2.getRootData().equals("XXX"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - root data not equal to XXX");
        System.out.println();
    }


    public static void testAdd()
    {        
    
        System.out.println("TESTING BST add METHOD");            

        System.out.println("Add a single value to the BST");
        BinarySearchTree<String> b1 = new BinarySearchTree<String>();
        
        String comp = "h";
        b1.add(comp);
        
        if(b1.getRootData()!= null)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - root data is null");
        String data = (String) b1.getRootData();
        if(comp.equals(data))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + data + " for root not " + comp);
        
        System.out.println("Add another value to the BST");
        b1.add("a");
        
        if(b1.getRootData()!= null)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - root data is null");
        data = (String) b1.getRootData();
        if(comp.equals(data))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - root changed; got " + data + " for root not " + comp);
        
       
                   

        System.out.println();
    }
    
    
    public static void testInorderIterator()
    {        
    
        int value;
        
        System.out.println("TESTING THE inorder Iterator");
            
        System.out.println("Checking for an empty tree");                
        BinarySearchTree<String> b0 = new BinarySearchTree<String>();
        Iterator iter = b0.getInorderIterator();
        if(!iter.hasNext())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test -  should not have next");
            
        System.out.println("Checking a tree with one node");                
        BinarySearchTree<String> b1 = new BinarySearchTree<String>("1");
        iter = b1.getInorderIterator();
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
        
        
        System.out.println("Checking a larger tree");                
        
                                   
        BinarySearchTree<String> b2 = new BinarySearchTree<String>();
        b2.add("f");
        b2.add("e");
        b2.add("h");
        b2.add("a");
        b2.add("g");
        b2.add("j");
        b2.add("d");
        b2.add("i");
        b2.add("k");
        b2.add("c");
        b2.add("b");
          

        iter = b2.getInorderIterator();
        if(iter.hasNext())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test -  should have next");
            
        s = (String) iter.next();
        if(s.equals("a"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been a");

        s = (String) iter.next();
        if(s.equals("b"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been b"); 
 
        s = (String) iter.next();
        if(s.equals("c"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been c");
            
        s = (String) iter.next();
        if(s.equals("d"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been d");
            
            
        s = (String) iter.next();
        if(s.equals("e"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been e");
            
        s = (String) iter.next();
        if(s.equals("f"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been f");

        s = (String) iter.next();
        if(s.equals("g"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been g");


        s = (String) iter.next();
        if(s.equals("h"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been h");  
            
        s = (String) iter.next();
        if(s.equals("i"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been i");
            
        s = (String) iter.next();
        if(s.equals("j"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been j");

        s = (String) iter.next();
        if(s.equals("k"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been k");
            
            
            
        if(!iter.hasNext())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test -  should not have next");        
        
        

 
        System.out.println();
    }
    
    public static void testIsEmpty()
    {        
    
        System.out.println("TESTING BST THE isEmpty METHOD");
            
            
        System.out.println("Checking to an empty tree");
        BinarySearchTree<String> b1 = new BinarySearchTree<String>();
         
        if(b1.isEmpty())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - tree was not empty");
        
       
       
            
        System.out.println("Checking a tree with one element");
        BinarySearchTree<String> b2 = new BinarySearchTree<String>("XXX");
        
        if(!b2.isEmpty())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - tree should not have been empty");


            
        System.out.println("Checking a larger tree");
        BinarySearchTree<String> b3 = new BinarySearchTree<String>();
        b3.add("a");
        b3.add("c");
        if(!b3.isEmpty())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - tree should not have been empty");
            
            
        System.out.println();
    }



    public static void testClear()
    {        
    
        System.out.println("TESTING BST THE clear METHOD");
            
        BinarySearchTree<String> b1 = new BinarySearchTree<String>();
        b1.add("a");
        b1.add("b");
        b1.add("a");
       
        b1.clear();
        
        if(b1.isEmpty())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - b1 should be empty");
            

        System.out.println();
    }
    
    
    
    public static void testGetHeight()
    {        
        int value;
        
        System.out.println("TESTING BST THE getHeight METHOD");
            
            
        System.out.println("Checking height of an empty tree");                
        BinarySearchTree<String> b0 = new BinarySearchTree<String>();
        value = b0.getHeight();
        if(value == 0)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + value + "; height should be 0");
            
        System.out.println("Checking height of a tree with a single node");                
        BinarySearchTree<String> b1 = new BinarySearchTree<String>("1");
        value = b1.getHeight();
        if(value == 1)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + value + "; height should be 1");
       
        System.out.println("Checking height of a tree with two nodes");                
        BinarySearchTree<String> b2 = new BinarySearchTree<String>("a");
        b2.add("b");
        value = b2.getHeight();
        if(value == 2)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + value + "; height should be 2");
        

        System.out.println("Checking height of a tree with three nodes (linear)");                
        BinarySearchTree<String> b3 = new BinarySearchTree<String>("c");
        b3.add("a");
        b3.add("b");
        
        value = b3.getHeight();
        if(value == 3)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + value + "; height should be 3");
        
        System.out.println("Checking height of a tree with three nodes (balanced)");                
        b3 = new BinarySearchTree<String>();
        b3.add("b");
        b3.add("c");
        b3.add("a");

        value = b3.getHeight();
        if(value == 2)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + value + "; height should be 2");

        System.out.println("Checking height of a tree b4");
               
        BinarySearchTree<String> b4 = new BinarySearchTree<String>();
        b4.add("f");
        b4.add("e");
        b4.add("h");
        b4.add("a");
        b4.add("g");
        b4.add("d");

        value = b4.getHeight();
        if(value == 4)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + value + "; height should be 4");
 
 
        System.out.println("Checking height of a larger tree");                
        b4.add("j");
        b4.add("i");
        b4.add("k");
        b4.add("c");
        b4.add("b");
 
        value = b4.getHeight();        
        if(value == 6)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + value + "; height should be 6"); 
            
            
            
        System.out.println("Checking height of a tree with duplicated nodes");                
        b4.clear();
        b4.add("i");
        b4.add("i");
        b4.add("i");
 
        value = b4.getHeight();        
        if(value == 1)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + value + "; height should be 1");           
 
 

        System.out.println();
    }





    public static void testGetNumberOfNodes()
    {        
        int value;
        
        System.out.println("TESTING BST THE getNumberOfNodes METHOD");
            
            
        System.out.println("Checking # nodes in an empty tree");                
        BinarySearchTree<String> b0 = new BinarySearchTree<String>();
        value = b0.getNumberOfNodes();
        if(value == 0)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + value + "; # nodes should be 0");
            
        System.out.println("Checking # nodes of a tree with a single node");                
        BinarySearchTree<String> b1 = new BinarySearchTree<String>("1");
        value = b1.getNumberOfNodes();
        if(value == 1)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + value + "; # nodes should be 1");
       
        System.out.println("Checking # nodes of a tree with two nodes");                
        BinarySearchTree<String> b2 = new BinarySearchTree<String>("a");
        b2.add("b");
        value = b2.getNumberOfNodes();
        if(value == 2)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + value + "; # nodes should be 2");
        

        System.out.println("Checking # nodes of a tree with three nodes (linear)");                
        BinarySearchTree<String> b3 = new BinarySearchTree<String>("c");
        b3.add("a");
        b3.add("b");
        
        value = b3.getNumberOfNodes();
        if(value == 3)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + value + "; # nodes should be 3");
        
        System.out.println("Checking # nodes of a tree with three nodes (balanced)");                
        b3 = new BinarySearchTree<String>();
        b3.add("b");
        b3.add("c");
        b3.add("a");

        value = b3.getNumberOfNodes();
        if(value == 3)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + value + "; # nodes should be 3");

        System.out.println("Checking # nodes of a tree b4");
               
        BinarySearchTree<String> b4 = new BinarySearchTree<String>();
        b4.add("f");
        b4.add("e");
        b4.add("h");
        b4.add("a");
        b4.add("g");
        b4.add("d");

        value = b4.getNumberOfNodes();
        if(value == 6)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + value + "; # nodes should be 6");

 
 
        System.out.println("Checking # nodes of a larger tree");                
        b4.add("j");
        b4.add("i");
        b4.add("k");
        b4.add("c");
        b4.add("b");
 
        value = b4.getNumberOfNodes();        
        if(value == 11)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + value + "; # nodes should be 11");

        System.out.println("Checking # nodes of a tree with duplicate value");                
        b4.clear();
        b4.add("i");
        b4.add("i");
        b4.add("i");

        value = b4.getNumberOfNodes();        
        if(value == 1)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + value + "; # nodes should be 1");
 

        System.out.println();
    }




    public static void testGetEntry()
    {        
        String value;
        String comp;
        
        System.out.println("TESTING BST THE getEntry METHOD");
            
            
        System.out.println("Checking getEntry of an empty tree");                
        BinarySearchTree<String> b0 = new BinarySearchTree<String>();
        comp = "c";
        value = (String) b0.getEntry(comp);
        if(value == null)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + value + "; should be null");
            
        System.out.println("Checking getEntry of a tree with a single node");                
        BinarySearchTree<String> b1 = new BinarySearchTree<String>(comp);
        value = (String) b1.getEntry(comp);
        if(comp.equals(value) )
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + value + "; should be " + comp);

        comp = "d";
        value = (String) b0.getEntry(comp);
        if(value == null )
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + value + "; should be null");
       
        



        System.out.println("Checking getentry of another tree");
               
        BinarySearchTree<String> b4 = new BinarySearchTree<String>();
        b4.add("f");
        b4.add("e");
        b4.add("h");
        b4.add("b");
        b4.add("g");

        System.out.println("looking for values that should be in the tree");

        comp="g";
        value = (String) b4.getEntry(comp);
        if(comp.equals(value) )
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + value + "; should be " + comp);

        comp="b";
        value = (String) b4.getEntry(comp);
        if(comp.equals(value) )
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + value + "; should be " + comp);

        comp="h";
        value = (String) b4.getEntry(comp);
        if(comp.equals(value) )
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + value + "; should be " + comp);

        comp="e";
        value = (String) b4.getEntry(comp);
        if(comp.equals(value) )
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + value + "; should be " + comp);

        comp="f";
        value = (String) b4.getEntry(comp);
        if(comp.equals(value) )
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + value + "; should be " + comp);
 
        System.out.println("looking for values that should not be in the tree");

        comp="a";
        value = (String) b4.getEntry(comp);
        if(value == null )
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + value + "; should be null");
 
        comp="c";
        value = (String) b4.getEntry(comp);
        if(value == null )
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + value + "; should be null");


        comp="d";
        value = (String) b4.getEntry(comp);
        if(value == null )
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + value + "; should be null");


        comp="i";
        value = (String) b4.getEntry(comp);
        if(value == null )
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + value + "; should be null");


        comp="k";
        value = (String) b4.getEntry(comp);
        if(value == null )
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + value + "; should be null");


        System.out.println();
    }
    
    
    
    

    public static void testRemove()
    {

        String s;
        String comp;
        
        System.out.println("TESTING BST THE remove METHOD");
            
        System.out.println("Checking remove on a tree with one value");                
        BinarySearchTree<String> b0 = new BinarySearchTree<String>("d");
        
        comp = "c";
        b0.remove(comp);
        if(!b0.isEmpty() )
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got tree should not be empty");
            
        comp = "d";
        b0.remove(comp);
        if(b0.isEmpty() )
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got tree should be empty");

        System.out.println("Checking a larger tree");                
        
                                   
        BinarySearchTree<String> b2 = new BinarySearchTree<String>();
        b2.add("f");
        b2.add("e");
        b2.add("h");
        b2.add("a");
        b2.add("g");
        b2.add("j");
        b2.add("d");
        b2.add("i");
        b2.add("k");
        b2.add("c");
        b2.add("b");
        
        b2.remove("a");
        b2.remove("c");
        b2.remove("g");
        b2.remove("k");
        b2.remove("f");
          

        Iterator<String> iter = b2.getInorderIterator();
        if(iter.hasNext())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test -  should have next");
            
        comp="b";
        s = (String) iter.next();
        if(comp.equals(s))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been " + comp);
            
            
        comp="d";
        s = (String) iter.next();
        if(comp.equals(s))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been " + comp);
            
            
        comp="e";
        s = (String) iter.next();
        if(comp.equals(s))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been " + comp);
            
            
        comp="h";
        s = (String) iter.next();
        if(comp.equals(s))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been " + comp);
            
            
        comp="i";
        s = (String) iter.next();
        if(comp.equals(s))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been " + comp);
        
        
        comp="j";
        s = (String) iter.next();
        if(comp.equals(s))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been " + comp);
            
            
            
        if(!iter.hasNext())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test -  should not have next");        
        System.out.println();


        System.out.println("Checking another larger tree");                
        
                                   
        b2 = new BinarySearchTree<String>();
        b2.add("m");
        b2.add("c");
        b2.add("b");
        b2.add("o");
        b2.add("a");
        b2.add("n");
        b2.add("g");
        b2.add("f");
        b2.add("p");
        b2.add("k");
        b2.add("j");
        b2.add("e");
        b2.add("h");
        b2.add("d");
        b2.add("i");
        b2.add("l");
        
        b2.remove("a");
        b2.remove("c");
        b2.remove("g");
        b2.remove("k");
        b2.remove("m");
        
        System.out.println("Added and removed some values");                
          

        iter = b2.getInorderIterator();
        if(iter.hasNext())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test -  should have next");
            
        comp="b";
        s =  iter.next();
        if(comp.equals(s))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been " + comp);
            
            
        comp="d";
        s =  iter.next();
        if(comp.equals(s))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been " + comp);
            
            
        comp="e";
        s =  iter.next();
        if(comp.equals(s))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been " + comp);
            
            
        comp="f";
        s =  iter.next();
        if(comp.equals(s))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been " + comp);
            
        comp="h";
        s =  iter.next();
        if(comp.equals(s))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been " + comp);
            
            
        comp="i";
        s =  iter.next();
        if(comp.equals(s))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been " + comp);
        
        
        comp="j";
        s =  iter.next();
        if(comp.equals(s))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been " + comp);
            
        
        comp="l";
        s =  iter.next();
        if(comp.equals(s))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been " + comp);
            
        comp="n";
        s =  iter.next();
        if(comp.equals(s))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been " + comp);
            
        comp="o";
        s =  iter.next();
        if(comp.equals(s))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been " + comp);
 
        comp="p";
        s =  iter.next();
        if(comp.equals(s))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been " + comp);
            

            
            
        if(!iter.hasNext())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test -  should not have next");        
        System.out.println();
        
        
        b2.remove("n");
        b2.remove("b");
        b2.remove("f");
        
        b2.add("a");
        b2.add("c");
        b2.add("g");
        System.out.println("Added and removed some more values");                
          

        iter = b2.getInorderIterator();
        if(iter.hasNext())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test -  should have next");
            
        comp="a";
        s =  iter.next();
        if(comp.equals(s))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been " + comp);
            
            
        comp="c";
        s =  iter.next();
        if(comp.equals(s))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been " + comp);
            
            
        comp="d";
        s =  iter.next();
        if(comp.equals(s))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been " + comp);
            
        comp="e";
        s =  iter.next();
        if(comp.equals(s))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been " + comp);
            
            
        comp="g";
        s =  iter.next();
        if(comp.equals(s))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been " + comp);
        
        
        comp="h";
        s =  iter.next();
        if(comp.equals(s))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been " + comp);
            
        
        comp="i";
        s =  iter.next();
        if(comp.equals(s))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been " + comp);
            
        comp="j";
        s =  iter.next();
        if(comp.equals(s))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been " + comp);
            
        comp="l";
        s =  iter.next();
        if(comp.equals(s))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been " + comp);
 
        comp="o";
        s = (String) iter.next();
        if(comp.equals(s))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been " + comp);
            
            
        comp="p";
        s =  iter.next();
        if(comp.equals(s))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + s + " should have been " + comp);
            
            
            
        if(!iter.hasNext())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test -  should not have next");        
        System.out.println();
        System.out.println("Showing values");                
        iter = b2.getInorderIterator();
        while(iter.hasNext())
            System.out.print(iter.next() + " ");
        System.out.println();

        
        }


}
