package exercicio09.chess.pieces;

import exercicio09.board.Board;
import exercicio09.board.Piece;
import exercicio09.board.Position;
import exercicio09.chess.enums.Color;

public abstract class ChessPiece extends Piece {
	private Color color;
	private Board board;

	public ChessPiece( ) {
	}

	public ChessPiece( Board board, Color color ) {
		super( );
		this.board = board;
		this.color = color;
	}

	@Override
	public Board getBoard( ) {
		return board;
	}

	public void setBoard( Board board ) {
		this.board = board;
	}

	public Color getColor( ) {
		return color;
	}

	public void setColor( Color color ) {
		this.color = color;
	}

	protected boolean isThereOpponentPiece( Position position ) {
		ChessPiece piece = ( ChessPiece ) getBoard( ).piece( position );
		return piece != null && piece.getColor( ) != color;
	}

	@Override
	public abstract boolean[][] possibleMoves( );

	public abstract void toNorth( Position p, boolean[][] mat );

	public abstract void toNorthEast( Position p, boolean[][] mat );

	public abstract void toEast( Position p, boolean[][] mat );

	public abstract void toSouthEast( Position p, boolean[][] mat );

	public abstract void toSouth( Position p, boolean[][] mat );

	public abstract void toSouthWest( Position p, boolean[][] mat );

	public abstract void toWest( Position p, boolean[][] mat );

	public abstract void toNorthWest( Position p, boolean[][] mat );
}
