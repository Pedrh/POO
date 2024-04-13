package model;

public class TempoParcial extends Funcionario {
	private int horaEntrada;
	private int horaSaida;
	
	public TempoParcial() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(int horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public int getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(int horaSaida) {
		this.horaSaida = horaSaida;
	}
	
	
	@Override
	public String toString() {
		return "Funcionario Tempo Parcial------------\nHora de entrada=" + horaEntrada + ", Hora de saida=" + horaSaida + ", Id=" + getId() + ", Nome=" + getNome()
				+ ", Salario=" + getSalario() + "\n";
	}
}
