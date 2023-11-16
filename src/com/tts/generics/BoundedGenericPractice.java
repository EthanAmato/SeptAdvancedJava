package com.tts.generics;

// Sometimes you may want to create a class or a method that can take some types of data as input / return type
// but not others.
// For example, you may have a mathematical operation that should be able to take in any of the numbers (Long,
// Integer, Byte, Double, Float, etc.) but wouldn't be able to handle adding things like Scanners - just doesn't make
// sense.
// You can address / enforce limitations on what types of objects can be passed to a generic method/class
// using something called BoundedGenerics

public class BoundedGenericPractice {

	// To enforce only a subset of types that have a class in common,
	// we can use T extends that class we want to restrict by:
	// This enforces our method calls to only provide Ts that inherit from the
	// Number class
	// this would include classes like Byte, Long, Float, Double, Integer, Short
	public static <T extends Number> double add(T n1, T n2) {
		return n1.doubleValue() + n2.doubleValue();
	}

	public static void main(String[] args) {

		Boolean myTrue = true;
		Boolean myFalse = false;

		// Boolean not inheriting from Number, therefore we can't call add() with it
		// add(myTrue, myFalse);

		Integer myNum = 120;
		Integer mySecondNum = 502;
		System.out.println(add(myNum, mySecondNum));

		Double myDouble = 1452.24d;
		Double mySecondDouble = 5013.212d;

		System.out.println(add(myDouble, mySecondDouble));

	}
}
