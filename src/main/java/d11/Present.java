package d11;

public class Present {
	private long worryLevel;
	
	public Present(long worryLevel) {
		this.worryLevel = worryLevel;
	}
	
	public void increaseWorryLevel(Monkey.Operation operation, Integer operationValue) {
		switch (operation) {
			case ADD -> worryLevel += operationValue;
			case SQUARE -> worryLevel *= worryLevel;
			case MULTIPLE -> worryLevel *= operationValue;
		}
	}
	
	public void divideWorryLevelByThree() {
		worryLevel /= 3;
		
	}
	
	public void handleWorryLevel(long worryDivisable) {
		worryLevel = worryLevel % worryDivisable;
	}
	
	public long getWorryLevel() {
		return worryLevel;
	}
	
	@Override
	public String toString() {
		return "Present{" +
				"worryLevel=" + worryLevel +
				'}';
	}
}
