package modulo16.interfaces.exercise01.model.services;

public class PaypalService implements OnlinePaymentService {
	private static final double MONTHLY_INTEREST = 0.01;
	private static final double FEE = 0.02;
	@Override
	public double paymentFee( double amount ) {
		return amount * FEE;
	}

	@Override
	public double interest( double amount, int months ) {
		return amount * months * MONTHLY_INTEREST;
	}
}
