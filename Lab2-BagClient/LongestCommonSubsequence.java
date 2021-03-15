// 22C
// TTh 9:30-11.15
// Name : Lei Hao
// Lab2 Bag Client

import java.io.*;
import java.util.*;

/**
 * LongestCommonSubsequence is a program that will determine the longest string that is 
 * a subsequence of two input strings. This program applies a brute force solution technique.
 * 
 * @author Charles Hoot
 * @version 4.0
 */
public class LongestCommonSubsequence {

    public static void main(String args[]) {
        BagInterface<String> toCheckContainer = null;

        Scanner input;
        input = new Scanner(System.in);

        System.out.println("This program determines the longest string that is a subsequence of two input string.");
        System.out.println("Please enter the first string:");
        String first = input.next();

        System.out.println("Please enter the second string:");
        String second = input.next();

        // ADD CODE HERE TO CREATE THE BAG WITH THE INITIAL STRING
        // In main create a new bag and assign it to toCheckContainer. Add in the string first.
        BagInterface<String> containBag = new ArrayBag<>();
        containBag.add(first);
        toCheckContainer = containBag;
        toCheckContainer.toString();

        System.out.println("The strings to check are: " + toCheckContainer);
        String bestSubsequence = new String("");

        // Remove an item from toCheckContainer and store it in an String variable.
        bestSubsequence = toCheckContainer.remove();

        // ADD CODE HERE TO CHECK THE STRINGS IN THE BAG
        boolean isSubsequence = isSubsequence(bestSubsequence, second);
        if (isSubsequence) {
            System.out.println("Found " + bestSubsequence + " for the longest common subsequence "
                    + second);
        }
        else {
            System.out.println("Didn't find any subsequence.");
        }
    }

    /**
     * Determine if one string is a subsequence of the other.
     *
     * @param check See if this is a subsequence of the other argument.
     * @param against The string to check against.
     * @return     A boolean if check is a subsequence of other. 
     */
    public static boolean isSubsequence(String check, String against) {
        boolean result = false;
        // ADD CODE HERE TO CHECK IF WE HAVE A SUBSEQUENCE
        int indexInCheck = 0;
        //if (against.length() >= check.length()) {
        for (int indexInAgainst = 0; indexInAgainst < against.length(); indexInAgainst++) {

            // If char found move to next char
            if (check.charAt(indexInCheck) == against.charAt(indexInAgainst)) {
                ++indexInCheck;
            }

            // Equal means all the characters of check are
            // found in against in order
            if (indexInCheck == check.length()) {
                result = true;
                return result;
            }
        }
        return result;
    }
}