
/**
 * A class to test the recursive string replace.
 * 
 * @author Charles Hoot 
 * @version 4.0
 */
public class TestReplace
{

    public static void main(String args[])
    {
        testReplace();
    }
    
    public static void testReplace()
    {
        RecursiveStringReplace rs = new RecursiveStringReplace();
        String result;
        System.out.println("TESTING RECURSIVE STRING REPLACE");
        
        System.out.println("Testing with an empty string");
        result = rs.replace("", 'a', 'b');
        if(result.equals(""))
        {
            System.out.println("     Passed");
        }
        else
        {
            System.out.println("**** Fails " + result + " is not the empty string");
        }

        System.out.println("Testing a string of size one - no replacement");
        result = rs.replace("c", 'a', 'b');
        if(result.equals("c"))
        {
            System.out.println("     Passed");
        }
        else
        {
            System.out.println("**** Fails " + result + " is not c");
        }        


        System.out.println("Testing a string of size one -  replacement");
        result = rs.replace("a", 'a', 'b');
        if(result.equals("b"))
        {
            System.out.println("     Passed");
        }
        else
        {
            System.out.println("**** Fails " + result + " is not b");
        }        

        System.out.println("Testing a string with no replacement");
        result = rs.replace("ABC cdefgh", 'a', 'b');
        if(result.equals("ABC cdefgh"))
        {
            System.out.println("     Passed");
        }
        else
        {
            System.out.println("**** Fails " + result + " is not the string ABC cdefgh");
        }        

        System.out.println("Testing a string with replacement");
        result = rs.replace("ABC bcadefgah", 'a', 'b');
        if(result.equals("ABC bcbdefgbh"))
        {
            System.out.println("     Passed");
        }
        else
        {
            System.out.println("**** Fails " + result + " is not the string ABC bcbdefgbh");
        }        


        System.out.println("Testing a string with replacement");
        result = rs.replace("dddddddddd", 'd', 'a');
        if(result.equals("aaaaaaaaaa"))
        {
            System.out.println("     Passed");
        }
        else
        {
            System.out.println("**** Fails " + result + " is not the string aaaaaaaaaa");
        }        

    }
}
  
