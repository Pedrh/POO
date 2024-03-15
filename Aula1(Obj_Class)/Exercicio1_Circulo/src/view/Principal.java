package view;

import model.Circulo;

public class Principal {

	public static void main(String[] args) {

		Circulo circulo = new Circulo(5);
		
		System.out.println(circulo.getArea());
		System.out.println(circulo.getPerimetro());
	}

}
