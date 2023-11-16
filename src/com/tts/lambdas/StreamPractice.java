package com.tts.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// The Stream API in java is one of the most common use cases for lambdas. It provides
// methods like 'filter' 'map' 'reduce' and 'forEach' and accepts lambda expressions
// to process streams of data in a 'functional style'
public class StreamPractice {

	public static void main(String[] args) {

		// First let's create a collection of data to turn into a stream to process with
		// lambdas:
		List<String> names = Arrays.asList("Alice", "Jeremy", "David", "Troy", "Jared", "Frank", "Dominic");

		System.out.println(names);

		// We can initialize the stream() api using the .stream() method on a list:

		List<String> result = names.stream()
				// Filter method is a method in the stream API that we can provide a lambda
				// to filter our List however we want:
//				.filter(name -> name.startsWith("B"))
				
				// .sorted() also takes a lambda but will sort strings in ascending order by default
				.sorted((String s1, String s2) -> s2.compareTo(s1)) 
				
				// Provide yet another lambda to make every single string in our List uppercase:
				.map((String name) -> name.toUpperCase() + " is cool!")				
				.collect(Collectors.toList());

		System.out.println(result);
		
		List<Integer> nums = Arrays.asList(341,123,1222,1042);
		
		int sum = nums.stream()
				.map(n -> n * n)
				.sorted()
				.reduce(0, (n1, n2) -> n1 + n2);
		
		System.out.println(sum);
		
	}
}
