import java.util.*;
import TreePackage.*;

/**
 * PreToPost will take an expression in prefix notation and convert it into postfix using
 * a binary tree.
 * 
 * @author Charles Hoot
 * @version 4.0
 */

    
public class PreToPost
{

    public static void main(String args[])
    {
        BinaryTree<String> expression = null;
        
        String toParse = getExpressionString();

        //ADD CODE HERE TO GET THE EXPRESSION TREE AND THEN ITERATE OVER
        //IT TO PRODUCE THE POST FIX EXPRESSION
        // In the main, create a new Scanner that will break up the string
        // that was read into tokens. Use next() to get the tokens as strings.
        Scanner input = new Scanner(toParse);
//        input.next();
        expression = getTree(input);

        Iterator<String> tokensIterator = expression.getPostorderIterator();
        while (tokensIterator.hasNext()) {
            System.out.println(tokensIterator.next());
        }
    }
        
        
    /**
     * Get the tree from the pre order expression tokens recursively
     *
     * @param expressionScanner a Scanner that holds the tokens in pre order
     * @return    a Binary tree hold the expression
     */
    private static BinaryTree<String> getTree(Scanner expressionScanner)
    {

        BinaryTree<String> result = null;
        
        // ADD CODE TO RECURSIVELY CONSTRUCT THE BINARY TREE FROM THE PREFIX
        // EXPRESSION HERE

        // check if number of token is 0.
        if (!expressionScanner.hasNext()) {
            throw new NumberFormatException();
        }
        String token = expressionScanner.next();

        if (isNumeric(token)) {
            result = new BinaryTree<>(token);
        }
        else if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
            BinaryTree<String> leftSubTree = getTree(expressionScanner);
            BinaryTree<String> rightSubTree = getTree(expressionScanner);
            result = new BinaryTree<String>(token, leftSubTree, rightSubTree);
        }
        else {
            throw new NumberFormatException();
        }
        return result;
    }

    // get this check code from StackOverflow:
    // https://stackoverflow.com/a/12569609
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
    
    /**
     * getExpressionString - Get the string with the expression.
     *
     * @return    A String from the keyboard.
     */
    private static String getExpressionString()
    {
        Scanner input;
        String inString = "";
        try
        {
            input = new Scanner(System.in);
            
            System.out.println("Please enter a prefix expression");
            inString = input.nextLine().trim();           
        }
        catch(Exception e)
        {
            System.out.println("There was an error with System.in");
            System.out.println(e.getMessage());
            System.out.println("Will use the expression + a b / c");
            inString = "+ a b / c";
        }
           
        return inString;
                                    
    }
    
}
