package d10;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
	private Map<Integer, Long> register = new TreeMap<>();
	private Long lastValue;
	private Character LIT_PIXEL = '.';
	private Character DARK_PIXEL = '#';
	List<Character> crtScreen = new ArrayList<>();
	
	public void compute(List<String> input) {
		initRegister();
		performAllInstructions(input);
		
		calculateSignalStrength();
		
		drawImage();
	}
	
	private void calculateSignalStrength() {
		long result = 20 * register.get(20) +
				60 * register.get(60) +
				100 * register.get(100) +
				140 * register.get(140) +
				180 * register.get(180) +
				220 * register.get(220);
		System.out.println("Signal Strength: " + result);
	}
	
	private void initRegister() {
		lastValue = 1L;
		register.put(1, lastValue);
	}
	
	private void performAllInstructions(List<String> input) {
		int index = 1;
		for (String instruction : input) {
			String[] parsedInstruction = instruction.split(StringUtils.SPACE);
			if ("noop".equals(parsedInstruction[0])) {
				drawPixel(++index);
				register.put(index, getCurrentRegisterValue());
			} else {
				drawPixel(++index);
				register.put(index, getCurrentRegisterValue());
				
				drawPixel(++index);
				register.put(index, getCurrentRegisterValue() + Long.parseLong(parsedInstruction[1]));
				lastValue = register.get(index);
			}
		}
	}
	
	private void drawPixel(int index) {
		int crtIndex = (index - 2) % 40;
		System.out.println("Drawing Index: " + index + ", ScreenPosition: " + crtIndex + ", signalPosition = " + getCurrentRegisterValue());
		
		char pixel = (getCurrentRegisterValue() == crtIndex - 1 ||
				getCurrentRegisterValue() == crtIndex ||
				getCurrentRegisterValue() == crtIndex + 1)
				? DARK_PIXEL : LIT_PIXEL;
		
		crtScreen.add(pixel);
	}
	
	private void drawImage() {
		int index = 0;
		for (Character ch : crtScreen) {
			System.out.print(ch);
			index++;
			if (index % 40 == 0) {
				System.out.println();
			}
		}
	}
	
	private Long getCurrentRegisterValue() {
		return lastValue;
	}
}
