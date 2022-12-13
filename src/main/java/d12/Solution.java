package d12;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
	
	private char[][] input;
	private char[][] backup;
	private final int rows_max_index;
	private final int cols_max_index;
	private static final Character PATH_BEGINNING = 'S';
	private static final Character PATH_END = 'E';
	
	private List<Integer> shortestPath = new ArrayList<>();
	
	public Solution(char[][] input) {
		this.input = input;
		this.backup = input;
		rows_max_index = input.length;
		cols_max_index = input[0].length;
	}
	
	public void computeFromExample() {
		Node nodeA = new Node("A");
		Node nodeB = new Node("B");
		Node nodeC = new Node("C");
		Node nodeD = new Node("D");
		Node nodeE = new Node("E");
		Node nodeF = new Node("F");
		
		nodeA.addDestination(nodeB, 10);
		nodeA.addDestination(nodeC, 15);
		
		nodeB.addDestination(nodeD, 12);
		nodeB.addDestination(nodeF, 15);
		
		nodeC.addDestination(nodeE, 10);
		
		nodeD.addDestination(nodeE, 2);
		nodeD.addDestination(nodeF, 1);
		
		nodeF.addDestination(nodeE, 5);
		
		Graph graph = new Graph();
		
		graph.addNode(nodeA);
		graph.addNode(nodeB);
		graph.addNode(nodeC);
		graph.addNode(nodeD);
		graph.addNode(nodeE);
		graph.addNode(nodeF);
		
		graph = Dijkstra.calculateShortestPathFromSource(graph, nodeA);
		System.out.println("dupa");
	}
	
	public void computeDijstra() {
		Tuple<Integer, Integer> startLocation = findStartLocation();
		Graph graph = new Graph();
		initNode(graph);
		
		for (int row = 0; row < rows_max_index; row++) {
			for (int col = 0; col < cols_max_index; col++) {
				int finalRow = row;
				int finalCol = col;
				char currentChar = input[row][col];
				Tuple<Integer, Integer> currentLocation = new Tuple<>(row, col);
				Node node = graph.getNodes().stream()
						.filter(it -> it.getRow() == finalRow)
						.filter(it -> it.getCol() == finalCol)
						.findFirst().orElse(null);
				
				if (goLeft(currentChar, currentLocation)) {
					Node neighbourNode = graph.getNodes().stream()
							.filter(it -> it.getRow() == finalRow)
							.filter(it -> it.getCol() == finalCol - 1)
							.findFirst().orElse(null);
					node.addDestination(neighbourNode, 1);
					graph.addNode(node);
				}
				if (goRight(currentChar, currentLocation)) {
					Node neighbourNode = graph.getNodes().stream()
							.filter(it -> it.getRow() == finalRow)
							.filter(it -> it.getCol() == finalCol + 1)
							.findFirst().orElse(null);
					node.addDestination(neighbourNode, 1);
					graph.addNode(node);
				}
				if (goUp(currentChar, currentLocation)) {
					Node neighbourNode = graph.getNodes().stream()
							.filter(it -> it.getRow() == finalRow - 1)
							.filter(it -> it.getCol() == finalCol)
							.findFirst().orElse(null);
					node.addDestination(neighbourNode, 1);
					graph.addNode(node);
				}
				if (goDown(currentChar, currentLocation)) {
					Node neighbourNode = graph.getNodes().stream()
							.filter(it -> it.getRow() == finalRow + 1)
							.filter(it -> it.getCol() == finalCol)
							.findFirst().orElse(null);
					node.addDestination(neighbourNode, 1);
					graph.addNode(node);
				}
//				System.out.println("check");
			}
		}
		
		for (var item : graph.getNodes()) {
			System.out.println(item);
			
		}
//		createBackup();
		Node nodeA = graph.getNodes().stream()
				.filter(it -> it.getRow() == startLocation.getRow())
				.filter(it -> it.getCol() == startLocation.getCol())
				.findFirst().orElse(null);
		
		Tuple<Integer, Integer> endLocation = findEndLocation();
		
		Node endNode = graph.getNodes().stream()
				.filter(it -> it.getRow() == endLocation.getRow())
				.filter(it -> it.getCol() == endLocation.getCol())
				.findFirst().orElse(null);
		
		graph = Dijkstra.calculateShortestPathFromSource(graph, nodeA);
		

		Integer integer = graph.getNodes().stream().filter(it -> it.equals(endNode)).map(Node::getDistance).findFirst().orElseThrow();
//		System.out.println("Output: " + graph.getNodes().stream()
//				.filter(it -> it.equals(endNode))
//				.map(Node::getDistance)
//				.findFirst()
//		);
		
		System.out.println(integer);
	}
	
	private void initNode(Graph graph) {
		for (int row = 0; row < rows_max_index; row++) {
			for (int col = 0; col < cols_max_index; col++) {
				Node node = new Node(row, col);
				graph.addNode(node);
			}
			
		}
	}
	
	public void computePartOne() throws IOException {
		Tuple<Integer, Integer> startLocation = findStartLocation();
		createBackup();
		int step = 0;
		int i = lookForMinimalPath(startLocation, step);
		System.out.println("DONE, result: " + i);
	}
	
	private int lookForMinimalPath(Tuple<Integer, Integer> startLocation, int step) throws IOException {
		printMaze(step);
		char currentChar = input[startLocation.getRow()][startLocation.getCol()];
		while (currentChar != PATH_END) {
//			createBackup();
			if (goRight(currentChar, startLocation)) {
				markPathAsUsed(startLocation, "RIGHT");
				lookForMinimalPath(new Tuple<>(startLocation.getRow(), startLocation.getCol() + 1), ++step);
			} else if (goLeft(currentChar, startLocation)) {
				markPathAsUsed(startLocation, "LEFT");
				lookForMinimalPath(new Tuple<>(startLocation.getRow(), startLocation.getCol() - 1), ++step);
			} else if (goUp(currentChar, startLocation)) {
				markPathAsUsed(startLocation, "UP");
				lookForMinimalPath(new Tuple<>(startLocation.getRow() - 1, startLocation.getCol()), ++step);
			} else if (goDown(currentChar, startLocation)) {
				markPathAsUsed(startLocation, "DOWN");
				lookForMinimalPath(new Tuple<>(startLocation.getRow() + 1, startLocation.getCol()), ++step);
			}
		}
		if (currentChar == PATH_END) {
			shortestPath.add(step);
			return step;
		}
		return step;
	}
	
	private void printMaze(int step) {
		System.out.println("-------------------STEP:" + step + " ---------------------");
		for (int row = 0; row < rows_max_index; row++) {
			for (int col = 0; col < cols_max_index; col++) {
				System.out.print(input[row][col]);
			}
			System.out.println();
		}
		
	}
	
	private void markPathAsUsed(Tuple<Integer, Integer> startLocation, String down) {
		char output = switch (down) {
			case "UP" -> '^';
			case "DOWN" -> 'V';
			case "LEFT" -> '<';
			case "RIGHT" -> '>';
			default -> throw new UnsupportedOperationException();
		};
		input[startLocation.getRow()][startLocation.getCol()] = output;
	}
	
	private boolean goLeft(char currentChar, Tuple<Integer, Integer> startLocation) {
		try {
			char nextChar = input[startLocation.getRow()][startLocation.getCol() - 1];
			return canGoThere(currentChar, nextChar);
		} catch (ArrayIndexOutOfBoundsException e) {
			// do nothing
		}
		return false;
	}
	
	private boolean goRight(char currentChar, Tuple<Integer, Integer> startLocation) {
		try {
			char nextChar = input[startLocation.getRow()][startLocation.getCol() + 1];
			return canGoThere(currentChar, nextChar);
		} catch (ArrayIndexOutOfBoundsException e) {
			// do nothing
		}
		return false;
	}
	
	
	private boolean goUp(char currentChar, Tuple<Integer, Integer> startLocation) {
		try {
			char nextChar = input[startLocation.getRow() - 1][startLocation.getCol()];
			return canGoThere(currentChar, nextChar);
		} catch (ArrayIndexOutOfBoundsException e) {
			// do nothing
		}
		return false;
	}
	
	
	private boolean goDown(char currentChar, Tuple<Integer, Integer> startLocation) {
		try {
			char nextChar = input[startLocation.getRow() + 1][startLocation.getCol()];
			return canGoThere(currentChar, nextChar);
		} catch (ArrayIndexOutOfBoundsException e) {
			// do nothing
		}
		return false;
	}
	
	private boolean canGoThere(char currentChar, char nextChar) {
		return (currentChar == 'S' && nextChar == 'a')
				|| (currentChar == nextChar)
				|| (currentChar == nextChar - 1)
				|| (currentChar == 'z' && nextChar == 'E');
	}
	
	private Tuple<Integer, Integer> findStartLocation() {
		for (int row = 0; row < rows_max_index; row++) {
			for (int col = 0; col < cols_max_index; col++) {
				if (input[row][col] == PATH_BEGINNING) {
					return new Tuple<>(row, col);
				}
			}
		}
		return null;
	}
	
	private Tuple<Integer, Integer> findEndLocation() {
		for (int row = 0; row < rows_max_index; row++) {
			for (int col = 0; col < cols_max_index; col++) {
				if (input[row][col] == PATH_END) {
					return new Tuple<>(row, col);
				}
			}
		}
		return null;
	}
	
	/**
	 * nie wiem jak zrobic backup
	 */
	private void createBackup() {
		for (int i = 0; i < input.length; i++) {
			System.arraycopy(input[i], 0, backup[i], 0, input[0].length);
		}
	}
	
	
}