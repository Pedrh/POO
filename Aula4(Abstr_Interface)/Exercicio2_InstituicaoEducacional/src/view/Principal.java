package view;

import controller.AlunoSuperiorController;
import controller.AlunoTecnicoController;
import model.EstudanteSuperior;
import model.EstudanteTecnico;

public class Principal {

	public static void main(String[] args) {
		EstudanteSuperior es = new EstudanteSuperior();
		
		es.setNome("Giovana");
		es.setRa("111222333");
		es.setEmail("giovana.long@email.com");
		es.setInstituicaoSegundoGrau("Unicamp");
		es.setAnoConclusaoSegundoGrau(2019);
		es.setMediaNotas(8.5f);
		es.setQtdAprovacoes("12");
		
		
		
		EstudanteTecnico et = new EstudanteTecnico();
		
		et.setNome("Andre");
		et.setEmail("an.dre@email.com");
		et.setRa("12123232");
		et.setMediaNotas(6.2f);
		et.setQtdAprovacoes("26");
		
		AlunoSuperiorController alunoS = new AlunoSuperiorController();
		AlunoTecnicoController alunoT = new AlunoTecnicoController();
		
		System.out.println("Superior:\nRendimento: " + alunoS.percentualRendimento(es) +  " \nProgressão: " + alunoS.percentualProgressao(es));
		
		System.out.println("----------------------------------------------");
		
		System.out.println("Tecnico:\nRendimento: " + alunoT.percentualRendimento(et) +  "\nProgressão: " + alunoT.percentualProgressao(et));
	}

}
