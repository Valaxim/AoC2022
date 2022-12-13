package d03;

import utils.ParseUtil;

import java.io.IOException;
import java.util.List;

public class Day3 {
	
	public static void main(String[] args) throws IOException {
		ParseUtil parser = new ParseUtil();
		List<String> input = parser.readInputLineByLine("inputDay3.txt");
		
		Solution solution = new Solution();
		int var = solution.compute(input);
		int varPart2 = solution.computePartB(input);
		
		System.out.println("Answer Day3 part 1: " + var);
		System.out.println("Answer Day3 part 2: " + varPart2);
	}
}

