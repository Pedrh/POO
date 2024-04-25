package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class ContaBancaria {
	private String cliente;
	private int numConta;
	private float saldo;
	
	public ContaBancaria() {
		super();
	}

	
	public void sacar(float valor) throws ArithmeticException {
		if(valor > saldo) {
			throw new ArithmeticException("O valor não pode ser maior que o saldo que é: R$" + saldo);
		}
		saldo -= valor;
	}
	
	public void depositar(float valor) {
		saldo += valor;
	}
	
	
}
