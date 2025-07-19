package model.entities;

public class Cliente {
	
	 private String nome;
	 private String email; 
	 private String cpf;
	 
	 public Cliente() {
	 }

	 
	 public Cliente(String nome, String email) {
		 this.nome = nome; 
		 this.email = email;
	 }
	 
	 public Cliente(String nome, String email, String cpf) {
		 this.nome = nome; 
		 this.email = email;
		 this.cpf = cpf;
	 }
	 

	 
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public void checkCpf() {
		if(getCpf() == null){
			System.out.println("CPF: Não informado");
		}
		else {
			System.out.println("CPF: " + cpf);
		}
	}
	
	public String toString(){
		return "Nome: "
			+ nome 
			+ "\nEmail: "
			+ email;
		
	}



}
