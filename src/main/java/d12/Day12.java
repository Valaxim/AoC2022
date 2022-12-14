package d12;

import utils.ParseUtil;

import java.util.List;

public class Day12 {
	public static void main(String[] args) throws Exception {
		
		ParseUtil parseUtil = new ParseUtil();
		List<String> input = parseUtil.readInputLineByLine("inputDay12.txt");
		BFS z1 = new BFS();
		
		System.out.println("Solution day12, partA: " + z1.runPart1(input));
		System.out.println("Solution day12, partB: " + z1.runPart2(input));
	}
}
