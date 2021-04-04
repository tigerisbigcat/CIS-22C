import TreePackage.*;
import java.util.*;

/**
 * This is a test class for the Tree/Binary Search tree classes
 * in the TreePackage
 * 
 * @author Charles Hoot
 * @version 4.0
 */

    
public class TestParentAccess
{
    
    public static void main(String args[])
    {        
        testCanGoBackToParent();
        testGoBackToParent();
    }

    public static void testCanGoBackToParent()
    {        
    
        System.out.println("TESTING THE canGoBackToParent METHOD");
            
            
        System.out.println("Checking  an empty tree");
        BinaryTree<String> b1 = new BinaryTree<String>();
         
        if(!b1.canGoBackToParent())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - should not be able to go back to parent");

        System.out.println("Checking a one node tree");
        BinaryTree<String> b2 = new BinaryTree<String>("XXX");
         
        if(!b2.canGoBackToParent())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - should not be able to go back to parent");
        


            
        System.out.println("Checking a tree composed from two other trees");
        BinaryTree<String> b3 = new BinaryTree<String>("YYY", b2, b2);
        if(!b3.canGoBackToParent())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - should not be able to go back to parent of root node.");
        
        b3.advanceToRight();
        if(b3.canGoBackToParent())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - should  be able to go back to parent of right child");

        b3.advanceToRight();
        if(!b3.canGoBackToParent())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - current should be null and should not be able to go back to a parent");


        System.out.println("Checking another tree composed from two other trees");
        b2 = new BinaryTree<String>("XXX");
        b3 = new BinaryTree<String>("YYY", b2, b2);
        if(!b3.canGoBackToParent())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - should not be able to go back to parent of root");
        
        b3.advanceToLeft();
        if(b3.canGoBackToParent())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - should  be able to go back to parent of left child.");

        b3.advanceToLeft();
        if(!b3.canGoBackToParent())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - current should be null and should not  be able to go back to a parent");

          
            
        System.out.println();
    }
    
    
    public static void testGoBackToParent()
    {        
    
        System.out.println("TESTING THE goBackToParent METHODS");
            
        BinaryTree<String> b1 = new BinaryTree<String>("X");
        BinaryTree<String> b2 = new BinaryTree<String>("Y");
     
            

            
        System.out.println("Checking a tree composed from two other trees");
        BinaryTree<String> b3 = new BinaryTree<String>("Z", b1, b2);
        b3.advanceToLeft();
        b3.goBackToParent();
        String data = (String) b3.getCurrentData();
        if(data.equals("Z"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + data + "  should have been Z. (Went down left, then back)");
        
        if(b3.canAdvanceToLeft())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - should be able to advance left");       

        if(b3.canAdvanceToRight())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - should  be able to advance right");       

        
        b3.goBackToParent();
        data = (String) b3.getCurrentData();
        if(data==null)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + data + "  should have been null");

        b3.advanceToRight();
        data = (String) b3.getCurrentData();
        if(data==null)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + data + "  should have been null");
        
        
        
        b1 = new BinaryTree<String>("X");
        b2 = new BinaryTree<String>("Y");
 
        System.out.println("Checking another tree composed from two other trees");
        b3 = new BinaryTree<String>("Z", b1, b2);
        b3.advanceToRight();
        b3.goBackToParent();
        data = (String) b3.getCurrentData();
        if(data.equals("Z"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + data + "  should have been Z");
        
        if(b3.canAdvanceToLeft())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - should be able to advance left");       

        if(b3.canAdvanceToRight())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - should  be able to advance right");       

        b3.goBackToParent();
        data = (String) b3.getCurrentData();
        if(data==null)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + data + "  should have been null");

        b3.advanceToLeft();
        data = (String) b3.getCurrentData();
        if(data==null)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + data + "  should have been null");
   
            
            
        System.out.println("Checking for a larger tree");                
        BinaryTree<String> b0 = new BinaryTree<String>();
                        
        b1 = new BinaryTree<String>("1");
     
        
                                   
        b2 = new BinaryTree<String>("2", b1, b0);
          
        b3 = new BinaryTree<String>("3", b2, b0);
        

              
        b1 = new BinaryTree<String>("1");
        b2 = new BinaryTree<String>("2", b1, b1);
    
        BinaryTree<String> b4 = new BinaryTree<String>("4", b3, b3);
           
        BinaryTree<String> b5 = new BinaryTree<String>("5");
        BinaryTree<String> b6 = new BinaryTree<String>("6");
        BinaryTree<String> b7 = new BinaryTree<String>("7", b5, b6);

        BinaryTree<String> b8 = new BinaryTree<String>("8", b7, b4);

        b8.advanceToRight();
        b8.advanceToRight();
        b8.advanceToLeft();
        b8.advanceToLeft();
        data = (String) b8.getCurrentData();
        if(data.equals("1"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + data +"  should have been 1");
        
        if(b8.canGoBackToParent())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - should  be able to go back");       

        b8.goBackToParent();
        data = (String) b8.getCurrentData();
        if(data.equals("2"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + data +"  should have been 2");
        
        if(b8.canGoBackToParent())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - should  be able to go back");       
            
            
        b8.goBackToParent();
        data = (String) b8.getCurrentData();
        if(data.equals("3"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + data+ "  should have been 3");
        
        if(b8.canGoBackToParent())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - should  be able to go back");       


        b8.goBackToParent();
        data = (String) b8.getCurrentData();
        if(data.equals("4"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + data + "  should have been 4");
        
        if(b8.canGoBackToParent())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - should  be able to go back");       


        b8.goBackToParent();
        data = (String) b8.getCurrentData();
        if(data.equals("8"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + data + "  should have been 8");
        
        if(!b8.canGoBackToParent())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - should not be able to go back");       


        System.out.println("Trying a new path from the root");                
        b8.advanceToLeft();
        b8.advanceToRight();
        
       data = (String) b8.getCurrentData();
        if(data.equals("6"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + data +"  should have been 6");
        
        if(b8.canGoBackToParent())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - should  be able to go back");       

        b8.goBackToParent();
        data = (String) b8.getCurrentData();
        if(data.equals("7"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + data +"  should have been 7");
        
        if(b8.canGoBackToParent())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - should  be able to go back");       
            
            
        b8.goBackToParent();
        data = (String) b8.getCurrentData();
        if(data.equals("8"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + data+ "  should have been 8");
        
        if(!b8.canGoBackToParent())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - should not be able to go back");       


            
        System.out.println("Running up and down all pointers, should end up back at the root node");                
        b8.resetAccess();
        b8.advanceToLeft(); b8.advanceToLeft();
        b8.goBackToParent();
        b8.advanceToRight();
        b8.goBackToParent(); b8.goBackToParent();
        b8.advanceToRight(); b8.advanceToLeft(); b8.advanceToLeft(); b8.advanceToLeft();
        b8.goBackToParent(); b8.goBackToParent(); b8.goBackToParent();
        b8.advanceToRight(); b8.advanceToLeft(); b8.advanceToLeft();
        b8.goBackToParent(); b8.goBackToParent(); b8.goBackToParent(); b8.goBackToParent();
        
        // go to each leaf and back to the root
        b8.advanceToLeft(); b8.advanceToLeft();
        b8.goBackToParent(); b8.goBackToParent();
        b8.advanceToLeft(); b8.advanceToRight();
        b8.goBackToParent(); b8.goBackToParent();
        b8.advanceToRight(); b8.advanceToLeft(); b8.advanceToLeft(); b8.advanceToLeft();
        b8.goBackToParent(); b8.goBackToParent(); b8.goBackToParent(); b8.goBackToParent();
        b8.advanceToRight(); b8.advanceToRight(); b8.advanceToLeft(); b8.advanceToLeft();
        b8.goBackToParent(); b8.goBackToParent(); b8.goBackToParent(); b8.goBackToParent();
        
        data = (String) b8.getCurrentData();
        if(data.equals("8"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + data+ "  should have been 8");
        
        if(!b8.canGoBackToParent())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - should not be able to go back");   
         System.out.println();
    }



    
}
