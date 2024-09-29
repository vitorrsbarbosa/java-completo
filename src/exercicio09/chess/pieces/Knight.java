package exercicio09.chess.pieces;

import exercicio09.boardgame.Board;
import exercicio09.boardgame.Position;
import exercicio09.chess.ChessPiece;
import exercicio09.chess.Color;

public class Knight extends ChessPiece {
	public Knight( Board board, Color color ) {
		super( board, color );
	}

	@Override
	public boolean[][] possibleMoves( ) {
		boolean[][] mat = new boolean[ getBoard( ).getRows( ) ][ getBoard( ).getColumns( ) ];
		Position p = new Position( 0, 0 );
		toNorth( p, mat );
		toEast( p, mat );
		toSouth( p, mat );
		toWest( p, mat );

		return mat;
	}

	@Override
	public String toString( ) {
		return "N";
	}


	@Override
	public void toNorth( Position p, boolean[][] mat ) {

	}

	@Override
	public void toNorthEast( Position p, boolean[][] mat ) {

	}

	@Override
	public void toEast( Position p, boolean[][] mat ) {

	}

	@Override
	public void toSouthEast( Position p, boolean[][] mat ) {

	}

	@Override
	public void toSouth( Position p, boolean[][] mat ) {

	}

	@Override
	public void toSouthWest( Position p, boolean[][] mat ) {

	}

	@Override
	public void toWest( Position p, boolean[][] mat ) {

	}

	@Override
	public void toNorthWest( Position p, boolean[][] mat ) {

	}
}
