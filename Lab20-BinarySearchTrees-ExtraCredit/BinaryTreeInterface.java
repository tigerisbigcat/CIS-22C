package TreePackage;

/** An interface for the ADT Binary Tree.
*
* This code is from Chapter 23 of
* Data Structures and Abstractions with Java 4/e
*      by Carrano
*/

public interface BinaryTreeInterface<T> extends TreeInterface<T>, TreeIteratorInterface<T>
{
    /** Sets this binary tree to a new one-node binary tree.
    * @param rootData The object that is the data for the new tree's root.
    */
    public void setTree(T rootData);
    
    /** Sets this binary tree to a new binary tree.
    * @param rootData The object that is the data for the new tree's root.
    * @param leftTree The left subtree of the new tree.
    * @param rightTree The right subtree of the new tree. */
    public void setTree(T rootData, BinaryTreeInterface<T> leftTree,
                    BinaryTreeInterface<T> rightTree);
} // end BinaryTreeInterface