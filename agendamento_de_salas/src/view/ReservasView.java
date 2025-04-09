package view;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import entities.Reserva;
import entities.SistemaReserva;

public class ReservasView {

	private Scanner sc;
	private SistemaReserva sistemareserva;

	public ReservasView() {
		sistemareserva = new SistemaReserva();
		sc = new Scanner(System.in);
	}

	public void exibirMenu() {

		System.out.println("====== SISTEMAS DE AGENDAMENTO DE SALAS ======");
		while (true) {
			System.out.println("1 - Adicionar Reserva");
			System.out.println("2 - Listar Reservas");
			System.out.println("3 - Sair");
			System.out.print("Escolha uma opção: ");

			if (!sc.hasNextInt()) {
				System.out.println("Opção inválida! Digite um número");
				sc.next();
				continue;
			}
			int opcao = sc.nextInt();
			sc.nextLine();
			System.out.println("====================================================");
			System.out.println();

			switch (opcao) {

			case 1:
				System.out.print("Informe o nome do solicitante: ");
				String nome = sc.nextLine();
				System.out.print("Informe  o número da sala (ex: 101): ");
				int sala = sc.nextInt();
				sc.nextLine();
				System.out.print("Informe a data da reserva (DD/MM/AAAA): ");
				String receberData = sc.nextLine();
				LocalDate data = LocalDate.parse(receberData, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				System.out.print("Informe o horario de início (HH:MM): ");
				LocalTime horaInicio = LocalTime.parse(sc.nextLine());
				System.out.print("Informe o horario de término (HH:MM): ");
				LocalTime horaFim = LocalTime.parse(sc.nextLine());
				Reserva novaReserva = new Reserva(nome, sala, data, horaInicio, horaFim);
				if (sistemareserva.verificarConflitos(novaReserva)) {
					System.out.println();
					System.out.println("ERRO: Horário em conflito com outra reserva existente!");
				} else {
					sistemareserva.addReservas(novaReserva);
					System.out.println();
					System.out.println("Reserva adicionada com sucesso!");
				}
				System.out.println("====================================================");
				System.out.println();
				break;

			case 2:
				System.out.println("=== RESERVAS CADASTRADAS ===");
				sistemareserva.listarReservas();
				System.out.println();
				break;

			case 3:
				System.out.println("Encerrando o sistema. Até Mais!");
				sc.close();
				return;
			default:
				System.out.println("Opção inválida. Tente novamente");
			}

		}
	}
}
