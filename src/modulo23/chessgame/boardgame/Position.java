package modulo23.chessgame.boardgame;

public class Position {
	private int row;
	private int column;
	
	public Position( ) {
	}

	public Position(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public int getRow( ) {
		return row;
	}

	public void setRow( int row ) {
		this.row = row;
	}

	public int getColumn( ) {
		return column;
	}

	public void setColumn( int column ) {
		this.column = column;
	}

	public void setValues(int newRow, int newColumn) {
		this.row = newRow;
		this.column = newColumn;
	}

	@Override
	public String toString( ) {
		return  row + ", " + column;
	}
}
