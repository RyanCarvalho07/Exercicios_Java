package service;

import java.time.LocalDate;

import model.Contract;
import model.Installment;

public class ContractService {

	private OnlinePaymentService onlinePayment;

	public ContractService(OnlinePaymentService onlinePayment) {
		this.onlinePayment = onlinePayment;
	}

	public void processContract(Contract contract, Integer months) {
		double basicPlot = contract.getTotalValue() / months;

		for (int i = 1; i <= months; i++) {
			LocalDate dueDate = contract.getDate().plusMonths(i);
			double interest = onlinePayment.interest(basicPlot, i);
			double paymentFee = onlinePayment.paymentFee(basicPlot + interest);
			double amount = basicPlot + interest + paymentFee;

			contract.getInstallments().add(new Installment(dueDate, amount));

		}

	}

}
