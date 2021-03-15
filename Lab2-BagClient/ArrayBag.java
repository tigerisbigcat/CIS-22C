
/**
A class of bags whose entries are stored in a fixed-size array.
@author Frank M. Carrano
 * This code is from Chapter 2 of
 * Data Structures and Abstractions with Java 4/e
 *      by Carrano 
 */
public final class ArrayBag<T> implements BagInterface<T> {

    private final T[] bag;
    private int numberOfEntries;
    private static final int DEFAULT_CAPACITY = 25;
    
    private boolean initialized = false;
    private static final int MAX_CAPACITY = 10000;

    /** Creates an empty bag whose initial capacity is 25. */
    public ArrayBag() {
        this(DEFAULT_CAPACITY);
    } // end default constructor

    /**
     * Creates an empty bag having a given initial capacity.
     *
     * @param desiredCapacity The integer capacity desired.
     */
    public ArrayBag(int desiredCapacity) {
        if (desiredCapacity <= MAX_CAPACITY) {

            // The cast is safe because the new array contains null entries.
            @SuppressWarnings("unchecked")
            T[] tempBag = (T[]) new Object[desiredCapacity]; // Unchecked cast
            bag = tempBag;
            numberOfEntries = 0;
            initialized = true;
        }
        else
            throw new IllegalStateException("Attempt to create a bag " +
                                            "whose capacity exceeds " +
                                            "allowed maximum.");
    } // end constructor

    /** Adds a new entry to this bag.
    @param newEntry The object to be added as a new entry.
    @return True if the addition is successful, or false if not. */
    public boolean add(T newEntry) {
        checkInitialization();
        boolean result = true;
        if (isArrayFull()) {
            result = false;
        }
        else { // Assertion: result is true here
            bag[numberOfEntries] = newEntry;
            numberOfEntries++;
        } // end if
        return result;
 
    } // end add

    /** Throws an exception if this object is not initialized.
     * 
     */
    private void checkInitialization()
    {
        if (!initialized)
             throw new SecurityException("ArrayBag object is not initialized " +
                                        "properly.");
   }
    
    /** Retrieves all entries that are in this bag.
    @return A newly allocated array of all the entries in the bag. */
    public T[] toArray() {
        
        // the cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries]; // unchecked cast
        for (int index = 0; index < numberOfEntries; index++) {
            result[index] = bag[index];
        } // end for
        return result;
    } // end toArray

    /** Sees whether this bag is full.
    @return True if the bag is full, or false if not. */
    private boolean isArrayFull() {
        return numberOfEntries >= bag.length;
    } // end isArrayFull

    /** Sees whether this bag is empty.
    @return True if the bag is empty, or false if not. */
    public boolean isEmpty() {
        return numberOfEntries == 0;
    } // end isEmpty

    /** Gets the current number of entries in this bag.
    @return The integer number of entries currently in the bag. */
    public int getCurrentSize() {
        return numberOfEntries;
    } // end getCurrentSize

    /** Counts the number of times a given entry appears in this bag.
    @param anEntry The entry to be counted.
    @return The number of times anEntry appears in the bag. */
    public int getFrequencyOf(T anEntry) {
        checkInitialization();
        int counter = 0;
        for (int index = 0; index < numberOfEntries; index++) {
            if (anEntry.equals(bag[index])) {
                counter++;
            } // end if
        } // end for
        return counter;
    } // end getFrequencyOf

    /** Tests whether this bag contains a given entry.
    @param anEntry The entry to locate.
    @return True if the bag contains anEntry, or false if not. */
    public boolean contains(T anEntry) {
        checkInitialization();
        return getIndexOf(anEntry) > -1;
    } // end contains

    /** Removes all entries from this bag. */
    public void clear() {
        while (!isEmpty()) {
            remove();
        }
    } // end clear

    /** Removes one unspecified entry from this bag, if possible.
    @return Either the removed entry, if the removal was successful,
    or null if otherwise. */
    public T remove() {
        checkInitialization();
        T result = removeEntry(numberOfEntries - 1);

        return result;
    } // end remove

    /** Removes one occurrence of a given entry from this bag.
    @param anEntry The entry to be removed.
    @return True if the removal was successful, or false if not. */
    public boolean remove(T anEntry) {
        checkInitialization();
        int index = getIndexOf(anEntry);
        T result = removeEntry(index);
        return anEntry.equals(result);
    } // end remove

// Removes and returns the entry at a given array index within the array bag.
// If no such entry exists, returns null.
// Preconditions: 0 <= givenIndex < numberOfEntries;
//                  checkInitialization has been called.
    private T removeEntry(int givenIndex) {
        T result = null;
        if (!isEmpty() && (givenIndex >= 0)) {
            result = bag[givenIndex];                   // entry to remove
            bag[givenIndex] = bag[numberOfEntries - 1]; // Replace entry with last entry
            bag[numberOfEntries - 1] = null;            // remove last entry
           numberOfEntries--;
         } // end if
        return result;
    } // end removeEntry

// Locates a given entry within the array bag.
// Returns the index of the entry, if located, or -1 otherwise.
// Precondition: checkInitialization has been called.
    private int getIndexOf(T anEntry) {
        int where = -1;
        boolean stillLooking = true;
        int index = 0;
        while ( stillLooking && (index < numberOfEntries)) {
            if (anEntry.equals(bag[index])) {
                stillLooking = false;
                where = index;
            } // end if
            index++;
        } // end for
// Assertion: If where > -1, anEntry is in the array bag, and it
// equals bag[where]; otherwise, anEntry is not in the array
        return where;
    } // end getIndexOf
    
    
    /** Override the toString() method so that we get a more useful display of
     * the contents in the bag.
     * @return a string representation of the contents of the bag */
    public String toString() {
        
        String result = "Bag[ ";
        
        for (int index = 0; index < numberOfEntries; index++) {
            result += bag[index] + " ";
        } // end for
        
        result += "]";
        return result;
    } // end toString
} // end ArrayBag
