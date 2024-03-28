package model;

public class Trapezio extends Quadrilatero{

	private float baseMenor;
	
	public Trapezio() {
		super();
	}
	
	public float getBaseMenor() {
		return baseMenor;
	}

	public void setBaseMenor(float baseMenor) {
		this.baseMenor = baseMenor;
	}
	
	

	@Override
	public float calcArea() {
		return ((getBase() + baseMenor) * getAltura()) / 2;
	}

	@Override
	public float calcPerimetro() {
		float baseTriangulo = getBase() - baseMenor;
		float pitagoras = (float) Math.sqrt((baseTriangulo * baseTriangulo) + (getAltura() * getAltura()));
		return baseMenor + getBase() + (pitagoras * 2);
	}

}
