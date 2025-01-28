package modulo16.interfaces.diamondproblem.entities;

public class ConcretePrinter extends Device implements Printer {
	public ConcretePrinter( String serialNumber ) {
		super( serialNumber );
	}

	@Override
	public void processDoc( String doc ) {
		System.out.println( "ConcretePrinter processing: " + doc );
	}

	@Override
	public void print( String doc ) {
		System.out.println( "Printing: " + doc );
	}
}
