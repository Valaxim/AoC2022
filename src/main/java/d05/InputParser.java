package d05;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class InputParser {
	
	public static Map<Integer, Deque<String>> getTestData() {
		Deque<String> deque1 = new ArrayDeque<>();
		deque1.add("Z");
		deque1.add("N");
		
		Deque<String> deque2 = new ArrayDeque<>();
		deque2.add("M");
		deque2.add("C");
		deque2.add("D");
		
		Deque<String> deque3 = new ArrayDeque<>();
		deque3.add("P");
		
		Map<Integer, Deque<String>> map = new HashMap<>();
		map.put(1, deque1);
		map.put(2, deque2);
		map.put(3, deque3);
		return map;
	}
	
	public static Map<Integer, Deque<String>> getProductionData() {
		Deque<String> deque1 = new ArrayDeque<>();
		deque1.add("W");
		deque1.add("B");
		deque1.add("D");
		deque1.add("N");
		deque1.add("C");
		deque1.add("F");
		deque1.add("J");
		
		Deque<String> deque2 = new ArrayDeque<>();
		deque2.add("P");
		deque2.add("Z");
		deque2.add("V");
		deque2.add("Q");
		deque2.add("L");
		deque2.add("S");
		deque2.add("T");
		
		Deque<String> deque3 = new ArrayDeque<>();
		deque3.add("P");
		deque3.add("Z");
		deque3.add("B");
		deque3.add("G");
		deque3.add("J");
		deque3.add("T");
		
		Deque<String> deque4 = new ArrayDeque<>();
		deque4.add("D");
		deque4.add("T");
		deque4.add("L");
		deque4.add("J");
		deque4.add("Z");
		deque4.add("B");
		deque4.add("H");
		deque4.add("C");
		
		Deque<String> deque5 = new ArrayDeque<>();
		deque5.add("G");
		deque5.add("V");
		deque5.add("B");
		deque5.add("J");
		deque5.add("S");
		
		Deque<String> deque6 = new ArrayDeque<>();
		deque6.add("P");
		deque6.add("S");
		deque6.add("Q");
		
		Deque<String> deque7 = new ArrayDeque<>();
		deque7.add("B");
		deque7.add("V");
		deque7.add("D");
		deque7.add("F");
		deque7.add("L");
		deque7.add("M");
		deque7.add("P");
		deque7.add("N");
		
		Deque<String> deque8 = new ArrayDeque<>();
		deque8.add("P");
		deque8.add("S");
		deque8.add("M");
		deque8.add("F");
		deque8.add("B");
		deque8.add("D");
		deque8.add("L");
		deque8.add("R");
		
		Deque<String> deque9 = new ArrayDeque<>();
		deque9.add("V");
		deque9.add("D");
		deque9.add("T");
		deque9.add("R");
		
		Map<Integer, Deque<String>> map = new HashMap<>();
		map.put(1, deque1);
		map.put(2, deque2);
		map.put(3, deque3);
		map.put(4, deque4);
		map.put(5, deque5);
		map.put(6, deque6);
		map.put(7, deque7);
		map.put(8, deque8);
		map.put(9, deque9);
		
		return map;
	}
}