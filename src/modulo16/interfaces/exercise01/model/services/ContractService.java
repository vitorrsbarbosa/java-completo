package modulo16.interfaces.exercise01.model.services;

import modulo16.interfaces.exercise01.model.entities.Contract;
import modulo16.interfaces.exercise01.model.entities.Installment;

import java.time.LocalDate;

public class ContractService {
	private OnlinePaymentService service;

	public ContractService( OnlinePaymentService service ) {
		this.service = service;
	}

	public void processContract( Contract contract, int months ) {
		double baseValue = contract.getTotalValue( ) / months;

		// para cada mês de parcela realizar os seguintes cálculos
		for( int i = 1; i <= months; i++ ) {
			LocalDate dueDate = contract.getDate( ).plusMonths( i );
			// Descobre o juro mensal e, após isso, adiciona ao valor base da parcela.
			double interest = service.interest( baseValue, i );
			// Define a taxa de pagamento em cima do valor com juros.
			double fee = service.paymentFee( baseValue + interest );
			contract.getInstallment( ).add( new Installment( dueDate,baseValue + interest + fee ) );
		}
	}
}
