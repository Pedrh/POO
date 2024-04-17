package Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Model.Prova;

public class ProvaController implements IAvaliacoesRealizadas<Prova> {
	private List<Prova> lista;
	
	public ProvaController() {
		lista = new ArrayList<>();
	}
	
	@Override
	public void adicionarAvaliacao(Prova e) {
		e.setMedia((float) Math.random() * 10.0f);
		lista.add(e);
	}

	@Override
	public void removerAvaliacao(Prova e) {
		lista.remove(e);
	}

	@Override
	public Prova encontrarAvaliacao(int posicao) {
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
