package exercicio10;

import java.io.*;
import java.util.Scanner;

public class Program {
	public static void main( String[] args ) {
		String filePath = "C:\\Temp\\in.txt";
		try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
			String line = br.readLine();
			while(line != null){
				System.out.println(line);
				line = br.readLine();
			}

		} catch( IOException e ) {
			System.err.println( "Error: " + e.getMessage() );
		}
	}
}
