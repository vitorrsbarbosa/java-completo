package modulo23.chessgame.application;

import modulo23.chessgame.chess.ChessMatch;
import modulo23.chessgame.chess.ChessPiece;
import modulo23.chessgame.chess.ChessPosition;
import modulo23.chessgame.chess.Color;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UI {
	// Using ANSI colors to improve visually the program
	// (from this link)[https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println]
	public static final String ANSI_RESET = "\u001B[0m";

	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

	// https://stackoverflow.com/questions/2979383/java-clear-the-console
	public static void clearScreen( ) {
		System.out.print( "\033[H\033[2J" );
		System.out.flush( );
	}

	public static void printMatch( ChessMatch match, List<ChessPiece> captured ) {
		printBoard( match.getPieces( ) );
		System.out.println( );
		printCapturedPieces( captured );
		System.out.println( );
		System.out.println( "Turn: " + match.getTurn( ) );
		if( ! match.isCheckMate( ) ) {
			System.out.println( "Waiting player: " + match.getCurrentPlayer( ) );
			if( match.isCheck( ) ) {
				System.out.println( "CHECK!" );
			}
		} else {
			System.out.println( "CHECK MATE!" );
			System.out.println( "Winner: " + match.getCurrentPlayer( ) );
		}
	}

	public static void printBoard( ChessPiece[][] pieces ) {
		System.out.println( );
		for( int i = 0; i < pieces.length; i++ ) {
			System.out.print( ANSI_GREEN + "[" + ( 8 - i ) + "] " + ANSI_RESET );
			for( int j = 0; j < pieces.length; j++ ) {
				printPiece( pieces[ i ][ j ], false );
			}
			System.out.println( );
		}
		System.out.println( "    " + ANSI_GREEN + "[a] [b] [c] [d] [e] [f] [g] [h]" + ANSI_RESET );
	}

	public static void printBoard( ChessPiece[][] pieces, boolean[][] possibleMoves ) {
		System.out.println( );
		for( int i = 0; i < pieces.length; i++ ) {
			System.out.print( ANSI_GREEN + "[" + ( 8 - i ) + "] " + ANSI_RESET );
			for( int j = 0; j < pieces.length; j++ ) {
				printPiece( pieces[ i ][ j ], possibleMoves[ i ][ j ] );
			}
			System.out.println( );
		}
		System.out.println( "    " + ANSI_GREEN + "[a] [b] [c] [d] [e] [f] [g] [h]" + ANSI_RESET );
	}

	private static void printPiece( ChessPiece piece, boolean background ) {
		if( background ) {
			System.out.print( ANSI_BLUE_BACKGROUND );
		}
		if( piece == null ) {
			System.out.print( " - " + ANSI_RESET );
		} else {
			if( piece.getColor( ).equals( Color.WHITE ) ) {
				System.out.print( " " + ANSI_WHITE + piece + ANSI_RESET + " " );
			} else {
				System.out.print( " " + ANSI_YELLOW + piece + ANSI_RESET + " " );
			}
		}
		System.out.print( " " );
	}

	private static void printCapturedPieces( List<ChessPiece> capturedPieces ) {
		List<ChessPiece> white = capturedPieces.stream( ).filter( x -> x.getColor( ) == Color.WHITE ).toList( );
		List<ChessPiece> black = capturedPieces.stream( ).filter( x -> x.getColor( ) == Color.BLACK ).toList( );

		System.out.println( "Captured pieces: " );
		System.out.print( "White: " );
		System.out.println( ANSI_WHITE + Arrays.toString( white.toArray( ) ) + ANSI_RESET );
		System.out.print( "Black: " );
		System.out.println( ANSI_YELLOW + Arrays.toString( black.toArray( ) ) + ANSI_RESET );
	}

	public static ChessPosition readChessPosition( Scanner scanner ) {
		try {
			String position = scanner.nextLine( ).toLowerCase( );
			char column = position.charAt( 0 );
			int row = Integer.parseInt( position.substring( 1 ) );
			return new ChessPosition( column, row );
		} catch( RuntimeException e ) {
			throw new InputMismatchException( "Error reading ChessPosition. Valid input from 'a1' to 'h8'." );
		}
	}
}
