package modulo16.interfaces.defaultmethods.services;

import modulo16.interfaces.defaultmethods.interfaces.InterestService;

import java.security.InvalidParameterException;

public class BrazilInterestService implements InterestService {
	private double interestRate;

	public BrazilInterestService( double interestRate ) {
		this.interestRate = interestRate;
	}

	@Override
	public double getInterestRate( ) {
		return interestRate;
	}
}
