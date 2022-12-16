package d03;

import utils.ParseUtil;

import java.io.IOException;
import java.util.List;

public class Day3 {
	
	public static void main(String[] args) throws IOException {
		ParseUtil parser = new ParseUtil();
		List<String> input = parser.readInputLineByLine("inputDay3.txt");
		
		Solution solution = new Solution();
		int outputA = solution.compute(input);
		int outputB = solution.computePartB(input);
		
		System.out.println("Answer Day3 partA: " + outputA);
		System.out.println("Answer Day3 partB: " + outputB);
	}
}

