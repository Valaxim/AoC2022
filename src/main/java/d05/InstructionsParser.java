package d05;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import utils.ParseUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InstructionsParser {
	
	public static List<List<Integer>> getAllProductionInstruction() throws IOException {
		ParseUtil parser = new ParseUtil();
		List<String> input = parser.readInputLineByLine("inputDay5.txt");
		
		List<List<Integer>> parsedInstructions = new ArrayList<>();
		for (String str : input) {
			List<Integer> singleInstruction = Arrays.stream(str.split(StringUtils.SPACE))
					.filter(StringUtils::isNumeric)
					.map(NumberUtils::createInteger)
					.toList();
			parsedInstructions.add(singleInstruction);
		}
		return parsedInstructions;
	}
	
	public static List<List<Integer>> getAllTestInstruction() throws IOException {
		ParseUtil parser = new ParseUtil();
		List<String> input = parser.readInputLineByLine("inputTestDay5.txt");
		
		List<List<Integer>> parsedInstructions = new ArrayList<>();
		for (String str : input) {
			List<Integer> singleInstruction = Arrays.stream(str.split(StringUtils.SPACE))
					.filter(StringUtils::isNumeric)
					.map(NumberUtils::createInteger)
					.toList();
			parsedInstructions.add(singleInstruction);
		}
		return parsedInstructions;
	}
	
}