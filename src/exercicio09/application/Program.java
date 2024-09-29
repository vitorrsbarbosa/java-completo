package exercicio09.application;

import exercicio09.chess.ChessException;
import exercicio09.chess.ChessMatch;
import exercicio09.chess.ChessPiece;
import exercicio09.chess.ChessPosition;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
	public static void main( String[] args ) {
		Scanner sc = new Scanner( System.in );
		ChessMatch chessMatch = new ChessMatch( );

		while( true ) {
			try {
				UI.clearScreen( );
				UI.printBoard( chessMatch.getPieces( ) );
				System.out.print( "Source: " );
				ChessPosition source = UI.readChessPosition( sc );

				boolean[][] possibleMoves = chessMatch.possibleMoves( source );
				UI.clearScreen( );
				UI.printBoard( chessMatch.getPieces( ), possibleMoves );
				System.out.print( "Target: " );
				ChessPosition target = UI.readChessPosition( sc );

				ChessPiece capturedPiece = chessMatch.performChessMove( source, target );
			} catch( ChessException | InputMismatchException e ) {
				System.out.println( e.getMessage( ) );
				sc.nextLine( );
			}
		}
	}
}
