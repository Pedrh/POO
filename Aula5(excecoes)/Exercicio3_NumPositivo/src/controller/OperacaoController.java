package controller;

public class OperacaoController {
	public int operacaoValor(int valor) throws ArithmeticException {
		if(valor < 0) {
			throw new ArithmeticException("O valor não pode ser negativo");
		}
		
		if(valor % 2 == 0) {
			System.out.print("O número é par, seu quadrado é ");
			return valor * valor;
		} else {
			System.out.print("O número é impar, seu cubo é ");
			return valor * valor * valor;
		}
	}
}
