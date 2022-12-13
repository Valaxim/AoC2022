package d09;

import java.util.Objects;

public class RopeEdge {
	
	private int x;
	private int y;
	
	public RopeEdge() {
		this.x = 0;
		this.y = 0;
	}
	
	public RopeEdge(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		RopeEdge ropeEdge = (RopeEdge) o;
		return x == ropeEdge.x && y == ropeEdge.y;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}
	
	public void move(Rope.Directions direction) {
		switch (direction) {
			case UP -> this.setY(y + 1);
			case DOWN -> this.setY(y - 1);
			case LEFT -> this.setX(x - 1);
			case RIGHT -> this.setX(x + 1);
		}
	}
	
	public void moveTailToHead(int head_x, int head_y) {
		if (Math.abs(getX() - head_x) > 1 || Math.abs(getY() - head_y) > 1) {
			performTailMove(head_x, head_y);
		}
	}
	
	private void performTailMove(int head_x, int head_y) {
		if (head_x > getX() && head_y > getY()) {  // RIGHT-UP
			setX(x + 1);
			setY(y + 1);
		} else if (head_x > getX() && head_y == getY()) { // RIGHT
			setX(x + 1);
		} else if (head_x < getX() && head_y > getY()) { // LEFT-UP
			setX(x - 1);
			setY(y + 1);
		} else if (head_x < getX() && head_y == getY()) { // LEFT
			setX(x - 1);
		} else if (head_x > getX() && head_y < getY()) { // RIGHT-DOWN
			setX(x + 1);
			setY(y - 1);
		} else if (head_x == getX() && head_y < getY()) { // DOWN
			setY(y - 1);
		} else if (head_x < getX() && head_y < getY()) {  // LEFT-DOWN
			setX(x - 1);
			setY(y - 1);
		} else if (head_x == getX() && head_y > getY()) { // UP
			setY(y + 1);
		}
		System.out.println("Head xy: " + x + " " + y + " Tail xy: " + getX() + " " + getY());
	}
}
