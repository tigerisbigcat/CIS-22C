// 22C
// TTh 9:30-11:15
// Name : Lei Hao

package com.company;
import java.util.Scanner;

public class Palindrome {

    public static void main(String[] args) {

        System.out.print("Enter any string: ");
        Scanner in=new Scanner(System.in);
        String inputString = in.nextLine();
        LinkedStack stack = new LinkedStack();

        for (int i = 0; i < inputString.length(); i++) {
            stack.push(inputString.charAt(i));
        }

        String reverseString = "";

        while (!stack.isEmpty()) {
            reverseString = reverseString + stack.pop();
        }

        if (inputString.equals(reverseString))
            System.out.println("The input String is a palindrome.");
        else
            System.out.println("The input String is not a palindrome.");
    }

}
