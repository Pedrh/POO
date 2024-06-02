package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Aluno;

public class AlunoDao implements ICRUDDAO<Aluno> {

	private GenericDao gDao;
	
	public AlunoDao(GenericDao gDao) {
		this.gDao = gDao;
	}
	
	@Override
	public void insert(Aluno a) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String mysql = "INSERT INTO aluno VALUES (?,?,?)";
		PreparedStatement ps =  c.prepareStatement(mysql);
		ps.setInt(1, a.getRa());
		ps.setString(2, a.getNome());
		ps.setString(3, a.getEmail());
		ps.execute();
		ps.close();
		c.close();
	}

	@Override
	public void update(Aluno a) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String mysql = "UPDATE aluno SET nome = ?, email = ? WHERE ra = ?";
		PreparedStatement ps =  c.prepareStatement(mysql);
		ps.setString(1, a.getNome());
		ps.setString(2, a.getEmail());
		ps.setInt(3, a.getRa());
		ps.execute();
		ps.close();
		c.close();
	}

	@Override
	public void delete(Aluno a) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String mysql = "DELETE FROM aluno WHERE ra = ?";
		PreparedStatement ps =  c.prepareStatement(mysql);
		ps.setInt(1, a.getRa());
		ps.execute();
		ps.close();
		c.close();
	}

	@Override
	public Aluno findOne(Aluno a) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String mysql = "SELECT ra, nome, email FROM aluno WHERE ra = ?";
		PreparedStatement ps =  c.prepareStatement(mysql);
		ps.setInt(1, a.getRa());
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			a.setRa(rs.getInt("ra"));
			a.setNome(rs.getString("nome"));
			a.setEmail(rs.getString("email"));
		}
		
		ps.close();
		rs.close();
		c.close();
		return a;
	}

	@Override
	public List<Aluno> findAll() throws SQLException, ClassNotFoundException {
		List<Aluno> alunos = new ArrayList<>();
		Connection c = gDao.getConnection();
		String mysql = "SELECT ra, nome, email FROM aluno";
		PreparedStatement ps = c.prepareStatement(mysql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Aluno a = new Aluno();
			a.setRa(rs.getInt("ra"));
			a.setNome(rs.getString("nome"));
			a.setEmail(rs.getString("email"));
			
			alunos.add(a);
		}
		ps.close();
		rs.close();
		c.close();
		return alunos;
	}

}
