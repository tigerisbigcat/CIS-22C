package QueuePackage;

import java.util.Arrays;

public class PriorityQueue<T extends Comparable<T>> implements PriorityQueueInterface<T> {
    private T[] items;
    private final static int max_size = 512;
    private int size;

    public PriorityQueue() {
        items = (T[]) new Comparable[max_size];
        size = 0;
    }

    /** Adds a new entry to this priority queue.
     * @param newEntry An object to be added.
     */
    public void add(T newEntry) {
        if (size < max_size) {
            items[size] = newEntry;
            int place = size;
            int parent = (place - 1) / 2;
            while ((parent >= 0) && (items[place].compareTo(items[parent]) < 0)) {
                T temp = items[place];
                items[place] = items[parent];
                items[parent] = temp;
                place = parent;
                parent = (place - 1) / 2;
            }
            size++;
        }
        else {
            throw new PQException("The priorityQueue is full");
        }
    }

    /** Removes and returns the entry having the highest priority.
     * @return  The object with the highest priority.
     * @throws EmptyQueueException if the queue was empty before the operation.
     */
    public T remove() {
        if (!isEmpty()) {
            T front = items[0];
            swap(0, --size);
            if (size != 0) {
                PQRebuild(0);
            }
            return front;
        }
        else {
            throw new EmptyQueueException("Empty queue.");
        }
    }

    /** Retrieves the entry having the highest priority.
     * @return The object having the highest priority.
     * @throws EmptyQueueException if the queue was empty before the operation.
     */
    public T peek() {
        T root = null;
        if(!isEmpty()) {
            root = items[0];
        }
        else {
            throw new EmptyQueueException("Empty queue.");
        }
        return root;
    }

    /** Detects whether this priority queue is empty.
     * @return True if the priority queue is empty, or false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Gets the size of this priority queue.
     * @return The number of entries currently in the priority queue.
     */
    public int getSize() {
        return size;
    }

    /** Removes all entries from this priority queue
     */
    public void clear() {
        size = 0;
    }

    private void swap(int minChild, int current) {
        T temp = items[minChild];
        items[minChild] = items[current];
        items[current] = temp;
    }

    private boolean isChild(int root) {
        return root >= size/2 && root < size;
    }

    private void PQRebuild(int root) {
        while (!isChild(root)){
            int minChild = 2 * root + 1;
            if(items[minChild].compareTo(items[minChild+1]) > 0 && minChild < size - 1) {
                minChild++;
            }
            if(items[root].compareTo(items[minChild]) <= 0) {
                return;
            }
            swap(root,minChild);
            root = minChild;
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(items, 0, size));
    }
}
