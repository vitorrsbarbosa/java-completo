package exercicio09.chess;

import exercicio09.boardgame.Board;
import exercicio09.boardgame.Piece;
import exercicio09.boardgame.Position;

public abstract class ChessPiece extends Piece {
	private Color color;
	private Board board;
	private int moveCount;

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

	public int getMoveCount( ) {
		return moveCount;
	}

	public void setMoveCount( int moveCount ) {
		this.moveCount = moveCount;
	}

	public void increaseMoveCount( ) {
		setMoveCount( moveCount++ );
	}

	public void decreaseMoveCount( ) {
		setMoveCount( moveCount-- );
	}

	protected boolean isThereOpponentPiece( Position position ) {
		ChessPiece piece = ( ChessPiece ) getBoard( ).piece( position );
		return piece != null && piece.getColor( ) != color;
	}

	public ChessPosition getChessPosition( ) {
		return ChessPosition.fromPosition( position );
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
