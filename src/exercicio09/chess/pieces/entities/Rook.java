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
	public void toRight( Position p, boolean[][] mat ) {
		// right
		p.setValues( position.getRow( ), position.getColumn( ) + 1 );
		while( getBoard( ).positionExists( position ) && ! getBoard( ).thereIsAPiece( position ) ) {
			mat[ position.getRow( ) ][ position.getColumn( ) ] = true;
			p.setColumn( position.getColumn( ) + 1 );
		}
		if( getBoard( ).positionExists( position ) && isThereOpponentPiece( position ) ) {
			mat[ position.getRow( ) ][ position.getColumn( ) ] = true;
		}
	}

	@Override
	public void toDiagonalRightBellow( Position p, boolean[][] mat ) {
		mat[ position.getRow( ) ][ position.getColumn( ) ] = false;
	}

	@Override
	public void toBellow( Position p, boolean[][] mat ) {
		// bellow
		p.setValues( position.getRow( ) + 1, position.getColumn( ) );
		while( getBoard( ).positionExists( position ) && ! getBoard( ).thereIsAPiece( position ) ) {
			mat[ position.getRow( ) ][ position.getColumn( ) ] = true;
			p.setRow( position.getRow( ) + 1 );
		}
		if( getBoard( ).positionExists( position ) && isThereOpponentPiece( position ) ) {
			mat[ position.getRow( ) ][ position.getColumn( ) ] = true;
		}
	}

	@Override
	public void toDiagonalLeftBellow( Position p, boolean[][] mat ) {
		mat[ position.getRow( ) ][ position.getColumn( ) ] = false;
	}

	@Override
	public void toLeft( Position p, boolean[][] mat ) {
		// left
		p.setValues( position.getRow( ), position.getColumn( ) - 1 );
		while( getBoard( ).positionExists( position ) && ! getBoard( ).thereIsAPiece( position ) ) {
			mat[ position.getRow( ) ][ position.getColumn( ) ] = true;
			p.setColumn( position.getColumn( ) - 1 );
		}
		if( getBoard( ).positionExists( position ) && isThereOpponentPiece( position ) ) {
			mat[ position.getRow( ) ][ position.getColumn( ) ] = true;
		}
	}

	@Override
	public void toDiagonalLeftAbove( Position p, boolean[][] mat ) {
		mat[ position.getRow( ) ][ position.getColumn( ) ] = false;
	}

	@Override
	public void toAbove( Position p, boolean[][] mat ) {
		// above
		p.setValues( position.getRow( ) - 1, position.getColumn( ) );
		while( getBoard( ).positionExists( position ) && ! getBoard( ).thereIsAPiece( position ) ) {
			mat[ position.getRow( ) ][ position.getColumn( ) ] = true;
			p.setRow( position.getRow( ) - 1 );
		}
		if( getBoard( ).positionExists( position ) && isThereOpponentPiece( position ) ) {
			mat[ position.getRow( ) ][ position.getColumn( ) ] = true;
		}
	}

	@Override
	public void toDiagonalRightAbove( Position p, boolean[][] mat ) {
		mat[ position.getRow( ) ][ position.getColumn( ) ] = false;
	}
}
