package d16;

import utils.ParseUtil;

import java.io.IOException;
import java.util.List;

public class Day16 {
	public static final int TIME_TILL_EXPLOSION = 30;
	
	public static void main(String[] args) throws IOException {
		
		ParseUtil parseUtil = new ParseUtil();
		List<String> input = parseUtil.readInputLineByLine("inputDay16.txt");
		
		Solution solution = new Solution(input);
		long output = solution.calculateTotalPressure(TIME_TILL_EXPLOSION, "AA");
		System.out.println("PartA: " + output);

	}
}
