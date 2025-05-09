package service;

import model.Carrinho;
import model.Produto;

public class CarrinhoService {

	Carrinho carrinho;

	public CarrinhoService() {
		this.carrinho = new Carrinho();
	}

	public boolean adicionarProduto(String nome, Double preco, Integer quantidade) {
		if (nome == null || nome.isBlank()) {
			System.out.println("Erro: O nome do produto está incorreto.");
			return false;
		}
		if (preco <= 0.0 || preco == null || quantidade <= 0 || quantidade == null) {
			System.out.println("Erro: Preço e quantidade devem ser maior do que zero.");
			return false;
		}
		
		Produto produto = new Produto(nome, preco, quantidade);
		carrinho.adicionarProduto(produto);
		System.out.println("Item adicionado com sucesso!");
		return true;
	}

	public boolean removerProduto(String nome) {
		if (carrinho.estaVazio()) {
			System.out.println("O carrinho está vazio!");
			return false;
		}

		return carrinho.removerProduto(nome);
	}

	public void listarProduto() {
		carrinho.lisatarProduto();
	}

	public double calcularTotal() {
		return carrinho.calcularTotal();
	}

	public void finalizarCompra() {
		System.out.println(carrinho);
		carrinho.limparCarrinho();
	}

}
