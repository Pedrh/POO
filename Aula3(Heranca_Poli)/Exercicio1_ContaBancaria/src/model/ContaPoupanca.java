package model;

public class ContaPoupanca extends ContaBancaria {
	private int diaRendimento;
	
	public ContaPoupanca() {
		super();
	}
	
	public int getDiaRendimento() {
		return this.diaRendimento;
	}
	
	public void setDiaRendimento(int diaRendimento) {
		this.diaRendimento = diaRendimento;
	}
	
	public void calcularNovoSaldo() {
		setSaldo(getSaldo() * diaRendimento);	
	}
	
}
