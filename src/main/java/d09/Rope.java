package d09;

import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Set;

public class Rope {
	private Set<RopeEdge> visitedLocationsByTail = new HashSet<>();
	
	public Rope() {
		this.head = new RopeEdge();
		this.tail = new RopeEdge();
	}
	
	private RopeEdge head;
	private RopeEdge tail;
	
	public void performInstruction(String instruction) {
		String[] parsedInstruction = parse(instruction);
		Directions direction = switch (parsedInstruction[0]) {
			case "R" -> Directions.RIGHT;
			case "D" -> Directions.DOWN;
			case "L" -> Directions.LEFT;
			case "U" -> Directions.UP;
			default -> throw new UnsupportedOperationException();
		};
		Integer steps = Integer.parseInt(parsedInstruction[1]);
		
		for (int i = 0; i < steps; i++) {
			move(direction);
			visitedLocationsByTail.add(new RopeEdge(tail.getX(), tail.getY()));
		}
	}
	
	private String[] parse(String instruction) {
		return instruction.split(StringUtils.SPACE);
	}
	
	protected void move(Directions direction) {
		head.move(direction);
		tail.moveTailToHead(head.getX(), head.getY());
	}
	
	enum Directions {
		RIGHT,
		LEFT,
		UP,
		DOWN;
	}
	
	public Set<RopeEdge> getVisitedLocationsByTail() {
		return visitedLocationsByTail;
	}
}
