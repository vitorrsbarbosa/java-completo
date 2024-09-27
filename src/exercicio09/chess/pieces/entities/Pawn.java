package exercicio09.chess.pieces.entities;

import exercicio09.board.Board;
import exercicio09.board.Position;
import exercicio09.chess.enums.Color;
import exercicio09.chess.pieces.ChessPiece;

public class Pawn extends ChessPiece {
	public Pawn( Board board, Color color ) {
		super( board, color );
	}

	@Override
	public boolean[][] possibleMoves( ) {
		boolean[][] mat = new boolean[ getBoard( ).getRows( ) ][ getBoard( ).getColumns( ) ];
		Position p = new Position( 0,0 );
		toRight( p,mat );
		// toDiagonalRightBellow( p,mat );
		toBellow( p,mat );
		// toDiagonalLeftBellow( p,mat );
		toLeft( p,mat );
		// toDiagonalLeftAbove( p,mat );
		toAbove( p,mat );
		// toDiagonalRightAbove( p,mat );

		return mat;
	}

	@Override
	public String toString( ) {
		return "P";
	}

	@Override
	public void toRight(Position p, boolean[][] mat ) {
		mat[ position.getRow( ) ][ position.getColumn( ) ] = false;
	}

	@Override
	public void toDiagonalRightBellow( Position p,boolean[][] mat ) {
		p.setValues( position.getRow( ) + 1, position.getColumn( ) + 1 );
		while( getBoard( ).positionExists( position ) && getBoard( ).thereIsAPiece( position ) && isThereOpponentPiece( position ) ) {
			mat[ position.getRow( ) ][ position.getColumn( ) ] = true;
			p.setValues( position.getRow( ) + 1, position.getColumn( ) + 1 );
		}
	}

	@Override
	public void toBellow( Position p,boolean[][] mat ) {

	}

	@Override
	public void toDiagonalLeftBellow( Position p,boolean[][] mat ) {

	}

	@Override
	public void toLeft( Position p,boolean[][] mat ) {
		mat[ position.getRow( ) ][ position.getColumn( ) ] = false;
	}

	@Override
	public void toDiagonalLeftAbove( Position p,boolean[][] mat ) {
	}

	@Override
	public void toAbove( Position p,boolean[][] mat ) {

	}

	@Override
	public void toDiagonalRightAbove( Position p,boolean[][] mat ) {

	}
}
