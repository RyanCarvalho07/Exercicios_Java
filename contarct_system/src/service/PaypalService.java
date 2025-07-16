package service;

public class PaypalService implements OnlinePaymentService {
	
	
	public static final double SIMPLE_INTEREST = 0.01;
	public static final double TAX = 0.02;
	  

	@Override
	public Double interest(Double amount, Integer months) {
		return  amount * SIMPLE_INTEREST * months;
	}

	@Override
	public Double paymentFee(Double amount) {
		  return amount * TAX ;
	}

}
