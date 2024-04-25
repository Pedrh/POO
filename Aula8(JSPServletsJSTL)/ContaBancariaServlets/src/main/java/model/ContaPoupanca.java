package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContaPoupanca extends ContaBancaria {
	private int diaRendimento;

	public ContaPoupanca() {
		super();
	}
	
	public void calcularNovoSaldo(int taxaRendimento) {
		setSaldo(getSaldo()+ (getSaldo() * (taxaRendimento / 100f)));
	}
	
	@Override
	public String toString() {
		return "Nome cliente: " + getCliente() + ", numero da conta: " + getNumConta() + ", rendimento diario: " + diaRendimento +
				"%, saldo: " + getSaldo();
	}
}
