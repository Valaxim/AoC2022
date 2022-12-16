package d11;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Monkey {
	
	enum Operation {
		MULTIPLE,
		ADD,
		SQUARE
	}
	
	private int id;
	
	private Operation operation;
	private Integer operationValue;
	
	private int divisibleValue;
	private int testPositiveOutput;
	private int testNegativeOutput;
	private List<Present> presentList = new CopyOnWriteArrayList<>();
	
	private int inspectedPresent;
	
	public Monkey(int id, Operation operation, Integer operationValue, int divisibleValue, int testPositiveOutput, int testNegativeOutput) {
		this.id = id;
		this.operation = operation;
		this.operationValue = operationValue;
		this.divisibleValue = divisibleValue;
		this.testPositiveOutput = testPositiveOutput;
		this.testNegativeOutput = testNegativeOutput;
		this.inspectedPresent = 0;
	}
	
	
	public void addPresent(Present present) {
		presentList.add(present);
	}
	
	public List<Present> getPresentList() {
		return presentList;
	}
	
	public void setPresentList(List<Present> presentList) {
		this.presentList = presentList;
	}
	
	public long getInspectedPresent() {
		return inspectedPresent;
	}
	
	public void setInspectedPresent(int inspectedPresent) {
		this.inspectedPresent = inspectedPresent;
	}
	
	public void increaseInspectedPresents() {
		this.inspectedPresent++;
	}
	
	public Operation getOperation() {
		return operation;
	}
	
	public Integer getOperationValue() {
		return operationValue;
	}
	
	public int getDivisibleValue() {
		return divisibleValue;
	}
	
	public int getTestPositiveOutput() {
		return testPositiveOutput;
	}
	
	public int getTestNegativeOutput() {
		return testNegativeOutput;
	}
	
	public Present removePresent(Present present) {
		this.presentList.remove(present);
		return present;
	}
	
	@Override
	public String toString() {
		return "Monkey{" +
				"id=" + id +
				'}';
	}
}
