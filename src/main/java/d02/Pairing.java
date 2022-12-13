package d02;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Pairing {
	
	private OpponentMapping opponentMapping;
	private MyMapping myMapping;
	
	public Pairing(String opponentChoice, String myChoice) {
		if (opponentChoice.equals(OpponentMapping.ROCK.getValue())) {
			this.opponentMapping = OpponentMapping.ROCK;
		} else if (opponentChoice.equals(OpponentMapping.PAPER.getValue())) {
			this.opponentMapping = OpponentMapping.PAPER;
		} else {
			this.opponentMapping = OpponentMapping.SCISSORS;
		}
		
		if (myChoice.equals(MyMapping.ROCK.getValue())) {
			this.myMapping = MyMapping.ROCK;
		} else if (myChoice.equals(MyMapping.PAPER.getValue())) {
			this.myMapping = MyMapping.PAPER;
		} else {
			this.myMapping = MyMapping.SCISSORS;
		}
	}
	
	public Pairing(OpponentMapping opponentChoice, MyMapping myChoice) {
		this.opponentMapping = opponentChoice;
		this.myMapping = myChoice;
	}
	
	public static Map<Pairing, Result> possibleOutcomes() {
		Map<Pairing, Result> possibleOutcomes = new HashMap<>();
		possibleOutcomes.put(new Pairing(OpponentMapping.ROCK, MyMapping.ROCK), Result.DRAW);
		possibleOutcomes.put(new Pairing(OpponentMapping.ROCK, MyMapping.PAPER), Result.WIN);
		possibleOutcomes.put(new Pairing(OpponentMapping.ROCK, MyMapping.SCISSORS), Result.LOSE);
		possibleOutcomes.put(new Pairing(OpponentMapping.PAPER, MyMapping.PAPER), Result.DRAW);
		possibleOutcomes.put(new Pairing(OpponentMapping.PAPER, MyMapping.SCISSORS), Result.WIN);
		possibleOutcomes.put(new Pairing(OpponentMapping.PAPER, MyMapping.ROCK), Result.LOSE);
		possibleOutcomes.put(new Pairing(OpponentMapping.SCISSORS, MyMapping.SCISSORS), Result.DRAW);
		possibleOutcomes.put(new Pairing(OpponentMapping.SCISSORS, MyMapping.ROCK), Result.WIN);
		possibleOutcomes.put(new Pairing(OpponentMapping.SCISSORS, MyMapping.PAPER), Result.LOSE);
		return possibleOutcomes;
	}
	
	private int getPointsFromSpecificChoice() {
		return switch (myMapping) {
			case ROCK -> 1;
			case PAPER -> 2;
			case SCISSORS -> 3;
		};
	}
	
	public int fight() {
		int sum = 0;
		sum += possibleOutcomes().get(this).getValue();
		sum += getPointsFromSpecificChoice();
		return sum;
	}
	
	public int fightWithDesiredOutput() {
		replaceKeyWithResult();
		return fight();
	}
	
	private void replaceKeyWithResult() {
		Result var = switch (this.myMapping) {
			case ROCK -> Result.LOSE;
			case PAPER -> Result.DRAW;
			case SCISSORS -> Result.WIN;
		};
		determineUserChoice(var);
	}
	
	private void determineUserChoice(Result var) {
		MyMapping expectedMapping;
		if (possibleOutcomes().get(new Pairing(this.opponentMapping, MyMapping.PAPER)).equals(var)) {
			expectedMapping = MyMapping.PAPER;
		} else if (possibleOutcomes().get(new Pairing(this.opponentMapping, MyMapping.ROCK)).equals(var)) {
			expectedMapping = MyMapping.ROCK;
		} else {
			expectedMapping = MyMapping.SCISSORS;
		}
		this.myMapping = expectedMapping;
	}
	
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Pairing pairing = (Pairing) o;
		return opponentMapping == pairing.opponentMapping && myMapping == pairing.myMapping;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(opponentMapping, myMapping);
	}
}
