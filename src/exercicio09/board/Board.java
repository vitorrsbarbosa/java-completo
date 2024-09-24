package exercicio09.board;

public class Board {
	private int rows;
	private int columns;
	private Piece[][] pieces;

	private Board board;

	public Board( ) {
	}

	public Board( int rows, int columns ) {
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[ rows ][ columns ];
	}

	public int getRows( ) {
		return rows;
	}

	public void setRows( int rows ) {
		this.rows = rows;
	}

	public int getColumns( ) {
		return columns;
	}

	public void setColumns( int columns ) {
		this.columns = columns;
	}

	public Piece piece( int row, int column ) {
		return pieces[ row ][ column ];
	}

	public Piece piece( Position position ) {
		return pieces[ position.getRow( ) ][ position.getColumn( ) ];
	}

	public void placePiece( Piece piece, Position position ) {
		piece.setPosition( position );
	}

	public Piece removePiece( Position position ) {
		return pieces[ position.getRow( ) ][ position.getColumn( ) ];
	}

	public boolean positionExists( Position position ) {
		return position.getRow( ) <= rows && position.getColumn( ) <= columns;
	}
}
