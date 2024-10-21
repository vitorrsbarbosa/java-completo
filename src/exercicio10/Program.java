package exercicio10;

import exercicio10.files.ManipulateFiles;
import exercicio10.read.ReadMethods;
import exercicio10.write.WriteMethods;

public class Program {
	public static void main( String[] args ) {
		ReadMethods.readFile01( );
		ReadMethods.readFile02( );
		ReadMethods.readFile03( );

		WriteMethods.writeFile( );
		WriteMethods.writeNewFile( );

		ManipulateFiles.readListOfFolders( );
	}
}
