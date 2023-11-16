package com.tts.generics;

import java.util.ArrayList;

public class GenericPractice {

	// Up until this point of the class, we have been creating methods that
	// expliclty return
	// a single data type. For example, we may have something like the following:
	public static int add(int n1, int n2) {
		return n1 + n2;
	}

	// If we want to create a method that returns a generic type - meaning it can
	// work with any
	// data type - we can provide angle brackets and a placeholder letter (like T
	// for type): <T> as a
	// prefix to the return type

	// We define the placeholder 'Generic' with the brackets and then follow it by
	// the return type (void)
	public static <T> void swap(T[] array, int i, int j) {
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String[] args) {
		double n1 = 10;
		double n2 = 15;

		// Can't do this because we explicitly told Java we take ints as input but
		// provided doubles
		// even though they can technically be added together like ints...
		// add(n1,n2);

		// What is the solution to creating more 'generic' methods and classes in Java?
		// The answer is something called a "Generic" - these allow you to write and use
		// generic classes, interfaces, and methods that work with different data types
		// while also ensuring type safety when you compile your program

		// You will typically use generics when you need a flexible and reusable piece
		// of code that can
		// work with different data types without compromising type safety

		// A huge example would be the Collections framework in general - take an
		// ArrayList as an example:
		ArrayList<String> myStudents = new ArrayList<>();

		String[] favShows = { "Breaking Bad", "The Boys", "One Punch Man", "Criminal Minds" };
		swap(favShows, 0, 2);

		for (String show : favShows) {
			System.out.print(show + ", ");
		}

		System.out.println();
		
		Integer[] favNums = { 12, 82, 100 };
		swap(favNums, 0, 1);

		for (Integer num : favNums) {
			System.out.print(num + ", ");
		}

		System.out.println();

		Box<String> myBox = new Box<>("Xbox Series X");
		
		System.out.println(myBox.getContent());
		
		
		Product nintendoWii = new Product("Wii", 100.0, true);
		
		Box<Product> myConsoleObject = new Box<>(nintendoWii);
		System.out.println(myConsoleObject.getContent());
		
		
		
		
		
	
	}

}
