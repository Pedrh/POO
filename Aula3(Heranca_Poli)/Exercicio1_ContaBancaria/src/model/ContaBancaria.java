package model;

public class ContaBancaria {
	private String cliente;
	private int num_conta;
	private float saldo;
	
	public ContaBancaria() {
		super();
	}
	
	
	public String getCliente() {
		return this.cliente;
	}
	
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	
	public int getNum_conta() {
		return this.num_conta;
	}
	
	public void setNum_conta(int num_conta) {
		this.num_conta = num_conta;
	}
	
	public float getSaldo() {
		return this.saldo;
	}
	
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	public void sacar(float valorSaque) {
		if(valorSaque > saldo) {
			System.out.println("Não é possível fazer o saque nesse valor");
		}else {
			saldo = saldo - valorSaque;
			System.out.println("Seu novo saldo é de: " + saldo);
		}
	}
	
	public void depositar(float valorDeposito) {
		saldo = saldo + valorDeposito;
		System.out.println("Seu novo saldo é de: " + saldo);
	}
	
	
	
}
