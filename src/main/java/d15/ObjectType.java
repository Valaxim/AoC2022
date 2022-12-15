package d15;

public enum ObjectType {
	
	BEACON('B'),
	SENSOR('S'),
	NO_SIGNAL('.'),
	SIGNAL('#'),
	TO_ANALYZE('!');
	
	private final char type;
	
	ObjectType(char symbol) {
		this.type = symbol;
	}
	
	public char getValue() {
		return type;
	}
}
