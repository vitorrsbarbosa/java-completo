package exercicio07;

import exercicio07.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
	public static void main( String[] args ) {
		Scanner scanner = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			System.out.print( "Room number: " );
			int number = scanner.nextInt( );
			System.out.print( "Date to check-in: " );
			Date checkin = sdf.parse( scanner.next( ) );
			System.out.print( "Date to check-out: " );
			Date checkout = sdf.parse( scanner.next( ) );

			Reservation reservation = new Reservation( number, checkin, checkout );
			System.out.println( "Reservation: " + reservation );

			System.out.println( );
			System.out.println( "Enter data to update reservation: " );
			System.out.print( "Date to check-in: " );
			checkin = sdf.parse( scanner.next( ) );
			System.out.print( "Date to check-out: " );
			checkout = sdf.parse( scanner.next( ) );

			reservation.updateDates( checkin, checkout );
			System.out.println( "Reservation: " + reservation );
		} catch( ParseException e ) {
			System.out.println( "Invalid date format" );
		} catch( IllegalArgumentException e ) {
			System.out.println( "Error in reservation: " + e.getMessage( ) );
		}
		scanner.close();
	}
}
