/**
 * An exception used to indicate an attempt to access an empty tree.
 * 
 * @author Charles Hoot
 * @version 4.0
 */

package TreePackage;

public final class EmptyTreeException extends RuntimeException {

    public EmptyTreeException(String s) {
        super(s);
    }
    
}
