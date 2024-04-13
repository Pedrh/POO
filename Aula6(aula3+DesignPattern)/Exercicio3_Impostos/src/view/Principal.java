package view;

import controller.IImpostoStrategy;
import controller.ImpostoBeloHorizonte;
import controller.ImpostoCuritiba;
import controller.ImpostoPortoAlegre;
import controller.ImpostoSaoPaulo;

public class Principal {

	public static void main(String[] args) {
		IImpostoStrategy imposto = new ImpostoSaoPaulo();
		imposto.calcularImposto();
		
		imposto = new ImpostoBeloHorizonte();
		imposto.calcularImposto();
		
		imposto = new ImpostoPortoAlegre();
		imposto.calcularImposto();
		
		imposto = new ImpostoCuritiba();
		imposto.calcularImposto();
	}

}
