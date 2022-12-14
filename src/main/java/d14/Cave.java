package d14;

import java.util.Arrays;
import java.util.List;

public class Cave {
	
	protected char[][] caveStructure;
	protected int caveDepth = 0;
	
	protected Cave(List<String> caveStructureInstructions) {
		initCaveStructure(caveStructureInstructions);
	}
	
	private void initCaveStructure(List<String> caveStructureInstructions) {
		caveStructure = new char[300][1000];
		for (char[] chars : caveStructure) {
			Arrays.fill(chars, Structure.AIR.getValue());
		}
		caveStructure[0][500] = Structure.SAND_SOURCE.getValue();
		
		for (String instruction : caveStructureInstructions) {
			String[] splitInstruction = instruction.split("->");
			for (int index = 0; index < splitInstruction.length - 1; index++) {
				placeRockLine(splitInstruction[index], splitInstruction[index + 1]);
			}
		}
		
	}
	
	private void placeRockLine(String startLine, String endLine) {
		String[] startLinePoint = startLine.split(",");
		String[] endLinePoint = endLine.split(",");
		int x1 = Integer.parseInt(startLinePoint[0].trim());
		int y1 = Integer.parseInt(startLinePoint[1].trim());
		int x2 = Integer.parseInt(endLinePoint[0].trim());
		int y2 = Integer.parseInt(endLinePoint[1].trim());
		
		for (int y = Math.min(y1, y2); y <= Math.max(y1, y2); y++) {
			for (int x = Math.min(x1, x2); x <= Math.max(x1, x2); x++) {
				caveStructure[y][x] = Structure.ROCK.getValue();
				caveDepth = Math.max(caveDepth, y);
			}
		}
	}
	
	
	public void draw() {
		int minX = 400;
		int maxX = 600;
		int maxY = 200;
		
		for (int y = 0; y <= maxY; y++) {
			for (int x = minX; x <= maxX; x++) {
				System.out.print(caveStructure[y][x]);
			}
			System.out.println();
		}
	}
	
	public void pourSand() {
		int sandNo = 0;
		while (pourSandUnit(0, 500)) {
			sandNo++;
		}
		System.out.println("Cave depth: " + caveDepth);
		System.out.println("Sand No: " + sandNo);
	}
	
	private boolean pourSandUnit(int y, int x) {
		if (stopCondition(y, x)) {
			return false;
		}
		if (caveStructure[y + 1][x] == Structure.AIR.getValue()) {
			return pourSandUnit(y + 1, x);
		} else if (caveStructure[y + 1][x - 1] == Structure.AIR.getValue()) {
			return pourSandUnit(y + 1, x - 1);
		} else if (caveStructure[y + 1][x + 1] == Structure.AIR.getValue()) {
			return pourSandUnit(y + 1, x + 1);
		}
		caveStructure[y][x] = Structure.WATER.getValue();
		return true;
	}
	
	protected boolean stopCondition(int y, int x) {
		return y > caveDepth;
	}
}
