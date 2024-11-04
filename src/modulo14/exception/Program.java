package modulo14.exception;

import modulo14.exception.entities.Account;
import modulo14.exception.exceptions.BankMovmentException;

import java.util.Locale;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println( "Enter account data" );
			System.out.print( "Number: " );
			int number = sc.nextInt( );
			System.out.print( "Holder: " );
//			Read {ENTER} buffer
			sc.nextLine();
			String holder = sc.nextLine( );
			System.out.print( "Initial balance: " );
			Double initialBalance = sc.nextDouble( );
			System.out.print( "Withdraw limit: " );
			Double withdrawLimit = sc.nextDouble( );

			Account account = new Account( number, holder, initialBalance, withdrawLimit );
			System.out.print( "Enter amount to withdraw: " );
			account.withdraw( sc.nextDouble( ) );
			System.out.println( "New balance: " + account.getBalance( ) );
		} catch( BankMovmentException e ) {
			System.out.println( "Withdraw error: " + e.getMessage( ) );
		}
		sc.close();
	}
}
