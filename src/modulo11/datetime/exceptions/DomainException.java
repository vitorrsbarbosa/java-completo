package modulo11.datetime.exceptions;

import java.io.Serial;

//	RuntimeException - o compilador não obriga tratamento
//	Exception - o compilador obriga tratamento
public class DomainException extends Exception {
	@Serial
	private static final long serialVersionUID = 1L;

	public DomainException( String msg ) {
		super( msg );
	}
}
