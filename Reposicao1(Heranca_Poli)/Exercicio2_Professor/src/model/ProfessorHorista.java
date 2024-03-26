package model;

public class ProfessorHorista extends Professor {
	private int horasAula;
	private double valorHoraAula;
	
	public ProfessorHorista() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getHorasAula() {
		return horasAula;
	}

	public void setHorasAula(int horasAula) {
		this.horasAula = horasAula;
	}

	public double getValorHoraAula() {
		return valorHoraAula;
	}

	public void setValorHoraAula(double valorHoraAula) {
		this.valorHoraAula = valorHoraAula;
	}
	
	@Override
	public void calcSalario() {
		System.out.println("Salario: R$" + horasAula * valorHoraAula);
	}
}
