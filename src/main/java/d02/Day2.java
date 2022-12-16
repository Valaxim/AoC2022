package d02;

import utils.ParseUtil;

import java.io.IOException;
import java.util.List;

public class Day2 {
	
	public static void main(String[] args) throws IOException {
		ParseUtil parser = new ParseUtil();
		List<String> input = parser.readInputLineByLine("inputDay2.txt");
		
		int sum = Solution.getSum(input);
		System.out.println("Answer Day2 partA:" + sum);
		
		int sum2 = Solution.getPartB(input);
		System.out.println("Answer Day2 partB:" + sum2);
	}
}

