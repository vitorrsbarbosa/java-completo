package exercicio09;

import exercicio09.board.entities.ChessMatch;

public class Program {
	public static void main( String[] args ) {
//		Scanner sc = new Scanner( System.in );

		ChessMatch chessMatch = new ChessMatch( );
		UI.printBoard( chessMatch.getPieces( ) );
//		sc.close( );
	}
}
