package d01;

import utils.ParseUtil;

import java.io.IOException;
import java.util.List;

public class Day1 {
	
	public static void main(String[] args) throws IOException {
		ParseUtil parser = new ParseUtil();
		List<String> input = parser.readInputLineByLine("inputDay1.txt");
		
		Solution solution = new Solution();
		List<Integer> dataFromInput = solution.createDataFromInput(input);
		
		Integer var = solution.getInteger(dataFromInput);
		
		int varTop3 = solution.getVarTop3(dataFromInput);
		
		System.out.println("Answer Day1 part 1: " +var);
		System.out.println("Answer Day1 part 2: " +varTop3);
	}
}

