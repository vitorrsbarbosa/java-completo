package modulo14.exception.exceptions;

import java.io.Serial;

public class BankMovmentException extends Exception {
	@Serial
	private static final long serialVersionUID = 1L;
	public BankMovmentException(String msg) {
		super(msg);
	}
}
