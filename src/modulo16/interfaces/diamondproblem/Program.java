package modulo16.interfaces.diamondproblem;

import modulo16.interfaces.diamondproblem.entities.ComboDevice;
import modulo16.interfaces.diamondproblem.entities.ConcretePrinter;
import modulo16.interfaces.diamondproblem.entities.ConcreteScanner;

public class Program {
	public static void main( String[] args ) {
		ConcretePrinter p = new ConcretePrinter("1080");
		p.processDoc( "My letter." );
		p.print( "My letter." );
		System.out.println( "-------" );
		ConcreteScanner s = new ConcreteScanner( "2003" );
		s.processDoc( "My email." );
		System.out.println( "Scan result: " + s.scan() );
		System.out.println( "-------" );
		ComboDevice c = new ComboDevice( "8084" );
		c.processDoc( "File" );
		c.print( "My file" );
		System.out.println( "Scan result: " + c.scan() );
	}
}
