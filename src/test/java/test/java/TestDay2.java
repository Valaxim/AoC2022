package test.java;

import d02.Solution;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDay2 {
	@Test
	public void test1() {
		List<String> integers = readTestData();
		
		assertEquals(Solution.getSum(integers), 15);
	}
	
	@Test
	public void test2() {
		List<String> integers = readTestData();

		assertEquals(Solution.getPartB(integers), 12);
	}

	
	private List<String> readTestData() {
		List<String> testData = List.of("A Y", "B X", "C Z");
			return testData;
	}
	
	
}
