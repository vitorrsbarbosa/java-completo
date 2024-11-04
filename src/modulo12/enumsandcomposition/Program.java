package modulo12.enumsandcomposition;

import modulo12.enumsandcomposition.entities.Department;
import modulo12.enumsandcomposition.entities.HourContract;
import modulo12.enumsandcomposition.entities.Worker;
import modulo12.enumsandcomposition.entities.enums.WorkerLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
	public static void main( String[] args ) throws ParseException {
		Locale.setDefault( Locale.US );
		SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy" );
		Scanner sc = new Scanner( System.in );
		System.out.print( "Enter department's name: " );
		String departmentName = sc.nextLine( );
		System.out.println( "Enter worker's data: " );
		System.out.print( "Name: " );
		String workerName = sc.nextLine( );
		System.out.print( "Level: " );
		String workerLevel = sc.nextLine( );
		System.out.print( "Base Salary: " );
		Double workerBaseSalary = sc.nextDouble( );
		Worker worker = new Worker( workerName, WorkerLevel.valueOf( workerLevel ), workerBaseSalary, new Department( departmentName ) );
		System.out.print( "How many contracts to this worker? " );
		int contractsNumber = sc.nextInt( );
		for( int i = 0; i < contractsNumber; i++ ) {
			System.out.println( "Enter contract #" + ( i + 1 ) + "'s data: " );
			System.out.print( "Date (dd/MM/yyyy): " );
			Date contractDate = sdf.parse( sc.next( ) );
			System.out.print( "Value per hour: " );
			Double contractValuePerHour = sc.nextDouble( );
			System.out.print( "Duration (hours) : " );
			Integer contractDuration = sc.nextInt( );
			HourContract contract = new HourContract( contractDate, contractValuePerHour, contractDuration );
			worker.addContract( contract );
		}
		System.out.println( );
		System.out.print( "Enter month and year to calculate income (MM/YYYY): " );
		String monthAndYear = sc.next( );
		int month = Integer.parseInt( monthAndYear.substring( 0, 2 ) );
		int year = Integer.parseInt( monthAndYear.substring( 3 ) );
		System.out.println( "Name: " + worker.getName( ) );
		System.out.println( "Department: " + worker.getDepartment( ).getName( ) );
		System.out.println( "Level: " + worker.getLevel( ) );
		System.out.println( "Income for " + monthAndYear + ": " + String.format( "%.2f", worker.income( month, year ) ) );
		sc.close( );
	}
}
