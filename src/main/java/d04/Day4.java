package d04;

import utils.ParseUtil;

import java.io.IOException;
import java.util.List;

public class Day4 {
	
	public static void main(String[] args) throws IOException {
		ParseUtil parser = new ParseUtil();
		List<String> input = parser.readInputLineByLine("inputDay4.txt");
		
		Solution solution = new Solution();
		int var = solution.computePartA(input);
		int var2 = solution.computePartB(input);
	
		
		System.out.println("Answer Day4 part 1: " + var);
		System.out.println("Answer Day4 part 2: " +  var2);
	}
}

