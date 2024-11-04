package modulo15.file.example.entities;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManipulator {
	public String createFile( String pathToFile ) {
		String[] lines = new String[] { "TV LED,1290.99,1", "Video Game Chair,350.50,3", "Iphone X,900.00,2", "Samsung Galaxy 9,850.00,2" };
		String filePath = pathToFile + "/file.csv";
		try( BufferedWriter bw = new BufferedWriter( new FileWriter( filePath ) ) ) {
			for( String line : lines ) {
				bw.write( line );
				bw.newLine( );
			}
			return filePath;
		} catch( IOException e ) {
			System.err.println( "Error creating data file: " + e.getMessage( ) );
		}
		return filePath;
	}

	private String createOutputFolder( String pathToFile ) {
		File sourceFile = new File( pathToFile );
		String sourceFolder = sourceFile.getParent( );
		boolean success = new File( sourceFolder + "/out" ).mkdir( );
		assert success;
		return sourceFolder + "/out";
	}

	public List<Product> collectFileInfoWithinGivenPathToProduct( String pathToFile ) {
		List<Product> products = new ArrayList<>( );
		try( BufferedReader br = new BufferedReader( new FileReader( pathToFile ) ) ) {
			String line = br.readLine( );
			while( line != null ) {
				String[] filds = line.split( "," );

				String name = filds[ 0 ];
				double price = Double.parseDouble( filds[ 1 ] );
				int quantity = Integer.parseInt( filds[ 2 ] );
				products.add( new Product( name, price, quantity ) );

				line = br.readLine( );
			}
			return products;

		} catch( IOException e ) {
			System.err.println( "Error collecting data from file: " + e.getMessage( ) );
		}
		return products;
	}

	public void createSummaryFile( String pathToFile, List<Product> products ) {
		String outputFilePath = createOutputFolder( pathToFile );
		outputFilePath += "/summary.csv";
		try( BufferedWriter bw = new BufferedWriter( new FileWriter( outputFilePath ) ) ) {
			for( Product product : products ) {
				bw.write( product.getName( ) + "," + String.format( "%.2f", product.totalPrice( ) ) );
				bw.newLine( );
			}
		} catch( IOException e ) {
			System.err.println( "Error creating summary file: " + e.getMessage( ) );
		}
	}
}
