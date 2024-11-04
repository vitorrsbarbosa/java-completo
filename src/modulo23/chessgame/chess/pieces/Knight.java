package modulo23.chessgame.chess.pieces;

import modulo23.chessgame.boardgame.Board;
import modulo23.chessgame.boardgame.Position;
import modulo23.chessgame.chess.ChessPiece;
import modulo23.chessgame.chess.Color;

public class Knight extends ChessPiece {
	public Knight( Board board, Color color ) {
		super( board, color );
	}

	public String toString( ) {
		return "N";
	}

	private boolean canMove( Position position ) {
		ChessPiece piece = ( ChessPiece ) getBoard( ).piece( position );
		return piece == null || piece.getColor( ) != getColor( );
	}

	@Override
	public boolean[][] possibleMoves( ) {
		boolean[][] mat = new boolean[ getBoard( ).getRows( ) ][ getBoard( ).getColumns( ) ];
		Position p = new Position( 0, 0 );
		//hack to make knight's movement work without changing method's signature
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
		//+2 up +1 right
		newPosition.setValues( position.getRow( ) - 2, position.getColumn( ) + 1 );
		if( getBoard( ).positionExists( newPosition ) && canMove( newPosition ) ) {
			mat[ newPosition.getRow( ) ][ newPosition.getColumn( ) ] = true;
		}
	}

	@Override
	public void toNorthEast( Position newPosition, boolean[][] mat ) {
		// +1 up +2 right
		newPosition.setValues( position.getRow( ) - 1, position.getColumn( ) + 2 );
		if( getBoard( ).positionExists( newPosition ) && canMove( newPosition ) ) {
			mat[ newPosition.getRow( ) ][ newPosition.getColumn( ) ] = true;
		}
	}

	@Override
	public void toEast( Position newPosition, boolean[][] mat ) {
		// +1 down +2 right
		newPosition.setValues( position.getRow( ) + 1, position.getColumn( ) + 2 );
		if( getBoard( ).positionExists( newPosition ) && canMove( newPosition ) ) {
			mat[ newPosition.getRow( ) ][ newPosition.getColumn( ) ] = true;
		}
	}

	@Override
	public void toSouthEast( Position newPosition, boolean[][] mat ) {
		// +2 down +1 right
		newPosition.setValues( position.getRow( ) + 2, position.getColumn( ) + 1 );
		if( getBoard( ).positionExists( newPosition ) && canMove( newPosition ) ) {
			mat[ newPosition.getRow( ) ][ newPosition.getColumn( ) ] = true;
		}
	}

	@Override
	public void toSouth( Position newPosition, boolean[][] mat ) {
		// +2 down +1 left
		newPosition.setValues( position.getRow( ) + 2, position.getColumn( ) - 1 );
		if( getBoard( ).positionExists( newPosition ) && canMove( newPosition ) ) {
			mat[ newPosition.getRow( ) ][ newPosition.getColumn( ) ] = true;
		}
	}

	@Override
	public void toSouthWest( Position newPosition, boolean[][] mat ) {
		// +1 down +2 left
		newPosition.setValues( position.getRow( ) + 1, position.getColumn( ) - 2 );
		if( getBoard( ).positionExists( newPosition ) && canMove( newPosition ) ) {
			mat[ newPosition.getRow( ) ][ newPosition.getColumn( ) ] = true;
		}
	}

	@Override
	public void toWest( Position newPosition, boolean[][] mat ) {
		// +1 up +2 left
		newPosition.setValues( position.getRow( ) - 1, position.getColumn( ) - 2 );
		if( getBoard( ).positionExists( newPosition ) && canMove( newPosition ) ) {
			mat[ newPosition.getRow( ) ][ newPosition.getColumn( ) ] = true;
		}
	}

	@Override
	public void toNorthWest( Position newPosition, boolean[][] mat ) {
		//+2 up +1 left
		newPosition.setValues( position.getRow( ) - 2, position.getColumn( ) - 1 );
		if( getBoard( ).positionExists( newPosition ) && canMove( newPosition ) ) {
			mat[ newPosition.getRow( ) ][ newPosition.getColumn( ) ] = true;
		}
	}
}
