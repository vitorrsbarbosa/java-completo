package exercicio06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Program {
	public static void main( String[] args ) {
		File file = new File( "C:\\Temp\\in.txt" );
		Scanner scanner = null;
		try {
			scanner = new Scanner( file );
			while( scanner.hasNextLine( ) ) {
				System.out.println( scanner.nextLine( ) );
				System.out.println( "WHILE block executed." );
			}
			System.out.println( "TRY block executed." );
		} catch( FileNotFoundException e ) {
			System.out.println( "Error opening file: " + e.getMessage( ) );
			System.out.println( "CATCH block executed." );
		} finally {
			if( scanner != null ) {
				scanner.close( );
				System.out.println( "IF block executed." );
			}
			System.out.println( "FINALLY block executed." );
		}
	}
}
