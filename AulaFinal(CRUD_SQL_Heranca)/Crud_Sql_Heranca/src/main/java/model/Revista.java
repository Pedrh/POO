package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Revista extends Exemplar {
	private String issn;
	
	public Revista() {
		super();
	}
	
	@Override
	public String toString() {
		return "Nome: " + nome + ", Cod: " + codigo + ", Págs: " + qtdPaginas + ", ISSN: " + issn;
	}
}
