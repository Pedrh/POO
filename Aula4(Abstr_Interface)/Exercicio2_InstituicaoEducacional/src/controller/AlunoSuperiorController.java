package controller;

import model.Estudante;

public class AlunoSuperiorController implements IAlunosController {

	public AlunoSuperiorController() {
		super();
	}
	
	
	@Override
	public double percentualRendimento(Estudante est) {
		return est.getMediaNotas() * est.getQtdAprovacoes() * 0.972;
	}

	@Override
	public double percentualProgressao(Estudante est) {
		return est.getQtdAprovacoes() / 6;
	}
	
}
