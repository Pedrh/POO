package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Aluguel;
import model.Aluno;
import model.Exemplar;
import model.Revista;

public class AluguelDao implements ICRUDDAO<Aluguel> {

	private GenericDao gDao;
	
	public AluguelDao(GenericDao gDao) {
		this.gDao = gDao;
	}

	@Override
	public void insert(Aluguel a) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String mysql = "INSERT INTO aluguel VALUES (?,?,?,?)";
		PreparedStatement ps = c.prepareStatement(mysql);
		ps.setInt(1, a.getExemplar().getCodigo());
		ps.setInt(2, a.getAluno().getRa());
		ps.setDate(3, java.sql.Date.valueOf(a.getDataRetirada()));
		ps.setDate(4, java.sql.Date.valueOf(a.getDataDevolucao()));
		ps.execute();
		ps.close();
		c.close();
	}

	@Override
	public void update(Aluguel a) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String mysql = "UPDATE aluguel SET codigo = ?, alunoRa = ?, dataDevolucao = ? "
				+ "WHERE dataRetirada = ?";
		PreparedStatement ps = c.prepareStatement(mysql);
		ps.setInt(1, a.getExemplar().getCodigo());
		ps.setInt(2, a.getAluno().getRa());
		ps.setDate(3, java.sql.Date.valueOf(a.getDataDevolucao()));
		ps.setDate(4, java.sql.Date.valueOf(a.getDataRetirada()));
		ps.execute();
		ps.close();
		c.close();
	}

	@Override
	public void delete(Aluguel a) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String mysql = "DELETE FROM aluguel WHERE dataRetirada = ?";
		PreparedStatement ps = c.prepareStatement(mysql);
		ps.setDate(1, java.sql.Date.valueOf(a.getDataRetirada()));
		ps.execute();
		ps.close();
		c.close();
	}

	@Override
	public Aluguel findOne(Aluguel a) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		StringBuffer mysql = new StringBuffer();
		mysql.append("SELECT al.ra as ra, al.nome as nomeAluno, al.email as email, ");
		mysql.append("e.codigo as codigo, e.nome as nomeExemp, e.qtdPaginas as qtdPaginas, ");
		mysql.append("a.dataRetirada as dataRetirada, a.dataDevolucao as dataDevolucao ");
		mysql.append("FROM aluno al inner join aluguel a on al.ra = a.alunoRa ");
		mysql.append("inner join exemplar e on e.codigo = a.codigo ");
		mysql.append("AND a.dataRetirada = ?");
		
		PreparedStatement ps = c.prepareStatement(mysql.toString());
		ps.setDate(1,java.sql.Date.valueOf(a.getDataRetirada()));
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Aluno aluno = new Aluno();
			Exemplar exemplar = new Revista();
			
			aluno.setRa(rs.getInt("ra"));
			aluno.setNome(rs.getString("nomeAluno"));
			aluno.setEmail(rs.getString("email"));
			
			exemplar.setCodigo(rs.getInt("codigo"));
			exemplar.setNome(rs.getString("nomeExemp"));
			exemplar.setQtdPaginas(rs.getInt("qtdPaginas"));
			
			a.setAluno(aluno);
			a.setExemplar(exemplar);
			a.setDataRetirada(rs.getDate("dataRetirada").toLocalDate());
			a.setDataDevolucao(rs.getDate("dataDevolucao").toLocalDate());
			
		}
		rs.close();
		ps.close();
		c.close();
		return a;
	}

	@Override
	public List<Aluguel> findAll() throws SQLException, ClassNotFoundException {
		List<Aluguel> alugueis = new ArrayList<>();
		Connection c = gDao.getConnection();
		StringBuffer mysql = new StringBuffer();
		mysql.append("SELECT al.ra as ra, al.nome as nomeAluno, al.email as email, ");
		mysql.append("e.codigo as codigo, e.nome as nomeExemp, e.qtdPaginas as qtdPaginas, ");
		mysql.append("a.dataRetirada as dataRetirada, a.dataDevolucao as dataDevolucao ");
		mysql.append("FROM aluno al inner join aluguel a on al.ra = a.alunoRa ");
		mysql.append("inner join exemplar e on e.codigo = a.codigo");
		
		PreparedStatement ps = c.prepareStatement(mysql.toString());
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Aluno aluno = new Aluno();
			aluno.setRa(rs.getInt("ra"));
			aluno.setNome(rs.getString("nomeAluno"));
			aluno.setEmail(rs.getString("email"));
			
			Exemplar exemplar = new Revista();
			exemplar.setCodigo(rs.getInt("codigo"));
			exemplar.setNome(rs.getString("nomeExemp"));
			exemplar.setQtdPaginas(rs.getInt("qtdPaginas"));
			
			Aluguel a = new Aluguel();
			a.setAluno(aluno);
			a.setExemplar(exemplar);
			a.setDataRetirada(rs.getDate("dataRetirada").toLocalDate());
			a.setDataDevolucao(rs.getDate("dataDevolucao").toLocalDate());
			
			alugueis.add(a);
		}
		rs.close();
		ps.close();
		c.close();
		return alugueis;
	}

}
