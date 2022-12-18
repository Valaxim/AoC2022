package d17;

import org.apache.commons.lang3.tuple.MutablePair;

import java.util.List;

public enum Rock {
	FIRST_ROCK("####"),
	
	SECOND_ROCK(".#.\n###\n.#."),
	THIRD_ROCK("..#\n..#\n###"),
	FOURTH_ROCK("#\n#\n#\n#"),
	FIFTH_ROCK("##\n##");
	
	private final String symbol;
	
	Rock(String symbol) {
		this.symbol = symbol;
	}
	
	
	// MutablePair.of(y,x)
	public List<MutablePair<Integer, Integer>> getValue(int height) {
		return switch (this) {
			case FIRST_ROCK -> List.of(
					MutablePair.of(height, 2),
					MutablePair.of(height, 3),
					MutablePair.of(height, 4),
					MutablePair.of(height, 5));
			case SECOND_ROCK -> List.of(
					MutablePair.of(height, 3),
					MutablePair.of(height + 1, 2),
					MutablePair.of(height + 1, 3),
					MutablePair.of(height + 1, 4),
					MutablePair.of(height + 2, 3));
			case THIRD_ROCK -> List.of(
					MutablePair.of(height, 2),
					MutablePair.of(height, 3),
					MutablePair.of(height, 4),
					MutablePair.of(height + 1, 4),
					MutablePair.of(height + 2, 4));
			case FOURTH_ROCK -> List.of(
					MutablePair.of(height, 2),
					MutablePair.of(height + 1, 2),
					MutablePair.of(height + 2, 2),
					MutablePair.of(height + 3, 2));
			case FIFTH_ROCK -> List.of(
					MutablePair.of(height, 2),
					MutablePair.of(height, 3),
					MutablePair.of(height + 1, 2),
					MutablePair.of(height + 1, 3));
		};
	}
}
