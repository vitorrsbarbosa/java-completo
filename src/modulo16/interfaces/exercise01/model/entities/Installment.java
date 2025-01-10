package modulo16.interfaces.exercise01.model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Installment {
	private LocalDate dueDate;
	private Double amount;

	public Installment( LocalDate dueDate, Double amount ) {
		this.dueDate = dueDate;
		this.amount = amount;
	}

	public LocalDate getDueDate( ) {
		return dueDate;
	}

	public void setDueDate( LocalDate dueDate ) {
		this.dueDate = dueDate;
	}

	public Double getAmount( ) {
		return amount;
	}

	public void setAmount( Double amount ) {
		this.amount = amount;
	}

	@Override
	public String toString( ) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern( "dd/MM/yyyy", Locale.US );
		return dueDate.format( dtf ) + " - " + String.format( "%.2f", amount );
	}
}
