package d10;

import utils.ParseUtil;

import java.io.IOException;
import java.util.List;

public class Day10 {
	public static void main(String[] args) throws IOException {
		ParseUtil parser = new ParseUtil();
		List<String> input = parser.readInputLineByLine("inputDay10.txt");
		
		Solution solution = new Solution();
		solution.compute(input);
	}
}
