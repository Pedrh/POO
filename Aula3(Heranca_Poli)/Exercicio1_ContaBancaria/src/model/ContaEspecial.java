package model;

public class ContaEspecial extends ContaBancaria{
	private float limite;
	
	public ContaEspecial() {
		super();
	}
	
	public float getLimite() {
		return this.limite;
	}
	
	public void setLimite( float limite) {
		this.limite = limite;
	}
	
	
	@Override
	public void sacar(float valorSaque) {
		if(valorSaque > limite + getSaldo()) {
			System.out.println("Não é possível fazer o saque nesse valor");
		}else {
			setSaldo(getSaldo() - valorSaque);
			System.out.println("Seu novo saldo da Conta Especial é de: " + getSaldo());
		}
	}
}
