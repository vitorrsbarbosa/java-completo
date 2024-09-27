package exercicio09.chess.pieces.entities;

import exercicio09.board.Board;
import exercicio09.board.Position;
import exercicio09.chess.enums.Color;
import exercicio09.chess.pieces.ChessPiece;

public class Rook extends ChessPiece {
	public Rook( Board board, Color color ) {
		super( board, color );
	}

	@Override
	public String toString( ) {
		return "R";
	}

	@Override
	public boolean[][] possibleMoves( ) {
		boolean[][] mat = new boolean[ getBoard( ).getRows( ) ][ getBoard( ).getColumns( ) ];
		Position p = new Position( 0, 0 );
		toRight( p, mat );
		toBellow( p, mat );
		toLeft( p, mat );
		toAbove( p, mat );

		return mat;
	}

	@Override
	public void toRight( Position p, boolean[][] mat ) {
		// right
		p.setValues( position.getRow( ), position.getColumn( ) + 1 );
		while( getBoard( ).positionExists( p ) && ! getBoard( ).thereIsAPiece( p ) ) {
			mat[ p.getRow( ) ][ p.getColumn( ) ] = true;
			p.setColumn( p.getColumn( ) + 1 );
		}
		if( getBoard( ).positionExists( p ) && isThereOpponentPiece( p ) ) {
			mat[ p.getRow( ) ][ p.getColumn( ) ] = true;
		}
	}

	@Override
	public void toDiagonalRightBellow( Position p, boolean[][] mat ) {
	}

	@Override
	public void toBellow( Position p, boolean[][] mat ) {
		// bellow
		p.setValues( position.getRow( ) + 1, position.getColumn( ) );
		while( getBoard( ).positionExists( p ) && ! getBoard( ).thereIsAPiece( p ) ) {
			mat[ p.getRow( ) ][ p.getColumn( ) ] = true;
			p.setRow( p.getRow( ) + 1 );
		}
		if( getBoard( ).positionExists( p ) && isThereOpponentPiece( p ) ) {
			mat[ p.getRow( ) ][ p.getColumn( ) ] = true;
		}
	}

	@Override
	public void toDiagonalLeftBellow( Position p, boolean[][] mat ) {
	}

	@Override
	public void toLeft( Position p, boolean[][] mat ) {
		// left
		p.setValues( position.getRow( ), position.getColumn( ) - 1 );
		while( getBoard( ).positionExists( p ) && ! getBoard( ).thereIsAPiece( p ) ) {
			mat[ p.getRow( ) ][ p.getColumn( ) ] = true;
			p.setColumn( p.getColumn( ) - 1 );
		}
		if( getBoard( ).positionExists( p ) && isThereOpponentPiece( p ) ) {
			mat[ p.getRow( ) ][ p.getColumn( ) ] = true;
		}
	}

	@Override
	public void toDiagonalLeftAbove( Position p, boolean[][] mat ) {
	}

	@Override
	public void toAbove( Position p, boolean[][] mat ) {
		// above
		p.setValues( position.getRow( ) - 1, position.getColumn( ) );
		while( getBoard( ).positionExists( p ) && ! getBoard( ).thereIsAPiece( p ) ) {
			mat[ p.getRow( ) ][ p.getColumn( ) ] = true;
			p.setRow( p.getRow( ) - 1 );
		}
		if( getBoard( ).positionExists( p ) && isThereOpponentPiece( p ) ) {
			mat[ p.getRow( ) ][ p.getColumn( ) ] = true;
		}
	}

	@Override
	public void toDiagonalRightAbove( Position p, boolean[][] mat ) {
	}
}
