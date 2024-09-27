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

	public abstract void toLeft( Position p, boolean[][] mat );

	public abstract void toDiagonalRightBellow( Position p, boolean[][] mat );

	public abstract void toRight( Position p, boolean[][] mat );

	public abstract void toDiagonalLeftBellow( Position p, boolean[][] mat );

	public abstract void toAbove( Position p, boolean[][] mat );

	public abstract void toDiagonalLeftAbove( Position p, boolean[][] mat );

	public abstract void toBellow( Position p, boolean[][] mat );

	public abstract void toDiagonalRightAbove( Position p, boolean[][] mat );
}
