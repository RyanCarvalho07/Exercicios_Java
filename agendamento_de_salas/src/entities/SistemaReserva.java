package entities;

import java.util.ArrayList;
import java.util.List;

public class SistemaReserva {

	private List<Reserva> reservas = new ArrayList<>();

	public void addReservas(Reserva r) {
		reservas.add(r);
	}

	public void listarReservas() {
		for (Reserva r : reservas) {
			System.out.println(r);
		}
	}

	public boolean verificarConflitos(Reserva r) {
		boolean temConflito = false;
		for (Reserva list : reservas) {
			if (list.conflitaCom(r)) {
				temConflito = true;
			}
		}
		return temConflito;
	}

}
