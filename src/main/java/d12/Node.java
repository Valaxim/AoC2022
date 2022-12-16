package d12;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Node implements Comparable<Node> {
	
	private int row;
	private int col;
	
	private String str;
	
	private LinkedList<Node> shortestPath = new LinkedList<>();
	
	private int distance = 99;
	
	private Map<Node, Integer> adjacentNodes = new HashMap<>();
	
	
	public Node(String str) {
		this.str = str;
	}
	
	public Node(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	public void addDestination(Node destination, int distance) {
		adjacentNodes.put(destination, distance);
	}
	
	public int getRow() {
		return row;
	}
	
	public void setRow(int row) {
		this.row = row;
	}
	
	public int getCol() {
		return col;
	}
	
	public void setCol(int col) {
		this.col = col;
	}
	
	public Map<Node, Integer> getAdjacentNodes() {
		return adjacentNodes;
	}
	
	public void setAdjacentNodes(Map<Node, Integer> adjacentNodes) {
		this.adjacentNodes = adjacentNodes;
	}
	
	public Integer getDistance() {
		return distance;
	}
	
	public void setDistance(Integer distance) {
		this.distance = distance;
	}
	
	public List<Node> getShortestPath() {
		return shortestPath;
	}
	
	public void setShortestPath(LinkedList<Node> shortestPath) {
		this.shortestPath = shortestPath;
	}
	
	@Override
	public String toString() {
		return "Node{" +
				"row=" + row +
				", col=" + col + "}";
		
	}
	
	
	@Override
	public int compareTo(Node o) {
		if (this.row != o.getRow()) {
			return Integer.compare(this.row, o.getRow());
		} else {
			return Integer.compare(this.col, o.getCol());
		}
	}
}