/*
 * A quick test class to check the operation of the bag class.

 */

/**
 *
 * @author Charles Hoot
 */
public class BagTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayBag<String> testBag = new ArrayBag<String>();

        System.out.println("Initial state:");
        report(testBag);
        System.out.println("\nAdd 6 strings to the bag");
        testBag.add("A");
        testBag.add("B");
        testBag.add("A");
        testBag.add("B");
        testBag.add("A");
        testBag.add("A");
        System.out.println("Bag is now:");
        report(testBag);
        System.out.println("\nRemove A and B from the bag");
        testBag.remove("A");
        testBag.remove("B");
        System.out.println("Bag is now ");
        report(testBag);

        System.out.println("\nRemove A and B from the bag");
        testBag.remove("A");
        testBag.remove("B");
        System.out.println("Bag is now ");
        report(testBag);

        System.out.println("\nRemove A and B from the bag");
        testBag.remove("A");
        testBag.remove("B");
        System.out.println("Bag is now ");
        report(testBag);

        System.out.println("\nRemove A and B from the bag");
        testBag.remove("A");
        testBag.remove("B");
        System.out.println("Bag is now ");
        report(testBag);

    }

    public static void report(ArrayBag<String> reportOn) {
        System.out.println("Bag contents" + reportOn);
        System.out.println("size is " + reportOn.getCurrentSize() + " and empty is " + reportOn.isEmpty());
        System.out.println("Frequency of A is " + reportOn.getFrequencyOf("A"));
        System.out.println("Frequency of B is " + reportOn.getFrequencyOf("B"));
        System.out.println("Frequency of D is " + reportOn.getFrequencyOf("D"));
        System.out.println("Bag contains A: " + reportOn.contains("A"));
        System.out.println("Bag contains B: " + reportOn.contains("B"));
        System.out.println("Bag contains D: " + reportOn.contains("D"));

    }

}
