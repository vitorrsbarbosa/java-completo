package exercicio09.chess.pieces.entities;

import exercicio09.board.Board;
import exercicio09.chess.enums.Color;
import exercicio09.chess.pieces.ChessPiece;

public class King extends ChessPiece {
	public King( Board board, Color color ) {
		super( board, color );
	}

	@Override
	public String toString( ) {
		return "K";
	}
}