package exercicio07.exceptions;

//	RuntimeException - o compilador não obriga tratamento
//	Exception - o compilador obriga tratamento
public class DomainException extends Exception {
	private static final long serialVersionUID = 1L;

	public DomainException( String msg ) {
		super( msg );
	}
}
