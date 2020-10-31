import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

public class StreamsApi {

	/*
	 * Example 1
	 * Create a stream of integers and print them
	 * */
	@Test
	public void createStreamOfIntegers() {
		IntStream.range(1, 10)
			.forEach(System.out::println);
	}
	
	@Test
	public void createStreamOfIntegersShortHand() {
		IntStream.range(1, 10)
			.forEach(System.out::println);
	}
	
	/*
	 * Example 2
	 * Filter even numbers and print them
	 * */
	@Test
	public void filerEvenNumbers() {
		IntStream.range(1, 10)
			.filter(i -> i % 2 == 0 )
			.forEach(System.out::println);
	}
	
	/*
	 * Example 3
	 * Filter odd numbers and get their sum
	 * */
	@Test
	public void filterAndSumOddNumbers() {
		System.out.println(
			IntStream.range(1, 10)
			.filter(i -> i % 2 != 0 )
			.sum());
	}
	
	/*
	 * Example 4
	 * Get a stream from an Array
	 * */
	final String input = "The quick brown fox jumped over the lazy dogs. Previous sentence contains all letters of alphebet.";
	final String[] inputArray = input.replaceAll("\\.", "").split(" ");
	@Test
	public void getStreamFromArray() {
		Arrays.stream(inputArray)
			.forEach(System.out::println);
	}
	
	/*
	 * Example 5
	 * Get a stream from a List
	 * */
	@Test
	public void getStreamFromList() {
		Arrays.asList(inputArray).stream()
			.forEach(System.out::println);
	}
	
	/*
	 * Example 6
	 * Map words to numbers based on length
	 * */
	@Test
	public void mapStreamToNumbers() {
		Arrays.stream(inputArray)
			.map(String::length)
			.forEach(System.out::println);
	}
	
	/*
	 * Example 7
	 * Collect mapped numbers to a List
	 * */
	@Test
	public void collectNumbersToList() {
		List<Integer> numbers = Arrays.stream(inputArray)
									.map(s -> s.length())
									.collect(Collectors.toList());
		numbers.stream().forEach(System.out::println);
	}
	
	/*
	 * Example 8
	 * Collect word lengths into a Map
	 * */
	@Test
	public void collectNumbersToMap() {
		Map<String, Integer> wordLengths = Arrays.stream(inputArray)
											.collect(Collectors.toMap(s -> s, s -> s.length()));
		wordLengths.keySet().stream()
			.forEach(key -> System.out.println(key + " --> " + wordLengths.get(key)));
	}
	
	/*
	 * Example 9
	 * Reduce words into sum of lengths
	 * */
	@Test
	public void reduceWordsIntoSumOfLengths() {
		int totalWordLength = Arrays.stream(inputArray)
									.map(s -> s.length())
									.reduce(0, (sum, length) -> sum + length);
		System.out.println(totalWordLength);
	}
	
	/*
	 * Example 10
	 * Sort words
	 * */
	@Test
	public void sortWords() {
		Arrays.stream(inputArray)
				.sorted()
				.forEach(System.out::println);
	}
	
	// Any match, all match, parallel streams
}
