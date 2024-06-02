package controller;

import java.sql.SQLException;
import java.util.List;

import model.Aluno;
import persistence.AlunoDao;
import persistence.GenericDao;

public class AlunoController implements IAlunoFactory, ICRUDController<Aluno> {

	public AlunoController() {
		super();
	}

	@Override
	public Aluno createAluno(int ra, String nome, String email){
		Aluno a = new Aluno();
		a.setRa(ra);
		a.setNome(nome);
		a.setEmail(email);	
		return a;
	}
	
	public void insert(Aluno a) throws ClassNotFoundException, SQLException {
		GenericDao gDao = new GenericDao();
		AlunoDao aDao = new AlunoDao(gDao);
		aDao.insert(a);
	}
	public void update(Aluno a) throws ClassNotFoundException, SQLException {
		GenericDao gDao = new GenericDao();
		AlunoDao aDao = new AlunoDao(gDao);
		aDao.update(a);
	}


	public void delete(Aluno a) throws ClassNotFoundException, SQLException {
		GenericDao gDao = new GenericDao();
		AlunoDao aDao = new AlunoDao(gDao);
		aDao.delete(a);
		
	}

	public Aluno findOne(Aluno a) throws ClassNotFoundException, SQLException {
		GenericDao gDao = new GenericDao();
		AlunoDao aDao = new AlunoDao(gDao);
		return aDao.findOne(a);
	}


	public List<Aluno> findAll() throws ClassNotFoundException, SQLException {
		GenericDao gDao = new GenericDao();
		AlunoDao aDao = new AlunoDao(gDao);
		return aDao.findAll();
	}

		
}
