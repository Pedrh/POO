package controller;

import model.Funcionario;
import model.Temporario;

public class ContratacaoTemporario extends ContratacaoFactory {

	@Override
	public Funcionario iniciarContratacao() {
		Temporario funcTemporario = new Temporario();
		int id = (int) (Math.random() * 101) + 100;
		funcTemporario.setDia(01);
		funcTemporario.setMes(03);
		funcTemporario.setAno(2022);
		funcTemporario.setId(id);
		funcTemporario.setNome("Amanda");
		funcTemporario.setSalario(1200);
		return funcTemporario;
	}

}
