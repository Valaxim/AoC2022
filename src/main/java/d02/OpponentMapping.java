package d02;

public enum OpponentMapping {
	ROCK("A"),
	PAPER("B"),
	SCISSORS("C");
	
	private String code;
	
	OpponentMapping(String typeCode) {
		this.code = typeCode;
	}
	
	public String getValue() {
		return this.code;
	}
	
}
