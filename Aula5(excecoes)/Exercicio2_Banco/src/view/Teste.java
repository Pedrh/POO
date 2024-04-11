package view;

import model.Conta;

public class Teste {

	public static void main(String[] args) {
		Conta cont = new Conta();
		
		cont.setAgencia(756);
		cont.setCodigo(5698);
		cont.setLimite(1200);
		cont.setSaldo(500);
		
		try {
			cont.depositar(500);
			cont.sacar(200);
			cont.sacar(2500);
		} catch(ArithmeticException e) {
			System.err.println(e.getMessage());
		}
	}

}
