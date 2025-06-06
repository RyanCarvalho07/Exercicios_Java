package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.JuristicPerson;
import entities.Physicsperson;
import entities.Taxpayer;

public class program {

	public static void main(String[] args) {
       
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Taxpayer> lista = new ArrayList<>();
		
		
		System.out.print("Enter the number of tax payers: ");
		int taxPay = sc.nextInt();
		
		for(int i=1; i<=taxPay; i++) {
			System.out.println("Tax payer #" + i + " data: ");
			System.out.print("Individual or company (i/c)? ");
			char iorC = sc.next().charAt(0);
			
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Anual income: ");
			double annualIncome = sc.nextDouble();
			if(iorC == 'i') {
				System.out.print("Health expenditures: ");
				double value = sc.nextDouble();
				lista.add(new Physicsperson(name, annualIncome, value));
			}
			if(iorC == 'c') {
				System.out.print("Number of employees: ");
				int employees = sc.nextInt();
				lista.add(new JuristicPerson(name, annualIncome,employees));
			}
		}
		
		
	     System.out.println();
	     System.out.println("TAXES PAID");
	      double totalTax = 0.0;
	      for(Taxpayer tax : lista) {
	    	  double tottax = tax.calculateTax();
	    	  totalTax += tottax;
	    	  System.out.println(tax);
	      }
	      
	      System.out.println();
	      System.out.println("TOTAL TAXES: " + totalTax);
		
		
		
		
		
		sc.close();

	}

}
