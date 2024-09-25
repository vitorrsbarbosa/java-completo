package exercicio09.board.entities;

import exercicio09.board.Board;
import exercicio09.board.Piece;
import exercicio09.board.Position;
import exercicio09.chess.enums.Color;
import exercicio09.chess.exceptions.ChessException;
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

	private void placeNewPiece( char column, int row, ChessPiece piece ) {
		board.placePiece( piece, new ChessPosition( column, row ).toPosition( ) );
	}

	private void initialSetup( ) {
		placeNewPiece( 'a', 8, new Rook( board, Color.WHITE ) );
		placeNewPiece( 'b', 8, new Knight( board, Color.WHITE ) );
		placeNewPiece( 'c', 8, new Bishop( board, Color.WHITE ) );
		placeNewPiece( 'd', 8, new Queen( board, Color.WHITE ) );
		placeNewPiece( 'e', 8, new King( board, Color.WHITE ) );
		placeNewPiece( 'f', 8, new Bishop( board, Color.WHITE ) );
		placeNewPiece( 'g', 8, new Knight( board, Color.WHITE ) );
		placeNewPiece( 'h', 8, new Rook( board, Color.WHITE ) );

		for( char i = 'a'; i <= 'h'; i++ ) {
			placeNewPiece( i, 7, new Pawn( board, Color.WHITE ) );
			placeNewPiece( i, 2, new Pawn( board, Color.BLACK ) );
		}

		placeNewPiece( 'a', 1, new Rook( board, Color.BLACK ) );
		placeNewPiece( 'b', 1, new Knight( board, Color.BLACK ) );
		placeNewPiece( 'c', 1, new Bishop( board, Color.BLACK ) );
		placeNewPiece( 'd', 1, new King( board, Color.BLACK ) );
		placeNewPiece( 'e', 1, new Queen( board, Color.BLACK ) );
		placeNewPiece( 'f', 1, new Bishop( board, Color.BLACK ) );
		placeNewPiece( 'g', 1, new Knight( board, Color.BLACK ) );
		placeNewPiece( 'h', 1, new Rook( board, Color.BLACK ) );
	}

	public ChessPiece performChessMove( ChessPosition sourcePosition, ChessPosition targetPosition ) {
		Position source = sourcePosition.toPosition( );
		Position target = targetPosition.toPosition( );
		validateSourcePosition( source );
		Piece capturedPiece = makeMove( source, target );
		return ( ChessPiece ) capturedPiece;
	}

	private Piece makeMove( Position source, Position target ) {
		Piece piece = board.removePiece( source );
		Piece capturedPiece = board.removePiece( target );
		board.placePiece( piece, target );
		return capturedPiece;
	}

	private void validateSourcePosition( Position source ) {
		if( ! board.thereIsAPiece( source ) ) {
			throw new ChessException( "Position not on the board." );
		}
	}
}
