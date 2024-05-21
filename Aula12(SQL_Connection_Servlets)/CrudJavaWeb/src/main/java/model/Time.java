package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Time {

	private int codigo;
	private String nome;
	private String cidade;
	
	public Time() {
		super();
	}

	@Override
	public String toString() {
		return "Time " + nome + "(" + cidade + ")";
	}
	
	
}
