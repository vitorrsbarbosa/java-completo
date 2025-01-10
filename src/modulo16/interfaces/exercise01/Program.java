package modulo16.interfaces.exercise01;

import modulo16.interfaces.exercise01.model.entities.Contract;
import modulo16.interfaces.exercise01.model.entities.Installment;
import modulo16.interfaces.exercise01.model.services.ContractService;
import modulo16.interfaces.exercise01.model.services.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
	public static void main( String[] args ) {
		/*
		 * Entre os dados do contrato:
		 * Numero: 8028
		 * Data (dd/MM/yyyy): 25/06/2018
		 * Valor do contrato: 600.00
		 * Entre com o numero de parcelas: 3
		 * Parcelas:
		 * 25/07/2018 - 206.04
		 * 25/08/2018 - 208.08
		 * 25/09/2018 - 210.12
		 */
		Locale.setDefault( Locale.US );
		Scanner sc = new Scanner( System.in );
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern( "dd/MM/yyyy", Locale.US );

		System.out.println( "Enter contract data" );
		System.out.print( "Contract number: " );
		int contractNumber = sc.nextInt( );
		System.out.print( "Date (dd/MM/yyyy): " );
		LocalDate date = LocalDate.parse( sc.next( ), dtf );
		System.out.print( "Contract value: " );
		double value = sc.nextDouble( );
		System.out.print( "Insert installments number: " );
		int installmentsNumber = sc.nextInt( );

		Contract contract = new Contract( contractNumber, date, value );
		ContractService service = new ContractService( new PaypalService( ) );
		service.processContract( contract, installmentsNumber );

		System.out.println( "===============================" );
		System.out.println( "Installments:" );
		for( Installment i : contract.getInstallment( ) ) {
			System.out.println( i );
		}
		sc.close( );
	}
}
