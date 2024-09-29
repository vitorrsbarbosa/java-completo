package exercicio09.chess.pieces;

import exercicio09.boardgame.Board;
import exercicio09.boardgame.Position;
import exercicio09.chess.ChessPiece;
import exercicio09.chess.Color;

public class Pawn extends ChessPiece {
	public Pawn( Board board, Color color ) {
		super( board, color );
	}

	@Override
	public boolean[][] possibleMoves( ) {
		boolean[][] mat = new boolean[ getBoard( ).getRows( ) ][ getBoard( ).getColumns( ) ];
		Position p = new Position( 0, 0 );
		toNorth( p, mat );
		// toNorthEast( p,mat );
		toEast( p, mat );
		// toSouthEast( p,mat );
		toSouth( p, mat );
		// toSouthWest( p,mat );
		toWest( p, mat );
		// toNorthWest( p,mat );

		return mat;
	}

	@Override
	public String toString( ) {
		return "P";
	}

	@Override
	public void toNorth( Position p, boolean[][] mat ) {

	}

	@Override
	public void toNorthEast( Position p, boolean[][] mat ) {
	}

	@Override
	public void toEast( Position p, boolean[][] mat ) {
		mat[ position.getRow( ) ][ position.getColumn( ) ] = false;
	}

	@Override
	public void toSouthEast( Position p, boolean[][] mat ) {

	}

	@Override
	public void toSouth( Position p, boolean[][] mat ) {

	}

	@Override
	public void toSouthWest( Position p, boolean[][] mat ) {
		p.setValues( position.getRow( ) + 1, position.getColumn( ) + 1 );
		while( getBoard( ).positionExists( position ) && getBoard( ).thereIsAPiece( position ) && isThereOpponentPiece( position ) ) {
			mat[ position.getRow( ) ][ position.getColumn( ) ] = true;
			p.setValues( position.getRow( ) + 1, position.getColumn( ) + 1 );
		}
	}

	@Override
	public void toWest( Position p, boolean[][] mat ) {
		mat[ position.getRow( ) ][ position.getColumn( ) ] = false;
	}

	@Override
	public void toNorthWest( Position p, boolean[][] mat ) {

	}
}
