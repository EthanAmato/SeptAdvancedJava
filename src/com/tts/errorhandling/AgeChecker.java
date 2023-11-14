package com.tts.errorhandling;

public class AgeChecker {

	public static void checkAge(int age) {
		if(age < 0 || age > 120) {
			throw new InvalidAgeException(age);
		} else {
			System.out.println(age + " is a valid age!");
		}
	}
	
	public static void main(String[] args) {
		try {
			checkAge(10);
			checkAge(4000);
		} catch (InvalidAgeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getInvalidAge());
		}
	}
	
}
