package com.tts.bookparser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class BookParser {

	// This main method is going to take a path to a txt file in our project and it
	// will
	// read from the file, remove all punctuation, set all letters to lowercase, and
	// record the count of all occurrences of each unique word in the file
	public static void main(String[] args) {
//		String path = "gutenberg.org_files_2701_old_moby10b.txt";
		String path = "hamlet.txt";
		// Let's think about the nature of the data that we want to collect from our
		// file:
		// We want to have a pairing of each individual word with that word's specific
		// count in the book(file)
		// Given the nature of this particular scenario, it sounds like a HashMap will
		// be extremely useful

		// Create a HashMap where the keys are Strings and the associated values are
		// Integers
		// Note that we are using the Wrapper class for Integer -> When working with
		// Data Structures,
		// we must use objects rather than primitives
		Map<String, Integer> wordCounts = new HashMap<>();

		try {
			FileReader reader = new FileReader(path);
			BufferedReader bufferedReader = new BufferedReader(reader);

			// We are going to read the file line by line:
			String line;
			// We will replace the value of line with the next line in the file
			// until we reach the last one, in which case .readLine() will return 'null'
			while ((line = bufferedReader.readLine()) != null) {
				// Let's get rid of all of the punctuation in line
				// We can use the .replace() method and pass it something called a 'regular
				// expression'
				// to only keep characters that are alphabetical and a corresponding letter
				// to replace all non-alphabetical letters with ("")
				line = line.replaceAll("[^a-zA-Z ]", "");

				// convert all letters to lowercase for standardization purposes
				line = line.toLowerCase();

				// We will create an array of Strings from our line in the book by
				// whitespace separations (spaces or tabs)
				// E.g. "the car is blue" -> [the, car, is, blue]
				String[] words = line.split("\\s+");

				for (String word : words) {
					if (!word.isEmpty()) {
						// If the word is already in the map, we will increment its
						// count. Otherwise, we will add the new word to the map with count = 1

						// Fortunately, the map interface / HashMap class provides a method specifically
						// for this use case: it is called .getOrDefault()

						// This method works like the following:
						// 1. We will access the location in the hashmap where the key is the word
						// we are currently working on.
						// 2. At that location, we will run getOrDefault to receive the wordcount of
						// the given word. If the word 'word' is NOT present, we will set it to 0 by
						// default
						// and no matter what we increment by one
						wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);

					}
				}

			}

			bufferedReader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Loop through an 'EntrySet' of our Hashmap to get individual key / value pairs of
		// words and their counts:
//		for(Entry<String, Integer> wordEntry : wordCounts.entrySet()) {
//			System.out.println(wordEntry.getKey() + " occurred " + wordEntry.getValue() + " times...");
//		}
		
		// can also access individual word counts based on string:
		System.out.println(wordCounts.get("whale"));
		
		// Here's how we can sort our hashMap so that we can look at the most / least occurring words:
		
		// We can use a .stream() to run bulk processes in Java on our HashMap so that we can wait
		// for it to first sort, then print out individual key / value pairs in ascending / descending order
		
		// This way we get a data structure that keeps track of our data in a less abstract / more order-oriented
		// fashion than a hashmap
		wordCounts
			.entrySet()
			// Turn our entry set into a stream which we can run bulk processes on
			// such as sorting:
			.stream()
			// An intermediate operation that also returns a stream which will consist of the elements
			// of the original stream (wordCOunts as an entrySet())
			// It takes something called a comparator as input which will take 2 pieces of data and
			// compare them based on logic we write (so we will compare whether wordCount1 is bigger than
			// wordCount2). This will use a type of Java syntax that we will learn on thursday and is called
			// a 'lambda function'
			// This is essentially the rules that we follow when determining which item goes in front of
			// another item inside of our 'sorted entrySet'
			.sorted((wordCount1, wordCount2) -> wordCount1.getValue().compareTo(wordCount2.getValue()))
			// For each now SORTED item in our entry set, we will print out the word and its associated
			// wordcount
			// This also takes a lambda
			.forEach((wordEntry) -> System.out.println(wordEntry.getKey() + " : " + wordEntry.getValue()));

	}

}
