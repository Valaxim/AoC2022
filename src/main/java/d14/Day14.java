package d14;

import utils.ParseUtil;

import java.io.IOException;
import java.util.List;

public class Day14 {
	public static void main(String[] args) throws IOException {
		
		ParseUtil parseUtil = new ParseUtil();
		List<String> input = parseUtil.readInputLineByLine("inputDay14.txt");
		
		Cave cave = new Cave(input);
		cave.pourSand();
		
		Cave caveWithFloor = new CaveWithFloor(input);
		caveWithFloor.pourSand();
	}
}
