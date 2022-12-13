package d05;

import utils.ParseUtil;

import java.io.IOException;
import java.util.Deque;
import java.util.List;
import java.util.Map;

public class Day5 {
	
	public static void main(String[] args) throws IOException {
		ParseUtil parser = new ParseUtil();
		List<String> input = parser.readInputLineByLine("inputDay5.txt");

//		Map<Integer, Deque<String>> testData = InputParser.getTestData();
		Map<Integer, Deque<String>> testData = InputParser.getProductionData();
		
		Solution solution = new Solution(testData);
//		String var = solution.computePartA(testData);


//		testData = InputParser.getTestData();
		testData = InputParser.getProductionData();
		solution = new Solution(testData);
		String var2 = solution.computePartB(testData);


//		System.out.println("Answer Day5 part 1: " + var);
		System.out.println("Answer Day5 part 2: " + var2);
	}
}
