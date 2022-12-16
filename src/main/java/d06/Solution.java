package d06;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	
	public int compute(String input, int requiredDistinctCharacterNumber) {
		int output = 0;
		for (int i = 0; i < input.length() - requiredDistinctCharacterNumber; i++) {
			Set<Character> set = new HashSet<>();
			for (int j = 0; j < requiredDistinctCharacterNumber; j++) {
				set.add(input.charAt(i + j));
			}
			if (set.size() == requiredDistinctCharacterNumber) {
				return i + requiredDistinctCharacterNumber;  // i + 3 + 1 (we don't count from 0 but 1
			}
		}
		return output;
	}
	
}
