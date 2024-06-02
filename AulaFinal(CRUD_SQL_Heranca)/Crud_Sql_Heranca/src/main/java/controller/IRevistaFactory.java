package controller;

import model.Revista;

public interface IRevistaFactory {
	public Revista createRevista(int codigo, String nome, int qtdPaginas, String issn);
}
