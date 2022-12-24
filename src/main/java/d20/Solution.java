package d20;

import java.util.LinkedList;
import java.util.List;

public class Solution {
	
	record Number(long value, int order) {
	}
	
	private LinkedList<Number> linkedList;
	private LinkedList<Number> output;
	private int listSize;
	
	public Solution(List<String> input) {
		this(input, 1L);
	}
	
	public Solution(List<String> input, long decryptionKey) {
		int order = 0;
		linkedList = new LinkedList<>();
		for (String value : input) {
			linkedList.add(new Number(Long.parseLong(value) * decryptionKey, order++));
		}
		listSize = linkedList.size();
	}
	
	public long compute() {
		output = new LinkedList<>(linkedList);
		mixing();
		return calculateOutput();
	}
	
	public long computePartB() {
		output = new LinkedList<>(linkedList);
		for (int i = 0; i < 10; i++) {
			mixing();
		}
		return calculateOutput();
	}
	
	
	private void mixing() {
		for (int index = 0; index < listSize; index++) {
			Number valueThatShouldBeProcessed = linkedList.get(index);
			
			int currentIndexOfValue = this.output.indexOf(valueThatShouldBeProcessed);
			Number remove = this.output.remove(currentIndexOfValue);
			
			// Use -1 on the modulo operation -> just removed an element from the list
			int indexAfterMoving = Math.floorMod(currentIndexOfValue + remove.value, listSize - 1);
			
			this.output.add(indexAfterMoving, remove);
		}
	}
	
	private long calculateOutput() {
		var zeroValueObject = output.stream()
				.filter(it -> it.value == 0)
				.findFirst()
				.orElseThrow();
		
		int zeroValuePosition = output.indexOf(zeroValueObject);
		
		int indexOf1000thElementAfterZero = (zeroValuePosition + 1000) % listSize;
		int indexOf2000thElementAfterZero = (zeroValuePosition + 2000) % listSize;
		int indexOf3000thElementAfterZero = (zeroValuePosition + 3000) % listSize;
		
		return output.get(indexOf1000thElementAfterZero).value
				+ output.get(indexOf2000thElementAfterZero).value
				+ output.get(indexOf3000thElementAfterZero).value;
	}
}