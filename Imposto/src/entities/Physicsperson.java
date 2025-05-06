package entities;

public class Physicsperson extends Taxpayer {

	private Double HealthExpenses;

	public Physicsperson() {
		super();
	}

	public Physicsperson(String name, Double annualIncome, Double healthExpenses) {
		super(name, annualIncome);
		this.HealthExpenses = healthExpenses;
	}

	public Double getHealthExpenses() {
		return HealthExpenses;
	}

	public void setHealthExpenses(Double healthExpenses) {
		HealthExpenses = healthExpenses;
	}

	@Override
	public double calculateTax() {
		double tax = 0.0;
		if (annualIncome < 20000.0) {
			tax = annualIncome * 0.15;
		}
		if (annualIncome >= 20000.0) {
			tax = annualIncome * 0.25;
		}
		if (HealthExpenses > 0.0) {
			tax -= HealthExpenses * 0.5;
		}
		if(tax < 0.0) {
			tax = 0.0;
		}
		
		return tax;

	}
	

	public String toString() {
		return getName() 
			+ ": $ "
			+ String.format("%.2f", calculateTax());
	}

}
