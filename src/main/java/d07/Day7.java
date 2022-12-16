package d07;

import utils.ParseUtil;

import java.io.IOException;
import java.util.List;

public class Day7 {
	
	public static void main(String[] args) throws IOException {
		ParseUtil parser = new ParseUtil();
		List<String> input = parser.readInputLineByLine("inputDay7.txt");
		
		Solution solution = new Solution();
		solution.compute(input);
		long outputA = solution.findSumOfAllDirectoryBelow100kSpace();
		long outputB = solution.findSmallestDirectoryToDelete();
		
		System.out.println("Answer Day7 part 1: " + outputA);
		System.out.println("Answer Day7 part 2: " + outputB);
	}
}
