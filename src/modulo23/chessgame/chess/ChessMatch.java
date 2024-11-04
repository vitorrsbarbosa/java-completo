package modulo23.chessgame.chess;

import modulo23.chessgame.boardgame.Board;
import modulo23.chessgame.boardgame.Piece;
import modulo23.chessgame.boardgame.Position;
import modulo23.chessgame.chess.pieces.*;

import java.util.ArrayList;
import java.util.List;

public class ChessMatch {
	private final List<Piece> piecesOnTheBoard = new ArrayList<>( );
	private final List<Piece> capturedPieces = new ArrayList<>( );
	private int turn;
	private Color currentPlayer;
	private boolean check;
	private boolean checkMate;
	private ChessPiece enPassantVulnerable;
	private ChessPiece promoted;
	private Board board;

	public ChessMatch( ) {
		board = new Board( 8, 8 );
		setTurn( 1 );
		setCurrentPlayer( Color.WHITE );
		initialSetup( );
	}

	public ChessMatch( int turn, Color currentPlayer, boolean check, boolean checkMate, ChessPiece enPassantVulnerable, ChessPiece promoted ) {
		this.turn = turn;
		this.currentPlayer = currentPlayer;
		this.check = check;
		this.checkMate = checkMate;
		this.enPassantVulnerable = enPassantVulnerable;
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

	public ChessPiece getEnPassantVulnerable( ) {
		return enPassantVulnerable;
	}

	public void setEnPassantVulnerable( ChessPiece enPassantVulnerable ) {
		this.enPassantVulnerable = enPassantVulnerable;
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
		placeNewPiece( 'a', 8, new Rook( board, Color.BLACK ) );
		placeNewPiece( 'b', 8, new Knight( board, Color.BLACK ) );
		placeNewPiece( 'c', 8, new Bishop( board, Color.BLACK ) );
		placeNewPiece( 'd', 8, new Queen( board, Color.BLACK ) );
		placeNewPiece( 'e', 8, new King( board, Color.BLACK, this ) );
		placeNewPiece( 'f', 8, new Bishop( board, Color.BLACK ) );
		placeNewPiece( 'g', 8, new Knight( board, Color.BLACK ) );
		placeNewPiece( 'h', 8, new Rook( board, Color.BLACK ) );

		for( char i = 'a'; i <= 'h'; i++ ) {
			placeNewPiece( i, 7, new Pawn( board, Color.BLACK, this ) );
			placeNewPiece( i, 2, new Pawn( board, Color.WHITE, this ) );
		}

		placeNewPiece( 'a', 1, new Rook( board, Color.WHITE ) );
		placeNewPiece( 'b', 1, new Knight( board, Color.WHITE ) );
		placeNewPiece( 'c', 1, new Bishop( board, Color.WHITE ) );
		placeNewPiece( 'd', 1, new Queen( board, Color.WHITE ) );
		placeNewPiece( 'e', 1, new King( board, Color.WHITE, this ) );
		placeNewPiece( 'f', 1, new Bishop( board, Color.WHITE ) );
		placeNewPiece( 'g', 1, new Knight( board, Color.WHITE ) );
		placeNewPiece( 'h', 1, new Rook( board, Color.WHITE ) );
	}

	private void nextTurn( ) {
		setTurn( getTurn( ) + 1 );
		setCurrentPlayer( currentPlayer.equals( Color.WHITE ) ? Color.BLACK : Color.WHITE );
	}

	private Color opponent( Color color ) {
		return ( color.equals( Color.WHITE ) ? Color.BLACK : Color.WHITE );
	}

	private ChessPiece king( Color color ) {
		List<Piece> list = piecesOnTheBoard.stream( ).filter( x -> ( ( ChessPiece ) x ).getColor( ) == color ).toList( );
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
						undoMove( source1, target, capturedPiece );

						if( ! testCheck ) {
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
		ChessPiece movedPiece = ( ChessPiece ) board.piece( target );

		// #specialMove promotion
		promoted = null;
		if( movedPiece instanceof Pawn ) {
			if( ( movedPiece.getColor( ) == Color.WHITE && target.getRow( ) == 0 ) || ( movedPiece.getColor( ) == Color.BLACK && target.getRow( ) == 7 ) ) {
				promoted = ( ChessPiece ) board.piece( target );
				promoted = replacePromotedPiece( "Q" );
			}
		}
		check = testCheck( opponent( currentPlayer ) );

		if( testCheckMate( opponent( currentPlayer ) ) ) {
			checkMate = true;
		} else {
			nextTurn( );
		}
		// #specialMove en passant
		if( movedPiece instanceof Pawn && ( target.getRow( ) == source.getRow( ) - 2 || target.getRow( ) == source.getRow( ) + 2 ) ) {
			enPassantVulnerable = movedPiece;
		} else {
			enPassantVulnerable = null;
		}
		return ( ChessPiece ) capturedPiece;
	}

	public ChessPiece replacePromotedPiece( String type ) {
		if( promoted == null ) {
			throw new IllegalStateException( "There is no piece to be promoted." );
		}
		if( ! type.equals( "B" ) && ! type.equals( "N" ) && ! type.equals( "R" ) && ! type.equals( "Q" ) ) {
			return promoted;
		}
		Position position = promoted.getChessPosition( ).toPosition( );
		Piece piece = board.removePiece( position );
		piecesOnTheBoard.remove( piece );

		ChessPiece newPiece = newPiece( type, promoted.getColor( ) );
		board.placePiece( newPiece, position );
		piecesOnTheBoard.add( newPiece );

		return newPiece;
	}

	private ChessPiece newPiece( String type, Color color ) {
		return switch( type ) {
			case "B" -> new Bishop( board, color );
			case "N" -> new Knight( board, color );
			case "R" -> new Rook( board, color );
			default -> new Queen( board, color );
		};
	}

	private Piece makeMove( Position source, Position target ) {
		ChessPiece piece = ( ChessPiece ) board.removePiece( source );
		piece.increaseMoveCount( );
		Piece capturedPiece = board.removePiece( target );
		board.placePiece( piece, target );
		if( capturedPiece != null ) {
			piecesOnTheBoard.remove( capturedPiece );
			capturedPieces.add( capturedPiece );
		}
		// #specialMove castling kingside rook
		if( piece instanceof King && target.getColumn( ) == source.getColumn( ) + 2 ) {
			Position sourceRookPosition = new Position( source.getRow( ), source.getColumn( ) + 3 );
			Position targetRookPosition = new Position( source.getRow( ), source.getColumn( ) + 1 );
			ChessPiece rook = ( ChessPiece ) board.removePiece( sourceRookPosition );
			board.placePiece( rook, targetRookPosition );
			rook.increaseMoveCount( );
		}
		// #specialMove castling queenside rook
		if( piece instanceof King && target.getColumn( ) == source.getColumn( ) - 2 ) {
			Position sourceRookPosition = new Position( source.getRow( ), source.getColumn( ) - 4 );
			Position targetRookPosition = new Position( source.getRow( ), source.getColumn( ) - 1 );
			ChessPiece rook = ( ChessPiece ) board.removePiece( sourceRookPosition );
			board.placePiece( rook, targetRookPosition );
			rook.increaseMoveCount( );
		}
		// #specialMove en passant
		if( piece instanceof Pawn ) {
			// diagonal move without capturing any piece
			if( source.getColumn( ) != target.getColumn( ) && capturedPiece == null ) {
				Position pawnPosition;
				if( piece.getColor( ) == Color.WHITE ) {
					pawnPosition = new Position( target.getRow( ) + 1, target.getColumn( ) );
				} else {
					// same as if( piece.getColor( ) == Color.BLACK ) {
					pawnPosition = new Position( target.getRow( ) - 1, target.getColumn( ) );
				}
				capturedPiece = board.removePiece( pawnPosition );
				capturedPieces.add( capturedPiece );
				piecesOnTheBoard.remove( capturedPiece );
			}
		}
		return capturedPiece;
	}

	private void undoMove( Position source, Position target, Piece capturedPiece ) {
		ChessPiece piece = ( ChessPiece ) board.removePiece( target );
		piece.decreaseMoveCount( );
		board.placePiece( piece, source );
		if( capturedPiece != null ) {
			board.placePiece( capturedPiece, target );
			capturedPieces.remove( capturedPiece );
			piecesOnTheBoard.add( capturedPiece );
		}
		// #specialMove castling kingside rook
		if( piece instanceof King && target.getColumn( ) == source.getColumn( ) + 2 ) {
			Position sourceRookPosition = new Position( source.getRow( ), source.getColumn( ) + 3 );
			Position targetRookPosition = new Position( target.getRow( ), target.getColumn( ) + 1 );
			ChessPiece rook = ( ChessPiece ) board.removePiece( targetRookPosition );
			board.placePiece( rook, sourceRookPosition );
			rook.decreaseMoveCount( );
		}
		// #specialMove castling queenside rook
		if( piece instanceof King && target.getColumn( ) == source.getColumn( ) - 2 ) {
			Position sourceRookPosition = new Position( source.getRow( ), source.getColumn( ) - 4 );
			Position targetRookPosition = new Position( target.getRow( ), target.getColumn( ) - 1 );
			ChessPiece rook = ( ChessPiece ) board.removePiece( targetRookPosition );
			board.placePiece( rook, sourceRookPosition );
			rook.decreaseMoveCount( );
		}
		// #specialMove en passant
		if( piece instanceof Pawn ) {
			// diagonal move without capturing any piece
			if( source.getColumn( ) != target.getColumn( ) && capturedPiece == enPassantVulnerable ) {
				ChessPiece pawn = ( ChessPiece ) board.removePiece( target );
				Position pawnPosition;
				if( piece.getColor( ) == Color.WHITE ) {
					pawnPosition = new Position( 3, target.getColumn( ) );
				} else {
					// same as if( piece.getColor( ) == Color.BLACK ) {
					pawnPosition = new Position( 4, target.getColumn( ) );
				}
				board.placePiece( pawn, pawnPosition );
			}
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
