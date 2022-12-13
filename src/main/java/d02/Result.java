package d02;

public enum Result {
	WIN(6),
	DRAW(3),
	LOSE(0);
	
	private Integer points;
	
	Result(Integer points) {
		this.points = points;
	}
	
	public Integer getValue() {
		return this.points;
	}
}

