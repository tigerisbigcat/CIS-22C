//package Deque.DoublyLinked;
package com.company;
/**
   A driver that demonstrates the class LinkedDeque.
   
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 4.0
*/
public class Driver 
{
	public static void main(String[] args) 
	{
		testDequeOperations();
		System.out.println("\n\nDone.");
	}  // end main

	public static void testDequeOperations()
	{
		System.out.println("Create a deque: ");
		DequeInterface<String> myDeque = new LinkedDeque<>();
		System.out.println("\n\nisEmpty() returns " + myDeque.isEmpty() + "\n");
		
		System.out.println("Add to front and back of deque to get\n" +
		                   "Joe Jess Jim Jill Jane Jerry\n");
		myDeque.addToFront("Jim");
		myDeque.addToFront("Jess");

		myDeque.addToBack("Jill");
		myDeque.addToBack("Jane");

		myDeque.addToFront("Joe");
		myDeque.addToBack("Jerry");

		System.out.println("\nisEmpty() returns " + myDeque.isEmpty() + "\n");

		System.out.println("\n\nTesting getFront, getBack, removeFront, removeBack:\n");
		String front,  back;
		front = myDeque.getFront();
		System.out.println(front + " is at the front of the deque.");
		
		back = myDeque.getBack();   
		System.out.println(back + " is at the back of the deque.");					

		front = myDeque.removeFront();
		System.out.println(front + " is removed from the front of the deque.");
		
		back = myDeque.removeBack();
		System.out.println(back + " is removed from the back of the deque.");
		
		front = myDeque.getFront();
		System.out.println(front + " is at the front of the deque.");
		
		back = myDeque.getBack();   
		System.out.println(back + " is at the back of the deque.");	
		
		System.out.println("\n\nTesting clear:\n");
		myDeque.clear();
		System.out.println("\nisEmpty() returns " + myDeque.isEmpty() + "\n\n");
		
      System.out.println("The next calls will throw an exception." + "\n");
		front = myDeque.removeFront();
		front = myDeque.removeBack();
	} // end testDequeOperations
}  // end Driver

/*
 Create a deque:
 
 
 isEmpty() returns true
 
 Add to front and back of deque to get
 Joe Jess Jim Jill Jane Jerry
 
 
 isEmpty() returns false
 
 
 
 Testing getFront, getBack, removeFront, removeBack:
 
 Joe is at the front of the deque.
 Jerry is at the back of the deque.
 Joe is removed from the front of the deque.
 Jerry is removed from the back of the deque.
 Jess is at the front of the deque.
 Jane is at the back of the deque.
 
 
 Testing clear:
 
 
 isEmpty() returns true
 
 
 The next calls will throw an exception.
 
 Exception in thread "main" EmptyQueueException
	at LinkedDeque.getFront(LinkedDeque.java:60)
	at LinkedDeque.removeFront(LinkedDeque.java:67)
	at Driver.testDequeOperations(Driver.java:60)
	at Driver.main(Driver.java:12)
*/


