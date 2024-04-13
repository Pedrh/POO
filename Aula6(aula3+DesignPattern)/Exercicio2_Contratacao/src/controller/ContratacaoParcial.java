package controller;

import model.Funcionario;
import model.TempoParcial;

public class ContratacaoParcial extends ContratacaoFactory {
	public ContratacaoParcial() {
		super();
	}
	
	@Override
	public Funcionario iniciarContratacao() {
		TempoParcial funcParcial = new TempoParcial();
		int id = (int) (Math.random() * 101) + 100;
		funcParcial.setHoraEntrada(8);
		funcParcial.setHoraSaida(17);
		funcParcial.setId(id);
		funcParcial.setNome("Flavia");
		funcParcial.setSalario(1200);
		return funcParcial;
	}

}
