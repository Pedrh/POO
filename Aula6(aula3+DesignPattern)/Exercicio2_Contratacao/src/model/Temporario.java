package model;

public class Temporario extends Funcionario {
	
	private int dia;
	private int mes;
	private int ano;
	
	public Temporario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
	
	
	public String toString() {
		return "Funcionario Temporario------------\nDia de inicio=" + dia + ", mes de inicio=" + mes + ", ano de inicio=" + ano  
		+ ", Id=" + getId() + ", Nome=" + getNome() + ", Salario=" + getSalario() + "\n";
	}
}
