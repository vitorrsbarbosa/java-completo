package modulo23.chessgame.application;

import modulo23.chessgame.chess.ChessException;
import modulo23.chessgame.chess.ChessMatch;
import modulo23.chessgame.chess.ChessPiece;
import modulo23.chessgame.chess.ChessPosition;

import java.util.*;

public class Program {
	public static void main( String[] args ) {
		Scanner sc = new Scanner( System.in );
		ChessMatch chessMatch = new ChessMatch( );
		List<ChessPiece> captured = new ArrayList<>( );

		while( ! chessMatch.isCheckMate( ) ) {
			try {
				UI.clearScreen( );
				UI.printMatch( chessMatch, captured );
				System.out.print( "Source: " );
				ChessPosition source = UI.readChessPosition( sc );

				boolean[][] possibleMoves = chessMatch.possibleMoves( source );
				UI.clearScreen( );
				UI.printBoard( chessMatch.getPieces( ), possibleMoves );
				System.out.print( "Target: " );
				ChessPosition target = UI.readChessPosition( sc );

				ChessPiece capturedPiece = chessMatch.performChessMove( source, target );
				if( capturedPiece != null ) {
					captured.add( capturedPiece );
				}
				if(chessMatch.getPromoted() != null) {
					System.out.print( "Enter piece for promotion (B/N/R/Q): " );
					String type = sc.nextLine( ).toUpperCase(  );
					while( !type.equals( "B" ) && !type.equals( "N" ) && !type.equals( "R" ) && !type.equals( "Q" ) ) {
						System.out.print( "Invalid value! Enter piece for promotion (B/N/R/Q): " );
						type = sc.nextLine( ).toUpperCase(  );
					}
					chessMatch.replacePromotedPiece(type);
				}
			} catch( ChessException | InputMismatchException e ) {
				System.out.println( e.getMessage( ) );
				sc.nextLine( );
			}
		}
		UI.clearScreen();
		UI.printMatch( chessMatch, captured );
	}
}