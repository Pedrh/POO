package controller;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import model.Aluguel;
import model.Aluno;
import model.Exemplar;
import persistence.AluguelDao;
import persistence.GenericDao;

public class AluguelController implements IAluguelFactory, ICRUDController<Aluguel> {
	
	public AluguelController() {
		super();
	}

	@Override
	public Aluguel createAluguel(Aluno aluno, Exemplar exemplar, LocalDate dataRetirada, LocalDate dataDevolucao) throws ClassNotFoundException, SQLException {
		Aluguel a = new Aluguel();
		
		a.setAluno(aluno);
		a.setExemplar(exemplar);
		a.setDataRetirada(dataRetirada);
		a.setDataDevolucao(dataDevolucao);
		return a;
	}

	@Override
	public void insert(Aluguel a) throws SQLException, ClassNotFoundException {
		GenericDao gDao = new GenericDao();
		AluguelDao aDao =  new AluguelDao(gDao);
		aDao.insert(a);
	}

	@Override
	public void update(Aluguel a) throws SQLException, ClassNotFoundException {
		GenericDao gDao = new GenericDao();
		AluguelDao aDao =  new AluguelDao(gDao);
		aDao.update(a);
		
	}

	@Override
	public void delete(Aluguel a) throws SQLException, ClassNotFoundException {
		GenericDao gDao = new GenericDao();
		AluguelDao aDao =  new AluguelDao(gDao);
		aDao.delete(a);
		
	}

	@Override
	public Aluguel findOne(Aluguel a) throws SQLException, ClassNotFoundException {
		GenericDao gDao = new GenericDao();
		AluguelDao aDao =  new AluguelDao(gDao);
		return aDao.findOne(a);
	}

	@Override
	public List<Aluguel> findAll() throws SQLException, ClassNotFoundException {
		GenericDao gDao = new GenericDao();
		AluguelDao aDao =  new AluguelDao(gDao);
		return aDao.findAll();
	}
	
	
	

}
