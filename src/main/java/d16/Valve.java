package d16;

import java.util.List;

public class Valve {
	
	private final long pressure;
	private final String name;
	private List<String> adjacentValves;
	
	private boolean isValveOpen;
	
	public Valve(String name, int pressure, List<String> adjacentValves) {
		this.name = name;
		this.pressure = pressure;
		this.adjacentValves = adjacentValves;
		this.isValveOpen = false;
	}
	
	public boolean isValveOpen() {
		return isValveOpen;
	}
	
	public long getPressure() {
		return pressure;
	}
	
	public String getName() {
		return name;
	}
	
	public List<String> getAdjacentValves() {
		return adjacentValves;
	}
	
}
