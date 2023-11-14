package com.tts.errorhandling;

// To tell Java that we want this to be a custom Exception that we can throw
// inside of our very own programs, we have to make it extend (inherit from) the 'RuntimeException' class
// which makes this an 'Unchecked' Exception. To enforce it as a 'checked' Exception, we can have it
// extend the Exception class
public class InvalidAgeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int invalidAge;

	public InvalidAgeException(int age) {
		super("Invalid age: " + age + ". Age must be between 0 and 120.");
		this.invalidAge = age;
	}

	public int getInvalidAge() {
		return this.invalidAge;
	}

}
