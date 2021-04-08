
package TreePackage; 
    
/** An implementation of the ADT Binary Search Tree.
 *
 * This code is from Chapter 25 of
 * Data Structures and Abstractions with Java 4/e
 *      by Carrano
 *      
  * @version 4.0
 */
    
public class BinarySearchTree<T extends Comparable<? super T>>
                extends BinaryTree<T>
                implements SearchTreeInterface<T>
{
    public BinarySearchTree()
    {
        super();
    } // end default constructor
    
    public BinarySearchTree(T rootEntry)
    {
        super();
        setRootNode(new BinaryNode<T>(rootEntry));
    } // end constructor
    
    
    public void setTree(T rootData) // disable setTree (see Segment 25.6)
    {
        throw new UnsupportedOperationException();
    } // end setTree
    
    
    public void setTree(T rootData, BinaryTreeInterface<T> leftTree,
                        BinaryTreeInterface<T> rightTree)
    {
        throw new UnsupportedOperationException();
    } // end setTree
    
    
    public T getEntry(T entry)
    {
        return findEntry(getRootNode(), entry);
    } // end getEntry
    
    
    private T findEntry(BinaryNode<T> rootNode, T entry)
    {
        T result = null;
        if (rootNode != null)
        {
            T rootEntry = rootNode.getData();
            if (entry.equals(rootEntry))
                result = (T) rootEntry;
            else if (entry.compareTo(rootEntry) < 0)
                result = findEntry(rootNode.getLeftChild(), entry);
            else
                result = findEntry(rootNode.getRightChild(), entry);
        } // end if
        return result;
    } // end findEntry
    
    
    public boolean contains(T entry)
    {
        return getEntry(entry) != null;
    } // end contains
    
    public T add(T newEntry)
    {
        T result = null;
        
        if (isEmpty())
            setRootNode(new BinaryNode<T>(newEntry));
        else
            result = addEntry(newEntry);
        return result;
    } // end add
    
    /** Adds newEntry to the nonempty subtree rooted at rootNode. (non-recursive).
        @param newEntry An item to add to the search tree.
     */
    private T addEntry(T newEntry)
    {
        BinaryNode<T> currentNode = getRootNode();
        assert currentNode != null; 

        T result = null;
        boolean found = false;
        
        while (!found)
        {
            T currentEntry = currentNode.getData();
            int comparison = newEntry.compareTo(currentEntry);
            
            if (comparison == 0)
            { // newEntry matches currentEntry;
                // return and replace currentEntry
                found = true;
                result = currentEntry;
                currentNode.setData(newEntry);
            }
            else if (comparison < 0)
            {
                if (currentNode.hasLeftChild())
                    currentNode = currentNode.getLeftChild();
                else
                {
                    // Add node on the left side
                    found = true;
                    
                    // CHANGE THIS TO SET PARENT POINTERS AND FIX UP THREADS
                    currentNode.setLeftChild(new BinaryNode<T>(newEntry));

                } // end if
            }
            else
            {
                assert comparison > 0;
                if (currentNode.hasRightChild())
                    currentNode = currentNode.getRightChild();
                else
                {
                    // Add node on the right side
                    found = true;
                    
                    // CHANGE THIS TO SET PARENT POINTERS AND FIX UP THREADS
//                    currentNode.setRightChild(new BinaryNode<T>(newEntry));
                    
                } // end if
            } // end if
        } // end while
        
    return result;
    } // end addEntry
  
    
    
    
    
    /** Removes entry from the search tree (non-recursive).
     * @return The item if found, otherwise return null.
     */
    public T remove(T entry)
    {
        T result = null;
        boolean found = false;
        // Locate node (and its parent) that contains a match for entry
        NodePair pair = findNode(entry);
        BinaryNode<T> currentNode = pair.getFirst();
        BinaryNode<T> parentNode = pair.getSecond();
        
        if (currentNode != null) // Entry is found
        {
            result = currentNode.getData(); // Get entry to be removed
            // Case 1: currentNode has two children
            if (currentNode.hasLeftChild() && currentNode.hasRightChild())
            {
                // Replace entry in currentNode with the entry in another node
                // that has at most one child; that node can be deleted
                // Get node to remove (contains inorder predecessor; has at
                // most one child) and its parent
                pair = getNodeToRemove(currentNode);
                BinaryNode<T> nodeToRemove = pair.getFirst();
                parentNode = pair.getSecond();
                // Copy entry from nodeToRemove to currentNode
                currentNode.setData(nodeToRemove.getData());
                currentNode = nodeToRemove;
                // Assertion: currentNode is the node to be removed; it has at most one child
                // Assertion: Case 1 has been transformed to Case 2
            } // end if
            
            // Case 2: currentNode has at most one child; delete it
            removeNode(currentNode, parentNode);
        } // end if
        return result;
    } // end remove

    
    private NodePair findNode(T entry)
    {
        BinaryNode<T> parentNode = null;
        BinaryNode<T> currentNode = getRootNode();
        
        NodePair result = new NodePair();
        boolean found = false;
        
        while (!found && currentNode != null)
        {
            T currentData = currentNode.getData();
            int comparison = entry.compareTo(currentData);
            
            if (comparison == 0) // entry == current entry
            {
                found = true;
            }
            else if (comparison < 0) // entry < current entry
            {
                parentNode = currentNode;
                currentNode = currentNode.getLeftChild();
            }
            else // entry > root entry
            {
                parentNode = currentNode;
                currentNode = currentNode.getRightChild();
            }
        }

        if (found)
            result = new NodePair(currentNode, parentNode);
        // found entry is currentNode.getData()
        return result;
    } // end findNode

    
    private NodePair getNodeToRemove(BinaryNode<T> currentNode)
    {
        // Find the inorder predecessor by searching the left subtree;
        // it will be the largest entry in the subtree, occurring
        // in the node are far right as possible.
        BinaryNode<T> leftSubtreeRoot = currentNode.getLeftChild();
        BinaryNode<T> rightChild = leftSubtreeRoot;
        BinaryNode<T> priorNode = currentNode;
        
        while (rightChild.hasRightChild())
        {
            priorNode = rightChild;
            rightChild = rightChild.getRightChild();
        } // end while
        
        // rightChild contains the inorder predecessor and is the node to
        // remove; priorNode is its parent
        return new NodePair(rightChild, priorNode);
    } // end getNodeToRemove
    

    // Remove this node directly, it has at most 1 child
    private void removeNode(BinaryNode<T> nodeToRemove,
                            BinaryNode<T> parentNode)
    {
        BinaryNode<T> childNode;

        if (nodeToRemove.hasLeftChild())
        {
            childNode = nodeToRemove.getLeftChild();
        }
        else
        {
            childNode = nodeToRemove.getRightChild();
        }
            
        // Assertion: If nodeToRemove is a leaf, childNode is null
        assert (nodeToRemove.isLeaf() && childNode == null) ||
                !nodeToRemove.isLeaf();
        
        if (nodeToRemove == getRootNode())
        {
            setRootNode(childNode);
        }
        else if (parentNode.getLeftChild() == nodeToRemove)
        {
            parentNode.setLeftChild(childNode);
        }
        else
        {
            parentNode.setRightChild(childNode);
        }
            
    } // end removeNode

    
    
    
    private class NodePair
    {
        private BinaryNode<T> first;
        private BinaryNode<T> second;

        public NodePair()
        {
            first = null;
            second = null;
        }

        public NodePair(BinaryNode<T> myFirst, BinaryNode<T> mySecond)
        {
            first = myFirst;
            second = mySecond;
        }
        
        public BinaryNode<T> getFirst()
        {
            return first;
        }
        
        public BinaryNode<T> getSecond()
        {
            return second;
        }
    }
}
