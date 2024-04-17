package Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Model.Atividade;

public class AtividadeController implements IAvaliacoesRealizadas<Atividade> {
	private List<Atividade> lista;
	
	
	public AtividadeController() {
		lista = new ArrayList<>();
	}

	@Override
	public void adicionarAvaliacao(Atividade e) {
		lista.add(e);
	}

	@Override
	public void removerAvaliacao(Atividade e) {
		lista.remove(e);
	}

	@Override
	public Atividade encontrarAvaliacao(int posicao) {
		return lista.get(posicao);
	}

	@Override
	public void limparAvaliacoes() {
		lista.clear();
	}

	@Override
	public void mostrarAvaliacoes() {
		System.out.println(Arrays.toString(lista.toArray()));
	}

}
