package exercicio10.files;

import java.io.File;
import java.util.Scanner;

public class ManipulateFiles {
	public static void readListOfFolders( ) {
		Scanner sc = new Scanner( System.in );
		System.out.print( "Enter a folder path: " );
		String strPath = sc.nextLine( );
		File path = new File( strPath );

		File[] folders = path.listFiles( File::isDirectory );
		System.out.println( "FOLDERS:" );
		assert folders != null;
		for( File folder : folders ) {
			System.out.println( folder );
		}
		sc.close( );
	}
}
