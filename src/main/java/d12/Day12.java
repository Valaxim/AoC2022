package d12;

import utils.ParseUtil;

import java.io.IOException;
import java.util.List;

public class Day12 {
	public static void main(String[] args) throws Exception {
		
		ParseUtil parseUtil = new ParseUtil();
		List<String> chuj = parseUtil.readInputLineByLine("inputDay12.txt");
		ZajebaneZGithuba z1 = new ZajebaneZGithuba();
		System.out.println(z1.runPart1(chuj));
		System.out.println(z1.runPart2(chuj));
	}
}
