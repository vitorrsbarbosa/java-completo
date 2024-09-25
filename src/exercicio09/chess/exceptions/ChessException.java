package exercicio09.chess.exceptions;

import exercicio09.board.exceptions.BoardException;

public class ChessException extends BoardException {
	public ChessException( String message ) {
		super( message );
	}
}
