package exercicio09.chess;

import exercicio09.boardgame.Board;
import exercicio09.boardgame.Piece;
import exercicio09.boardgame.Position;
import exercicio09.chess.pieces.King;
import exercicio09.chess.pieces.Rook;

import java.util.ArrayList;
import java.util.List;

public class ChessMatch {
	private final List<Piece> piecesOnTheBoard = new ArrayList<>( );
	private final List<Piece> capturedPieces = new ArrayList<>( );
	private int turn;
	private Color currentPlayer;
	private boolean check;
	private boolean checkMate;
	private ChessPiece enPassant;
	private ChessPiece promoted;
	private Board board;

	public ChessMatch( ) {
		board = new Board( 8, 8 );
		setTurn( 1 );
		setCurrentPlayer( Color.WHITE );
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
//		placeNewPiece( 'a', 8, new Rook( board, Color.WHITE ) );
//		placeNewPiece( 'b', 8, new Knight( board, Color.WHITE ) );
//		placeNewPiece( 'c', 8, new Bishop( board, Color.WHITE ) );
//		placeNewPiece( 'd', 8, new Queen( board, Color.WHITE ) );
//		placeNewPiece( 'e', 8, new King( board, Color.WHITE ) );
//		placeNewPiece( 'f', 8, new Bishop( board, Color.WHITE ) );
//		placeNewPiece( 'g', 8, new Knight( board, Color.WHITE ) );
//		placeNewPiece( 'h', 8, new Rook( board, Color.WHITE ) );

//		for( char i = 'a'; i <= 'h'; i++ ) {
//			placeNewPiece( i, 7, new Pawn( board, Color.WHITE ) );
//			placeNewPiece( i, 2, new Pawn( board, Color.BLACK ) );
//		}

//		placeNewPiece( 'a', 1, new Rook( board, Color.BLACK ) );
//		placeNewPiece( 'b', 1, new Knight( board, Color.BLACK ) );
//		placeNewPiece( 'c', 1, new Bishop( board, Color.BLACK ) );
//		placeNewPiece( 'd', 1, new King( board, Color.BLACK ) );
//		placeNewPiece( 'e', 1, new Queen( board, Color.BLACK ) );
//		placeNewPiece( 'f', 1, new Bishop( board, Color.BLACK ) );
//		placeNewPiece( 'g', 1, new Knight( board, Color.BLACK ) );
//		placeNewPiece( 'h', 1, new Rook( board, Color.BLACK ) );

		placeNewPiece( 'h', 7, new Rook( board, Color.WHITE ) );
		placeNewPiece( 'd', 1, new Rook( board, Color.WHITE ) );
		placeNewPiece( 'e', 1, new King( board, Color.WHITE ) );

		placeNewPiece( 'b', 8, new Rook( board, Color.BLACK ) );
		placeNewPiece( 'a', 8, new King( board, Color.BLACK ) );

	}

	private void nextTurn( ) {
		setTurn( getTurn( ) + 1 );
		setCurrentPlayer( currentPlayer.equals( Color.WHITE ) ? Color.BLACK : Color.WHITE );
	}

	private Color opponent( Color color ) {
		return ( color.equals( Color.WHITE ) ? Color.BLACK : Color.WHITE );
	}

	private ChessPiece king( Color color ) {
		List<Piece> list = piecesOnTheBoard
				.stream( ).filter( x -> ( ( ChessPiece ) x ).getColor( ) == color ).toList( );
		for( Piece p : list ) {
			if( p instanceof King ) {
				return ( ChessPiece ) p;
			}
		}
		throw new IllegalArgumentException( "There is no " + color + " king on the board" );
	}

	private boolean testCheck( Color color ) {
		Position kingPosition = king( color ).getChessPosition( ).toPosition( );
		List<Piece> opponentPieces = piecesOnTheBoard.stream( ).filter( x -> ( ( ChessPiece ) x ).getColor( ) == opponent( color ) ).toList( );
		for( Piece p : opponentPieces ) {
			boolean[][] mat = p.possibleMoves( );
			if( mat[ kingPosition.getRow( ) ][ kingPosition.getColumn( ) ] ) {
				return true;
			}
		}
		return false;
	}

	private boolean testCheckMate( Color color ) {
		if( ! testCheck( color ) ) {
			return false;
		}
		List<Piece> list = piecesOnTheBoard.stream( ).filter( x -> ( ( ChessPiece ) x ).getColor( ) == color ).toList( );
		for( Piece p : list ) {
			boolean[][] mat = p.possibleMoves( );
			for( int i = 0; i < board.getRows( ); i++ ) {
				for( int j = 0; j < board.getColumns( ); j++ ) {
					if( mat[ i ][ j ] ) {
						Position source1 = p.getPosition( );
						Position source2 = ( ( ChessPiece ) p ).getChessPosition( ).toPosition( );
						Position target = new Position( i, j );
						Piece capturedPiece = makeMove( source1, target );
						boolean testCheck = testCheck( color );
						undoMove( source1,target,capturedPiece );

						if(!testCheck) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}

	private void placeNewPiece( char column, int row, ChessPiece piece ) {
		board.placePiece( piece, new ChessPosition( column, row ).toPosition( ) );
		piecesOnTheBoard.add( piece );
	}

	public boolean[][] possibleMoves( ChessPosition sourcePosition ) {
		Position position = sourcePosition.toPosition( );
		validateSourcePosition( position );
		return board.piece( position ).possibleMoves( );
	}

	public ChessPiece performChessMove( ChessPosition sourcePosition, ChessPosition targetPosition ) {
		Position source = sourcePosition.toPosition( );
		Position target = targetPosition.toPosition( );
		validateSourcePosition( source );
		validateTargetPosition( source, target );
		Piece capturedPiece = makeMove( source, target );
		if( testCheck( currentPlayer ) ) {
			undoMove( source, target, capturedPiece );
			throw new ChessException( "You can't put yourself in check" );
		}
		check = (testCheck( opponent( currentPlayer ) ))? true:false;

		if(testCheckMate( opponent( currentPlayer ) ) ) {
			checkMate = true;
		} else {
			nextTurn( );
		}
		return ( ChessPiece ) capturedPiece;
	}

	private Piece makeMove( Position source, Position target ) {
		Piece piece = board.removePiece( source );
		Piece capturedPiece = board.removePiece( target );
		board.placePiece( piece, target );
		if( capturedPiece != null ) {
			piecesOnTheBoard.remove( capturedPiece );
			capturedPieces.add( capturedPiece );
		}
		return capturedPiece;
	}

	private void undoMove( Position source, Position target, Piece capturedPiece ) {
		Piece p = board.removePiece( target );
		board.placePiece( p, source );
		if( capturedPiece != null ) {
			board.placePiece( capturedPiece, target );
			capturedPieces.remove( capturedPiece );
			piecesOnTheBoard.add( capturedPiece );
		}
	}

	private void validateSourcePosition( Position source ) {
		if( ! board.thereIsAPiece( source ) ) {
			throw new ChessException( "There is no piece on source position." );
		}
		if( currentPlayer != ( ( ChessPiece ) board.piece( source ) ).getColor( ) ) {
			throw new ChessException( "These isn't your piece to play, choose some " + currentPlayer + " piece to play with." );
		}
		if( ! board.piece( source ).isThereAnyPossibleMove( ) ) {
			throw new ChessException( "There is no possible moves for the chosen piece." );
		}
	}

	private void validateTargetPosition( Position source, Position target ) {
		if( ! board.piece( source ).possibleMove( target ) ) {
			throw new ChessException( "The chosen piece can't move to target position." );
		}
	}
}
