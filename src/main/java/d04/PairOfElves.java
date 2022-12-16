package d04;

public class PairOfElves {
	
	private int firstElfStartRange;
	private int firstElfEndRange;
	private int secondElfStartRange;
	private int secondElfEndRange;
	
	public PairOfElves(String data) {
		String replacedStr = data.replace(",", "-");
		String[] split = replacedStr.split("-");
		
		this.firstElfStartRange = Integer.parseInt(split[0]);
		this.firstElfEndRange = Integer.parseInt(split[1]);
		this.secondElfStartRange = Integer.parseInt(split[2]);
		this.secondElfEndRange = Integer.parseInt(split[3]);
	}
	
	public boolean fullyContainsTheOther() {
		if (firstElfStartRange <= secondElfStartRange && firstElfEndRange >= secondElfEndRange) {
			return true;
		} else return secondElfStartRange <= firstElfStartRange && secondElfEndRange >= firstElfEndRange;
	}
	
	public boolean isOverlapping() {
		if (secondElfStartRange >= firstElfStartRange && secondElfStartRange <= firstElfEndRange) { // case: 2 <= 3 <= 8
			return true;
		} else if (secondElfEndRange >= firstElfStartRange && secondElfEndRange <= firstElfEndRange) { // case: 2 <= 11 <= 8
			return true;
		} else return fullyContainsTheOther(); // cover case 19-12, 2-93
	}
	
}
