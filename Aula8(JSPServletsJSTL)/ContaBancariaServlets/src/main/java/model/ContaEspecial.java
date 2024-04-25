package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContaEspecial extends ContaBancaria {
	private float limite;

	public ContaEspecial() {
		super();
	}
	
	@Override
	public void sacar(float valor) throws ArithmeticException {
		if(valor > getSaldo() + limite) {
			throw new ArithmeticException("O valor não pode ser maior que o limite + saldo.\nLimite atual: R$" + limite + "\nSaldo atual: R$" + getSaldo());
		}
		
		setSaldo(getSaldo() - valor);
	}
	
	@Override
	public String toString() {
		return "Nome cliente: " + getCliente() + ", numero da conta: " + getNumConta() + ", limite: " + limite +
				", saldo: " + getSaldo();
	}
}
