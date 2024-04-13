package model;

public class Motor {
	
	private int qtdPist;
	private int potencia;
	
	public Motor() {
		super();
	}
	
	public int getQtdPist() {
		return this.qtdPist;
	}
	
	public final void setQtdPist(int qtdPist) {
		this.qtdPist = qtdPist;
	}
	
	public int getPotencia() {
		return this.potencia;
	}
	
	public final void setPotencia(int potencia) {
		this.potencia = potencia;
	}
}
