package controller;

import model.Funcionario;
import model.TempoIntegral;

public class ContratacaoIntegral extends ContratacaoFactory {

	public ContratacaoIntegral() {
		super();
	}
	
	@Override
	public Funcionario iniciarContratacao() {
		TempoIntegral funcIntegral = new TempoIntegral();
		int id = (int) (Math.random() * 101) + 100;
		funcIntegral.setBancoHoras(20);
		funcIntegral.setId(id);
		funcIntegral.setNome("Rogério");
		funcIntegral.setSalario(1200);
		return funcIntegral;
	}

}
