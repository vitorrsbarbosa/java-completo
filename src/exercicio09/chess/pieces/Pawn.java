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

		if( getColor( ).equals( Color.WHITE ) ) {
			toNorth( p, mat );
			toNorthWest( p, mat );
			toNorthEast( p, mat );
		}
		if( getColor( ).equals( Color.BLACK ) ) {
			toSouth( p, mat );
			toSouthWest( p, mat );
			toSouthEast( p, mat );
		}
		return mat;
	}

	@Override
	public String toString( ) {
		return "P";
	}

	@Override
	public void toNorth( Position p, boolean[][] mat ) {
		p.setValues( position.getRow( ) - 1, position.getColumn( ) );
		if( getBoard( ).positionExists( p ) && ! getBoard( ).thereIsAPiece( p ) ) {
			mat[ p.getRow( ) ][ p.getColumn( ) ] = true;
		}
		p.setValues( position.getRow( ) - 2, position.getColumn( ) );
		Position p2 = new Position( position.getRow( ) - 1, position.getColumn( ) );
		if( getBoard( ).positionExists( p ) && ! getBoard( ).thereIsAPiece( p ) && getBoard( ).positionExists( p2 ) && ! getBoard( ).thereIsAPiece( p2 ) && getMoveCount( ) == 0 ) {
			mat[ p.getRow( ) ][ p.getColumn( ) ] = true;
		}
	}

	@Override
	public void toNorthEast( Position p, boolean[][] mat ) {
		p.setValues( position.getRow( ) - 1, position.getColumn( ) + 1 );
		if( getBoard( ).positionExists( p ) && isThereOpponentPiece( p ) ) {
			mat[ p.getRow( ) ][ p.getColumn( ) ] = true;
		}
	}

	@Override
	public void toEast( Position p, boolean[][] mat ) {
		mat[ p.getRow( ) ][ p.getColumn( ) ] = false;
	}

	@Override
	public void toSouthEast( Position p, boolean[][] mat ) {
		p.setValues( position.getRow( ) + 1, position.getColumn( ) + 1 );
		if( getBoard( ).positionExists( p ) && isThereOpponentPiece( p ) ) {
			mat[ p.getRow( ) ][ p.getColumn( ) ] = true;
		}
	}

	@Override
	public void toSouth( Position p, boolean[][] mat ) {
		p.setValues( position.getRow( ) + 1, position.getColumn( ) );
		if( getBoard( ).positionExists( p ) && ! getBoard( ).thereIsAPiece( p ) ) {
			mat[ p.getRow( ) ][ p.getColumn( ) ] = true;
		}
		p.setValues( position.getRow( ) + 2, position.getColumn( ) );
		Position p2 = new Position( position.getRow( ) + 1, position.getColumn( ) );
		if( getBoard( ).positionExists( p ) && ! getBoard( ).thereIsAPiece( p ) && getBoard( ).positionExists( p2 ) && ! getBoard( ).thereIsAPiece( p2 ) && getMoveCount( ) == 0 ) {
			mat[ p.getRow( ) ][ p.getColumn( ) ] = true;
		}
	}

	@Override
	public void toSouthWest( Position p, boolean[][] mat ) {
		p.setValues( position.getRow( ) + 1, position.getColumn( ) - 1 );
		if( getBoard( ).positionExists( p ) && isThereOpponentPiece( p ) ) {
			mat[ p.getRow( ) ][ p.getColumn( ) ] = true;
		}
	}

	@Override
	public void toWest( Position p, boolean[][] mat ) {
		mat[ p.getRow( ) ][ p.getColumn( ) ] = false;
	}

	@Override
	public void toNorthWest( Position p, boolean[][] mat ) {
		p.setValues( position.getRow( ) - 1, position.getColumn( ) - 1 );
		if( getBoard( ).positionExists( p ) && isThereOpponentPiece( p ) ) {
			mat[ p.getRow( ) ][ p.getColumn( ) ] = true;
		}
	}
}
