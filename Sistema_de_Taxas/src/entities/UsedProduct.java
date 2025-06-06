package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UsedProduct extends Product{
	
	public static final DateTimeFormatter sdft = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private LocalDate manufactureDate;
	
	public UsedProduct() {
	}

	public UsedProduct(String name, Double price, LocalDate manufactureDate) {
		super(name, price);
		this.manufactureDate = manufactureDate;
	}
	
	
	@Override
	public String priceTag() {
		return getName()
			+ " $ "
			+ price
			+ " (Manufacture date: "
			+ sdft.format(manufactureDate)
		    + ")";
	}


}
