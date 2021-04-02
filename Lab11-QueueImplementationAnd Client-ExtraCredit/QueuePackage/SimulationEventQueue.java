package QueuePackage;

public class SimulationEventQueue implements SimulationEventQueueInterface {

    // Create a private variable to store the current simulation time.
    private double currentTime;
    private int size;

    // Create a private variable to store the contents of the queue.
    //private VectorQueue<SimulationEvent> contentsOfQueue = new VectorQueue<>();
    private PriorityQueue<SimulationEvent> contentsOfQueue = new PriorityQueue();


//    public SimulationEventQueue() {
//        currentTime = 0.0;
//        size = 0;
//        //contentsOfQueue = new VectorQueue<>();
//    }

    /** Adds a new event to this event queue.  If the time of the event to be added
     * is earlier the the time for this event queue, do not add the event.
     * @param newEntry An event.
     */
    public void add(SimulationEvent newEntry) {
        if (newEntry.getTime() >= currentTime) {
            contentsOfQueue.add(newEntry);
            size++;
        }

//        else {
//            System.out.println("BOOOOOOOOOO");
//        }
        System.out.println("add " + newEntry + ": " + contentsOfQueue.toString());
    }

    /** Removes and returns the item with the earliest time.
     * @return The event with the earliest time or,
     * if the event queue was empty before the operation, null.
     */
    public SimulationEvent remove() {
        if (isEmpty()) {
            return null;
        }
        else {
            SimulationEvent front = null;
            front = contentsOfQueue.remove();
            currentTime = front.getTime();
            size--;
            System.out.println("remove " + front.toString() + ": " + contentsOfQueue.toString());
            return front;
        }
    }

    /** Retrieves the item with the earliest time.
     * @return The event with the earliest time or,
     * if the event queue was empty was empty before the operation, null.
     */
    public SimulationEvent peek() {
        if (isEmpty()) {
            return null;
        }
        else {
            return contentsOfQueue.peek();
        }
    }

    /** Detects whether this event queue is empty.
     * @return True if the event queue is empty.
     */
    public boolean isEmpty() {
        return contentsOfQueue.isEmpty();
    }

    /** Gets the size of this event queue.
     * @return The number of entries currently in the event queue.
     */
    public int getSize() {
        return size;
    }

    /** Removes all entries from this event queue.
     */
    public void clear() {
        contentsOfQueue.clear();
        size = 0;
    }

    /**
     * The current time of the simulation
     *
     * @return The time for the first event on the queue.
     */
    public double getCurrentTime() {
        return currentTime;
    }
}
