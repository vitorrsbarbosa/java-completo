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
		toNorth( p, mat );
		toEast( p, mat );
		toSouth( p, mat );
		toWest( p, mat );

		return mat;
	}

	@Override
	public void toNorth( Position newPosition, boolean[][] mat ) {
		newPosition.setValues( position.getRow( ) - 1, position.getColumn( ) );
		while( getBoard( ).positionExists( newPosition ) && ! getBoard( ).thereIsAPiece( newPosition ) ) {
			mat[ newPosition.getRow( ) ][ newPosition.getColumn( ) ] = true;
			newPosition.setRow( newPosition.getRow( ) - 1 );
		}
		if( getBoard( ).positionExists( newPosition ) && isThereOpponentPiece( newPosition ) ) {
			mat[ newPosition.getRow( ) ][ newPosition.getColumn( ) ] = true;
		}
	}

	@Override
	public void toNorthEast( Position newPosition, boolean[][] mat ) {
		newPosition.setValues( position.getRow( ), position.getColumn( ) );
		mat[ newPosition.getRow( ) ][ newPosition.getColumn( ) ] = false;
	}

	@Override
	public void toEast( Position newPosition, boolean[][] mat ) {
		newPosition.setValues( position.getRow( ), position.getColumn( ) - 1 );
		while( getBoard( ).positionExists( newPosition ) && ! getBoard( ).thereIsAPiece( newPosition ) ) {
			mat[ newPosition.getRow( ) ][ newPosition.getColumn( ) ] = true;
			newPosition.setColumn( newPosition.getColumn( ) - 1 );
		}
		if( getBoard( ).positionExists( newPosition ) && isThereOpponentPiece( newPosition ) ) {
			mat[ newPosition.getRow( ) ][ newPosition.getColumn( ) ] = true;
		}
	}

	@Override
	public void toSouthEast( Position newPosition, boolean[][] mat ) {
		newPosition.setValues( position.getRow( ), position.getColumn( ) );
		mat[ newPosition.getRow( ) ][ newPosition.getColumn( ) ] = false;
	}

	@Override
	public void toSouth( Position newPosition, boolean[][] mat ) {
		newPosition.setValues( position.getRow( ) + 1, position.getColumn( ) );
		while( getBoard( ).positionExists( newPosition ) && ! getBoard( ).thereIsAPiece( newPosition ) ) {
			mat[ newPosition.getRow( ) ][ newPosition.getColumn( ) ] = true;
			newPosition.setRow( newPosition.getRow( ) + 1 );
		}
		if( getBoard( ).positionExists( newPosition ) && isThereOpponentPiece( newPosition ) ) {
			mat[ newPosition.getRow( ) ][ newPosition.getColumn( ) ] = true;
		}
	}

	@Override
	public void toSouthWest( Position newPosition, boolean[][] mat ) {
		newPosition.setValues( position.getRow( ), position.getColumn( ) );
		mat[ newPosition.getRow( ) ][ newPosition.getColumn( ) ] = false;
	}

	@Override
	public void toWest( Position newPosition, boolean[][] mat ) {
		newPosition.setValues( position.getRow( ), position.getColumn( ) + 1 );
		while( getBoard( ).positionExists( newPosition ) && ! getBoard( ).thereIsAPiece( newPosition ) ) {
			mat[ newPosition.getRow( ) ][ newPosition.getColumn( ) ] = true;
			newPosition.setColumn( newPosition.getColumn( ) + 1 );
		}
		if( getBoard( ).positionExists( newPosition ) && isThereOpponentPiece( newPosition ) ) {
			mat[ newPosition.getRow( ) ][ newPosition.getColumn( ) ] = true;
		}
	}

	@Override
	public void toNorthWest( Position newPosition, boolean[][] mat ) {
		newPosition.setValues( position.getRow( ), position.getColumn( ) );
		mat[ newPosition.getRow( ) ][ newPosition.getColumn( ) ] = false;
	}
}
