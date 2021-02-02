// 22C
// TTh 9:30-11:15
// Name : Lei Hao
// Lists - Exercise 2 - ArrayList

package com.company;

import java.util.Arrays;

public class AList<T> implements ListInterface<T> {
    private T[] list; // Array of list entries; ignore list[0]
    private int numberOfEntries;
    private boolean initialized = false;
    private static final int DEFAULT_CAPACITY = 25;
    private static final int MAX_CAPACITY = 10000;

    public AList() {
        this(DEFAULT_CAPACITY);
    }

    public AList(int initialCapacity) {
        if(initialCapacity < DEFAULT_CAPACITY) {
            initialCapacity = DEFAULT_CAPACITY;
        }
        else {
            checkCapacity(initialCapacity);
        }

        @SuppressWarnings("unchecked")
        T[] tempList = (T[]) new Object[initialCapacity + 1];
        list = tempList;
        numberOfEntries = 0;
        initialized = true;
    }

    // Doubles the capacity of the array list if it is full.
    // Precondition: checkInitialization has been called.
    private void ensureCapacity()
    {
        int capacity = list.length - 1;
        if (numberOfEntries >= capacity)
        {
            int newCapacity = 2 * capacity;
            checkCapacity(newCapacity); // Is capacity too big?
            list = Arrays.copyOf(list, newCapacity + 1);
        } // end if
    } // end ensureCapacity

    // Makes room for a new entry at newPosition.
    // Precondition: 1 <= newPosition <= numberOfEntries + 1;
    // numberOfEntries is list's length before addition;
    // checkInitialization has been called.
    private void makeRoom(int newPosition)
    {
        assert (newPosition >= 1) && (newPosition <= numberOfEntries + 1);

        int newIndex = newPosition;
        int lastIndex = numberOfEntries;

    // Move each entry to next higher index, starting at end of
    // list and continuing until the entry at newIndex is moved
        for (int index = lastIndex; index >= newIndex; index--)
            list[index + 1] = list[index];
    } // end makeRoom

    // Shifts entries that are beyond the entry to be removed to the
    // next lower position.
    // Precondition: 1 <= givenPosition < numberOfEntries;
    // numberOfEntries is list's length before removal;
    // checkInitialization has been called.
    private void removeGap(int givenPosition)
    {
        assert (givenPosition >= 1) && (givenPosition < numberOfEntries);

        int removedIndex = givenPosition;
        int lastIndex = numberOfEntries;

        for (int index = removedIndex; index < lastIndex; index++)
            list[index] = list[index + 1];
    } // end removeGap


    // Throws an exception if this object is not initialized.
    private void checkInitialization()
    {
        if (!initialized)
            throw new SecurityException ("AList object is not initialized properly.");
    } // end checkInitialization



    // Throws an exception if the client requests a capacity that is too large.
    private void checkCapacity(int capacity)
    {
        if (capacity > MAX_CAPACITY)
            throw new IllegalStateException("Attempt to create a list " +
                    "whose capacity exceeds " +
                    "allowed maximum.");
    } // end checkCapacity


    /** Adds a new entry to the end of this list.
     Entries currently in the list are unaffected.
     The list's size is increased by 1.
     * @param newEntry The object to be added as a new entry.
     */
    public void add(T newEntry) {
        checkInitialization();
        list[numberOfEntries + 1] = newEntry;
        numberOfEntries++;
        ensureCapacity();
    }


    /** Adds a new entry at a specified position within this list.
     * Entries originally at and above the specified position
     * are at the next higher position within the list.
     * The list's size is increased by 1.
     * @param newPosition An integer that specifies the desired
     * position of the new entry.
     * @param newEntry The object to be added as a new entry.
     * @throws IndexOutOfBoundsException if either
     *    newPosition less than 1, or
     *    newPosition greater than getLength()+1.
     */
    public void add(int newPosition, T newEntry) {
        checkInitialization();
        if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) {
            if (newPosition <= numberOfEntries) {
                makeRoom(newPosition);
            }
            list[newPosition] = newEntry;
            numberOfEntries++;
            ensureCapacity();
        }
        else {
            throw new IndexOutOfBoundsException(
                    "Given position of add's new entry is out of bounds");
        }
    }


    /** Removes the entry at a given position from this list.
     * Entries originally at positions higher than the given
     * position are at the next lower position within the list,
     * and the list's size is decreased by 1.
     * @param givenPosition An integer that indicates the position of
     * the entry to be removed.
     * @return A reference to the removed entry.
     * @throws IndexOutOfBoundsException if either
     *    givenPosition less than 1, or
     *    givenPosition greater than getLength()+1.
     */
    public T remove(int givenPosition) {
        checkInitialization();
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            assert !isEmpty();
            T result = list[givenPosition];
            if (givenPosition < numberOfEntries) {
                removeGap(givenPosition);
            }
            numberOfEntries--;
            return result;
        }
        else {
            throw new IndexOutOfBoundsException(
                    "Illegal position given to remove operation.");
        }

    }


    /** Removes all entries from this list. */
    public void clear() {
        checkInitialization();
        for (int i = 1; i < getLength(); i++) {
            list[i] = null;
        }
        numberOfEntries = 0;
    }


    /** Replaces the entry at a given position in this list.
     * @param givenPosition An integer that indicates the position of the
     * entry to be replaced.
     * @param newEntry The object that will replace the entry at the
     * position givenPosition.
     * @return The original entry that was replaced.
     * @throws IndexOutOfBoundsException if either
     *    givenPosition less than 1, or
     *    givenPosition greater than getLength()+1.
     */
    public T replace(int givenPosition, T newEntry) {
        checkInitialization();
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            assert !isEmpty();
            T originalEntry = list[givenPosition];
            list[givenPosition] = newEntry;
            return originalEntry;
        }
        else {
            throw new IndexOutOfBoundsException(
                    "Illegal position given to replace operation.");
        }
    }


    /** Retrieves the entry at a given position in this list.
     * @param givenPosition An integer that indicates the position of
     * the desired entry.
     * @return A reference to the indicated entry.
     * @throws IndexOutOfBoundsException if either
     *    givenPosition less than 1, or
     *    givenPosition greater than getLength()+1.
     */
    public T getEntry(int givenPosition) {
        checkInitialization();
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            assert !isEmpty();
            return list[givenPosition];
        }
        else {
            throw new IndexOutOfBoundsException(
                    "Illegal position given to getEntry operation.");
        }
    }


    /** Sees whether this list contains a given entry.
     * @param anEntry The object that is the desired entry.
     * @return True if the list contains anEntry, or false if not.
     */
    public boolean contains(T anEntry) {
        checkInitialization();
        boolean found = false;
        int index = 1;
        while (!found && (index <= numberOfEntries)) {
            if (anEntry.equals(list[index])) {
                found = true;
            }
            index++;
        }
        return found;
    }


    /** Gets the length of this list.
     * @return The integer number of entries currently in the list.
     */
    public int getLength() {
        return numberOfEntries;
    }


    /** Sees whether this list is empty.
     * @return True if the list is empty, or false if not.
     */
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }


    /** Retrieves all entries that are in this list in the order in which
     they occur in the list.
     @return A newly allocated array of all the entries in the list.
     */
    public T[] toArray() {
        checkInitialization();
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries];
        for (int index = 0; index < numberOfEntries; index++) {
            result[index] = list[index + 1];
        }
        return result;
    }
} // end ListInterface