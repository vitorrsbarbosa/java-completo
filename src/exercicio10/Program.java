package exercicio10;

import java.io.*;
import java.util.Scanner;

public class Program {
	public static void main( String[] args ) {
		String filePath = "C:\\Temp\\in.txt";
		FileReader fr = null;
		BufferedReader br = null;
		try{
			fr = new FileReader(filePath);
			br = new BufferedReader(fr);
			String line = br.readLine();
			while(line != null){
				System.out.println(line);
				line = br.readLine();
			}

		} catch( IOException e ) {
			System.err.println( "Error: " + e.getMessage() );
		} finally {
			try {
				if( br != null ) {
					br.close( );
				}
				if( fr != null ) {
					fr.close( );
				}
			} catch( IOException e ) {
				e.printStackTrace();
			}
		}
	}
}
