package modulo15.file.write;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteMethods {
	public static void writeNewFile( ) {
		String[] lines = new String[] { "Good Morning", "Good Afternoon", "Good Evening" };
		String filePath = "C:\\Temp\\out.txt";
		try( BufferedWriter bw = new BufferedWriter( new FileWriter( filePath, true ) ) ) {
			for( String line : lines ) {
				bw.write( line );
				bw.newLine( );
			}
		} catch( IOException e ) {
			e.printStackTrace( );
		}
	}

	public static void writeFile( ) {
		String[] lines = new String[] { "Good Morning", "Good Afternoon", "Good Evening" };
		String filePath = "C:\\Temp\\out.txt";
		try( BufferedWriter bw = new BufferedWriter( new FileWriter( filePath ) ) ) {
			for( String line : lines ) {
				bw.write( line );
				bw.newLine( );
			}
		} catch( IOException e ) {
			e.printStackTrace( );
		}
	}
}
