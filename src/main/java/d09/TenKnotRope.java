package d09;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TenKnotRope extends Rope {
	private Set<RopeEdge> visitedLocationsByMasterTail = new HashSet<>();
	private RopeEdge head;
	private List<RopeEdge> tailList = new ArrayList<>();
	
	private final RopeEdge masterTail;
	
	public TenKnotRope() {
		this.head = new RopeEdge();
		for (int i = 0; i < 9; i++) {
			tailList.add(new RopeEdge());
		}
		masterTail = tailList.get(tailList.size() - 1);
	}
	
	@Override
	protected void move(Directions direction) {
		head.move(direction);
		int currentX = head.getX();
		int currentY = head.getY();
		
		for (var tail : tailList) {
			tail.moveTailToHead(currentX, currentY);
			currentX = tail.getX();
			currentY = tail.getY();
		}
		visitedLocationsByMasterTail.add(new RopeEdge(masterTail.getX(), masterTail.getY()));
	}
	
	public Set<RopeEdge> getVisitedLocationsByMasterTail() {
		return visitedLocationsByMasterTail;
	}
}
