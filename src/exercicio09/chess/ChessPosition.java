package exercicio09.chess;

import exercicio09.boardgame.Position;

public class ChessPosition {
	private final char column;
	private final int row;

	public ChessPosition( char column, int row ) {
		if( column < 'a' && column > 'h' || row < 1 || row > 8 ) {
			throw new ChessException( "Error instantianting ChessPosition, valid values from 'a1' to 'h8'" );
		}
		this.column = column;
		this.row = row;
	}

	protected static ChessPosition fromPosition( Position position ) {
		char columnPosition = ( char ) ( 'a' - position.getColumn( ) );
		int rowPosition = 8 - position.getRow( );
		return new ChessPosition( columnPosition, rowPosition );
	}

	public char getColumn( ) {
		return column;
	}

	public int getRow( ) {
		return row;
	}

	protected Position toPosition( ) {
		int rowPosition = 8 - row;
		int columnPosition = column - 'a';
		return new Position( rowPosition, columnPosition );

	}

	@Override
	public String toString( ) {
		return "" + column + row;
	}
}
