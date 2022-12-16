package d13;


import utils.ParseUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day13 {
	public static void main(String[] args) throws IOException {
		
		ParseUtil parseUtil = new ParseUtil();
		List<String> input = parseUtil.readInputLineByLine("inputDay13.txt");
		
		int resultPartA = 0;
		
		for (int index = 0, pairNo = 1; index < input.size(); index += 3, pairNo++) {
			Packet leftPacket = new Packet(input.get(index));
			Packet rightPacket = new Packet(input.get(index + 1));
			resultPartA += leftPacket.compareTo(rightPacket) < 0 ? pairNo : 0;
		}
		System.out.println("OutputPartA: " + resultPartA);
		
		List<Packet> allPacketList = new ArrayList<>();
		
		Packet firstPacket = new Packet("[[2]]");
		Packet secondPacket = new Packet("[[6]]");
		
		allPacketList.add(firstPacket);
		allPacketList.add(secondPacket);
		for (int index = 0; index < input.size(); index += 3) {
			allPacketList.add(new Packet(input.get(index)));
			allPacketList.add(new Packet(input.get(index + 1)));
		}
		List<Packet> collect = allPacketList.stream()
				.sorted()
				.toList();
		int outputPartB = ((collect.indexOf(firstPacket) + 1) * (collect.indexOf(secondPacket) + 1));
		System.out.println("OutputPartB: " + outputPartB);
	}
}
