package d16;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
	
	private List<Valve> tunnel;
	
	// record that holds all opened Valve with time frame, current value, total flow
	public record State(Map<String, Long> open, Valve valve, long totalFlow) {
	}
	
	public Solution(List<String> instructions) {
		this.tunnel = new ArrayList<>();
		initTunnel(instructions);
	}
	
	private void initTunnel(List<String> instructions) {
		for (String instruction : instructions) {
			String[] split = instruction.replaceAll("[;,]", StringUtils.EMPTY).split(StringUtils.SPACE);
			int pressureRate = Integer.parseInt(split[4].replace("rate=", StringUtils.EMPTY));
			List<String> strings = Arrays.stream(Arrays.copyOfRange(split, 9, split.length)).toList();
			tunnel.add(new Valve(split[1], pressureRate, strings));
		}
	}
	
	public long calculateTotalPressure(int timeTillExplosion, String firstValve) {
		Valve startingValve = getValveByName(firstValve);
		int releasedPressure = 0;
		
		Set<State> states = new HashSet<>();
		states.add(new State(new HashMap<>(), startingValve, releasedPressure));
		
		for (int time = 0; time < timeTillExplosion; time++) {
			Set<State> newStates = new HashSet<>();
			
			for (State state : states) {
				// calculateCurrentFlow
				long currentFlow = state.totalFlow() + state.open()
						.values().stream()
						.mapToLong(Long::longValue)
						.sum();
				
				// open if possible
				if (!state.valve.isValveOpen() && state.valve.getPressure() > 0) {
					Map<String, Long> newOpenedValue = new HashMap<>(state.open());
					newOpenedValue.put(state.valve.getName(), state.valve.getPressure());
					newStates.add(new State(newOpenedValue, state.valve(), currentFlow));
				}
				// go to all adjacent values
				state.valve.getAdjacentValves()
						.forEach(name -> newStates.add(new State(state.open, getValveByName(name), currentFlow)));
			}
			states = newStates;
		}
		
		return states.stream()
				.mapToLong(State::totalFlow)
				.max()
				.getAsLong();
	}
	
	private Valve getValveByName(String name) {
		return tunnel.stream()
				.filter(item -> item.getName().equals(name))
				.findFirst()
				.orElse(null);
	}
}
