package exercicio10.example;

import exercicio10.example.entities.FileManipulator;
import exercicio10.example.entities.Product;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
	public static void main( String[] args ) {
		Locale.setDefault( Locale.US );
		Scanner sc = new Scanner( System.in );
		FileManipulator fm = new FileManipulator( );
		System.out.print( "Enter the file path to work on: " );
		String pathToFile = sc.nextLine( );
		String file = fm.createFile( pathToFile );
		List<Product> productList = fm.collectFileInfoWithinGivenPathToProduct( file );
		fm.createSummaryFile( file, productList );

		sc.close( );
	}
}
