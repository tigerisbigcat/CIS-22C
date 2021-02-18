package StackAndQueuePackage;

public final class LinkedQueue<T> implements QueueInterface<T>
{
    private Node firstNode;
    private Node lastNode;

    public LinkedQueue() {
        firstNode = null;
        lastNode = null;
    }


    // public LinkedQueue(T newEntry, Node position )

    public void enqueue(T newEntry) {
        Node newNode = new Node(newEntry, null);
        if (isEmpty()) {
            firstNode = newNode;
        }
        else {
            lastNode.setNextNode(newNode);
        }
        lastNode = newNode;
    }

    /** Removes and returns the entry at the front of this queue.
     @return  The object at the front of the queue.
     @throws EmptyQueueException if the queue is empty before the operation. */
    public T dequeue() {
        T front = getFront();
        assert firstNode != null;
        firstNode.setData(null);
        firstNode = firstNode.getNextNode();
        if (firstNode == null) {
            lastNode = null;
        }
        return front;
    }

    /**  Retrieves the entry at the front of this queue.
     @return  The object at the front of the queue.
     @throws EmptyQueueException if the queue is empty. */
    public T getFront() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        else {
            return firstNode.getData();
        }
    }

    /** Detects whether this queue is empty.
     @return  True if the queue is empty, or false otherwise. */
    public boolean isEmpty() {
        return (firstNode == null) && (lastNode == null);
    }

    /** Removes all entries from this queue. */
    public void clear() {
        firstNode = null;
        lastNode = null;
    }

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
} // end Linkedqueue