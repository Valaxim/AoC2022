package d17;

import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Solution {
	
	private char[][] tower;
	private static final int TOWER_WIDTH = 7;
	private static final long DISTANCE_BETWEEN_GROUND = 3;
	
	private Set<State> towerState = new HashSet<>();
	
	private boolean isCycleDetected;
	
	record State(int rockNumber, int towerHeight, Rock rockShape, int windInstructionNumber, String lastTowerRow) {
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			State state = (State) o;
			return windInstructionNumber == state.windInstructionNumber && rockShape == state.rockShape && Objects.equals(lastTowerRow, state.lastTowerRow);
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(rockShape, windInstructionNumber, lastTowerRow);
		}
	}
	
	public long computePartA(List<String> input, long amountOfRocks) {
		tower = new char[55000][TOWER_WIDTH];
		for (char[] chars : tower) {
			Arrays.fill(chars, Structure.AIR.getValue());
		}
		
		int rockNumber = 0;
		int windInstruction = 0;
		long towerHeight;
		Rock activeRock = null;
		char[] charArray = input.get(0).toCharArray();
		List<MutablePair<Integer, Integer>> values = null;
		int windPatternLength = charArray.length;
		
		while (rockNumber < amountOfRocks + 1) {
			char windDirection = charArray[windInstruction % windPatternLength];
			if (activeRock == null) {
				rockNumber++;
				activeRock = generateRock(rockNumber);
				towerHeight = calculateTowerHeight() + DISTANCE_BETWEEN_GROUND;
				values = activeRock.getValue((int) towerHeight);
			}
			
			blowRock(values, windDirection);
			windInstruction++;
			
			boolean isRockReachGround = fallRock(values);
			if (isRockReachGround) {
				activeRock = null;
			}
		}
		return calculateTowerHeight();
	}
	
	public long computePartB(List<String> input, long amountOfRocks) {
		tower = new char[55000][TOWER_WIDTH];
		for (char[] chars : tower) {
			Arrays.fill(chars, Structure.AIR.getValue());
		}
		
		int rockNumber = 0;
		int windInstruction = 0;
		long towerHeight;
		long towerHeightThatShouldBeAdded = 0;
		Rock activeRock = null;
		char[] charArray = input.get(0).toCharArray();
		List<MutablePair<Integer, Integer>> values = null;
		Pair<State, State> cyclePair;
		
		int windPatternLength = charArray.length;
		
		while (rockNumber < amountOfRocks + 1) {
			char windDirection = charArray[windInstruction % windPatternLength];
			if (activeRock == null) {
				rockNumber++;
				activeRock = generateRock(rockNumber);
				towerHeight = calculateTowerHeight() + DISTANCE_BETWEEN_GROUND;
				values = activeRock.getValue((int) towerHeight);
			}
			
			blowRock(values, windDirection);
			windInstruction++;
			
			
			boolean isRockReachGround = fallRock(values);
			if (isRockReachGround) {
				if (!isCycleDetected) {
					cyclePair = detectCycle(rockNumber, windInstruction % windPatternLength, (int) calculateTowerHeight());
					if (cyclePair != null) {
						List<Long> longs = reduceInstructionAmount(cyclePair, amountOfRocks, rockNumber);
						amountOfRocks = rockNumber + longs.get(0);
						towerHeightThatShouldBeAdded = longs.get(1);
					}
				}
				activeRock = null;
			}
		}
		return calculateTowerHeight() + towerHeightThatShouldBeAdded;
	}
	
	private static List<Long> reduceInstructionAmount(Pair<State, State> cyclePair, long amountOfRocks, long currentRockNumber) {
		State left = cyclePair.getLeft();
		State right = cyclePair.getRight();
		long differenceInRocks = (long) right.rockNumber - left.rockNumber;
		long diffInTowerHeight = (long) right.towerHeight - left.towerHeight;
		long skippedCycle = (amountOfRocks - currentRockNumber) / differenceInRocks;
		long cycleLeft = (amountOfRocks - currentRockNumber) % differenceInRocks;
		long towerHeightWhichShouldBeAdded = diffInTowerHeight * skippedCycle;
		
		return List.of(cycleLeft, towerHeightWhichShouldBeAdded);
	}
	
	private List<MutablePair<Integer, Integer>> blowRock(List<MutablePair<Integer, Integer>> values, char windDirection) {
		boolean windIsBlockingByTowerWallOrRocks = false;
		int windCoords = (windDirection == '<') ? -1 : 1;
		if (!(values.stream()
				.anyMatch(it -> it.getRight() == 6 && windCoords == 1) || values.stream()
				.anyMatch(it -> it.getRight() == 0 && windCoords == -1))) {
			for (var item : values) {
				if (tower[item.getLeft()][item.getRight() + windCoords] != Structure.AIR.getValue()) {
					windIsBlockingByTowerWallOrRocks = true;
				}
			}
			if (!windIsBlockingByTowerWallOrRocks) {
				values.forEach(it -> it.setRight(it.getRight() + windCoords));
			}
		}
		return values;
	}
	
	private boolean fallRock(List<MutablePair<Integer, Integer>> values) {
		boolean windIsBlockingByTowerFloorOrRocks = false;
		for (var item : values) {
			if (item.getLeft() == 0 || tower[item.getLeft() - 1][item.getRight()] != Structure.AIR.getValue()) {
				windIsBlockingByTowerFloorOrRocks = true;
			}
		}
		if (!windIsBlockingByTowerFloorOrRocks) {
			values.forEach(it -> it.setLeft(it.getLeft() - 1));
		} else {
			values.forEach(it -> {
				int y = it.getLeft();
				int x = it.getRight();
				tower[y][x] = Structure.ROCK.getValue();
			});
		}
		return windIsBlockingByTowerFloorOrRocks;
	}
	
	private Rock generateRock(int rockNumber) {
		return switch (rockNumber % 5) {
			case 1 -> Rock.FIRST_ROCK;
			case 2 -> Rock.SECOND_ROCK;
			case 3 -> Rock.THIRD_ROCK;
			case 4 -> Rock.FOURTH_ROCK;
			case 0 -> Rock.FIFTH_ROCK;
			default -> throw new IllegalStateException("Unexpected value: " + rockNumber % 5);
		};
	}
	
	
	private Pair<State, State> detectCycle(int rockNumber, int windInstructionNumber, int towerHeight) {
		if (towerHeight > 10) {
			State state = new State(rockNumber, towerHeight, generateRock(rockNumber), windInstructionNumber,
					new StringBuilder()
							.append(tower[towerHeight - 1])
							.append(tower[towerHeight - 2])
							.append(tower[towerHeight - 3])
							.append(tower[towerHeight - 4])
							.append(tower[towerHeight - 5])
							.append(tower[towerHeight - 6])
							.toString());
			
			if (towerState.contains(state)) {
				State oldState = towerState.stream().filter(it -> it.equals(state)).findFirst().orElse(null);
				
				isCycleDetected = true;
				return Pair.of(oldState, state);
			} else {
				towerState.add(state);
			}
		}
		return null;
	}
	
	private long calculateTowerHeight() {
		for (int y = 0; y < tower.length; y++) {
			int emptySpace = 0;
			for (int x = 0; x < tower[0].length; x++) {
				if (tower[y][x] == Structure.ROCK.getValue() || tower[y][x] == Structure.GROUND.getValue()) {
					break;
				} else if (tower[y][x] == Structure.AIR.getValue()) {
					emptySpace++;
				}
			}
			if (emptySpace == TOWER_WIDTH) {
				return y;
			}
		}
		return Integer.MAX_VALUE;
	}
	
	public void drawTower() {
		int maxY = 3500;
		
		for (int y = maxY; y >= 0; y--) {
			System.out.print("ROW: " + y);
			for (int x = 0; x < TOWER_WIDTH; x++) {
				System.out.print(" " + tower[y][x]);
			}
			System.out.println();
		}
	}
}
