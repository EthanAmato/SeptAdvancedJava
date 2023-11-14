package com.tts.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOPractice {

	public static void main(String[] args) {

		// In Java, the type of class that we use to read/write to files
		// are called Input and Output Streams -> these are types of classes
		// that are able to read and write from files in different formats depending
		// on what type of stream they are.

		// Byte Stream: reads and writes data byte by byte. These are good for handling
		// all kinds of I/O which includes character data, image files, audio files, or
		// even any binary data file

		// The constructor takes a string that is the path to a file you want to read
		// from

		// When dealing with external sources such as files, things are more likely to
		// go
		// wrong. For example, the file might not exist, the network might be down, you
		// may not have permission to read/write to/from a file, or the disk might be
		// full

		// Therefore, the Java.io classes will typically enforce that you have something
		// called
		// a try/catch block to make sure that, if something goes wrong, you can
		// continue your
		// code without crashing the entire program

		// A try block will attempt to run the code inside of the curly braces
		// if it runs into an error, it will IMMEDIATELY stop running and switch to
		// whatever
		// failsafe code exists in the corresponding catch block
		try {

			FileInputStream byteInputStream = new FileInputStream("test_input.txt");

			// Represents each individual byte that we read from our file
			int i;

			// We will continuously read the next byte that exists in our file
			// and set i equal to it. As soon as i runs out of bytes to turn into /
			// there is no more information left in our file, byteInputStream.read() will
			// return -1, meaning we will stop our while loop
			while ((i = byteInputStream.read()) != -1) {
				// Without turning each version of i into a character, we see them in
				// their numerical form. This is a characteristic of a ByteStream

				// By coercing each int that we read from the bytestream into a character
				// primitive,
				// we can access the actual letters inside of our file
				System.out.println(i + " : " + (char) i);
			}

			// This will close the connection between our program and the disk - freeing up
			// resources
			// it is good form to do this
			byteInputStream.close();

			// To write to a file (instead of reading from one), we can use the
			// corresponding
			// FileOutputStream class available from java.io -> this is also a ByteStream

			// We have to provide this a destination to write to... if a file does not exist
			// at this path, it will create one
			FileOutputStream byteOutputStream = new FileOutputStream("output.txt");

			// Let's define some text to write to our output file:
			String mySecretMessage = "Fall is my favorite season because the leaves are pretty and hot chocolate is amazing";

			// FileOutputStream - just like FileInputStream - deals with Bytes and not
			// necessarily characters.
			// So what we need to do before writing to output.txt is convert our String into
			// something a bytestream
			// can understand - namely, an array of bytes:

			byte[] secretMessageBytes = mySecretMessage.getBytes();

			// This will show us the array of bytes that our secret message is turned into,
			// which is something
			// that the FileOutputStream can understand
			for (i = 0; i < secretMessageBytes.length; i++) {
				System.out.print(secretMessageBytes[i] + ",");
			}

			// To write to our FileOutputStream, we can just use the .write() method with the byte[] of
			// our message inside:
			byteOutputStream.write(secretMessageBytes);
			
			// Close connection to file / free up resources
			byteOutputStream.close();
		}
		// IOException is a catch-all type of exception (basically an error) that
		// will handle all types of things that can go wrong during IO operations
		catch (IOException e) {
			e.printStackTrace();
		}

	}

}
