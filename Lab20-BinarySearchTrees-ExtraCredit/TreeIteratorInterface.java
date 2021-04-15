package TreePackage;

/** An interface for the ADT Tree Iterator.
*
* This code is from Chapter 23 of
* Data Structures and Abstractions with Java 4/e
*      by Carrano
*/
import java.util.Iterator;
public interface TreeIteratorInterface<T>
{
    public Iterator<T> getPreorderIterator();
    public Iterator<T> getPostorderIterator();
    public Iterator<T> getInorderIterator();
    public Iterator<T> getLevelOrderIterator();
} // end TreeIteratorInterface
