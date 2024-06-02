package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Exemplar;
import model.Livro;
import model.Revista;
import persistence.GenericDao;
import persistence.LivroDao;
import persistence.RevistaDao;

public class ExemplarController {
	
	public ExemplarController() {
		super();
	}
	
	public List<Exemplar> juntaExemplares() throws ClassNotFoundException, SQLException{
		List<Exemplar> exemplares = new ArrayList<>();
		
		GenericDao gDao = new GenericDao();
		RevistaDao rDao = new RevistaDao(gDao);
		LivroDao lDao = new LivroDao(gDao);
		
		List<Revista> revistas = rDao.findAll(); 
		List<Livro> livros = lDao.findAll();
		
		exemplares.addAll(livros);
		exemplares.addAll(revistas);
		
		return exemplares;
	}
	
	public String especificaExemplar(Exemplar ex) throws ClassNotFoundException, SQLException {
		GenericDao gDao = new GenericDao();
		RevistaDao rDao = new RevistaDao(gDao);
		LivroDao lDao = new LivroDao(gDao);
		Livro l = new Livro();
		Revista r = new Revista();
		String saida = "";
		
		
		l.setCodigo(ex.getCodigo());
		r.setCodigo(ex.getCodigo());
		Exemplar exemplar = lDao.findOne(l);
		if(exemplar.getNome() != null) {
			saida = "livro";
		} else {
			exemplar = rDao.findOne(r);
			if(exemplar.getNome() != null){
				saida = "revista";
			}
		}
		
		
		return saida;
	}

}
