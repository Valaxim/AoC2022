package d05;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.Map;

public class Solution {
	
	private Map<Integer, Deque<String>> testData;
	
	public Solution(Map<Integer, Deque<String>> testData) {
		this.testData = testData;
	}
	
	public String computePartA(Map<Integer, Deque<String>> testData) throws IOException {
		
		List<List<Integer>> allInstruction = InstructionsParser.getAllProductionInstruction();
//		List<List<Integer>> allInstruction = InstructionsParser.getAllTestInstruction();
		for (List list : allInstruction) {
			int numberOfSteps = (int) list.get(0);
			int indexOfSourceCrate = (int) list.get(1);
			int indexOfTargetCrate = (int) list.get(2);
			
			executeInstruction(numberOfSteps, indexOfSourceCrate, indexOfTargetCrate);
			printStack();
		}
		return "Str";
	}
	
	private void executeInstruction(int numberOfSteps, int indexOfSourceCrate, int indexOfTargetCrate) {
		for (int i = 0; i < numberOfSteps; i++) {
			String item = testData.get(indexOfSourceCrate).pollLast();
			testData.get(indexOfTargetCrate).add(item);
		}
	}
	
	private void printStack() {
		for (int i = 0; i < testData.size(); i++) {
			System.out.print(testData.get(i + 1).peekLast());
		}
		System.out.println();
		System.out.println("---------");
	}
	
	public String computePartB(Map<Integer, Deque<String>> testData) throws IOException {
		List<List<Integer>> allInstruction = InstructionsParser.getAllProductionInstruction();
//		List<List<Integer>> allInstruction = InstructionsParser.getAllTestInstruction();
		for (List list : allInstruction) {
			int numberOfSteps = (int) list.get(0);
			int indexOfSourceCrate = (int) list.get(1);
			int indexOfTargetCrate = (int) list.get(2);
			
			executeInstructionWithNewCrane(numberOfSteps, indexOfSourceCrate, indexOfTargetCrate);
			printStack();
		}
		return "Str";
	}
	
	private void executeInstructionWithNewCrane(int numberOfSteps, int indexOfSourceCrate, int indexOfTargetCrate) {
		List<String> movedItem = new ArrayList<>();
		for (int i = 0; i < numberOfSteps; i++) {
			movedItem.add(testData.get(indexOfSourceCrate).pollLast());
		}
		Collections.reverse(movedItem);
		testData.get(indexOfTargetCrate).addAll(movedItem);
	}
}
