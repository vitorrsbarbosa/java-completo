package exercicio10;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Program {
	public static void main( String[] args ) {
		File file = new File( "C:\\Temp\\in.txt" );
		Scanner sc = null;
		try {
			sc = new Scanner( file );
			while( sc.hasNextLine( ) ) {
				System.out.println( sc.nextLine( ) );
			}
		} catch( IOException e ) {
			System.err.println( "Erro: " + e.getMessage( ) );
		} finally {
			assert sc != null;
			sc.close( );
		}
	}
}
