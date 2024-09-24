package exercicio09.chess.pieces.entities;

import exercicio09.board.Board;
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
}
