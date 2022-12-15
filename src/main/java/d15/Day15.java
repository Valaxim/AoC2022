package d15;


import utils.ParseUtil;

import java.io.IOException;
import java.util.List;

public class Day15 {
	public static final int ROW_INDEX = 2000000;
	
	public static void main(String[] args) throws IOException {
		
		ParseUtil parseUtil = new ParseUtil();
		List<String> input = parseUtil.readInputLineByLine("inputDay15.txt");
		
		BeaconZone beaconZone = new BeaconZone(input);
		int output = beaconZone.getAllSignalFromRow(ROW_INDEX);
		System.out.println("Part1: " + output);
		
		beaconZone.getMissingSignalInFrame(0, 4000000);
	}
}
