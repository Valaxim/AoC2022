package d08;


import utils.ParseUtil;

import java.io.IOException;

public class Day8 {
	
	public static void main(String[] args) throws IOException {
		ParseUtil parser = new ParseUtil();
		int[][] input = parser.read2DIntArray("inputDay8.txt");
		
		Solution solution = new Solution(input);
		int sum = solution.computePartA();
		
		
		int maximumVisibleTreeAmount = solution.computePartB();
		System.out.println("Answer Day8 part 1: " + sum);
		System.out.println("Answer Day9 part 2: " + maximumVisibleTreeAmount);
	}
}
