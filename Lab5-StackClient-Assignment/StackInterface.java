package com.company;

import java.util.EmptyStackException;

/**
An interface that describes the operations of a stack of objects.
@author Frank M. Carrano
 * This code is from Chapter 5 of
 * Data Structures and Abstractions with Java 4/e
 *      by Carrano
 */
public interface StackInterface<T> {

    /** Adds a new entry to the top of this stack.
    @param newEntry An object to be added to the stack. */
    public void push(T newEntry);

    /** Removes and returns this stack’s top entry.
    @return  The object at the top of the stack.
    @throws EmptyStackException if the stack is empty before the operation. */
    public T pop();

    /** Retrieves this stack’s top entry.
    @return The object at the top of the stack or null if
    @throws EmptyStackException if the stack is empty. */
    public T peek();

    /** Detects whether this stack is empty.
    @return True if the stack is empty. */
    public boolean isEmpty();

    /** Removes all entries from this stack */
    public void clear();
} // end StackInterface
