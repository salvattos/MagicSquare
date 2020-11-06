package square.model;

public class Tile {
	public final int sideLength = 100;
	int val;
	boolean isCenter;
	boolean isShown;
	int row;
	int col;
	
	public Tile(int val) {
		this.val = val;
		isShown = true;
	}
	
	public boolean isCenter() {return isCenter;}
	public void setCenter(Boolean flag) {isCenter = flag;}
	
	public boolean isShown() {return isShown;}
	public void setShown(boolean flag) {isShown = flag;}
	
	public int getVal() {return val;}
	public void setVal(int v) {val = v;}
	
	public int getRow() {return row;}
	public void setRow(int r) {row = r;}
	
	public int getCol() {return col;}
	public void setCol(int c) {col = c;}
	public Coordinate getLocation() {return new Coordinate(col, row);}
	
	public int getSideLength() {return sideLength;}
	
	public Tile copy() {
		Tile t = new Tile(val);
		t.setRow(row);
		t.setCol(col);
		t.setCenter(isCenter);
		//might need to reset is shown
		return t;
	}
	
	
	
	public boolean contains(Coordinate c) {
		if(c.col >= col && c.col < (col + 1) && c.row >= row && c.row < (row + 1)) {
			return true;
		}
		
		return false;
	}

	public void subtract(Tile tile) {
		this.isShown = false;
		tile.setVal(tile.getVal() - this.getVal());
		
	}

	public void add(Tile tile) {
		this.isShown = false;
		tile.setVal(tile.getVal() + this.getVal());		
	}

	public void multiply(Tile tile) {
		this.isShown = false;
		tile.setVal(tile.getVal() * this.getVal());		
	}
	
	public void divide(Tile tile) {
		this.isShown = false;
		tile.setVal(this.getVal() / tile.getVal());		
	}
	
}
