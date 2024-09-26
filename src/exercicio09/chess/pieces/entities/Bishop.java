package exercicio09.chess.pieces.entities;

import exercicio09.board.Board;
import exercicio09.board.Position;
import exercicio09.chess.enums.Color;
import exercicio09.chess.pieces.ChessPiece;

public class Bishop extends ChessPiece {
	public Bishop( Board board, Color color ) {
		super( board, color );
	}

	@Override
	public String toString( ) {
		return "B";
	}

	@Override
	public void toLeft( Position p, boolean[][] mat ) {

	}

	@Override
	public void toDiagonalRightBellow( Position p, boolean[][] mat ) {

	}

	@Override
	public void toRight( Position p, boolean[][] mat ) {

	}

	@Override
	public void toDiagonalLeftBellow( Position p, boolean[][] mat ) {

	}

	@Override
	public void toAbove( Position p, boolean[][] mat ) {

	}

	@Override
	public void toDiagonalLeftAbove( Position p, boolean[][] mat ) {

	}

	@Override
	public void toBellow( Position p, boolean[][] mat ) {

	}

	@Override
	public void toDiagonalRightAbove( Position p, boolean[][] mat ) {

	}
}
