package model;

public final class Carga extends Veiculo {
	
	private int cargaMax;
	private int tara;
	
	public Carga() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getCargaMax() {
		return cargaMax;
	}
	public final void setCargaMax(int cargaMax) {
		this.cargaMax = cargaMax;
	}


	public int getTara() {
		return tara;
	}
	public final void setTara(int tara) {
		this.tara = tara;
	}



	@Override
	public float calcVel(float velocMax) {
		return velocMax * 100000; //transformando de km/h para cm/h
	}


	@Override
	public String toString() {
		return "Veiculo Carga-----------\ncargaMax=" + cargaMax + "\nmotorPotencia=" + motor.getPotencia() +"\nmotorQtdPist=" + motor.getQtdPist() + ", \ntara=" + tara + ", \ngetPlaca()=" + getPlaca() + ", \ngetMarca()="
				+ getMarca() + ", \ngetModelo()=" + getModelo() + ", \ngetCor()=" + getCor() + ", \ngetVelocMax()="
				+ calcVel(getVelocMax()) + "cm/h, \ngetQtdRodas()=" + getQtdRodas() + "\n";
	}
	
	
}
