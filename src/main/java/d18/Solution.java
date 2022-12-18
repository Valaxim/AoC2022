package d18;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	enum SurfaceType {LAVA, WATER, AIR}
	
	record Cube(int x, int y, int z, SurfaceType type) {
		
		public Cube(int x, int y, int z) {
			this(x, y, z, SurfaceType.LAVA);
		}
	}
	
	List<Cube> cubeList;
	
	public Solution(List<String> input) {
		cubeList = new ArrayList<>();
		init(input);
	}
	
	private void init(List<String> input) {
		for (String str : input) {
			String[] split = str.split(",");
			cubeList.add(new Cube(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2])));
		}
	}
	
	public long compute(List<Cube> input) {
		cubeList = new ArrayList<>(input);
		return compute();
	}
	
	public long compute() {
		long surfaceArea = 0;
		for (Cube cube : cubeList) {
			surfaceArea += calculateSurfaceAreaForCube(cube);
		}
		return surfaceArea;
	}
	
	private long calculateSurfaceAreaForCube(Cube cube) {
		return 6 - cubeList.stream().filter(it -> it.x == cube.x + 1 && it.y == cube.y && it.z == cube.z
						|| it.x == cube.x - 1 && it.y == cube.y && it.z == cube.z
						|| it.y == cube.y - 1 && it.x == cube.x && it.z == cube.z
						|| it.y == cube.y + 1 && it.x == cube.x && it.z == cube.z
						|| it.z == cube.z - 1 && it.x == cube.x && it.y == cube.y
						|| it.z == cube.z + 1 && it.x == cube.x && it.y == cube.y)
				.toList()
				.size();
	}
	
}
