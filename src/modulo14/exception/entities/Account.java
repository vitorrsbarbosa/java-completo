package modulo14.exception.entities;

import modulo14.exception.exceptions.BankMovmentException;

public class Account {
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	public Account( ) {}
	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber( ) {
		return number;
	}

	public void setNumber( Integer number ) {
		this.number = number;
	}

	public String getHolder( ) {
		return holder;
	}

	public void setHolder( String holder ) {
		this.holder = holder;
	}

	public Double getBalance( ) {
		return balance;
	}

	public Double getWithdrawLimit( ) {
		return withdrawLimit;
	}

	public void setWithdrawLimit( Double withdrawLimit ) {
		this.withdrawLimit = withdrawLimit;
	}

	public void deposit( Double amount ) {
		this.balance += amount;
	}
	public void withdraw( Double amount ) throws BankMovmentException {
		if ( amount > this.balance ) {
			throw new BankMovmentException( "Not enough balance, you can withdraw at most " + this.getBalance() );
		} else if ( amount > this.withdrawLimit ) {
			throw new BankMovmentException( "The amount exceeds withdraw limit." );
		}
		this.balance -= amount;
	}
}
