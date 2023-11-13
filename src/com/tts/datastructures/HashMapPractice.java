package com.tts.datastructures;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class HashMapPractice {

	public static void main(String[] args) {
		// A HashMap is a data structure that allows you to store
		// key-value pairs. This makes it VERY USEFUL for quick lookups
		// based on a unique key.
		// Hashmaps are unordered and have no duplicates
		
		// In Python, a hashmap is called a dict() (short for dictionary),
		// and it is very similar to object literals in Javascript (although there
		// is also a Dictionary object in JS as well)
		
		// This angle bracket syntax is telling Java that the data type
		// of the Keys in our Hashamp is String and the datatype of the 
		// associated values is Integer
		HashMap<String, Long> phoneNumbers = new HashMap<>();
		
		// Provide a new pair of keys and values using the .put() method:
		
		phoneNumbers.put("Jerry", 9083251234l);
		phoneNumbers.put("Christopher", 7093442057l);
		phoneNumbers.put("Patricia", 1093229345l);

		System.out.println(phoneNumbers);
		
		// Can do EXTREMELY FAST LOOKUP of the value by providing the key
		// of our pair
		Long patriciaPhoneNumber = phoneNumbers.get("Patricia");
		System.out.println(patriciaPhoneNumber);
		
		
		// To loop through each element in our hash map, it differs a little
		// from our lists. We have to first convert our hasmap into something
		// called an entry set and then we can then access both the value and key
		// on each entry:
		// This is how you can do an enhanced for loop on a HashMap
		for (Entry<String, Long> entry : phoneNumbers.entrySet()) {
			System.out.println(entry);
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
		
		
		
	}
	
	
}
