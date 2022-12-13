package d03;

import java.util.List;
import java.util.NoSuchElementException;

public class Solution {
	
	public int compute(List<String> input) {
		int output = 0;
		for (String str : input) {
			char commonChar = getCommonChar(str);
			int value = calculateValue(commonChar);
			output += value;
		}
		return output;
	}
	
	private static char getCommonChar(String str) {
		String s1a = str.substring(0, (str.length() / 2));
		String s1b = str.substring((str.length() / 2));
		
		for (char ch : s1a.toCharArray()) {
			if (s1b.contains(String.valueOf(ch))) {
				return ch;
			}
		}
		throw new NoSuchElementException();
	}
	
	public int computePartB(List<String> input) {
		int output = 0;
		for (int i = 0; i < input.size(); i = i + 3) {
			String a = input.get(i);
			String b = input.get(i + 1);
			String c = input.get(i + 2);
			char commonChar = getCommonBadge(a, b, c);
			int value = calculateValue(commonChar);
			output += value;
		}
		return output;
	}
	
	private char getCommonBadge(String a, String b, String c) {
		for (char ch : a.toCharArray()) {
			if (b.contains(String.valueOf(ch)) && c.contains(String.valueOf(ch))) {
				return ch;
			}
		}
		throw new NoSuchElementException();
	}
	
	public int calculateValue(char ch) {
		if (Character.isLowerCase(ch))
			return ch - 'a' + 1;
		else
			return ch - 'A' + 27;
	}
	
}
