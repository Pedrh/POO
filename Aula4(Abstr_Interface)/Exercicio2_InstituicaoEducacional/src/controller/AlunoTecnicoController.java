package controller;

import model.Estudante;

public class AlunoTecnicoController implements IAlunosController {

	@Override
	public double percentualRendimento(Estudante est) {
		return est.getMediaNotas() * est.getQtdAprovacoes() * 0.931;
	}

	@Override
	public double percentualProgressao(Estudante est) {
		return est.getQtdAprovacoes() / 3;
	}

}
