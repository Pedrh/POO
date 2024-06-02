package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Livro extends Exemplar {
	private String isbn;
	private int edicao;
	
	public Livro() {
		super();
	}
	
	@Override
	public String toString() {
		return "Nome: " + nome + ", Cod: " + codigo + ", Pags: " + qtdPaginas + ", ISBN: " 
	+ isbn +", edicao: " + edicao;
	}
}
