package modulo16.interfaces.exercise01.model.services;

public interface OnlinePaymentService {
	double paymentFee(double amount);
	double interest(double amount, int months);
}
