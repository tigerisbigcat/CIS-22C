// 22C
// TTh 9:30-11:15
// Name : Lei Hao

import TreePackage.BinaryTreeInterface;
import TreePackage.*;

public class BinarySearchTree<T extends Comparable<? super T>>
        extends BinaryTree<T> implements SearchTreeInterface<T>
{
    public BinarySearchTree()
    {
        super();
    } // end default constructor

    public BinarySearchTree(T rootEntry)
    {
        super();
        setRootNode(new BinaryNode<>(rootEntry));
    } // end constructor

    public void setTree(T rootData) // Disable setTree (see Segment 25.6)
    {
        throw new UnsupportedOperationException();
    } // end setTree

    public void setTree(T rootData, BinaryTreeInterface<T> leftTree,
                                    BinaryTreeInterface<T> rightTree)
    {
        throw new UnsupportedOperationException();
    } // end setTree

    /** Searches for a specific entry in this tree.
     @param entry  An object to be found.
     @return  True if the object was found in the tree. */
    public boolean contains(T entry) {
        return getEntry(entry) != null;
    }

    /** Retrieves a specific entry in this tree.
     @param entry  An object to be found.
     @return  Either the object that was found in the tree or
     null if no such object exists. */
    public T getEntry(T entry) {
        return findEntry(getRootNode(),entry);
    }

    private T findEntry(BinaryNode<T> rootNode, T entry) {
        T result = null;
        if (rootNode != null) {
            T rootEntry = rootNode.getData();
            if (entry.equals(rootEntry)) {
                result = rootEntry;
            }
            else if (entry.compareTo(rootEntry) < 0) {
                result = findEntry(rootNode.getLeftChild(), entry);
            }
            else {
                result = findEntry(rootNode.getRightChild(), entry);
            }
        }
        return result;
    }

    /** Adds a new entry to this tree, if it does not match an existing
     object in the tree. Otherwise, replaces the existing object with
     the new entry.
     @param newEntry  An object to be added to the tree.
     @return  Either null if newEntry was not in the tree already, or
     the existing entry that matched the parameter newEntry
     and has been replaced in the tree. */
    public T add(T newEntry) {
        T result = null;
        if (isEmpty()) {
            setRootNode(new BinaryNode<>(newEntry));
        }
        else {
            result = addEntry(getRootNode(), newEntry);
        }
        return result;
    }

    private T addEntry(BinaryNode<T> rootNode, T newEntry) {
        assert rootNode != null;
        T result = null;
        int comparison = newEntry.compareTo(rootNode.getData());

        if (comparison == 0) {
            result = rootNode.getData();
            rootNode.setData(newEntry);
        }
        else if (comparison < 0) {
            if (rootNode.hasLeftChild()) {
                result = addEntry(rootNode.getLeftChild(), newEntry);
            }
            else {
                rootNode.setLeftChild(new BinaryNode<>(newEntry));
            }
        }
        else {
            assert comparison > 0;
            if (rootNode.hasRightChild()) {
                result = addEntry(rootNode.getRightChild(), newEntry);
            }
            else {
                rootNode.setRightChild(new BinaryNode<>(newEntry));
            }
        }
        return result;
    }

    private T addEntry(T entry) {
        BinaryNode<T> currentNode = getRootNode();
        assert currentNode != null;
        T result = null;
        boolean found = false;
        while (!found) {
            T currentEntry = currentNode.getData();
            int comparison = entry.compareTo(currentEntry);
            if (comparison == 0) {
                found = true;
                result = currentEntry;
                currentNode.setData(entry);
            }
            else if (comparison < 0) {
                if (currentNode.hasLeftChild()) {
                    currentNode = currentNode.getLeftChild();
                }
                else {
                    found = true;
                    currentNode.setLeftChild(new BinaryNode<>(entry));
                }
            }
            else {
                assert comparison > 0;
                if (currentNode.hasRightChild()) {
                    currentNode = currentNode.getRightChild();
                }
                else {
                    found = true;
                    currentNode.setRightChild(new BinaryNode<>(entry));
                }
            }
        }
        return result;
    }


    public T remove(T entry) {
        ReturnObject oldEntry = new ReturnObject(null);
        BinaryNode<T> newRoot = removeEntry(getRootNode(), entry, oldEntry);
        setRootNode(newRoot);
        return oldEntry.get();
    }

    private BinaryNode<T> removeEntry(BinaryNode<T> rootNode, T entry,
                                      ReturnObject oldEntry) {
        if (rootNode != null) {
            T rootData = rootNode.getData();
            int comparison = entry.compareTo(rootData);
            if (comparison == 0) {
                oldEntry.set(rootData);
                rootNode = removeFromRoot(rootNode);
            }
            else if (comparison < 0) {
                BinaryNode<T> leftChild = rootNode.getLeftChild();
                BinaryNode<T> subtreeRoot = removeEntry(leftChild, entry, oldEntry);
                rootNode.setLeftChild(subtreeRoot);
            }
            else {
                BinaryNode<T> rightChild = rootNode.getRightChild();
                rootNode.setRightChild(removeEntry(rightChild, entry,oldEntry));
            }
        }
        return rootNode;
    }

    private BinaryNode<T> removeFromRoot(BinaryNode<T> rootNode) {
        if (rootNode.hasLeftChild() && rootNode.hasRightChild()) {
            BinaryNode<T> leftSubtreeRoot = rootNode.getLeftChild();
            BinaryNode<T> largestNode = findLargest(leftSubtreeRoot);
            rootNode.setData((largestNode.getData()));
            rootNode.setLeftChild(removeLargest(leftSubtreeRoot));
        }
        else if (rootNode.hasRightChild()) {
            rootNode = rootNode.getRightChild();
        }
        else {
            rootNode = rootNode.getLeftChild();
        }
        return rootNode;
    }

    private BinaryNode<T> findLargest(BinaryNode<T> rootNode) {
        if (rootNode.hasRightChild()) {
            rootNode = findLargest(rootNode.getRightChild());
        }
        return rootNode;
    }

    private BinaryNode<T> removeLargest(BinaryNode<T> rootNode) {
        if (rootNode.hasRightChild()) {
            BinaryNode<T> rightChild = rootNode.getRightChild();
            rightChild = removeLargest(rightChild);
            rootNode.setRightChild(rightChild);
        }
        else {
            rootNode = rootNode.getLeftChild();
        }
        return rootNode;
    }

    private class ReturnObject
    {
        private T item;

        private ReturnObject(T entry)
        {
            item = entry;
        } // end constructor

        public T get()
        {
            return item;
        } // end get

        public void set(T entry)
        {
            item = entry;
        } // end set
    } // end ReturnObject
} // end BinarySearchTree
