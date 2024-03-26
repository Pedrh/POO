package model;

public class IngressoVip extends Ingresso {
	private String cargo;
	
	public IngressoVip() {
		super();
	}
	
	public String getCargo() {
		return this.cargo;
	}
	
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	
	@Override
	public float valorFinal(float taxaConveniencia) {
		double valorAcrescido = (getValor() + ((taxaConveniencia / 100) * getValor())) + (getValor() * 0.18);
		return (float) valorAcrescido;
	}
}
