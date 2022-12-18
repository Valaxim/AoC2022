package d17;

import utils.ParseUtil;

import java.time.Duration;

import java.io.IOException;
import java.time.Instant;
import java.util.List;

public class Day17 {
	
	private static final int AMOUNT_OF_ROCKS = 2022;
	
	private static final long HUGE_AMOUNT_OF_ROCKS = 1000000000000L;
	
	public static void main(String[] args) throws IOException {
		
		Instant start = Instant.now();
		
		ParseUtil parseUtil = new ParseUtil();
		List<String> input = parseUtil.readInputLineByLine("inputDay17.txt");
		Solution solution = new Solution();
		long output = solution.compute(input, AMOUNT_OF_ROCKS, false);
		System.out.println("PartA: " + output);
		
		
		Instant end = Instant.now();
		System.out.println("Runtime: " + Duration.between(start, end).toMillis() + " ms.");
		
		
		start = Instant.now();
		
		output = solution.compute(input, HUGE_AMOUNT_OF_ROCKS, true);
		System.out.println("PartB: " + output);
		end = Instant.now();
		
		System.out.println("Runtime: " + Duration.between(start, end).toMillis() + " ms.");
	}
}
