package d09;

import utils.ParseUtil;

import java.io.IOException;
import java.util.List;

public class Day9 {
	
	public static void main(String[] args) throws IOException {
		ParseUtil parser = new ParseUtil();
		List<String> input = parser.readInputLineByLine("inputDay9.txt");
		
		Solution solution = new Solution();
		solution.compute(input);
		
		
		System.out.println("Answer Day9 part 1: " + solution.getVisitedTailLocations().size());
		
		SolutionPartB solutionPartB = new SolutionPartB();
		solutionPartB.compute(input);
		
		System.out.println("Answer Day9 part 2: " + solutionPartB.getVisitedTailLocations().size());
	}
}
