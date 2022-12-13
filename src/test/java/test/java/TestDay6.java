package test.java;

import d06.Day6;
import d06.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDay6 {
	@Test
	public void test1_A() {
		String input = "mjqjpqmgbljsphdztnvjfqwrcgsmlb";
		assertEquals(new Solution().compute(input, Day6.REQUIRED_DISTINCT_CHARACTER_NUMBER_PART_A), 7);
	}
	
	@Test
	public void test2_A() {
		String input = "bvwbjplbgvbhsrlpgdmjqwftvncz";
		assertEquals(new Solution().compute(input, Day6.REQUIRED_DISTINCT_CHARACTER_NUMBER_PART_A), 5);
	}
	
	@Test
	public void test3_A() {
		String input = "nppdvjthqldpwncqszvftbrmjlhg";
		assertEquals(new Solution().compute(input, Day6.REQUIRED_DISTINCT_CHARACTER_NUMBER_PART_A), 6);
	}
	
	@Test
	public void test4_A() {
		String input = "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg";
		assertEquals(new Solution().compute(input, Day6.REQUIRED_DISTINCT_CHARACTER_NUMBER_PART_A), 10);
	}
	
	@Test
	public void test5_A() {
		String input = "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw";
		assertEquals(new Solution().compute(input, Day6.REQUIRED_DISTINCT_CHARACTER_NUMBER_PART_A), 11);
	}
	
	@Test
	public void test1_B() {
		String input = "mjqjpqmgbljsphdztnvjfqwrcgsmlb";
		assertEquals(new Solution().compute(input, Day6.REQUIRED_DISTINCT_CHARACTER_NUMBER_PART_B), 19);
	}
	
	@Test
	public void test2_B() {
		String input = "bvwbjplbgvbhsrlpgdmjqwftvncz";
		assertEquals(new Solution().compute(input, Day6.REQUIRED_DISTINCT_CHARACTER_NUMBER_PART_B), 23);
	}
	
	@Test
	public void test3_B() {
		String input = "nppdvjthqldpwncqszvftbrmjlhg";
		assertEquals(new Solution().compute(input, Day6.REQUIRED_DISTINCT_CHARACTER_NUMBER_PART_B), 23);
	}
	
	@Test
	public void test4_B() {
		String input = "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg";
		assertEquals(new Solution().compute(input, Day6.REQUIRED_DISTINCT_CHARACTER_NUMBER_PART_B), 29);
	}
	
	@Test
	public void test5_B() {
		String input = "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw";
		assertEquals(new Solution().compute(input, Day6.REQUIRED_DISTINCT_CHARACTER_NUMBER_PART_B), 26);
	}
	
	
}
