package view;

import model.Ingresso;
import model.IngressoVip;

public class Principal {

	public static void main(String[] args) {
		Ingresso ingresso1 = new Ingresso();
		
		ingresso1.setCodigo("12345");
		ingresso1.setvalor(100);
		
		IngressoVip ingressoV = new IngressoVip();
		
		ingressoV.setCodigo("12345");
		ingressoV.setvalor(100);
		ingressoV.setCargo("Banqueiro");
		
		
		System.out.println("Ingresso normal: " + ingresso1.valorFinal(15));
		System.out.println("----------------------");
		
		System.out.println("Ingresso Vip: " + ingressoV.valorFinal(15));
	}

}
