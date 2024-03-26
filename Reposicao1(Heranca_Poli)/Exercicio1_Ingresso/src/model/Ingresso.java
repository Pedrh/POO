package model;

public class Ingresso {
	private String codigo;
	private float valor;
	
	public Ingresso() {
		super();
	}
	
	public String getCodigo() {
		return this.codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
	public float getValor() {
		return this.valor;
	}
	
	public void setValor(float valor) {
		this.valor = valor;
	}
	
	
	public float valorFinal(float taxaConveniencia) {
		float valorAcrescido = valor + ( valor * (taxaConveniencia / 100));
		return valorAcrescido;
	}
}
