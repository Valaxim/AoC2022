package test.java;


import d03.Solution;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDay3 {
	@Test
	public void test1() {
		List<String> strings = readTestData();
		
		assertEquals(new Solution().compute(strings), 157);
	}
	
	@Test
	public void test2() {
		List<String> strings = readTestData();
		
		assertEquals(new Solution().computePartB(strings), 70);
	}
	
	
	private List<String> readTestData() {
		List<String> testData = List.of("vJrwpWtwJgWrhcsFMMfFFhFp",
				"jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
				"PmmdzqPrVvPwwTWBwg",
				"wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn",
				"ttgJtRGJQctTZtZT",
				"CrZsJsPPZsGzwwsLwLmpwMDw");
		return testData;
	}
	
	
}
