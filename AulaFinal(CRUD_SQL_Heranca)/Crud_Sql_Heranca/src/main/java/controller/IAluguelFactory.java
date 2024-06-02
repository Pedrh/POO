package controller;

import java.sql.SQLException;
import java.time.LocalDate;

import model.Aluguel;
import model.Aluno;
import model.Exemplar;

public interface IAluguelFactory {

	public Aluguel createAluguel(Aluno aluno, Exemplar exemplar, 
			LocalDate dataRetirada, LocalDate dataDevolucao)throws ClassNotFoundException, SQLException;
}
