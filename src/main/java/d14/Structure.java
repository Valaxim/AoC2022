package d14;

public enum Structure {
	
	ROCK('#'),
	WATER('o'),
	AIR('.'),
	SAND_SOURCE('+');
	
	private char value;
	
	Structure(char symbol) {
		this.value = symbol;
	}
	
	public char getValue() {
		return value;
	}
}
