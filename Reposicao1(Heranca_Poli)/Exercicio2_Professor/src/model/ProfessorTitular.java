package model;

public class ProfessorTitular extends Professor {
	private int anosInstituicao;
	private double salario;
	
	public ProfessorTitular() {
		super();
	}
	
	public int getAnosinstituicao() {
		return this.anosInstituicao;
	}
	
	public void setAnosInstituicao(int anosInstituicao) {
		this.anosInstituicao = anosInstituicao;
	}
	
	public double getSalario() {
		return this.salario;
	}
	
	public void setSalario(double salario) {
		double incremento = anosInstituicao * 0.05;
		this.salario = salario + (salario * incremento);
	}
	
	
}
