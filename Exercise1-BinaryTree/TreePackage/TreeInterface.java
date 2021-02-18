/**
   An interface of basic methods for the ADT tree.
   
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 4.0
*/
package TreePackage;
public interface TreeInterface<T>
{
   public T getRootData();
   public int getHeight();
   public int getNumberOfNodes();
   public boolean isEmpty();
   public void clear();
} // end TreeInterface
