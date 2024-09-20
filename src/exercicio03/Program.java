package exercicio03;

import exercicio03.entities.Account;
import exercicio03.entities.BusinessAccount;
import exercicio03.entities.SavingsAccount;

import java.util.ArrayList;
import java.util.List;

public class Program {
	public static void main( String[] args ) {
//		Account acc = new Account(1001,"Alex",0.0);
//		BusinessAccount bacc1 = new BusinessAccount( 1002,"Maria",0.0,500.0 );
//		SavingsAccount sacc1 = new SavingsAccount( 1003,"Joana",10.0,100.0 );
//		UPCASTING
//		Account bacc2 = new BusinessAccount(1004,"Bob",0.0,250.0);
//		Account sacc2 = new SavingsAccount( 1005,"Vitor",250.0,1000.0 );
//		DOWNCASTING
//		BusinessAccount bacc3 = (BusinessAccount) bacc1;
//		FAILED DOWNCASTING causing ClassCastException
//		BusinessAccount bacc4 = (BusinessAccount) sacc2;
//		if ( sacc1 instanceof BusinessAccount) {
//			BusinessAccount bacc5 = (BusinessAccount) sacc1;
//		}
		List<Account> list = new ArrayList<>( );
		list.add( new SavingsAccount( 1001, "Alex", 500.00, 0.01 ) );
		list.add( new BusinessAccount( 1002, "Maria", 200.00, 400.0 ) );
		list.add( new SavingsAccount( 1003, "Bob", 300.00, 0.01 ) );
		list.add( new BusinessAccount( 1004, "Anna", 1000.00, 500.0 ) );
		for( Account account : list ) {
			System.out.printf( "The balance of account %d is: %.2f%n", account.getNumber( ), account.getBalance( ) );
		}
		double sum = 0.0;
		for( Account account : list ) {
			sum += account.getBalance( );
		}
		System.out.printf( "Total balance of all accounts is: %.2f%n", sum );
		for( Account account : list ) {
			account.deposit( 10.0 );
			System.out.printf( "Updated balance of account %d is: %.2f%n", account.getNumber( ), account.getBalance( ) );
		}
	}
}
