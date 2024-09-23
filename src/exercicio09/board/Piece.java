package exercicio09.board;

public abstract class Piece {
	protected Position position;
	private Board board;

	public Piece( ) {
	}

	public Piece( Board board ) {
		this.board = board;
	}

	public Position getPosition( ) {
		return position;
	}

	public void setPosition( Position position ) {
		this.position = position;
	}

	protected Board getBoard( ) {
		return board;
	}

	public boolean[][] possibleMoves( ) {
		return null;
	}

	public boolean possibleMove( Position position ) {
		return false;
	}

	public boolean isThereAnyPossibleMove( ) {
		return false;
	}
}
