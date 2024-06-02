package controller;

import java.sql.SQLException;
import java.util.List;

import model.Revista;
import persistence.GenericDao;
import persistence.RevistaDao;

public class RevistaController implements IRevistaFactory, ICRUDController<Revista>{
	
	public RevistaController() {
		super();
	}

	@Override
	public Revista createRevista(int codigo, String nome, int qtdPaginas, String issn) {
		Revista r =  new Revista();
		r.setCodigo(codigo);
		r.setNome(nome);
		r.setQtdPaginas(qtdPaginas);
		r.setIssn(issn);
		return r;
	}
	
	public void insert(Revista r) throws ClassNotFoundException, SQLException {
		GenericDao gDao = new GenericDao();
		RevistaDao rDao = new RevistaDao(gDao);
		rDao.insert(r);
	}

	public void update(Revista r) throws ClassNotFoundException, SQLException {
		GenericDao gDao = new GenericDao();
		RevistaDao rDao = new RevistaDao(gDao);
		rDao.update(r);
	}
	
	public void delete(Revista r) throws ClassNotFoundException, SQLException {
		GenericDao gDao = new GenericDao();
		RevistaDao rDao = new RevistaDao(gDao);
		rDao.delete(r);
	}
	
	public Revista findOne(Revista r) throws ClassNotFoundException, SQLException {
		GenericDao gDao = new GenericDao();
		RevistaDao rDao = new RevistaDao(gDao);
		return rDao.findOne(r);
	}
	
	public List<Revista> findAll() throws ClassNotFoundException, SQLException {
		GenericDao gDao = new GenericDao();
		RevistaDao rDao = new RevistaDao(gDao);
		return rDao.findAll();
	}
}
