package d04;

import java.util.List;

public class Solution {
	
	public int computePartA(List<String> input) {
		int output = 0;
		for (String str : input) {
			PairOfElves pairOfElves = new PairOfElves(str);
			if (pairOfElves.fullyContainsTheOther()) {
				output++;
			}
		}
		return output;
	}
	
	public int computePartB(List<String> input) {
		int output = 0;
		for (String str : input) {
			PairOfElves pairOfElves = new PairOfElves(str);
			if (pairOfElves.isOverlapping()) {
				output++;
			}
		}
		return output;
	}
	
}
