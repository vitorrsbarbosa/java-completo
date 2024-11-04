package modulo23.chessgame.chess.pieces;

import modulo23.chessgame.boardgame.Board;
import modulo23.chessgame.boardgame.Position;
import modulo23.chessgame.chess.ChessMatch;
import modulo23.chessgame.chess.ChessPiece;
import modulo23.chessgame.chess.Color;

public class Pawn extends ChessPiece {
	private ChessMatch chessMatch;

	public Pawn( Board board, Color color, ChessMatch chessMatch ) {
		super( board, color );
		this.chessMatch = chessMatch;
	}

	@Override
	public String toString( ) {
		return "P";
	}

	@Override
	public boolean[][] possibleMoves( ) {
		boolean[][] mat = new boolean[ getBoard( ).getRows( ) ][ getBoard( ).getColumns( ) ];
		Position p = new Position( 0, 0 );

		if( getColor( ).equals( Color.WHITE ) ) {
			toNorth( p, mat );
			toNorthWest( p, mat );
			toNorthEast( p, mat );
			enPassantWhite( mat );
		}
		if( getColor( ).equals( Color.BLACK ) ) {
			toSouth( p, mat );
			toSouthWest( p, mat );
			toSouthEast( p, mat );
			enPassantBlack( mat );
		}
		return mat;
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

	private void enPassantWhite( boolean[][] mat ) {
		if( position.getRow( ) == 3 ) {
			Position left = new Position( position.getRow( ), position.getColumn( ) - 1 );
			if( getBoard( ).positionExists( left ) && isThereOpponentPiece( left ) && getBoard( ).piece( left ) == chessMatch.getEnPassantVulnerable( ) ) {
				mat[ left.getRow( ) - 1 ][ left.getColumn( ) ] = true;
			}
			Position right = new Position( position.getRow( ), position.getColumn( ) + 1 );
			if( getBoard( ).positionExists( right ) && isThereOpponentPiece( right ) && getBoard( ).piece( right ) == chessMatch.getEnPassantVulnerable( ) ) {
				mat[ right.getRow( ) - 1 ][ right.getColumn( ) ] = true;
			}
		}
	}

	private void enPassantBlack( boolean[][] mat ) {
		if( position.getRow( ) == 4 ) {
			Position left = new Position( position.getRow( ), position.getColumn( ) - 1 );
			if( getBoard( ).positionExists( left ) && isThereOpponentPiece( left ) && getBoard( ).piece( left ) == chessMatch.getEnPassantVulnerable( ) ) {
				mat[ left.getRow( ) + 1 ][ left.getColumn( ) ] = true;
			}
			Position right = new Position( position.getRow( ), position.getColumn( ) + 1 );
			if( getBoard( ).positionExists( right ) && isThereOpponentPiece( right ) && getBoard( ).piece( right ) == chessMatch.getEnPassantVulnerable( ) ) {
				mat[ right.getRow( ) + 1 ][ right.getColumn( ) ] = true;
			}
		}
	}
}
