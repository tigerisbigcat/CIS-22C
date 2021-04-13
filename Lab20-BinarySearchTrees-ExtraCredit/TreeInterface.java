package TreePackage;

/** An interface for the ADT Tree.
*
* This code is from Chapter 23 of
* Data Structures and Abstractions with Java 3/e
*      by Carrano
*/
    public interface TreeInterface<T>
{
    public T getRootData();
    public int getHeight();
    public int getNumberOfNodes();
    public boolean isEmpty();
    public void clear();
} // end TreeInterface