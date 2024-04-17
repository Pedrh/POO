package View;

import Controller.AtividadeController;
import Controller.ProvaController;
import Model.Atividade;
import Model.Prova;

public class Principal {

	public static void main(String[] args) {
		Prova prova1 = new Prova();
		prova1.setQuestao(5);
		
		Prova prova2 = new Prova();
		prova2.setQuestao(8);
		
		Prova prova3 = new Prova();
		prova3.setQuestao(10);
		
		Prova prova4 = new Prova();
		prova4.setQuestao(15);
		
		ProvaController provaC = new ProvaController();
		
		provaC.adicionarAvaliacao(prova1);
		provaC.adicionarAvaliacao(prova2);
		provaC.adicionarAvaliacao(prova3);
		provaC.adicionarAvaliacao(prova4);
		
		System.out.println(provaC.encontrarAvaliacao(2));
		provaC.mostrarAvaliacoes();
		provaC.removerAvaliacao(prova4);
		provaC.mostrarAvaliacoes();
		provaC.limparAvaliacoes();
		provaC.mostrarAvaliacoes();
		
		System.out.println("===============================================\n");
		
		Atividade atv1 = new Atividade();
		atv1.setAssunto("Direito".toCharArray());
		atv1.setNumPaginas(4);
		
		Atividade atv2 = new Atividade();
		atv2.setAssunto("Politica".toCharArray());
		atv2.setNumPaginas(7);

		Atividade atv3 = new Atividade();
		atv3.setAssunto("Saude".toCharArray());
		atv3.setNumPaginas(10);
		
		Atividade atv4 = new Atividade();
		atv4.setAssunto("Esporte".toCharArray());
		atv4.setNumPaginas(2);
		
		AtividadeController atvC = new AtividadeController();
		
		atvC.adicionarAvaliacao(atv1);
		atvC.adicionarAvaliacao(atv2);
		atvC.adicionarAvaliacao(atv3);
		atvC.adicionarAvaliacao(atv4);
		
		System.out.println(atvC.encontrarAvaliacao(2));
		atvC.mostrarAvaliacoes();
		atvC.removerAvaliacao(atv3);
		atvC.mostrarAvaliacoes();
		atvC.limparAvaliacoes();
		atvC.mostrarAvaliacoes();
	}

}
