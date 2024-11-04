package modulo23.chessgame.chess.pieces;

import modulo23.chessgame.boardgame.Board;
import modulo23.chessgame.boardgame.Position;
import modulo23.chessgame.chess.ChessMatch;
import modulo23.chessgame.chess.ChessPiece;
import modulo23.chessgame.chess.Color;

public class King extends ChessPiece {
	private final ChessMatch match;

	public King( Board board, Color color, ChessMatch match ) {
		super( board, color );
		this.match = match;
	}

	@Override
	public String toString( ) {
		return "K";
	}

	private boolean canMove( Position position ) {
		ChessPiece piece = ( ChessPiece ) getBoard( ).piece( position );
		return piece == null || piece.getColor( ) != getColor( );
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
		toMinorCastling( p, mat );
		toMajorCastling( p, mat );
		return mat;
	}

	@Override
	public void toNorth( Position newPosition, boolean[][] mat ) {
		newPosition.setValues( position.getRow( ) - 1, position.getColumn( ) );
		if( getBoard( ).positionExists( newPosition ) && canMove( newPosition ) ) {
			mat[ newPosition.getRow( ) ][ newPosition.getColumn( ) ] = true;
		}
	}

	@Override
	public void toNorthEast( Position newPosition, boolean[][] mat ) {
		newPosition.setValues( position.getRow( ) - 1, position.getColumn( ) + 1 );
		if( getBoard( ).positionExists( newPosition ) && canMove( newPosition ) ) {
			mat[ newPosition.getRow( ) ][ newPosition.getColumn( ) ] = true;
		}
	}

	@Override
	public void toEast( Position newPosition, boolean[][] mat ) {
		newPosition.setValues( position.getRow( ), position.getColumn( ) + 1 );
		if( getBoard( ).positionExists( newPosition ) && canMove( newPosition ) ) {
			mat[ newPosition.getRow( ) ][ newPosition.getColumn( ) ] = true;
		}
	}

	@Override
	public void toSouthEast( Position newPosition, boolean[][] mat ) {
		newPosition.setValues( position.getRow( ) + 1, position.getColumn( ) + 1 );
		if( getBoard( ).positionExists( newPosition ) && canMove( newPosition ) ) {
			mat[ newPosition.getRow( ) ][ newPosition.getColumn( ) ] = true;
		}
	}

	@Override
	public void toSouth( Position newPosition, boolean[][] mat ) {
		newPosition.setValues( position.getRow( ) + 1, position.getColumn( ) );
		if( getBoard( ).positionExists( newPosition ) && canMove( newPosition ) ) {
			mat[ newPosition.getRow( ) ][ newPosition.getColumn( ) ] = true;
		}
	}

	@Override
	public void toSouthWest( Position newPosition, boolean[][] mat ) {
		newPosition.setValues( position.getRow( ) + 1, position.getColumn( ) - 1 );
		if( getBoard( ).positionExists( newPosition ) && canMove( newPosition ) ) {
			mat[ newPosition.getRow( ) ][ newPosition.getColumn( ) ] = true;
		}
	}

	@Override
	public void toWest( Position newPosition, boolean[][] mat ) {
		newPosition.setValues( position.getRow( ), position.getColumn( ) - 1 );
		if( getBoard( ).positionExists( newPosition ) && canMove( newPosition ) ) {
			mat[ newPosition.getRow( ) ][ newPosition.getColumn( ) ] = true;
		}
	}

	@Override
	public void toNorthWest( Position newPosition, boolean[][] mat ) {
		newPosition.setValues( position.getRow( ) - 1, position.getColumn( ) - 1 );
		if( getBoard( ).positionExists( newPosition ) && canMove( newPosition ) ) {
			mat[ newPosition.getRow( ) ][ newPosition.getColumn( ) ] = true;
		}
	}

	private boolean testRookCastling( Position position ) {
		ChessPiece piece = ( ChessPiece ) getBoard( ).piece( position );
		return piece instanceof Rook && piece.getColor( ) == getColor( ) && piece.getMoveCount( ) == 0;
	}

	private void toMinorCastling( Position p, boolean[][] mat ) {
		if( getMoveCount( ) == 0 && ! match.isCheck( ) ) {
			Position minor = new Position( position.getRow( ), position.getColumn( ) + 3 );
			if( testRookCastling( minor ) ) {
				Position newRookPosition = new Position( position.getRow( ), position.getColumn( ) + 1 );
				Position newKingPosition = new Position( position.getRow( ), position.getColumn( ) + 2 );
				if( getBoard( ).piece( newRookPosition ) == null && getBoard( ).piece( newKingPosition ) == null ) {
					mat[ position.getRow( ) ][ position.getColumn( ) + 2 ] = true;
				}
			}
		}
	}

	private void toMajorCastling( Position p, boolean[][] mat ) {
		if( getMoveCount( ) == 0 && ! match.isCheck( ) ) {
			Position major = new Position( position.getRow( ), position.getColumn( ) - 4 );
			if( testRookCastling( major ) ) {
				Position newRookPosition = new Position( position.getRow( ), position.getColumn( ) - 1 );
				Position newKingPosition = new Position( position.getRow( ), position.getColumn( ) - 2 );
				Position nullPosition = new Position( position.getRow( ), position.getColumn( ) - 3 );
				if( getBoard( ).piece( newRookPosition ) == null && getBoard( ).piece( newKingPosition ) == null && getBoard( ).piece( nullPosition ) == null ) {
					mat[ position.getRow( ) ][ position.getColumn( ) - 2 ] = true;
				}
			}
		}
	}
}
