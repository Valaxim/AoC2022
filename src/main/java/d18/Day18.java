package d18;

import utils.ParseUtil;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class Day18 {
	

	public static void main(String[] args) throws IOException {
		
		Instant start = Instant.now();
		
		ParseUtil parseUtil = new ParseUtil();
		List<String> input = parseUtil.readInputLineByLine("inputDay18.txt");
		Solution solution = new Solution(input);
		long output = solution.compute();
		System.out.println("PartA: " + output);
		
		
		Instant end = Instant.now();
		System.out.println("Runtime: " + Duration.between(start, end).toMillis() + " ms.");
		

		start = Instant.now();
		
		solution = new Solution(input);
//		output = solution.computeExternalArea();
		System.out.println("PartB: " + output);
		end = Instant.now();
 	
		System.out.println("Runtime: " + Duration.between(start, end).toMillis() + " ms.");
	}
}
