import TreePackage.*;
import java.util.*;
 
/**
 * This is a test class for the Tree/Binary Search tree classes
 * in the TreePackage
 * 
 * @author Charles Hoot
 * @version 4.0
 */

   
public class TestBasicAccess
{
    
    public static void main(String args[])
    {        
        testGetCurrentData();
        testCanAdvance();
        testAdvance();
        testResetAccess();
    }

    public static void testGetCurrentData()
    {        
    
        System.out.println("TESTING  testGetCurrentData METHOD");            

        System.out.println("Checking an empty tree");
        BinaryTree<String> b1 = new BinaryTree<String>();
        
        if(b1.getCurrentData()==null)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - root data not null");
        
       
                   
        System.out.println("Checking a tree with one element");

        BinaryTree<String> b2 = new BinaryTree<String>("XXX");
        
        if(b2.getCurrentData().equals("XXX"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - root data not equal to XXX");


        System.out.println("Checking a tree composed from two other trees");
        BinaryTree<String> b3 = new BinaryTree<String>("ZZZ");
        BinaryTree<String> b4 = new BinaryTree<String>("YYY", b2, b3);
            
        
        if(b4.getCurrentData().equals("YYY"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - root data not equal to YYY");
        
        if(b2.getCurrentData()== null)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - tree b2 was not cleared in composition");
        
        if(b3.getCurrentData()== null)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - tree b3 was not cleared in composition");

        System.out.println();
    }
    
    
    public static void testCanAdvance()
    {        
    
        System.out.println("TESTING THE canAdvance METHODS");
            
            
        System.out.println("Checking to an empty tree");
        BinaryTree<String> b1 = new BinaryTree<String>();
         
        if(!b1.canAdvanceToLeft())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - should not be able to advance left");
        
         if(!b1.canAdvanceToRight())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - should not be able to advance right");


        System.out.println("Checking a one node tree");
        BinaryTree<String> b2 = new BinaryTree<String>("XXX");
         
        if(!b2.canAdvanceToLeft())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - should not be able to advance left");
        
         if(!b2.canAdvanceToRight())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - should not be able to advance right");       
            

            
        System.out.println("Checking a tree composed from two other trees");
        BinaryTree<String> b3 = new BinaryTree<String>("YYY", b2, b2);
        if(b3.canAdvanceToLeft())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - should  be able to advance left");
        
         if(b3.canAdvanceToRight())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - should be able to advance right");       


 
           
            
        System.out.println();
    }
    
    
    public static void testAdvance()
    {        
    
        System.out.println("TESTING THE advance METHODS");
            
        BinaryTree<String> b1 = new BinaryTree<String>("X");
        BinaryTree<String> b2 = new BinaryTree<String>("Y");
     
            

            
        System.out.println("Checking a tree composed from two other trees");
        BinaryTree<String> b3 = new BinaryTree<String>("Z", b1, b2);
        b3.advanceToLeft();
        String data = (String) b3.getCurrentData();
        if(data.equals("X"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + data + "  should have been X");
        
        if(!b3.canAdvanceToLeft())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - should not be able to advance left");       

        if(!b3.canAdvanceToRight())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - should not be able to advance right");       

        b3.advanceToLeft();
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
        data = (String) b3.getCurrentData();
        if(data.equals("Y"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + data + "  should have been X");
        
        if(!b3.canAdvanceToLeft())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - should not be able to advance left");       

        if(!b3.canAdvanceToRight())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - should not be able to advance right");       

        b3.advanceToRight();
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
        data = (String) b8.getCurrentData();
        if(data.equals("4"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + data +"  should have been 4");
        
        if(b8.canAdvanceToLeft())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - should  be able to advance left");       

        if(b8.canAdvanceToRight())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - should  be able to advance right");       


        b8.advanceToLeft();
        data = (String) b8.getCurrentData();
        if(data.equals("3"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + data +"  should have been 3");
        
        if(b8.canAdvanceToLeft())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - should be able to advance left");       

        if(!b8.canAdvanceToRight())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - should not be able to advance right");
            
            
        b8.advanceToLeft();
        data = (String) b8.getCurrentData();
        if(data.equals("2"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + data+ "  should have been 2");
        
        if(b8.canAdvanceToLeft())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - should be able to advance left");       

        if(!b8.canAdvanceToRight())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - should not be able to advance right");


        b8.advanceToLeft();
        data = (String) b8.getCurrentData();
        if(data.equals("1"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + data + "  should have been 1");
        
        if(!b8.canAdvanceToLeft())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - should not be able to advance left");       

        if(!b8.canAdvanceToRight())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - should not be able to advance right");
 
 
        System.out.println();
    }
    
    public static void testResetAccess()
    {        
        int value;
        
        System.out.println("TESTING THE reset METHOD");
            
            
        System.out.println("Checking for a larger tree");
        
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
        
        System.out.println("Going down the tree");
        b8.advanceToRight();
        String data = (String) b8.getCurrentData();
        if(data.equals("4"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + data +"  should have been 4");
        
        if(b8.canAdvanceToLeft())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - should  be able to advance left");       

        if(b8.canAdvanceToRight())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - should  be able to advance right");       


        b8.advanceToLeft();
        data = (String) b8.getCurrentData();
        if(data.equals("3"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + data +"  should have been 3");
        
        if(b8.canAdvanceToLeft())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - should be able to advance left");       

        if(!b8.canAdvanceToRight())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - should not be able to advance right");
            
            
        b8.advanceToLeft();
        data = (String) b8.getCurrentData();
        if(data.equals("2"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + data + "  should have been 2");
        
        if(b8.canAdvanceToLeft())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - should be able to advance left");       

        if(!b8.canAdvanceToRight())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - should not be able to advance right");


        b8.advanceToLeft();
        data = (String) b8.getCurrentData();
        if(data.equals("1"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + data+ "  should have been 1");
        
        if(!b8.canAdvanceToLeft())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - should not be able to advance left");       

        if(!b8.canAdvanceToRight())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - should not be able to advance right");


        System.out.println("Reset and go down a different path in the tree");
        b8.resetAccess();
        b8.advanceToLeft();
        data = (String) b8.getCurrentData();
        if(data.equals("7"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + data +"  should have been 7");
        
        if(b8.canAdvanceToLeft())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - should  be able to advance left");       

        if(b8.canAdvanceToRight())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - should  be able to advance right");       


        b8.advanceToRight();
        data = (String) b8.getCurrentData();
        if(data.equals("6"))
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - got " + data+ "  should have been 6");
        
        if(!b8.canAdvanceToLeft())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - should not be able to advance left");       

        if(!b8.canAdvanceToRight())
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test - should not be able to advance right");
            
            
         
 

        System.out.println();
    }




    
}
