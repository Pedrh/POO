package model;

public class TempoIntegral extends Funcionario {
	private int bancoHoras;

	public TempoIntegral() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getBancoHoras() {
		return bancoHoras;
	}

	public void setBancoHoras(int bancoHoras) {
		this.bancoHoras = bancoHoras;
	}

	@Override
	public String toString() {
		return "Funcionario Tempo Integral------------\nbancoHoras=" + bancoHoras + ", Id=" + getId() + ", Nome=" + getNome()
				+ ", Salario=" + getSalario() + "\n";
	}
	
	
}
