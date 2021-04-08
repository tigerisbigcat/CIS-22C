package TreePackage;

import java.util.*;

/** An implementation of the ADT Binary Tree.
*
* This code is modified from BinaryTree in Chapter 24 of
* Data Structures and Abstractions with Java 4/e
*      by Carrano
*/
    
public class BinaryTreeWithAccess<T> implements BinaryTreeAccessInterface<T>
{
    private BinaryNode<T> root;
    public BinaryTreeWithAccess()
    {
        root = null;
        resetAccess();
    } // end default constructor

    public BinaryTreeWithAccess(T rootData)
    {
        root = new BinaryNode<T>(rootData);
        resetAccess();
    } // end constructor

    public BinaryTreeWithAccess(T rootData, BinaryTreeWithAccess<T> leftTree,
                   BinaryTreeWithAccess<T> rightTree)
    {
        privateSetTree(rootData, leftTree, rightTree);
    } // end constructor

    
    public void setTree(T rootData)
    {
        root = new BinaryNode<T>(rootData);
        resetAccess();
    } // end setTree
    
    
    public void setTree(T rootData, BinaryTreeInterface<T> leftTree,
                     BinaryTreeInterface<T> rightTree)
    {
        privateSetTree(rootData, (BinaryTreeWithAccess<T>)leftTree, (BinaryTreeWithAccess<T>)rightTree);
    } // end setTree


    

    private void privateSetTree(T rootData,
                             BinaryTreeWithAccess<T> leftTree, BinaryTreeWithAccess<T> rightTree)
    {
        root = new BinaryNode<T>(rootData);

        if ((leftTree != null) && !leftTree.isEmpty())
            root.setLeftChild(leftTree.root);

        if ((rightTree != null) && !rightTree.isEmpty())
        {
            if (rightTree != leftTree)
                root.setRightChild(rightTree.root);
            else
                root.setRightChild(rightTree.root.copy());
        } // end if

        if ((leftTree != null) && (this != leftTree))
            leftTree.clear();

        if ((rightTree != null) && (this != rightTree))
                rightTree.clear();
        
        resetAccess();
    } // end privateSetTree


    public T getRootData() {
        if (isEmpty()) {
            throw new EmptyTreeException("Empty tree for operation getRootData");
        } else {
            return root.getData();
        }
    } // end getRootData

    public boolean isEmpty()
    {
        return root == null;
    } // end isEmpty

    public void clear()
    {
        root = null;
        resetAccess();
    } // end clear

    protected void setRootData(T rootData)
    {
        root.setData(rootData);
    } // end setRootData

    protected void setRootNode(BinaryNode<T> rootNode)
    {
        root = rootNode;
    } // end setRootNode

    protected BinaryNode<T> getRootNode()
    {
        return root;
    } // end getRootNode

    public int getHeight()
    {
        // Modified from Carano to return 0 if the tree is empty
        if(root== null)
            return 0;
        else
            return root.getHeight();    
    } // end getHeight

    public int getNumberOfNodes()
    {
        // Modified from Carano to return 0 if the tree is empty
        if(root== null)
            return 0;
        else
            return root.getNumberOfNodes();
    } // end getNumberOfNodes

    public void inorderTraverse()
    {
        inorderTraverse(root);
    } // end inorderTraverse

    private void inorderTraverse(BinaryNode<T> node)
    {
        if (node != null)
        {
            inorderTraverse(node.getLeftChild());
            System.out.println(node.getData());
            inorderTraverse(node.getRightChild());
        } // end if
    } // end inorderTraverse
    
    
    private class InorderIterator implements Iterator<T>
    {
        private Stack<BinaryNode<T>> nodeStack;
        private BinaryNode<T> currentNode;

        public InorderIterator()
        {
            nodeStack = new Stack<BinaryNode<T>>();
            currentNode = root;
        } // end default constructor

        public boolean hasNext()
        {
            return !nodeStack.isEmpty() || (currentNode != null);
        } // end hasNext

        public T next()
        {
            BinaryNode<T> nextNode = null;

            // Find leftmost node with no left child
            while (currentNode != null)
            {
                nodeStack.push(currentNode);
                currentNode = currentNode.getLeftChild();
            } // end while

            // Get leftmost node, then move to its right subtree
            if (!nodeStack.isEmpty())
            {
                nextNode = nodeStack.pop();
                assert nextNode != null; // Since nodeStack was not empty
                // before the pop
                currentNode = nextNode.getRightChild();
            }
            else
                throw new NoSuchElementException();

            return nextNode.getData();
        } // end next

        public void remove()
        {
            throw new UnsupportedOperationException();
        } // end remove

    } // end InorderIterator
    
    /* Create an inorder iterator.
    * @return The iterator.
    */
    public Iterator<T> getInorderIterator()
    {
        return new InorderIterator();
    }
    
    // Only the one iterator will be implemented by this code
    public Iterator<T> getPreorderIterator()
    {
        throw new RuntimeException("Post order iterators not yet supported by this class");   
    }
    public Iterator<T> getPostorderIterator()
    {
        throw new RuntimeException("Post order iterators not yet supported by this class");
    }
    public Iterator<T> getLevelOrderIterator()
    {
        throw new RuntimeException("Post order iterators not yet supported by this class");    
    }
    
    
    // Methods for BinaryTreeAccessInterface
    
    BinaryNode<T> current = null;
    
    /**
     * Gets the data in the current node.
     *
     * @return The data object in the current node.
     */
    public T getCurrentData() {
        T result = null;

        if (current != null) {
            result = current.getData();
        }
        return result;
    }

    /**
     * Determines if the current node has a left child.
     *
     * @return True if the left child is non-null.
     *
     */
    public boolean canAdvanceToLeft() {
        return (current != null && current.hasLeftChild());
    }

    /**
     * Moves the current node to the left child of the current node.
     */
    public void advanceToLeft() {
        if (current != null) {
            current = current.getLeftChild();
        }
    }

    /**
     * Determines if the current node has a right child.
     *
     * @return True if the right child is non-null.
     *
     */
    public boolean canAdvanceToRight() {
        return (current != null && current.hasRightChild());
    }

    /**
     * Moves the current node to the right child of the current node.
     */
    public void advanceToRight() {
        if (current != null) {
            current = current.getRightChild();
        }
    }

    /**
     * Sets the current node to the root of the tree.
     */
    public final void resetAccess() {
        current = root;
    }
    
}

	