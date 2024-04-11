package view;

import controller.OperacaoController;

public class Teste {

	public static void main(String[] args) {
		OperacaoController operacao = new OperacaoController();
		try {
			System.out.println(operacao.operacaoValor(0));
		} catch(ArithmeticException e) {
			System.err.println(e.getMessage());
		}
	}

}
