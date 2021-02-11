package com.company;

public final class TwoPartCircularLinkedQueue<T> implements QueueInterface<T>
{
    private Node queueNode; // References first node in queue
    private Node freeNode; // References node after back of queue

    public TwoPartCircularLinkedQueue()
    {
        freeNode = new Node(null, null);
        freeNode.setNextNode(freeNode);
        queueNode = freeNode;
    } // end default constructor

    /** Adds a new entry to the back of this queue.
     @param newEntry  An object to be added. */
    public void enqueue(T newEntry) {
        freeNode.setData(newEntry);
        if (isChainFull()) {
            Node newNode = new Node(null,freeNode.getNextNode());
            freeNode.setNextNode(newNode);
        }
        freeNode = freeNode.getNextNode();
    }

    /** Removes and returns the entry at the front of this queue.
     @return  The object at the front of the queue.
     @throws  EmptyQueueException if the queue is empty before the operation. */
    public T dequeue() {
        T front = getFront();
        assert !isEmpty();
        queueNode.setData(null);
        queueNode = queueNode.getNextNode();
        return front;
    }

    /**  Retrieves the entry at the front of this queue.
     @return  The object at the front of the queue.
     @throws  EmptyQueueException if the queue is empty. */
    public T getFront() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        else {
            return queueNode.getData();
        }
    }

    /** Detects whether this queue is empty.
     @return  True if the queue is empty, or false otherwise. */
    public boolean isEmpty() {
        return queueNode == freeNode;
    }

    public boolean isChainFull() {
        return queueNode == freeNode.getNextNode();
    }

    /** Removes all entries from this queue. */
    public void clear()
    {
        while (!isEmpty())
            dequeue();
    } // end clear

    class Node{
        private T data;
        private Node next;

        Node (T newEntry) {
            data = newEntry;
            next = null;
        }

        Node (T newEntry, Node position) {
            data = newEntry;
            next = position;
        }

        public void setData(T data) {
            this.data = data;
        }

        public void setNextNode(Node next) {
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public Node getNextNode() {
            return next;
        }
    } // end Node
} // end TwoPartCircularLinkedQueue