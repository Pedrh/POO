package model;

public class Conta {

	private int agencia;
	private int codigo;
	private int saldo;
	private float limite;
	
	public Conta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public float getLimite() {
		return limite;
	}

	public void setLimite(float limite) {
		this.limite = limite;
	}
	
	
	public void depositar(float valor) {
		saldo += valor;
		System.out.println("Deposito concluido. Saldo final: R$" + saldo);
	}
	
	public void sacar(float valor) throws ArithmeticException{
		if(valor > saldo + limite) {
			throw new ArithmeticException("Valor superior ao saldo disponível\nLimite total para saque: R$" + limite);
		}
		
		saldo -= valor;
		System.out.println("Saque concluido. Saldo final: R$" + saldo);
	}
	
}
