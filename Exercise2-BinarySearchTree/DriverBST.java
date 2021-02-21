
import TreePackage.SearchTreeInterface;

import java.util.Iterator;
/** 
   A driver that demonstrates the class BinarySearchTree.
   
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 4.0
*/
public class DriverBST 
{
	private static final String dirk    = "Dirk";
	private static final String abel    = "Abel";
  private static final String miguel  = "Miguel";
	private static final String tabatha = "Tabatha";
	private static final String tom     = "Tom";
	private static final String sam     = "Sam";
	private static final String reiss   = "Reiss";
	private static final String bette   = "Bette";
	private static final String carole  = "Carole";
	private static final String derek   = "Derek";
	private static final String nancy   = "Nancy";
	private static final String sue     = "Sue";
	private static final String amy     = "Amy";

	public static void main(String[] args) 
	{
		SearchTreeInterface<String> aTree = createTree(); // Tests add
		testTreeOperations(aTree);                        // Tests isEmpty, getRootData, getHeight, and getNumberOfNodes
      traverse(aTree);                                  // Tests getInorderIterator
		testSearchTreeOperations(aTree);                  // Tests getEntry, contains, and remove
		System.out.println("Done.");
	}  // end main

   /** Tests add. */
	public static SearchTreeInterface<String> createTree()
	{
		System.out.println("\n\nCreating a binary search tree:");
		SearchTreeInterface<String> aTree = new BinarySearchTree<>();
		System.out.println("Initial tree should be empty; isEmpty() returns " + aTree.isEmpty());

      // Test add
		System.out.println("\n\nTesting add():\n");
		System.out.println("Adding Dirk:           return " + aTree.add(dirk)    + " (should be null)");
		System.out.println("Adding Abel:           return " + aTree.add(abel)    + " (should be null)");
		System.out.println("Adding Miguel:         return " + aTree.add(miguel)  + " (should be null)");
		System.out.println("Adding Tabatha:        return " + aTree.add(tabatha) + " (should be null)");
		System.out.println("Adding Tom:            return " + aTree.add(tom)     + " (should be null)");
		System.out.println("Adding Sam:            return " + aTree.add(sam)     + " (should be null)");
		System.out.println("Adding Reiss:          return " + aTree.add(reiss)   + " (should be null)");
		System.out.println("Adding Bette:          return " + aTree.add(bette)   + " (should be null)");
		System.out.println("Adding Carole:         return " + aTree.add(carole)  + " (should be null)");
		System.out.println("Adding Derek:          return " + aTree.add(derek)   + " (should be null)");
		System.out.println("Adding Nancy:          return " + aTree.add(nancy)   + " (should be null)");
		System.out.println("Adding Sue:            return " + aTree.add(sue)     + " (should be null)");
		System.out.println("Adding Amy:            return " + aTree.add(amy)     + " (should be null)");
		System.out.println("Adding duplicate Dirk: return " + aTree.add("Dirk")  + " (should be Dirk)");
		return aTree;
	} // end createTree
   
   /** Displays the tree's nodes using an inorder traversal. */
	public static void traverse(SearchTreeInterface<String> bst)
	{
		Iterator<String> traverser = bst.getInorderIterator();
		
		while (traverser.hasNext())
			System.out.println(traverser.next());
		System.out.println();
	} // end traverse
   
   /** Tests isEmpty, getRootData, getHeight, and getNumberOfNodes. */
	public static void testTreeOperations(SearchTreeInterface<String> aTree)
	{
      System.out.println("\n\nTesting isEmpty, getRootData, getHeight, and getNumberOfNodes:\n");
		if (aTree.isEmpty())
			System.out.println("Tree is empty, but should not be.");
		else
			System.out.println("Tree is not empty.");
		
		// Display root, height, number of nodes
		System.out.println("Root of tree is "   + aTree.getRootData()      + " (should be Dirk)");
		System.out.println("Height of tree is " + aTree.getHeight()        + " (should be 6)");
		System.out.println("Tree has "          + aTree.getNumberOfNodes() + " nodes (should be 13)");
	
	} // end testTreeOperations
	
   /** Tests getEntry, contains, and remove. */
   public static void testSearchTreeOperations(SearchTreeInterface<String> aTree)
   {
      testGetEntry(aTree);
      testContains(aTree);
      testRemove(aTree);
   } // end testSearchTreeOperations
   
   // Tests getEntry.
	private static void testGetEntry(SearchTreeInterface<String> aTree)
	{
		
		System.out.println("\n\nTesting getEntry():\n");
		System.out.println("\nGetting Abel:    return " + aTree.getEntry("Abel")    + " (should be Abel)");
		System.out.println("\nGetting Sam:     return " + aTree.getEntry(sam)       + " (should be Sam)");
		System.out.println("\nGetting Tom:     return " + aTree.getEntry(tom)       + " (should be Tom)");
		System.out.println("\nGetting Reiss:   return " + aTree.getEntry(reiss)     + " (should be Reiss)");
		System.out.println("\nGetting Miguel:  return " + aTree.getEntry(miguel)    + " (should be Miguel)");
		System.out.println("\nGetting Phantom: return " + aTree.getEntry("Phantom") + " (should be null)");
   } // end testGetEntry
   
   // Test contains.
   private static void testContains(SearchTreeInterface<String> aTree)
   {
		System.out.println("\n\n\nTesting contains():\n");

		if ( aTree.contains("Sam") )
			System.out.println("\nSam is in tree - OK");
		else 
			System.out.println("Error in contains()");
		
		if ( aTree.contains(abel) )
			System.out.println("\nAbel is in tree - OK");
		else 
			System.out.println("Error in contains()");
		
		if ( aTree.contains(miguel) )
			System.out.println("\nMiguel is in tree - OK");
		else 
			System.out.println("Error in contains()");
		
		if ( aTree.contains(tom) )
			System.out.println("\nTom is in tree - OK");
		else 
			System.out.println("Error in contains()");

		if (!aTree.contains("Dave"))
			System.out.println("\nDave is not in tree - OK");
		else 
			System.out.println("Error in contains()");
   } // end testContains
   
   // Test remove.
	private static void testRemove(SearchTreeInterface<String> aTree)
	{
    System.out.println("\n\n\nTesting remove():\n");
		System.out.println("Removing Nancy:   return " + aTree.remove("Nancy") + " (should be Nancy)");  // leaf
		System.out.println("Removing Derek:   return " + aTree.remove(derek)   + " (should be Derek)");  // leaf
		System.out.println("Removing Abel:    return " + aTree.remove(abel)    + " (should be Abel)");   // one child
		System.out.println("Removing Dirk:    return " + aTree.remove(dirk)    + " (should be Dirk)");   // two children
		System.out.println("Removing Sam:     return " + aTree.remove(sam)     + " (should be Sam)");    // one child
		System.out.println("Removing Tabatha: return " + aTree.remove(tabatha) + " (should be Tabatha)");// two children
		System.out.println("Removing Dave:    return " + aTree.remove("Dave")  + " (should be null)");   // missing

		System.out.println("\n\nThe tree contains " + aTree.getNumberOfNodes() + " (should be 7) items, as follows:\n");
		traverse(aTree);
	} // end testRemove
}  // end DriverBST

/*
 
 
 Creating a binary search tree:
 Initial tree should be empty; isEmpty() returns true
 
 
 Testing add():
 
 Adding Dirk:           return null (should be null)
 Adding Abel:           return null (should be null)
 Adding Miguel:         return null (should be null)
 Adding Tabatha:        return null (should be null)
 Adding Tom:            return null (should be null)
 Adding Sam:            return null (should be null)
 Adding Reiss:          return null (should be null)
 Adding Bette:          return null (should be null)
 Adding Carole:         return null (should be null)
 Adding Derek:          return null (should be null)
 Adding Nancy:          return null (should be null)
 Adding Sue:            return null (should be null)
 Adding Amy:            return null (should be null)
 Adding duplicate Dirk: return Dirk (should be Dirk)
 
 
 Testing isEmpty, getRootData, getHeight, and getNumberOfNodes:
 
 Tree is not empty.
 Root of tree is Dirk (should be Dirk)
 Height of tree is 6 (should be 6)
 Tree has 13 nodes (should be 13)
 Abel
 Amy
 Bette
 Carole
 Derek
 Dirk
 Miguel
 Nancy
 Reiss
 Sam
 Sue
 Tabatha
 Tom
 
 
 
 Testing getEntry():
 
 
 Getting Abel:    return Abel (should be Abel)
 
 Getting Sam:     return Sam (should be Sam)
 
 Getting Tom:     return Tom (should be Tom)
 
 Getting Reiss:   return Reiss (should be Reiss)
 
 Getting Miguel:  return Miguel (should be Miguel)
 
 Getting Phantom: return null (should be null)
 
 
 
 Testing contains():
 
 
 Sam is in tree - OK
 
 Abel is in tree - OK
 
 Miguel is in tree - OK
 
 Tom is in tree - OK
 
 Dave is not in tree - OK
 
 
 
 Testing remove():
 
 Removing Nancy:   return Nancy (should be Nancy)
 Removing Derek:   return Derek (should be Derek)
 Removing Abel:    return Abel (should be Abel)
 Removing Dirk:    return Dirk (should be Dirk)
 Removing Sam:     return Sam (should be Sam)
 Removing Tabatha: return Tabatha (should be Tabatha)
 Removing Dave:    return null (should be null)
 
 
 The tree contains 7 (should be 7) items, as follows:
 
 Amy
 Bette
 Carole
 Miguel
 Reiss
 Sue
 Tom
 
 Done.
*/
