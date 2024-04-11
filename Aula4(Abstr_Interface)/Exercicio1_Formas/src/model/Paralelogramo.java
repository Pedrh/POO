package model;

public class Paralelogramo extends Quadrilatero {

	public Paralelogramo() {
		super();
	}
	
	@Override
	public float calcArea() {
		return getBase() * getAltura();
	}

	@Override
	public float calcPerimetro() {
		return 2 * (getBase() + getAltura());
	}

}
