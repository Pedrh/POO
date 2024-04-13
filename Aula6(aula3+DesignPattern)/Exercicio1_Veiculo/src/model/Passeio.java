package model;

public final class Passeio extends Veiculo {

	private int qtdPassageiros;
	
	
	public Passeio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getQtdPassageiros() {
		return qtdPassageiros;
	}
	public final void setQtdPassageiros(int qtdPassageiros) {
		this.qtdPassageiros = qtdPassageiros;
	}


	@Override
	public float calcVel(float velocMax) {
		return velocMax * 1000; // transformando de km/h para m/h
	}

	@Override
	public String toString() {
		return "Veiculo Passeio------------\nqtdPassageiros=" + qtdPassageiros + ", \nmotorPotencia=" + motor.getPotencia() +"\nmotorQtdPist=" + motor.getQtdPist() + ", \ngetPlaca()=" + getPlaca()
				+ ", \ngetMarca()=" + getMarca() + ", \ngetModelo()=" + getModelo() + ", \ngetCor()=" + getCor()
				+ ", \ngetVelocMax()=" + calcVel(getVelocMax()) + "m/h, \ngetQtdRodas()=" + getQtdRodas() + "\n";
	}
	
	
	
}
