package com.tts.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedStreamPractice {

	public static void main(String[] args) {

		// What we just did inside of IOPractice was a regular 'ol ByteStream.
		// Essentially, every time we wanted
		// to get a new piece of data (a byte) from our file, our computer did the
		// equivalent of 'opening the door
		// to our test_input.txt' got the next individual byte, left the file, did some
		// operation with it in
		// our while loop block, and then realized it needed to do it again with the
		// next byte until it ran out
		// of bytes to work with.

		// This is fairly inefficient, especially when we are dealing with documents
		// with millions of bytes to deal
		// with

		// To deal with this inefficiency, we are also able to use a type of
		// InputStream/OutputStrema called
		// a 'BufferedStream'
		// What a buffered stream does is it can read or write data in large chunks
		// instead of byte by byte
		// which will improve performance.

		// To create a Buffered Stream, we will first create a FileInputStream and then
		// use that
		// as input for a BufferedInputStream object (this is a decorator design
		// pattern)

		try {

			
			FileInputStream inputStream = new FileInputStream("test_input.txt");
			// Use BufferedInputStream as decorator for inputStream:
			BufferedInputStream bufferedStream = new BufferedInputStream(inputStream);
			
			// reading is functionally identical to our first use case:
			int i;
			while((i=bufferedStream.read()) != -1) {
				System.out.print((char) i);
			}
			
			bufferedStream.close();
			
			// Writing is a bit different however (but not too different):
			
			FileOutputStream outputStream = new FileOutputStream("buffered_output.txt");
			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
			
			String secretBufferedMessage = "Today is 11/14 - happy almost Thanksgiving";
			byte[] secretBufferedMessageBytes = secretBufferedMessage.getBytes();
			
			// But now we have to actually write to our file.
			// As opposed to regular ByteStream - a write operation in a BufferedOutputStream technically
			// writes to the buffer rather than the file itself. We have to explicitly tell Java
			// when to 'unload' all of the bytes held inside of the buffer to the file in one fell swoop.
			// We can do this using the .flush() method after using .write() to fill up the buffer:
			
			// Fill up buffer with message bytes:
			bufferedOutputStream.write(secretBufferedMessageBytes);
			
			// Write from the buffer to the actual file:
			bufferedOutputStream.flush();
			
			bufferedOutputStream.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
