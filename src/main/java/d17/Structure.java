package d17;

public enum Structure {
	
	ROCK('#'),
	FALLING_ROCK('@'),
	AIR('.'),
	GROUND('-');
	
	private char value;
	
	Structure(char symbol) {
		this.value = symbol;
	}
	
	public char getValue() {
		return value;
	}
}
