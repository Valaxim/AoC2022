package d08;

public class Solution {
	
	private int[][] input;
	private final int rowSize;
	private final int colSize;
	
	public Solution(int[][] input) {
		this.input = input;
		this.rowSize = input.length;
		this.colSize = input[0].length;
	}
	
	public int computePartA() {
		int sum = 0;
		
		for (int row = 0; row < input.length; row++) {
			for (int col = 0; col < input[row].length; col++) {
				boolean treeVisible = isTreeVisible(row, col);
				sum += treeVisible ? 1 : 0;
				System.out.println("rows: " + row + " cols: " + col + " with value: " + input[row][col] + " Is visible?: " + treeVisible);
			}
		}
		return sum;
	}
	
	private boolean isTreeVisible(int row, int col) {
		return isOnTheEdge(row, col) || isVisibleFromLeft(row, col) || isVisibleFromRight(row, col) || isVisibleFromTop(row, col) || isVisibleFromBottom(row, col);
	}
	
	private boolean isOnTheEdge(int row, int col) {
		return row == 0 || row == rowSize - 1 || col == 0 || col == colSize - 1;
	}
	
	private boolean isVisibleFromLeft(int row, int col) {
		int treeHeight = input[row][col];
		for (int index = col - 1; index >= 0; index--) {
			if (input[row][index] >= treeHeight) {
				return false;
			}
		}
		return true;
	}
	
	private boolean isVisibleFromRight(int row, int col) {
		int treeHeight = input[row][col];
		for (int index = col + 1; index <= colSize - 1; index++) {
			if (input[row][index] >= treeHeight) {
				return false;
			}
		}
		return true;
	}
	
	private boolean isVisibleFromTop(int row, int col) { // maybeNameIsMixedWithBottom
		int treeHeight = input[row][col];
		for (int index = row - 1; index >= 0; index--) {
			if (input[index][col] >= treeHeight) {
				return false;
			}
		}
		return true;
	}
	
	private boolean isVisibleFromBottom(int row, int col) {  // maybeNameIsMixedWithTop
		int treeHeight = input[row][col];
		for (int index = row + 1; index <= rowSize - 1; index++) {
			if (input[index][col] >= treeHeight) {
				return false;
			}
		}
		return true;
	}
	
	
	public int computePartB() {
		int sum = 0;
		
		for (int row = 0; row < input.length; row++) {
			for (int col = 0; col < input[row].length; col++) {
				int treeVisibleAmount = getAmountOfVisibleTree(row, col);
				sum = treeVisibleAmount > sum ? treeVisibleAmount : sum;
				System.out.println("rows: " + row + " cols: " + col + " with value: " + input[row][col] + " Number of visible trees?: " + treeVisibleAmount);
			}
		}
		return sum;
	}
	
	private int getAmountOfVisibleTree(int row, int col) {
		if (isOnTheEdge(row, col)) {
			return 0;
		} else {
			return getVisibleTreeFromLeft(row, col) * getVisibleTreeFromRight(row, col) * getVisibleTreeFromTop(row, col)
					* getVisibleTreeFromBottom(row, col);
		}
	}
	
	private int getVisibleTreeFromLeft(int row, int col) {
		int visibleTree = 0;
		int treeHeight = input[row][col];
		for (int index = col - 1; index >= 0; index--) {
			visibleTree++;
			if (input[row][index] >= treeHeight) {
				return visibleTree;
			}
		}
		return visibleTree;
	}
	
	private int getVisibleTreeFromRight(int row, int col) {
		int visibleTree = 0;
		int treeHeight = input[row][col];
		for (int index = col + 1; index <= colSize - 1; index++) {
			visibleTree++;
			if (input[row][index] >= treeHeight) {
				return visibleTree;
			}
		}
		return visibleTree;
	}
	
	private int getVisibleTreeFromTop(int row, int col) {
		int visibleTree = 0;
		int treeHeight = input[row][col];
		for (int index = row - 1; index >= 0; index--) {
			visibleTree++;
			if (input[index][col] >= treeHeight) {
				return visibleTree;
			}
		}
		return visibleTree;
	}
	
	private int getVisibleTreeFromBottom(int row, int col) {
		int visibleTree = 0;
		int treeHeight = input[row][col];
		for (int index = row + 1; index <= rowSize - 1; index++) {
			visibleTree++;
			if (input[index][col] >= treeHeight) {
				return visibleTree;
			}
		}
		return visibleTree;
	}
	
}
