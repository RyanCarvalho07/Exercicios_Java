package application;

import java.util.Locale;
import java.util.Scanner;
import service.CarrinhoService;

public class Main {
	public static void main(String[] args) throws Exception {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
	    CarrinhoService  carrinho = new CarrinhoService();
	

		System.out.println("===== MENU DE COMPRAS =====");
		while (true) {
			System.out.println("[1] Adicionar produto ao Carrinho");
			System.out.println("[2] Listar produtos no Carrinho");
			System.out.println("[3] Remover produtos do carrinho ");
			System.out.println("[4] Calcular Total");
			System.out.println("[5] Finalizar Compra");
			System.out.println("[6] Sair");
			System.out.print("Escolha uma opção: ");
			if (!sc.hasNextInt()) {
				System.out.println("Opção invalída! Digite um número.");
				sc.next();
				continue;
			}
			int opcao = sc.nextInt();
			sc.nextLine();

			switch (opcao) {

			case 1:
				System.out.println();
				System.out.println("----------------------------------------");
				System.out.print("Digite o nome do produto: ");
				String nome = sc.nextLine();
				System.out.print("Digite o preço do produto: ");
				double preco = sc.nextDouble();
				System.out.print("Digite a Quantidade: ");
				int quantidade = sc.nextInt();
				sc.nextLine();

				carrinho.adicionarProduto(nome, preco, quantidade);
				System.out.println("----------------------------------------");
				System.out.println();
				break;

			case 2:
				System.out.println();
				System.out.println("----------------------------------------");
				carrinho.listarProduto();
				System.out.println("----------------------------------------");
				System.out.println();
				break;

			case 3:
				System.out.println();
				System.out.println("----------------------------------------");
				System.out.println("Digite o nome do produto que deseja remover: ");
				String nomeExcluir = sc.nextLine();
				boolean removido = carrinho.removerProduto(nomeExcluir);

				if (removido) {
					System.out.println("Item Removido com sucesso!");
				} else {
					System.out.println("Produto não encotrado no carrinho.");
				}
				System.out.println("----------------------------------------");
				System.out.println();
				break;

			case 4:
				System.out.println();
				System.out.println("----------------------------------------");
				double total = carrinho.calcularTotal();
				System.out.println("R$ "+ total);
				System.out.println("----------------------------------------");
				System.out.println();
				break;

			case 5:
				carrinho.finalizarCompra();
				sc.close();
				return;

			case 6:
				System.out.println();
				System.out.println("----------------------------------------");
				System.out.println("Finalizando programa...");
				sc.close();
				return;

			}
		}
	}

}
