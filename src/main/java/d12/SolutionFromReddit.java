package d12;

import utils.ParseUtil;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
public class SolutionFromReddit {
	
	public void solve() throws Exception {
		ParseUtil parseUtil = new ParseUtil();
		
		List<String> lines = parseUtil.readInputLineByLine("inputDay12.txt");
		int[][] map;
		map = lines.stream()
				.map(s -> s.chars().map(i-> {
					if(i=='S') {
						return 27;
					} else if(i=='E') {
						return 0;
					} else {
						return 'z'+1-i;
					}
				}).toArray())
				.toArray(s -> new int[s][]);
		
		// Locate end:
		int endX = 0;
		int endY = 0;
		for(int x = 0; x < map.length; x++) {
			for(int y = 0; y < map[0].length; y++) {
				if (map[x][y] == 0) {
					endX = x;
					endY = y;
				}
			}
		}
		
		// Print solutions:
		System.out.println("Part 1: " + calculatePath(map, new int[map.length][map[0].length], endX, endY, 27));
		System.out.println("Part 2: " + calculatePath(map, new int[map.length][map[0].length], endX, endY, 26));
	}
	
	private int calculatePath(final int[][] map, final int[][] minKnownPath, final int x, final int y, int goal) {
		int pathToThisSquare = minKnownPath[x][y] + 1;
		
		int lowestSteps = Integer.MAX_VALUE;
		for(int direction = 1; direction <= 7; direction+=2) {
			int nx = x + ((direction%3) - 1);
			int ny = y + ((direction/3) - 1);
			
			if(nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length) {
				boolean canMakeStep = map[nx][ny] <= map[x][y] + 1;
				boolean isShorterPath = (minKnownPath[nx][ny] == 0 || pathToThisSquare < minKnownPath[nx][ny]);
				if(canMakeStep && isShorterPath) {
					minKnownPath[nx][ny] = pathToThisSquare;
					if(map[nx][ny] == goal) {
						return pathToThisSquare;
					}
					lowestSteps = Math.min(lowestSteps, calculatePath(map, minKnownPath, nx, ny, goal));
				}
			}
		}
		return lowestSteps;
	}
	
}

