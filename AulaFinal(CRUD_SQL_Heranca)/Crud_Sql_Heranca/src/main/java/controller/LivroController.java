package controller;

import java.sql.SQLException;
import java.util.List;

import model.Livro;
import persistence.GenericDao;
import persistence.LivroDao;

public class LivroController implements ILivroFactory, ICRUDController<Livro>{
	
	public LivroController() {
		super();
	}
	
	@Override
	public Livro createLivro(int codigo, String nome, int qtdPaginas, String isbn, int edicao) {
		Livro l = new Livro();
		l.setCodigo(codigo);
		l.setNome(nome);
		l.setQtdPaginas(qtdPaginas);
		l.setIsbn(isbn);
		l.setEdicao(edicao);
		return l;
	}
	
	public void insert(Livro l) throws ClassNotFoundException, SQLException {
		GenericDao gDao = new GenericDao();
		LivroDao lDao = new LivroDao(gDao);
		lDao.insert(l);
	}
	
	public void update(Livro l) throws ClassNotFoundException, SQLException {
		GenericDao gDao = new GenericDao();
		LivroDao lDao = new LivroDao(gDao);
		lDao.update(l);
	}
	
	public void delete(Livro l) throws ClassNotFoundException, SQLException {
		GenericDao gDao = new GenericDao();
		LivroDao lDao = new LivroDao(gDao);
		lDao.delete(l);
	}
	
	public Livro findOne(Livro l) throws ClassNotFoundException, SQLException {
		GenericDao gDao = new GenericDao();
		LivroDao lDao = new LivroDao(gDao);
		return lDao.findOne(l);
	}
	
	public List<Livro> findAll() throws ClassNotFoundException, SQLException {
		GenericDao gDao = new GenericDao();
		LivroDao lDao = new LivroDao(gDao);
		return lDao.findAll();
	}

}
