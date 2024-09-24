package exercicio09.board.entities;

import exercicio09.board.Board;
import exercicio09.board.Position;
import exercicio09.chess.enums.Color;
import exercicio09.chess.pieces.ChessPiece;
import exercicio09.chess.pieces.entities.*;

public class ChessMatch {
	private int turn;
	private Color currentPlayer;
	private boolean check;
	private boolean checkMate;
	private ChessPiece enPassant;
	private ChessPiece promoted;
	private Board board;

	public ChessMatch( ) {
		board = new Board( 8, 8 );
		initialSetup( );
	}

	public ChessMatch( int turn, Color currentPlayer, boolean check, boolean checkMate, ChessPiece enPassant, ChessPiece promoted ) {
		this.turn = turn;
		this.currentPlayer = currentPlayer;
		this.check = check;
		this.checkMate = checkMate;
		this.enPassant = enPassant;
		this.promoted = promoted;
	}

	public int getTurn( ) {
		return turn;
	}

	public void setTurn( int turn ) {
		this.turn = turn;
	}

	public Color getCurrentPlayer( ) {
		return currentPlayer;
	}

	public void setCurrentPlayer( Color currentPlayer ) {
		this.currentPlayer = currentPlayer;
	}

	public boolean isCheck( ) {
		return check;
	}

	public void setCheck( boolean check ) {
		this.check = check;
	}

	public boolean isCheckMate( ) {
		return checkMate;
	}

	public void setCheckMate( boolean checkMate ) {
		this.checkMate = checkMate;
	}

	public ChessPiece getEnPassant( ) {
		return enPassant;
	}

	public void setEnPassant( ChessPiece enPassant ) {
		this.enPassant = enPassant;
	}

	public ChessPiece getPromoted( ) {
		return promoted;
	}

	public void setPromoted( ChessPiece promoted ) {
		this.promoted = promoted;
	}

	public Board getBoard( ) {
		return board;
	}

	public void setBoard( Board board ) {
		this.board = board;
	}

	public ChessPiece[][] getPieces( ) {
		ChessPiece[][] aux = new ChessPiece[ board.getRows( ) ][ board.getColumns( ) ];
		for( int i = 0; i < board.getRows( ); i++ ) {
			for( int j = 0; j < board.getColumns( ); j++ ) {
				aux[ i ][ j ] = ( ChessPiece ) board.piece( i, j );
			}
		}
		return aux;
	}

	private void initialSetup( ) {
		board.placePiece( new Rook( board, Color.WHITE ), new Position( 0, 0 ) );
		board.placePiece( new Knight( board, Color.WHITE ), new Position( 0, 1 ) );
		board.placePiece( new Bishop( board, Color.WHITE ), new Position( 0, 2 ) );
		board.placePiece( new Queen( board, Color.WHITE ), new Position( 0, 3 ) );
		board.placePiece( new King( board, Color.WHITE ), new Position( 0, 4 ) );
		board.placePiece( new Bishop( board, Color.WHITE ), new Position( 0, 5 ) );
		board.placePiece( new Knight( board, Color.WHITE ), new Position( 0, 6 ) );
		board.placePiece( new Rook( board, Color.WHITE ), new Position( 0, 7 ) );

		for( int i = 0; i < board.getRows( ); i++ ) {
			board.placePiece( new Pawn( board, Color.WHITE ), new Position( 1, i ) );
			board.placePiece( new Pawn( board, Color.BLACK ), new Position( 6, i ) );
		}

		board.placePiece( new Rook( board, Color.BLACK ), new Position( 7, 0 ) );
		board.placePiece( new Knight( board, Color.BLACK ), new Position( 7, 1 ) );
		board.placePiece( new Bishop( board, Color.BLACK ), new Position( 7, 2 ) );
		board.placePiece( new King( board, Color.BLACK ), new Position( 7, 3 ) );
		board.placePiece( new Queen( board, Color.BLACK ), new Position( 7, 4 ) );
		board.placePiece( new Bishop( board, Color.BLACK ), new Position( 7, 5 ) );
		board.placePiece( new Knight( board, Color.BLACK ), new Position( 7, 6 ) );
		board.placePiece( new Rook( board, Color.BLACK ), new Position( 7, 7 ) );
	}
}
