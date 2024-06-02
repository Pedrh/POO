package model;

import java.sql.SQLException;
import java.time.LocalDate;

import controller.ExemplarController;
import controller.LivroController;
import controller.RevistaController;
import lombok.Getter;

@Getter

public class Aluguel {

	private Aluno aluno;
	private Exemplar exemplar;
	private LocalDate dataRetirada;
	private LocalDate dataDevolucao;
	
	public Aluguel() {
		super();
	}
	

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}


	public void setExemplar(Exemplar exemplar) throws ClassNotFoundException, SQLException {
		ExemplarController ec = new ExemplarController();
		String tipoExemplar = ec.especificaExemplar(exemplar);
		if(tipoExemplar.contains("livro")) {
			LivroController lc = new LivroController();
			Livro l = new Livro();
			l.setCodigo(exemplar.getCodigo());
			this.exemplar = lc.findOne(l);
		} else if(tipoExemplar.contains("revista")){
			RevistaController rc = new RevistaController();
			Revista r = new Revista();
			r.setCodigo(exemplar.getCodigo());
			this.exemplar  = rc.findOne(r);
		}
	}


	public void setDataRetirada(LocalDate dataRetirada) {
		this.dataRetirada = dataRetirada;
	}


	public void setDataDevolucao(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	
	@Override
	public String toString() {
		return "Nome Aluno: " + aluno.getNome() + ", RA: " + aluno.getRa() + 
				" Nome Exemplar : " + exemplar.getNome() + ", Cod: " + exemplar.getCodigo() +
				" Data retirada: " + dataRetirada + ", Data devolucao: " + dataDevolucao;
	}
}
