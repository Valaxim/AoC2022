package d13;


import utils.ParseUtil;

import java.io.IOException;
import java.util.List;

public class Day13 {
	public static void main(String[] args) throws IOException {
		
		ParseUtil parseUtil = new ParseUtil();
		List<String> input = parseUtil.readInputLineByLine("inputDay13.txt");

		
		Solution solution = new Solution();
		solution.computePartOne();
	}
}
