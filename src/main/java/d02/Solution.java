package d02;

import java.util.List;

public class Solution {
	
	public static int getSum(List<String> input) {
		int sum = 0;
		for (String str: input) {
			String[] s = str.split(" ");
			sum += new Pairing(s[0], s[1]).fight();
		}
		return sum;
	}
	
	public static int getPartB(List<String> input) {
		int sum = 0;
		for (String str: input) {
			String[] s = str.split(" ");
			sum += new Pairing(s[0], s[1]).fightWithDesiredOutput();
		}
		return sum;
	}
}
