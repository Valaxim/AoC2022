package d13;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class SolutionTest {
	
	@Test
	public void test1() {
		String left = "[1,1,3,1,1]";
		String right = "[1,1,5,1,1]";
		
		Solution solution = new Solution();
		boolean isInRightOrder = solution.compute(left, right);
		assertTrue(isInRightOrder);
	}
	
	@Test
	public void test2() {
		String left = "[[1],[2,3,4]]";
		String right = "[[1],4]";
		
		Solution solution = new Solution();
		boolean isInRightOrder = solution.compute(left, right);
		assertTrue(isInRightOrder);
	}
	
	@Test
	public void test3() {
		String left = "[9]";
		String right = "[[8,7,6]]";
		
		Solution solution = new Solution();
		boolean isInRightOrder = solution.compute(left, right);
		assertFalse(isInRightOrder);
	}
	
	@Test
	public void test4() {
		String left = "[[4,4],4,4]";
		String right = "[[4,4],4,4,4]";
		
		Solution solution = new Solution();
		boolean isInRightOrder = solution.compute(left, right);
		assertTrue(isInRightOrder);
	}
	
	@Test
	public void test5() {
		String left = "[7,7,7,7]";
		String right = "[7,7,7]";
		
		Solution solution = new Solution();
		boolean isInRightOrder = solution.compute(left, right);
		assertFalse(isInRightOrder);
	}
	
	@Test
	public void test6() {
		String left = "[]";
		String right = "[3]";
		
		Solution solution = new Solution();
		boolean isInRightOrder = solution.compute(left, right);
		assertTrue(isInRightOrder);
	}
	
	@Test
	public void test7() {
		String left = "[[[]]]";
		String right = "[[]]";
		
		Solution solution = new Solution();
		boolean isInRightOrder = solution.compute(left, right);
		assertFalse(isInRightOrder);
	}
	
	@Test
	public void test8() {
		String left = "[1,[2,[3,[4,[5,6,7]]]],8,9]";
		String right = "[1,[2,[3,[4,[5,6,0]]]],8,9]";
		
		Solution solution = new Solution();
		boolean isInRightOrder = solution.compute(left, right);
		assertFalse(isInRightOrder);
	}
}