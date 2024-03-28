package view;

import model.Paralelogramo;
import model.Trapezio;

public class Principal {

	public static void main(String[] args) {
		Paralelogramo p = new Paralelogramo();
		
		p.setAltura(6);
		p.setBase(4);
		
		System.out.println("Paralelogramo:\nPerimetro: " + p.calcPerimetro() + "\nArea: " + p.calcArea());
		
		
		System.out.println("----------------------------------------");
		Trapezio t = new Trapezio();
		
		t.setBase(20);
		t.setBaseMenor(12);
		t.setAltura(8);
		
		System.out.println("Trapezio:\nPerimetro: " + t.calcPerimetro() + "\nArea: " + t.calcArea());
	}

}
