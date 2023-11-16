package com.tts.lambdas;

import java.util.List;
import java.util.ArrayList;


// A lambda (expression / method) in Java is a bit of syntax that allows you to express instances
// of single-method interfaces in a concise way -> essentially they let you create 'one-off functions'

// Put more technically, a lambda expression is represented as an instance of a functional interface
// You may be thinking, what the heck is a functional interface?!?!?!
// A functional interface is simply an interface - a contract between a class and a series of 
// abstract / unimplemented methods that ONLY HAS 1 ABSTRACT METHOD.
// Essentially a functional interface serves as a 'single function contract' that a referenced method
// MUST fulfill

public class LambdaPractice {
	// You can make a functional interface like this:
	// This annotation is optional but recommended because it provides compile-time checking
	// ensuring that our interface is actually a functional interface
	@FunctionalInterface
	public interface MyFunctionalInterface {
		void execute();
	}
	
	@FunctionalInterface
	public interface Calculator {
		int doMath(int n1, int n2);
	}
	
	
	public static int operate(int a, int b, Calculator functionObject) {
		return functionObject.doMath(a, b);
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		// The associated lambda looks like this: '(int optionalInput) -> line of code'
		// Best practices:
		// 1. Short, single-use pieces of code -> Lambda
		// 2. More complex logic -> use traditional classes or methods
		// 3. Use lambdas when you have functional interfaces
		MyFunctionalInterface myFIInstance = () -> System.out.println("Executing...");
		
		myFIInstance.execute();
		
		
		// We can provide multiple implementations of the same functional interface
		// using lambda expression:
		Calculator myAdder = (int n1, int n2) -> n1 + n2;
		System.out.println(myAdder.doMath(10, 40));
		
		Calculator mySubtractor = (int n1, int n2) -> n2 - n1;
		System.out.println(mySubtractor.doMath(100, 40));

		
		// In Java, there are some classes / APIs that already work with lambdas out of the box...
		
		// For example, we can use the .forEach method that is a part of the List interface to
		// apply some operation to every individual element in a List:
		
		List<String> names = List.of("Ethan", "Sydney", "Zachary", "Lexi", "Sarah");
		
		// Will hold all the names that start with S
		List<String> filteredNames = new ArrayList<>();
		
		// Can provide a lambda function as input to the forEach method
		// Java (specifically the Iterable class) will create a lambda expression to call on each of those
		// elements using the FunctionalInterface in Consumable.
		names.forEach((String name) -> {
			if(name.startsWith("S")) {
				filteredNames.add(name);
			}
		});
		
		System.out.println(filteredNames);
		
		
		// Passing lambdas like Javascript objects/callbacks...
		// As seen above, we are able to pass a lambda expression to .forEach() without having to instantiate
		// it like we did with myAdder and mySubtractor
		// This shows us that we are able to create anonymous functions and pass them to other methods in Java:
		
		// Can pass it pre-instantiated lambdas like myAdder
		System.out.println(operate(10, 23, myAdder));
		System.out.println(operate(10, 23, mySubtractor));

		// Can also pass it anonymous lambdas:
		System.out.println(operate(5,43, (int n1, int n2) -> n1 * n2));
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
