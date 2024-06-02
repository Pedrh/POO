package controller;

import model.Aluno;

public interface IAlunoFactory {
	public Aluno createAluno(int ra,String nome,String email);
	
}
