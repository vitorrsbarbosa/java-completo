package modulo16.interfaces;

import modulo16.interfaces.model.entities.CarRental;
import modulo16.interfaces.model.entities.Vehicle;
import modulo16.interfaces.model.services.BrazilTaxService;
import modulo16.interfaces.model.services.RentalService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main( String[] args ) {
        Locale.setDefault( Locale.US );
        Scanner sc = new Scanner( System.in );

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern( "dd/MM/yyyy HH:mm" );
        System.out.println( "Enter rental data" );
        System.out.print( "Car model: " );
        String carModel = sc.nextLine( );
        System.out.print( "Withdraw: (dd/MM/yyyy hh:mm) " );
        LocalDateTime start = LocalDateTime.parse( sc.nextLine( ), dtf );
        System.out.print( "Return: (dd/MM/yyyy hh:mm)  " );
        LocalDateTime end = LocalDateTime.parse( sc.nextLine( ), dtf );

        CarRental cr = new CarRental( new Vehicle( carModel ), start, end );

        System.out.print( "Enter price per hour: " );
        double pricePerHour = sc.nextDouble( );
        System.out.print( "Enter price per day: " );
        double pricePerDay = sc.nextDouble( );

        RentalService rentalService = new RentalService( pricePerHour, pricePerDay, new BrazilTaxService( ) );
        rentalService.processInvoice( cr );

        System.out.println( "BILL" );
        System.out.println( "Basic payment: " + cr.getInvoice( ).getBasicPayment( ) );
        System.out.println( "Tax: " + cr.getInvoice( ).getTax( ) );
        System.out.println( "Total payment: " + cr.getInvoice( ).getTotalPayment( ) );


        sc.close( );
    }
}
