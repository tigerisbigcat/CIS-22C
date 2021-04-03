// 22C
// TTh 9:30-11:15
// Name : Lei Hao
// Lab17 Hash Table Implementation

import java.util.*;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class HashedDictionaryOpenAddressingPerfectInstrumented<K, V> implements DictionaryInterface<K, V>  {
    private static int totalProbes = 0;

    public static void resetTotalProbes() {
        totalProbes = 0;
    }

    public static int getTotalProbes() {
        return totalProbes;
    }

    // The dictionary:
    private int numberOfEntries;
    private static final int DEFAULT_CAPACITY = 5; // Must be prime
    private static final int MAX_CAPACITY = 10000;

    // The hash table:
    private TableEntry<K, V>[] hashTable; // Dictionary entries
    private int tableSize;                          // Must be prime
    private static final int MAX_SIZE = 2 * MAX_CAPACITY;
    private boolean initialized = false;


    // fraction of hash table that can be filled
    // In the original code this was static final, but we want to be able
    // to change it for our timings.
    private double MAX_LOAD_FACTOR = 0.5;

    public HashedDictionaryOpenAddressingPerfectInstrumented()
    {
        this(DEFAULT_CAPACITY); // Call next constructor
    } // end default constructor


    public HashedDictionaryOpenAddressingPerfectInstrumented(int initialCapacity)
    {
        checkCapacity(initialCapacity);
        numberOfEntries = 0;

        // Set up hash table:
        // Initial size of hash table is same as initialCapacity if it is prime
        // otherwise increase it until it is prime size
        tableSize = getNextPrime(initialCapacity);
        checkSize(tableSize);  // Check for max array size

        // The case is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        TableEntry<K, V>[] temp = (TableEntry<K, V>[]) new TableEntry[tableSize];
        hashTable = temp;
        initialized = true;
    } // end constructor


    /** Throws an exception if this object is not initialized.*/
    private void checkInitialization()
    {
        if (!initialized)
            throw new SecurityException("ArrayBag object is not initialized " +
                    "properly.");
    }

    /** Throws an exception if the desired capacity is too large.*/
    private void checkCapacity(int desiredCapacity)
    {
        if (desiredCapacity > MAX_CAPACITY)
            throw new IllegalStateException("Attempt to create a hash table " +
                    "whose capacity exceeds " +
                    "allowed maximum.");
    }

    /** Throws an exception if the desired array size is too large.*/
    private void checkSize(int desiredSize)
    {
        if (desiredSize > MAX_SIZE)
            throw new IllegalStateException("Attempt to create a hash table " +
                    "array whose size exceeds " +
                    "allowed maximum.");
    }

    // New method to change the load factor.
    public void setMaxLoadFactor(double loadFactor)
    {
        MAX_LOAD_FACTOR = loadFactor;
    } // end setMaxLoadFactor


    private Random getHashGenerator(Object key) {
        int val = key.toString().hashCode();
        val = Math.abs(val);
        Random generator = new Random(val);
        return generator;
    }

    public V getValue(K key) {
        checkInitialization();
        V result = null;
        Random generator = getHashGenerator(key);
        int index = locate(generator, key);
        if (index != -1) {
            result = hashTable[index].getValue();
        }
        return result;
    }

    @Override
    public boolean contains(K key)
    {
        boolean result = false;
        Random generator = getHashGenerator(key);
        int index = locate(generator, key);

        if (index != -1)
            result = true; // key found; return true
        // else key not found; return false
        return result;
    } // end contains

    @Override
    public Iterator<K> getKeyIterator()
    {
        return new KeyIterator();
    } // end getKeyIterator

    @Override
    public Iterator<V> getValueIterator()
    {
        return new ValueIterator();
    } // end getValueIterator

    @Override
    public boolean isEmpty()
    {
        return numberOfEntries == 0;
    } // end isEmpty


    @Override
    public int getSize()
    {
        return numberOfEntries;
    } // end getSize

    @Override
    public void clear()
    {
        hashTable =  new TableEntry[hashTable.length];   // use the old table size
        numberOfEntries = 0;
    }


    @Override
    public V add(K key, V value) {
        checkInitialization();

        if ((key == null) || (value == null)) {
            throw new IllegalArgumentException();
        }
        else {
            V oldValue; // Value to return
            Random generator = getHashGenerator(key);
            int index = probe(generator, key);
            assert (index >= 0) && (index < hashTable.length);
            if (hashTable[index] == null || hashTable[index].isRemoved()) {
                hashTable[index] = new TableEntry<>(key, value);
                numberOfEntries++;
                oldValue = null;
            }
            else {
                oldValue = hashTable[index].getValue();
                hashTable[index].setValue(value);
            }
            if (isHashTableTooFull()) {
                enlargeHashTable();
            }
            return oldValue;
        }
    }

    public V remove(K key) {
        checkInitialization();
        V removedValue = null;
        Random generator = getHashGenerator(key);
        int index = locate(generator, key);
        if (index != -1) {
            removedValue = hashTable[index].getValue();
            hashTable[index].setToRemoved();
            numberOfEntries--;
        }
        return removedValue;
    }

    private int locate(Random generator, Object key) {
        boolean found = false;
        int index = generator.nextInt(hashTable.length);
        while (!found && (hashTable[index] != null)) {
            if (hashTable[index].isIn() && key.equals(hashTable[index].getKey())) {
                found = true;
            }
            else {
                index = generator.nextInt(hashTable.length);
            }
            totalProbes++;
        }
        if (!found) {
            totalProbes++;
        }
        int result = -1;
        if (found) {
            result = index;
        }
        return result;
    }

    private int probe(Random generator, Object key) {
        boolean found = false;
        int index = generator.nextInt(hashTable.length);
        int removedStateIndex = -1;
        while (!found && (hashTable[index] != null)) {
            if (hashTable[index].isIn()) {
                if (key.equals(hashTable[index].getKey())) {
                    found = true;
                }
                else {
                    index = generator.nextInt(hashTable.length);
                }
            }
            else {
                if (removedStateIndex == -1) {
                    removedStateIndex = index;
                }
                index = generator.nextInt(hashTable.length);
            }
            totalProbes++;
        }
        if (!found) {
            totalProbes++;
        }
        if (found || (removedStateIndex == -1)) {
            return index;
        }
        else {
            return removedStateIndex;
        }
    }

    // Precondition: checkInitialization has been called.
    private void enlargeHashTable()
    {
        TableEntry<K,V>[] oldTable = hashTable;
        int oldSize = hashTable.length;
        int newSize = getNextPrime(oldSize + oldSize);

        // The case is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        TableEntry<K, V>[] temp = (TableEntry<K, V>[]) new TableEntry[newSize];
        hashTable = temp;
        numberOfEntries = 0; // Reset size of dictionary, since it will be
        // incremented by add during rehash

        // Rehash dictionary entries from old array to the new and bigger
        // array; skip both null locations and removed entries
        for (int index = 0; index < oldSize; index++)
        {
            if ( (oldTable[index] != null) && oldTable[index].isIn() )
                add(oldTable[index].getKey(), oldTable[index].getValue());
        } // end for
    } // end enlargeHashTable

    private class TableEntry<S,T>
    {
        private S key;
        private T value;
        private boolean inTable; // true if entry is in hash table

        private TableEntry(S searchKey, T dataValue)
        {
            key = searchKey;
            value = dataValue;
            inTable = true;
        } // end constructor

        private T getValue(){
            return value;
        } // end getValue

        private void setValue(T x){
            value =x;
        } // end setValue

        private S getKey(){
            return key;
        } // end getKey

        private void setKey(S k){
            key = k;
        } // end setKey

        private void setToRemoved(){
            inTable = false;
        } // end setToRemoved

        private boolean isIn(){
            return inTable;
        } // end isIn

        private boolean isRemoved(){
            return !inTable;
        } // end isRemoved
    } // end TableEntry


    private class KeyIterator implements Iterator<K>
    {
        private int currentIndex; // Current position in hash table
        private int numberLeft; // Number of entries left in iteration

        private KeyIterator()
        {
            currentIndex = 0;
            numberLeft = numberOfEntries;
        } // end default constructor

        @Override
        public boolean hasNext()
        {
            return numberLeft > 0;
        } // end hasNext

        @Override
        public K next()
        {
            K result = null;
            if (hasNext())
            {
                // Skip table locations that do not contain a current entry
                while ( (hashTable[currentIndex] == null) ||
                        hashTable[currentIndex].isRemoved() )
                {
                    currentIndex++;
                } // end while

                result = hashTable[currentIndex].getKey();
                numberLeft--;
                currentIndex++;
            }
            else
                throw new NoSuchElementException();

            return result;
        } // end next

        @Override
        public void remove()
        {
            throw new UnsupportedOperationException();
        } // end remove

    } // end KeyIterator

    private boolean isHashTableTooFull() {
        return numberOfEntries > MAX_LOAD_FACTOR*hashTable.length;
    }

    private int getNextPrime(int t)
    {
        t = getNextOdd(t);      // get the next odd

        while(!isOddPrime(t))
        {
            t+= 2;              // try odds until a prime is found
        }

        return t;
    } // end getNextPrime

    private int getNextOdd(int t)
    {
        if(t%2 == 0)
            return t+1;
        else
            return t;
    } // end getNextOdd

    // Precondition: t is an odd value
    private boolean isOddPrime(int t)  // Not the most efficient method, but it will serve
    {
        int test = 3;
        boolean foundFactor = false;
        while(test*test < t && !foundFactor)
        {
            foundFactor = (t%test == 0);    // is it divisible by test
            test += 2;
        }

        return !foundFactor;
    } // end getNextPrime

    private class ValueIterator implements Iterator<V>
    {
        private int currentIndex; // current position in hash table
        private int numberLeft; // number of entries left in iteration

        private ValueIterator()
        {
            currentIndex = 0;
            numberLeft = numberOfEntries;
        } // end default constructor

        @Override
        public boolean hasNext()
        {
            return numberLeft > 0;
        } // end hasNext

        @Override
        public V next()
        {
            V result = null;
            if (hasNext())
            {
                // Skip table locations that do not contain a current entry
                while ( (hashTable[currentIndex] == null) ||
                        hashTable[currentIndex].isRemoved() )
                {
                    currentIndex++;
                } // end while

                result = hashTable[currentIndex].getValue();
                numberLeft--;
                currentIndex++;
            }
            else
                throw new NoSuchElementException();

            return result;
        } // end next

        @Override
        public void remove()
        {
            throw new UnsupportedOperationException();
        } // end remove
    } // end ValueIterator
}
