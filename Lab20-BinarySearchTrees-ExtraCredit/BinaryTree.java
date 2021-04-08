
package TreePackage;

/**
 * An implementation of the ADT Binary Tree.
 * 
 * This code is from Chapter 24 of 
 * Data Structures and Abstractions with Java 4/e
 * by Carrano
 * 
* Modified to use Java's built in Stack class by Charles Hoot 
* 
 * @version 4.0 
 */
import java.util.*;

public class BinaryTree<T> implements BinaryTreeInterface<T>
{

    private BinaryNode<T> root;

    public BinaryTree() {
        root = null;
    } // end default constructor

    public BinaryTree(T rootData) {
        root = new BinaryNode<T>(rootData);
    } // end constructor

    public BinaryTree(T rootData, BinaryTree<T> leftTree,
            BinaryTree<T> rightTree) {
        privateSetTree(rootData, leftTree, rightTree);
    } // end constructor

    public void setTree(T rootData) {
        root = new BinaryNode<T>(rootData);
    } // end setTree

    public void setTree(T rootData, BinaryTreeInterface<T> leftTree,
            BinaryTreeInterface<T> rightTree) {
        privateSetTree(rootData, (BinaryTree<T>) leftTree, (BinaryTree<T>) rightTree);
    } // end setTree

    private void privateSetTree(T rootData,
            BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
        root = new BinaryNode<T>(rootData);

        if ((leftTree != null) && !leftTree.isEmpty()) {
            root.setLeftChild(leftTree.root);
            // ADD CODE TO SET THE PARENT AND THREAD OF THE LEFT CHILD
        }

        if ((rightTree != null) && !rightTree.isEmpty()) {
            if (rightTree != leftTree) {
                root.setRightChild(rightTree.root);
            } else {
                root.setRightChild(rightTree.root.copy());
            }
            // ADD CODE TO SET THE PARENT OF THE RiGHT CHILD
            // SET THE THREAD OUT OF THE ROOT

        } // end if

        if ((leftTree != null) && (this != leftTree)) {
            leftTree.clear();
        }

        if ((rightTree != null) && (this != rightTree)) {
            rightTree.clear();
        }

    } // end privateSetTree

    public T getRootData() {
        if (isEmpty()) {
            throw new EmptyTreeException("Empty tree for operation getRootData");
        } else {
            return root.getData();
        }
    } // end getRootData

    public boolean isEmpty() {
        return root == null;
    } // end isEmpty

    public void clear() {
        root = null;
    } // end clear

    protected void setRootData(T rootData) {
        root.setData(rootData);
    } // end setRootData

    protected void setRootNode(BinaryNode<T> rootNode) {
        root = rootNode;
    } // end setRootNode

    protected BinaryNode<T> getRootNode() {
        return root;
    } // end getRootNode

    public int getHeight() {
        // Modified from Carrano to return 0 if the tree is empty
        if (root == null) {
            return 0;
        } else {
            return root.getHeight();
        }
    } // end getHeight

    public int getNumberOfNodes() {
        // Modified from Carrano to return 0 if the tree is empty
        if (root == null) {
            return 0;
        } else {
            return root.getNumberOfNodes();
        }
    } // end getNumberOfNodes

    public void inorderTraverse() {
        inorderTraverse(root);
    } // end inorderTraverse

    private void inorderTraverse(BinaryNode<T> node) {
        if (node != null) {
            inorderTraverse(node.getLeftChild());
            System.out.println(node.getData());
            inorderTraverse(node.getRightChild());
        } // end if
    } // end inorderTraverse

//      The inorder Iterator that uses the stack will be replaced
//      by one that uses threads
    private class InorderIterator implements Iterator<T> {

        private Stack<BinaryNode<T>> nodeStack;
        private BinaryNode<T> currentNode;

        public InorderIterator() {
            nodeStack = new Stack<BinaryNode<T>>();
            currentNode = root;
        } // end default constructor

        public boolean hasNext() {
            return !nodeStack.isEmpty() || (currentNode != null);
        } // end hasNext

        public T next() {
            BinaryNode<T> nextNode = null;

            // Find leftmost node with no left child
            while (currentNode != null) {
                nodeStack.push(currentNode);
                currentNode = currentNode.getLeftChild();
            } // end while

            // Get leftmost node, then move to its right subtree
            if (!nodeStack.isEmpty()) {
                nextNode = nodeStack.pop();
                assert nextNode != null; // Since nodeStack was not empty
                // before the pop
                currentNode = nextNode.getRightChild();
            } else {
                throw new NoSuchElementException();
            }

            return nextNode.getData();
        } // end next

        public void remove() {
            throw new UnsupportedOperationException();
        } // end remove

    } // end InorderIterator

    
    /* Create an inorder iterator.
     * @return The iterator.
     */
    public Iterator<T> getInorderIterator() {
        return new InorderIterator();
    }

    
    
    // Only the one iterator will be implemented by this code
    public Iterator<T> getPreorderIterator() {
        throw new RuntimeException("Pre order iterators not yet supported by this class");
    }

    public Iterator<T> getPostorderIterator() {
        throw new RuntimeException("Post order iterators not yet supported by this class");
    }

    public Iterator<T> getLevelOrderIterator() {
        throw new RuntimeException("Level order iterators not yet supported by this class");
    }

    // ADD IN METHODS FOR ACCESSING THE TREE

}
