package exercicio09.chess.pieces;

import exercicio09.board.Board;
import exercicio09.board.Piece;
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
}
