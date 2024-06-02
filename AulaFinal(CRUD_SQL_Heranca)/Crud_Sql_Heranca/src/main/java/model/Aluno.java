package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Aluno {
	private int ra;
	private String nome;
	private String email;
	
	
	public Aluno() {
		super();
	}
	
	@Override
	public String toString() {
		return "Nome Aluno: " + nome + ", RA: " + ra + ", email: " + email;
	}

}
