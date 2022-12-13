package d09;

import java.util.List;
import java.util.Set;

public class Solution {
	
	private Rope rope;
	
	public Solution() {
		this.rope = new Rope();
	}
	
	public void compute(List<String> input) {
		performAllInstructions(input);
	}
	
	private void performAllInstructions(List<String> input) {
		for (String instruction : input) {
			rope.performInstruction(instruction);
		}
	}
	
	public Set<RopeEdge> getVisitedTailLocations() {
		return rope.getVisitedLocationsByTail();
	}
}
