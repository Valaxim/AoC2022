package d20;


import utils.ParseUtil;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class Day20 {
	
	private static final long DECRYPTION_KEY = 811589153;
	
	public static void main(String[] args) throws IOException {
		
		Instant start = Instant.now();
		ParseUtil parseUtil = new ParseUtil();
		List<String> input = parseUtil.readInputLineByLine("inputDay20.txt");
		
		Solution solution = new Solution(input);
		long output = solution.compute();
		System.out.println("PartA: " + output);
		Instant end = Instant.now();
		System.out.println("Runtime: " + Duration.between(start, end).toMillis() + " ms.");



		start = Instant.now();
		solution = new Solution(input, DECRYPTION_KEY);
		output =  solution.computePartB();
		System.out.println("PartB: " + output);
		end = Instant.now();
		System.out.println("Runtime: " + Duration.between(start, end).toMillis() + " ms.");
	}
}
