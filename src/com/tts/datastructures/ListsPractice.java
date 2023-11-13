package com.tts.datastructures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

public class ListsPractice {

	public static void main(String[] args) {
		// Inside of Java we are provided a couple of types of lists:
		// A list is an ordered, mutable collection of items that allows for duplicate
		// elements

		// The primary type of List that we use from Java.util is the
		// ArrayList

		// This is the data structure that builds upon Arrays
		// but it overcomes the size limitations of an array by
		// being dynamically resized based on the amount of elements
		// inside of it -> you will not run into problems if you add extra
		// elements because under the hood, Java will resize the array so you always
		// have extra space for new data:
		ArrayList<String> books = new ArrayList<String>();
		books.add("Java Basics");
		books.add("Advanced Java");
		books.add("Design Patterns");
		System.out.println(books);

		// Can remove based on Object value or by index (which are both required
		// by List interface)
		books.remove("Java Basics");
		System.out.println(books);
//		Can do an enhanced for loop with an ArrayList due to it being
		// forced to implement the 'Iterable' interface
		for (String book : books) {
			System.out.println("Enhanced For Loop: " + book);
		}

		// Good for something like forEach in Javascript -> perform operation on each
		// element if necessary
//		books.forEach(null);

		// Clear the array
		books.clear();

		books.isEmpty();

		// ArrayLists are dynamic, resizable arrays and are useful when the number
		// of elements that you may need for a given operation is not known in advance
		// or might change

		// Sometimes it is necessary to choose a different implementation
		// of a list based on your use case.

		// Let's say that we are working with a use case that requires removing
		// from the beginning of the array quite often:
		// LinkedLists can handle this in O(1) time thanks to how they work under the
		// hood
		// (see the excalidraw / SinglyLinkedList implementation in this project)

		// In practice, the syntax for using a LinkedList is virtually identical
		// to an ArrayList:

		LinkedList<String> textbooks = new LinkedList<>();
		// same method name as ArrayList but COMPLETELY different implementation
		// Example of abstraction and of polymorphism
		textbooks.add("Intro to Calculus");
		textbooks.add("Zoology for Dummies");
		textbooks.add("Advanced Underwater Basket Weaving");
		System.out.println("LinkedLists:");
		System.out.println(textbooks);

		
		for (String textbook : textbooks) {
			System.out.println("Enhanced For Loop: " + textbook);
		}
		
		textbooks.clear();

//		textbooks.sort(null);

		textbooks.isEmpty();

		// Vector -> is a type of list that is safe for multithreaded code
		// this means when you have multiple processes running in parallel,
		// this Data structure will be accessed and modified in a safe manner
		// 'thread-safe'
		Vector<String> employees = new Vector<>();
		employees.add("Jerry");
		employees.add("Samantha");
		employees.add("Jasmine");

		System.out.println(employees);

	}

}
