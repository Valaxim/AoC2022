package test.java;


import d04.Solution;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDay4 {
	@Test
	public void test1() {
		List<String> strings = readTestData();
		assertEquals(new Solution().computePartA(strings), 2);
	}
	
	@Test
	public void test2() {
		List<String> strings = readTestData();
		
		assertEquals(new Solution().computePartB(strings), 4);
	}
	
	
	private List<String> readTestData() {
		List<String> testData = List.of("2-4,6-8",
				"2-3,4-5",
				"5-7,7-9",
				"2-8,3-7",
				"6-6,4-6",
				"2-6,4-8");
		return testData;
	}
	
}
