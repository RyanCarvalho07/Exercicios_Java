package application;

import java.util.Scanner;

import model.entities.Cliente;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);


		System.out.print("Entre com o nome: ");
		String nome = sc.nextLine();
		System.out.print("Entre com o email: ");
		String email = sc.nextLine();
		System.out.print("Entra com o CPF: ");
		String cpf = sc.nextLine();

		Cliente cliente = new Cliente(nome, email);
		
		if (!(cpf == null || cpf.isEmpty())){
		       cliente = new Cliente(nome, email, cpf);
		}

		System.out.println();
		System.out.println("Cliente");
		System.out.println(cliente);
		cliente.checkCpf();

		sc.close();
	}

}
