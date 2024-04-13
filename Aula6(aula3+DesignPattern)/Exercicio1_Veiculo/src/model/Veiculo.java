package model;

public abstract class Veiculo {
	
	private String placa;
	private String marca;
	private String modelo;
	private String cor;
	private float velocMax;
	private int qtdRodas;
	Motor motor;

	public Veiculo() {
		super();
	}
	
	public String getPlaca() {
		return this.placa;
	}
	public final void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public String getMarca() {
		return this.marca;
	}
	public final void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}
	public final void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}
	public final void setCor(String cor) {
		this.cor = cor;
	}

	public float getVelocMax() {
		return velocMax;
	}
	public final void setVelocMax(float velocMax) {
		this.velocMax = velocMax;
	}

	public int getQtdRodas() {
		return qtdRodas;
	}
	public final void setQtdRodas(int qtdRodas) {
		this.qtdRodas = qtdRodas;
	}

	public Motor getMotor() {
		return motor;
	}
	public final void setMotor(Motor motor) {
		this.motor = motor;
	}
	
	
	
	@Override
	public String toString() {
		return "Veiculo [placa=" + placa + ", marca=" + marca + ", modelo=" + modelo + ", cor=" + cor + ", velocMax="
				+ velocMax + "km/h , qtdRodas=" + qtdRodas + ", motor=" + motor + "]";
	}

	public abstract float calcVel(float velocMax);
	
}
