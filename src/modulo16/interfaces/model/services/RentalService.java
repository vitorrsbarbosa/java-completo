package modulo16.interfaces.model.services;

import modulo16.interfaces.model.entities.CarRental;
import modulo16.interfaces.model.entities.Invoice;

import java.time.Duration;

public class RentalService {
	private Double pricePerHour;
	private Double pricePerDay;
	private BrazilTaxService taxService;

	public RentalService( ) {
	}

	public RentalService( Double pricePerHour, Double pricePerDay, BrazilTaxService taxService ) {
		this.pricePerHour = pricePerHour;
		this.pricePerDay = pricePerDay;
		this.taxService = taxService;
	}

	public Double getPricePerHour( ) {
		return pricePerHour;
	}

	public void setPricePerHour( Double pricePerHour ) {
		this.pricePerHour = pricePerHour;
	}

	public Double getPricePerDay( ) {
		return pricePerDay;
	}

	public void setPricePerDay( Double pricePerDay ) {
		this.pricePerDay = pricePerDay;
	}

	public BrazilTaxService getTaxService( ) {
		return taxService;
	}

	public void setTaxService( BrazilTaxService taxService ) {
		this.taxService = taxService;
	}

	public void processInvoice( CarRental carRental ) {
		long minutes = Duration.between( carRental.getStart( ), carRental.getFinish( ) ).toMinutes( );
		long hours = minutes / 60;

		double basicPayment;
		if( hours <= 12 ) {
			basicPayment = pricePerHour * Math.ceil( hours );
		} else {
			basicPayment = pricePerDay * Math.ceil( hours / 24.0 );
		}

		double tax = taxService.tax( basicPayment );
		carRental.setInvoice( new Invoice( basicPayment,tax ) );
	}
}

