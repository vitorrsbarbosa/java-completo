package exercicio05;

import exercicio05.entities.Circle;
import exercicio05.entities.Rectangle;
import exercicio05.entities.Shape;
import exercicio05.entities.enums.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
	public static void main( String[] args ) {
		Locale.setDefault( Locale.US );
		List<Shape> shapes = new ArrayList<>( );
		Scanner scanner = new Scanner( System.in );
		System.out.print( "Enter number of shapes to calculate area: " );
		int n = scanner.nextInt( );
		for( int i = 1; i <= n; i++ ) {
			System.out.print( "Shape #" + i + " data: " );
			System.out.print( "Rectangle or Circle (r/c): " );
			char shape = scanner.next( ).charAt( 0 );
			System.out.print( "Color (BLACK/BLUE/RED): " );
			Color color = Color.valueOf( scanner.next( ) );
			if( shape == 'r' ) {
				System.out.print( "Width: " );
				double width = scanner.nextDouble( );
				System.out.print( "Height: " );
				double height = scanner.nextDouble( );
				shapes.add( new Rectangle( color, width, height ) );
			} else if( shape == 'c' ) {
				System.out.print( "Radius: " );
				double radius = scanner.nextDouble( );
				shapes.add( new Circle( color, radius ) );
			}
		}
		System.out.println( );
		System.out.println( "SHAPE AREAS: " );
		for( Shape s : shapes ) {
			System.out.printf( "The area equals to %.2f%n", s.area( ) );
		}
		scanner.close( );
	}
}
