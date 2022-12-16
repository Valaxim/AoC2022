package d14;

import java.util.List;

public class CaveWithFloor extends Cave {
	
	public CaveWithFloor(List<String> caveStructureInstructions) {
		super(caveStructureInstructions);
		placeFloor();
	}
	
	private void placeFloor() {
		for (int x = 0; x < caveStructure[0].length; x++) {
			caveStructure[caveDepth + 2][x] = Structure.ROCK.getValue();
		}
	}
	
	protected boolean stopCondition(int y, int x) {
		return (caveStructure[y][x] == Structure.WATER.getValue());
	}
}
