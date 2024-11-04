package modulo23.chessgame.chess.pieces;

import modulo23.chessgame.boardgame.Board;
import modulo23.chessgame.boardgame.Position;
import modulo23.chessgame.chess.ChessPiece;
import modulo23.chessgame.chess.Color;

public class Queen extends ChessPiece {
	public Queen( Board board, Color color ) {
		super( board, color );
	}

	@Override
	public String toString( ) {
		return "Q";
	}

	@Override
	public boolean[][] possibleMoves( ) {
		boolean[][] mat = new boolean[ getBoard( ).getRows( ) ][ getBoard( ).getColumns( ) ];
		Position p = new Position( 0, 0 );
		toNorth( p, mat );
		toNorthEast( p, mat );
		toEast( p, mat );
		toSouthEast( p, mat );
		toSouth( p, mat );
		toSouthWest( p, mat );
		toWest( p, mat );
		toNorthWest( p, mat );

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
		newPosition.setValues( position.getRow( ) - 1, position.getColumn( ) + 1 );
		while( getBoard( ).positionExists( newPosition ) && ! getBoard( ).thereIsAPiece( newPosition ) ) {
			mat[ newPosition.getRow( ) ][ newPosition.getColumn( ) ] = true;
			newPosition.setValues( newPosition.getRow( ) - 1, newPosition.getColumn( ) + 1 );
		}
		if( getBoard( ).positionExists( newPosition ) && isThereOpponentPiece( newPosition ) ) {
			mat[ newPosition.getRow( ) ][ newPosition.getColumn( ) ] = true;
		}
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
		newPosition.setValues( position.getRow( ) + 1, position.getColumn( ) + 1 );
		while( getBoard( ).positionExists( newPosition ) && ! getBoard( ).thereIsAPiece( newPosition ) ) {
			mat[ newPosition.getRow( ) ][ newPosition.getColumn( ) ] = true;
			newPosition.setValues( newPosition.getRow( ) + 1, newPosition.getColumn( ) + 1 );
		}
		if( getBoard( ).positionExists( newPosition ) && isThereOpponentPiece( newPosition ) ) {
			mat[ newPosition.getRow( ) ][ newPosition.getColumn( ) ] = true;
		}
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
		newPosition.setValues( position.getRow( ) + 1, position.getColumn( ) - 1 );
		while( getBoard( ).positionExists( newPosition ) && ! getBoard( ).thereIsAPiece( newPosition ) ) {
			mat[ newPosition.getRow( ) ][ newPosition.getColumn( ) ] = true;
			newPosition.setValues( newPosition.getRow( ) + 1, newPosition.getColumn( ) - 1 );
		}
		if( getBoard( ).positionExists( newPosition ) && isThereOpponentPiece( newPosition ) ) {
			mat[ newPosition.getRow( ) ][ newPosition.getColumn( ) ] = true;
		}
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
		newPosition.setValues( position.getRow( ) - 1, position.getColumn( ) - 1 );
		while( getBoard( ).positionExists( newPosition ) && ! getBoard( ).thereIsAPiece( newPosition ) ) {
			mat[ newPosition.getRow( ) ][ newPosition.getColumn( ) ] = true;
			newPosition.setValues( newPosition.getRow( ) - 1, newPosition.getColumn( ) - 1 );
		}
		if( getBoard( ).positionExists( newPosition ) && isThereOpponentPiece( newPosition ) ) {
			mat[ newPosition.getRow( ) ][ newPosition.getColumn( ) ] = true;
		}
	}
}
