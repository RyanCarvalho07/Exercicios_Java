package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Carrinho {

	Produto produto;
	List<Produto> itens = new ArrayList<>();
	Scanner sc = new Scanner(System.in);

	public Carrinho() {
	};

	public void adicionarProduto(Produto produto) {
		itens.add(produto);
	}

	public boolean removerProduto(String nomeExcluir) {
		Iterator<Produto> iterator = itens.iterator();
		while (iterator.hasNext()) {
			Produto p = iterator.next();
			if (p.getNome().equalsIgnoreCase(nomeExcluir)) {
				iterator.remove();
				return true;
			}
		}
		return false;
	}

	public void lisatarProduto() {
		if (itens.isEmpty()) {
             System.out.println("Carrinho está Vazio!");
		} else {
			for (Produto p : itens) {
				System.out.println(p);
			}
		}
	}

	public double calcularTotal() {
		double total = 0;
		for (Produto p : itens) {
			total += p.calcularSubtotal();
		}
		return total;
	}

	public boolean estaVazio() {
		return itens.isEmpty();

	}

	public void limparCarrinho() {
		itens.clear();
	}

	@Override
	public final String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n-------------------------------- \n");
		sb.append("Compra finalizada! \n");
		sb.append("Total pago: R$ ").append(String.format("%.2f", calcularTotal())).append("\n");
		sb.append("Obrigado pela prefêrencia!");
		return sb.toString();
	}

}
