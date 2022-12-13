package d12;

public class Tuple<K, V> {
	
	
	private K row;
	private V col;
	
	public Tuple(K row, V col) {
		this.row = row;
		this.col = col;
	}
	
	public K getRow() {
		return row;
	}
	
	public void setRow(K row) {
		this.row = row;
	}
	
	public V getCol() {
		return col;
	}
	
	public void setCol(V col) {
		this.col = col;
	}
}
