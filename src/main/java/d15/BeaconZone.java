package d15;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeaconZone {
	
	private static final String COMMA = ",";
	private Map<Point, ObjectType> beaconMap;
	private Map<Point, Integer> sensorSignalRangeMap;
	
	private record Point(int x, int y) {
	}
	
	public BeaconZone(List<String> input) {
		beaconMap = new HashMap<>();
		sensorSignalRangeMap = new HashMap<>();
		gatherExistingBeacons(input);
	}
	
	private void gatherExistingBeacons(List<String> input) {
		for (String instruction : input) {
			int[] coordinates = Arrays.stream(instruction.replace("Sensor at ", StringUtils.EMPTY)
							.replace(": closest beacon is at x=", COMMA)
							.replace("x=", StringUtils.EMPTY)
							.replace("y=", StringUtils.EMPTY)
							.split(COMMA))
					.map(String::trim)
					.mapToInt(Integer::parseInt).toArray();
			insertObjectWithGeneratedSignal(coordinates);
		}
	}
	
	private void insertObjectWithGeneratedSignal(int[] coordinates) {
		int distance = calculateManhattanDistanceFromSensorToBeacon(coordinates);
		beaconMap.put(new Point(coordinates[0], coordinates[1]), ObjectType.SENSOR);
		beaconMap.put(new Point(coordinates[2], coordinates[3]), ObjectType.BEACON);
		
		sensorSignalRangeMap.put(new Point(coordinates[0], coordinates[1]), distance);
	}
	
	
	private int calculateManhattanDistanceFromSensorToBeacon(int[] coordinates) {
		return Math.abs(coordinates[0] - coordinates[2]) + Math.abs(coordinates[1] - coordinates[3]);
	}
	
	private int calculateManhattanDistanceFromSensorToSpecificPosition(Point key, int rowIndex) {
		return Math.abs(key.y() - rowIndex);
	}
	
	private int calculateDistance(Point key1, Point key2) {
		return Math.abs(key1.x() - key2.x()) + Math.abs(key1.y() - key2.y());
	}
	
	public void draw() {
		int minX = -10;
		int maxX = 30;
		int minY = -10;
		int maxY = 30;
		
		for (int y = minY; y <= maxY; y++) {
			for (int x = minX; x <= maxX; x++) {
				System.out.print(getBeaconMap().getOrDefault(new Point(x, y), ObjectType.NO_SIGNAL).getValue());
			}
			System.out.println();
		}
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
	}
	
	public Map<Point, ObjectType> getBeaconMap() {
		return beaconMap;
	}
	
	public int getAllSignalFromRow(int rowIndex) {
		
		for (var item : sensorSignalRangeMap.entrySet()) {
			Point signalSource = item.getKey();
			int signalRange = item.getValue();
			int rangeToSpecificRow = calculateManhattanDistanceFromSensorToSpecificPosition(item.getKey(), rowIndex);
			if (signalRange >= rangeToSpecificRow) {
				int rangeThanCanBeUsed = signalRange - rangeToSpecificRow;
				for (int i = -rangeThanCanBeUsed; i <= rangeThanCanBeUsed; i++) {
					beaconMap.putIfAbsent(new Point(signalSource.x() + i, rowIndex), ObjectType.SIGNAL);
				}
				
				System.out.println("Drawing " + signalSource.x() + ", " + signalSource.y() + " with distance: " + signalRange
						+ " from: X: " + (signalSource.x() - rangeThanCanBeUsed) + " to X: " + (signalSource.x() + rangeThanCanBeUsed));
			}
		}
		
		return (int) beaconMap.entrySet().stream()
				.filter(it -> it.getKey().y() == rowIndex)
				.filter(it -> it.getValue().equals(ObjectType.SIGNAL))
				.count();
	}
	
	
	public void getMissingSignalInFrame(int minValue, int maxValue) {
		for (var item : sensorSignalRangeMap.entrySet()) {
			Point key = item.getKey();
			int distance = item.getValue();
			for (int i = 0; i <= distance; i++) {
				beaconMap.putIfAbsent(new Point(key.x() + i + 1, key.y() + (distance - i)), ObjectType.TO_ANALYZE); // BOTTOM-RIGHT
				beaconMap.putIfAbsent(new Point(key.x() - i - 1, key.y() - (distance - i)), ObjectType.TO_ANALYZE); // UPPER-LEFT
				beaconMap.putIfAbsent(new Point(key.x() + i, key.y() - (distance - i) - 1), ObjectType.TO_ANALYZE); // UPPER-RIGHT
				beaconMap.putIfAbsent(new Point(key.x() - i, key.y() + (distance - i) + 1), ObjectType.TO_ANALYZE); // BOTTOM-LEFT
			}
		}
		
		for (var itemToAnalyze : beaconMap.entrySet().stream().filter(it -> it.getValue().equals(ObjectType.TO_ANALYZE)).toList()) {
			int x = itemToAnalyze.getKey().x();
			int y = itemToAnalyze.getKey().y();
			
			outer:
			if (x >= minValue && x <= maxValue && y >= minValue && y <= maxValue) {
				for (var signalSource : sensorSignalRangeMap.entrySet()) {
					int distance = calculateDistance(itemToAnalyze.getKey(), signalSource.getKey());
					if (distance <= signalSource.getValue()) {
						break outer;
					}
				}
				BigDecimal bigDecimal =
						BigDecimal.valueOf(maxValue).multiply(BigDecimal.valueOf(itemToAnalyze.getKey().x())).add(BigDecimal.valueOf(itemToAnalyze.getKey().y()));
				System.out.println("Expected output: x: " + itemToAnalyze.getKey().x() + ", y: " + itemToAnalyze.getKey().y() + " " +
						"result: " + bigDecimal);
			}
		}
	}
}
	
	

