package d02;

public enum MyMapping {
	ROCK("X"),
	PAPER("Y"),
	SCISSORS("Z");
	
	private String code;
	
	MyMapping(String typeCode) {
		this.code = new String(typeCode);
	}
	
	public String getValue() {
		return this.code;
	}
}

