package modulo15.file.read;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadMethods {
	public static void readFile01( ) {
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

	public static void readFile02( ) {
		String filePath = "C:\\Temp\\in.txt";
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader( filePath );
			br = new BufferedReader( fr );
			String line = br.readLine( );
			while( line != null ) {
				System.out.println( line );
				line = br.readLine( );
			}
		} catch( IOException e ) {
			System.err.println( "Error: " + e.getMessage( ) );
		} finally {
			try {
				if( br != null ) {
					br.close( );
				}
				if( fr != null ) {
					fr.close( );
				}
			} catch( IOException e ) {
				e.printStackTrace( );
			}
		}
	}

	public static void readFile03( ) {
		String filePath = "C:\\Temp\\in.txt";
		try( BufferedReader br = new BufferedReader( new FileReader( filePath ) ) ) {
			String line = br.readLine( );
			while( line != null ) {
				System.out.println( line );
				line = br.readLine( );
			}
		} catch( IOException e ) {
			System.err.println( "Error: " + e.getMessage( ) );
		}
	}
}
