package entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Reserva {

	private String nome;
	private Integer sala;
	private LocalDate data;
	private LocalTime horaInicio;
	private LocalTime horaFim;

	public static DateTimeFormatter ftmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public Reserva() {
	}

	public Reserva(String nome, Integer sala, LocalDate data, LocalTime horaInicio, LocalTime horaFim) {
		this.nome = nome;
		this.sala = sala;
		this.data = data;
		this.horaInicio = horaInicio;
		this.horaFim = horaFim;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getSala() {
		return sala;
	}

	public void setSala(Integer sala) {
		this.sala = sala;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public LocalTime getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(LocalTime horaFim) {
		this.horaFim = horaFim;
	}

	public boolean conflitaCom(Reserva outro) {
		boolean resultadoDoConflito = false;
		if (this.data.equals(outro.data) && this.sala.equals(outro.sala)) {
			if (this.horaInicio.isBefore(outro.horaFim) && this.horaFim.isAfter(outro.horaInicio)) {
				resultadoDoConflito = true;
			}
		}
		return resultadoDoConflito;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Solicitante: " + nome + "\n");
		sb.append("Sala: " + sala + "\n");
		sb.append("Data: " + ftmt.format(data) + "\n");
		sb.append("Horário: " + horaInicio);
		sb.append(" Até " + horaFim);

		return sb.toString();
	}

};