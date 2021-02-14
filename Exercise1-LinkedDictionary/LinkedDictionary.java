package com.company;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedDictionary<K, V> implements DictionaryInterface<K, V>
{
    private Node firstNode; // Reference to first node of chain
    private int numberOfEntries;

    public LinkedDictionary()
    {
        initializeDataFields();
    } // end default constructor


    /** Adds a new entry to this dictionary. If the given search key already
     exists in the dictionary, replaces the corresponding value.
     @param key    An object search key of the new entry.
     @param value  An object associated with the search key.
     @return  Either null if the new entry was added to the dictionary
     or the value that was associated with key if that value
     was replaced. */
    public V add(K key, V value) {
        V result = null;
        Node currentNode = firstNode;
        while ((currentNode != null) && !key.equals(currentNode.getKey())) {
            currentNode = currentNode.getNextNode();
        }
        if (currentNode == null) {
            Node newNode = new Node(key, value);
            newNode.setNextNode(firstNode);
            firstNode = newNode;
            numberOfEntries++;
        }
        else {
            result = currentNode.getValue();
            currentNode.setValue(value);
        }
        return result;
    }

    /** Removes a specific entry from this dictionary.
     @param key  An object search key of the entry to be removed.
     @return  Either the value that was associated with the search key
     or null if no such object exists. */

    public V remove(K key) {
        V result = null;

        if (!isEmpty()) {
            Node currentNode = firstNode;
            Node nodeBefore = null;
            while ((currentNode != null) && !key.equals(currentNode.getKey())) {
                nodeBefore = currentNode;
                currentNode = currentNode.getNextNode();
            }
            if (currentNode != null) {
                Node nodeAfter = currentNode.getNextNode();
                if (nodeBefore == null) {
                    firstNode = nodeAfter;
                }
                else {
                    nodeBefore.setNextNode(nodeAfter);
                }
                result = currentNode.getValue();
                numberOfEntries--;
            }
        }
        return result;
    }


    /** Retrieves from this dictionary the value associated with a given
     search key.
     @param key  An object search key of the entry to be retrieved.
     @return  Either the value that is associated with the search key
     or null if no such object exists. */
    public V getValue(K key) {
        V result = null;
        Node currentNode = firstNode;
        while ((currentNode != null) && !key.equals(currentNode.getKey())) {
            currentNode = currentNode.getNextNode();
        }
        if (currentNode != null) {
            result = currentNode.getValue();
        }
        return result;
    }

    /** Sees whether a specific entry is in this dictionary.
     @param key  An object search key of the desired entry.
     @return  True if key is associated with an entry in the dictionary. */
    public boolean contains(K key) {
        return getValue(key) != null;
    }

    /** Creates an iterator that traverses all search keys in this dictionary.
     @return  An iterator that provides sequential access to the search
     keys in the dictionary. */
    public Iterator<K> getKeyIterator() {
        return new KeyIterator();
    }

    /** Creates an iterator that traverses all values in this dictionary.
     @return  An iterator that provides sequential access to the values
     in this dictionary. */
    public Iterator<V> getValueIterator() {
        return new ValueIterator();
    }

    /** Sees whether this dictionary is empty.
     @return  True if the dictionary is empty. */
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    /** Gets the size of this dictionary.
     @return  The number of entries (key-value pairs) currently
     in the dictionary. */
    public int getSize() {
        return numberOfEntries;
    }

    /** Removes all entries from this dictionary. */
    public void clear() {
        initializeDataFields();
    }

    // Same as in SortedLinkedDictionary.
// Since iterators implement Iterator, methods must be public.
    private class KeyIterator implements Iterator<K>
    {
        private Node nextNode;

        private KeyIterator()
        {
            nextNode = firstNode;
        } // end default constructor

        public boolean hasNext()
        {
            return nextNode != null;
        } // end hasNext

        public K next()
        {
            K result;

            if (hasNext())
            {
                result = nextNode.getKey();
                nextNode = nextNode.getNextNode();
            }
            else
            {
                throw new NoSuchElementException();
            } // end if

            return result;
        } // end next

        public void remove()
        {
            throw new UnsupportedOperationException();
        } // end remove
    } // end KeyIterator

    private class ValueIterator implements Iterator<V>
    {
        private Node nextNode;

        private ValueIterator()
        {
            nextNode = firstNode;
        } // end default constructor

        public boolean hasNext()
        {
            return nextNode != null;
        } // end hasNext

        public V next()
        {
            V result;

            if (hasNext())
            {
                result = nextNode.getValue();
                nextNode = nextNode.getNextNode();
            }
            else
            {
                throw new NoSuchElementException();
            } // end if

            return result;
        } // end next

        public void remove()
        {
            throw new java.lang.UnsupportedOperationException();
        } // end remove
    } // end getValueIterator

    private void initializeDataFields() {
        firstNode = null;
        numberOfEntries = 0;
    }


    private class Node
    {
        private K key;
        private V value;
        private Node next;

        private Node(K searchKey, V dataValue)
        {
            key = searchKey;
            value = dataValue;
            next = null;
        } // end constructor

        private Node(K searchKey, V dataValue, Node nextNode)
        {
            key = searchKey;
            value = dataValue;
            next = nextNode;
        } // end constructor

        private K getKey()
        {
            return key;
        } // end getKey

        private V getValue()
        {
            return value;
        } // end getValue

        private void setValue(V newValue)
        {
            value = newValue;
        } // end setValue

        private Node getNextNode()
        {
            return next;
        } // end getNextNode

        private void setNextNode(Node nextNode)
        {
            next = nextNode;
        } // end setNextNode
    } // end Node

} // end LinkedDictionary