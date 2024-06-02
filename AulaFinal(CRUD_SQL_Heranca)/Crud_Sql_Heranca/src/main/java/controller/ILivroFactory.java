package controller;

import model.Livro;

public interface ILivroFactory {
	public Livro createLivro(int codigo, String nome, int qtdPaginas, String isbn, int edicao);
}
