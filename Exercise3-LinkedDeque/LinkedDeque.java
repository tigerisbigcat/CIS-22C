package com.company;


public class LinkedDeque<T> implements DequeInterface<T>
{
    private DLNode firstNode; // References node at front of deque
    private DLNode lastNode; // References node at back of deque

    public LinkedDeque()
    {
        firstNode = null;
        lastNode = null;
    } // end default constructor

    /** Adds a new entry to the front/back of this dequeue.
     @param newEntry  An object to be added. */
    public void addToFront(T newEntry) {
        DLNode newNode = new DLNode(null, newEntry, firstNode);
        if (isEmpty()) {
            lastNode = newNode;
        }
        else {
            firstNode.setPreviousNode(newNode);
        }
        firstNode = newNode;
    }

    public void addToBack(T newEntry) {
        DLNode newNode = new DLNode(lastNode, newEntry, null);
        if (isEmpty()) {
            firstNode = newNode;
        } else {
            lastNode.setNextNode(newNode);
        }
        lastNode = newNode;
    }

        /** Removes and returns the front/back entry of this dequeue.
         @return The object at the front/back of the dequeue.
         @throws EmptyQueueException if the dequeue is empty before the operation. */
    public T removeFront() {
        T front = getFront();
        assert firstNode != null;
        firstNode = firstNode.getNextNode();
        if (firstNode == null) {
            lastNode = null;
        } else {
            firstNode.setPreviousNode(null);
        }
        return front;
    }

    public T removeBack () {
        T back = getBack();
        assert lastNode != null;
        lastNode = lastNode.getPreviousNode();
        if(lastNode == null) {
            firstNode = null;
        }
        else {
            lastNode.setNextNode(null);
        }
        return back;
    }

// end DequeInterface

    public T getBack()
    {
        if (isEmpty())
            throw new EmptyQueueException();
        else
            return lastNode.getData();
    } // end getBack

    public T getFront()
    {
        if (isEmpty())
            throw new EmptyQueueException();
        else
            return firstNode.getData();
    } // end getFront

    public void clear()
    {
        firstNode = null;
        lastNode = null;
    } // end clear
    public boolean isEmpty()
    {
        return (firstNode == null) && (lastNode == null);
    } // end isEmpty



    private class DLNode
    {
        private T data; // Deque entry
        private DLNode next; // Link to next node
        private DLNode previous; // Link to previous node

        private DLNode(T dataPortion)
        {
            data = dataPortion;
            next = null;
            previous = null;
        } // end constructor

        private DLNode(DLNode previousNode, T dataPortion, DLNode nextNode)
        {
            data = dataPortion;
            next = nextNode;
            previous = previousNode;
        } // end constructor

        private T getData()
        {
            return data;
        } // end getData

        private void setData(T newData)
        {
            data = newData;
        } // end setData

        private DLNode getNextNode()
        {
            return next;
        } // end getNextNode

        private void setNextNode(DLNode nextNode)
        {
            next = nextNode;
        } // end setNextNode

        private DLNode getPreviousNode()
        {
            return previous;
        } // end getPreviousNode

        private void setPreviousNode(DLNode previousNode)
        {
            previous = previousNode;
        } // end setPreviousNode
    } // end DLNode

} // end LinkedDeque
