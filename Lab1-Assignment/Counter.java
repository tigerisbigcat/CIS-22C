package com.company;

/**
 * The counter class implements a counter that will roll over to the initial
 * value when it hits the maximum value.
 * 
 * @author Charles Hoot 
 * @version 4.0
 */
public class Counter {
    // PUT PRIVATE DATA FIELDS HERE
    private int minimum;
    private int maximum;
    private int counter;
    private boolean rollOver;

    /**
     * The default constructor for objects of class Counter.  Minimum is 0 and the maximum
     * is the largest possible integer.
     */
    public Counter() {
        // ADD CODE FOR THE CONSTRUCTOR
        minimum = 0;
        maximum = 1000000000;
    }

    /**
     * The alternate constructor for objects of class Counter.  The minimum and maximum values are given as parameters.
     * The counter starts at the minimum value.
     * @param min The minimum value that the counter can have
     * @param max The maximum value that the counter can have
     * */
    public Counter(int min, int max) {
        // ADD CODE FOR THE ALTERNATE CONSTRUCTOR
        if (min > max) {
            throw new CounterInitializationException("min is greater than max");
        }

        if (min == max) {
            throw new CounterInitializationException("min is equal to max");
        }
        minimum = min;
        maximum = max;
        counter = min;
    }
    
    /**
     * Determine if two counters are in the same state
     *
     * @param  otherObject   the object to test against for equality
     * @return     true if the objects are in the same state
     */
    public boolean equals(Counter otherObject) {
        boolean result = true;
        if (otherObject instanceof Counter) {
            if (this.counter == otherObject.counter &&
                    this.maximum == otherObject.maximum &&
                    this.minimum == otherObject.minimum &&
                    this.rollOver == otherObject.rollOver) {
                result = true;
            }
            else {
                result = false;
            }
        }
        return result;
    }

    /**
     * Increases the counter by one
     */
    public void increase() {
        if (counter == maximum) {
            counter = minimum;
            rollOver = true;
        }
        else {
            counter++;
            rollOver = false;
        }
    }

     /**
     * Decreases the counter by one
     */
    public void decrease() {
        if (counter == minimum) {
            counter = maximum;
            rollOver = true;
        }
        else {
            counter--;
            rollOver = false;
        }
    }
    
    /**
     * Get the value of the counter
     *
     * @return     the current value of the counter
     */
    public int value() {
        // CHANGE THE RETURN TO GIVE THE CURRENT VALUE OF THE COUNTER
        return counter;
    }

    /**
     * Accessor that allows the client to determine if the counter
     *             rolled over on the last count
     *
     * @return     true if the counter rolled over
     */
    public boolean rolledOver() {
        // CHANGE THE RETURN TO THE ROLLOVER STATUS OF THE COUNTER
        return rollOver;
    }
    
    /**
     * Override the toString method to provide a more informative
     * description of the counter
     *
     * @return     a descriptive string about the object
     */
    public String toString() {
        if (rolledOver()) {
            return "[ Counter Minimum is " + minimum + ", Maximum is " + maximum +
                    "\n counter has the value " + value() +
                    "it has rolled over " + "]";
        }
        else {
            return "[ Counter Minimum is " + minimum + ", Maximum is " + maximum +
                    "\n  counter has the value " + value() +
                    "\n  it has not rolled over " + "]";
        }
    }
}
