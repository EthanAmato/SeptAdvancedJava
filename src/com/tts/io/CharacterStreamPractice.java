package com.tts.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharacterStreamPractice {

	public static void main(String[] args) {
		// In the case you are working with text in your files, there is a better
		// alternative
		// for it in comparison to Bytestreams.
		// For example, we know that bytes can only hold 256 unique values, therefore it
		// is useful to have
		// an alternative way of storing written data so that we can handle more types
		// of characters.

		// The streams responsible for handling this are called CharacterStreams:

		// Instead of FileInputStream, we use a class called a FileReader
		// Instead of a FileOutputStream, we use a class called a FileWriter

		try {
			FileReader characterInputStream = new FileReader("test_input.txt");
			// Buffered alternative to these character streams - they work functionally the
			// exact
			// same as the ByteStream BufferedInputStream / OutputStream. The only
			// difference
			// is that the name of the class / decorator is BufferedReader and
			// BufferedWriter:

			BufferedReader bufferedCharStream = new BufferedReader(characterInputStream);

			int i;
			while ((i = bufferedCharStream.read()) != -1) {
				// Works with UTF-16 encoding - 16 bit Unicode
				System.out.println(i + " : " + (char) i);
			}

			FileWriter characterOutputStream = new FileWriter("character_output.txt");
			
			BufferedWriter bufferedCharOutput = new BufferedWriter(characterOutputStream);
			
			
			String s = "blah blah blah 友人";

			// We can just give our outputstream a string because it is no longer a
			// Bytestream
			bufferedCharOutput.write(s);
			
			bufferedCharOutput.flush();

			bufferedCharOutput.close();

			// Buffered alternative to these character streams - they work functionally the
			// exact
			// same as the ByteStream BufferedInputStream / OutputStream. The only
			// difference
			// is that the name of the class / decorator is BufferedReader and
			// BufferedWriter:

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
