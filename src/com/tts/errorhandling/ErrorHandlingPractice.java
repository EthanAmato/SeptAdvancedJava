package com.tts.errorhandling;

import java.io.FileReader;
import java.io.IOException;

public class ErrorHandlingPractice {

	// Purposeful Exception-throwing method:

	public static void causeArithmeticException() {
		// To intialize an Exception java, we can use the 'throw' keyword
		// followed by the object instantiation of the type of Exception we want to
		// send:

		// Implicitly cause an ArithmeticException:
		int i = 10 / 0;

		throw new ArithmeticException("Explicitly cause an exception");
	}

	// Tell java that an IOException could be expected to occur in the readFile
	// method
	public static void readFile(String path) throws IOException {
		// 2 options to deal with a checked exception:
		// 1. Can have a try/catch block to deal with possible IOException
		// 2. We can associate the readFile() method with a particular Exception
		// that can occur inside of it using the 'throws' keyword:
		FileReader myFileReader = new FileReader(path);

		int i = 0;
		while ((i = myFileReader.read()) != -1) {
			System.out.print((char) i);
		}

		myFileReader.close();

	}

	public static void main(String[] args) {
		// Java provides a robust mechanism for handling runtime errors through its
		// Exception handling framework - a runtime error is when we get the big red
		// scary text while running our program (not during the compilation process)

		// An Exception in Java is an unwanted or unexpected event that can occur during
		// the execution
		// of a program. Exceptions are recoverable, meaning that the program can safely
		// continue its execution
		// after the exception is caught and handled.
		// Some examples of Exceptions in Java are FileNotFoundExceptions,
		// NullPointerExceptions, ClassNotFoundException,
		// ArrayindexOutOfBoundsException, etc.

		// Exceptions are NOT errors:
		// Errors in Java are defined as "any departure from the expected behavior of
		// the system or program, which
		// stops the working of the system." These are thrown by the JVM (Java virtual
		// machine) and are problems
		// that occur beyond the control of the user or programmer. Essentially they are
		// issues external to the
		// application and there is often no way to recover from them. Examples include
		// OutOfMemoryError or
		// StackOverflowError -> Both of these have to do with the actual resources
		// involved with the running
		// of a program (whether being insufficient or there being too big of a
		// callstack / to-do list for the program)
		// and are not inherent to the actual running of the program (although you can
		// write a program in such a way
		// to make these happen more often / predictably)

		// There is also the distinction in Java between Checked and Unchecked
		// Exceptions:

		// Checked Exception is an exceptional condition that a well-written application
		// should anticipate
		// and recover from -> these subject the catch requirement (such as IOException)

		// An Unchecked Exception is an exceptional condition that is external to the
		// application - these
		// extend the RuntimeException class and examples include ArithmeticException,
		// and NullPointerException.

		// Essentially, you know you are dealing with a checked exception if Eclipse is
		// telling you to write
		// a try-catch block BEFORE you run your code. Enforced by compiler.

		// If you run into the exception WHILE running your code, it's likely an
		// unchecked exception.
		// Not enforced by compiler

//		causeArithmeticException();

		// This will trigger a FileNotFoundException which inherits from IOException -
		// what we prepared
		// java for in our 'throws' declaration

		try {

			readFile("nonexistent_file.txt");

			readFile("test_input.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
