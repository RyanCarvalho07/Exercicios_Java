package entities;

public class JuristicPerson extends Taxpayer {
	
	private Integer EmployeeNumber;
	
	
	public JuristicPerson() {
		super();
	}


	public JuristicPerson(String name, Double annualIncome, Integer employeeNumber) {
		super(name, annualIncome);
	     this.EmployeeNumber = employeeNumber;
	}


	public Integer getEmployeeNumber() {
		return EmployeeNumber;
	}


	public void setEmployeeNumber(Integer employeeNumber) {
		EmployeeNumber = employeeNumber;
	}
    
	 
	@Override
	public double calculateTax() {
		double tax = 0.0;
		
		if(EmployeeNumber > 10 ) {
			tax = annualIncome * 0.14;
		}
		if(EmployeeNumber < 10) {
			tax = annualIncome * 0.16;
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
