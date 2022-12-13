package d09;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public class SolutionPartB extends Solution {
	
	private TenKnotRope rope;
	
	public SolutionPartB() {
		this.rope = new TenKnotRope();
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
		return rope.getVisitedLocationsByMasterTail();
	}
	
}
