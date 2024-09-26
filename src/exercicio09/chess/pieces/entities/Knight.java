package exercicio09.chess.pieces.entities;

import exercicio09.board.Board;
import exercicio09.chess.enums.Color;
import exercicio09.chess.pieces.ChessPiece;

public class Knight extends ChessPiece {
	public Knight( Board board, Color color ) {
		super( board, color );
	}

	@Override
	public String toString( ) {
		return "N";
	}

	@Override
	public boolean[][] possibleMoves( ) {
		boolean[][] mat = new boolean[ getBoard( ).getRows( ) ][ getBoard( ).getColumns( ) ];
		return mat;
	}
}
