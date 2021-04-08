package TreePackage;


/**
 * This interface is similar to the DecisionTreeInterface from Chapter 23
 * and allows a client to move down from the root in a binary tree.
 * 
 * @author Charles Hoot
 * @version 4.0
 */

public interface BinaryTreeAccessInterface<T> extends BinaryTreeInterface<T>
{
    /** Gets the data in the current node.
    * @return The data object in the current node.  
    * If there is no current node, return null.
    * */
    public T getCurrentData();
        
    /** Determines if the current node has a left child.
     * @return True if the left child is non-null.
     * If there is no current node, return null.
     * */
    public boolean canAdvanceToLeft();

    /** Sets the current node to the left child of
    * the current node. 
    * If there is no left node, make the current null.
    * */
    public void advanceToLeft();

    /** Determines if the current node has a right child. 
     * @return True if the right child is non-null.
     * */
    public boolean canAdvanceToRight(); 
    
    /** Sets the current node to the right child of
    * the current node. 
    * If there is no right node, make the current null.
    * */
    public void advanceToRight();
    
    /** Sets the current node to the root of the tree.*/
    public void resetAccess();
} // end BinaryTreeAccessInterface