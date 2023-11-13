package com.tts.datastructures;

import java.util.Arrays;

public class ArrayPractice {

	public static void printArray(int[] array) {
		System.out.print("[");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ", ");
		}
		System.out.print("]\n");
	}

	public static void printArray(String[] array) {
		System.out.print("[");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ", ");
		}
		System.out.print("]\n");
	}

	// Up until this point, we've kind of breezed over
	// this whole String[] syntax. When we put brackets next
	// to a data type, we are telling Java that it is a
	// data structure called an array:
	// an ordered collection of data of fixed length of the specified datatype
	public static void main(String[] args) {

		// datatype[] specifies that we want an array of that datatype
		// Need to create a new array object where each of the 6 allotted spaces
		// MUST be an int
		// If not specified, those 6 spaces will hold nothing and we would need
		// to set them manually
		int[] myFavoriteNums = new int[6];

		printArray(myFavoriteNums);

		// Set a new value for one of our 6 available spaces, we can use
		// the square brackets along with the index of the space we want to manipulate

		// Change the third spot in our array to 82 (because arrays are 0-indexed)
		myFavoriteNums[2] = 82;

		printArray(myFavoriteNums);

		// What if we wanted to create an array with already pre-filled values?

		// We can use curly braces and comma separated values to create a pre-defined
		// array that will automatically set the fixed length to the number of items
		// inside of it

		// This creates an array of Strings that only has 3 slots in it:
		// all of the values have been filled in already:
		String[] favFruits = { "Apple", "Blueberry", "Strawberry" };

		printArray(favFruits);

		// What happens if we try to modify the 3rd index (4th item) in our fruits
		// array?
		// favFruits[3] = "Kiwi"; // Throws an exception from Java saying that it has no
		// space for "Kiwi" since we specified we only wanted 3 items to begin with.

		// As you just saw with the weird printing behavior of arrays,
		// they are actually primitive with Java. Inside of Java.util, however,
		// there exists an Arrays class with a bunch of static methods that
		// are able to do a bunch of cool methods using arrays you define:

		int[] unorderedArray = { 4, 10, 2, 2, 132, 53, 12000 };
		// Can call the static .sort() method on the Arrays class:
		// Sorts in place and we can choose from a series of different sorting algorithms
		Arrays.sort(unorderedArray);
		printArray(unorderedArray);
		
		// Can look for items in primitive array using algorithms like binarySearch:
		System.out.println(Arrays.binarySearch(unorderedArray, 53));
		
	}

}
