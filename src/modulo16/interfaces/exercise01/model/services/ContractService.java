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
			// Descobre o juro mensal e após isso incrementa ao valor da parcela
			// Adiciona taxa de pagamento em cima do valor com juros
			LocalDate dueDate = contract.getDate( ).plusMonths( i );
			double interest = service.interest( baseValue, i );
			baseValue = + interest;
			double fee = service.paymentFee( baseValue );
			baseValue = + fee;
			contract.getInstallment( ).add( new Installment( dueDate,baseValue ) );
		}
	}
}
