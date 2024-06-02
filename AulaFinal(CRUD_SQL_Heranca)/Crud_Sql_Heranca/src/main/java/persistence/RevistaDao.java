package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Revista;

public class RevistaDao implements ICRUDDAO<Revista> {
	private GenericDao gDao;
	
	public RevistaDao(GenericDao gDao) {
		this.gDao = gDao;
	}

	@Override
	public void insert(Revista r) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		
		// primeiro: insercao na superclasse
		String mysql = "INSERT INTO exemplar VALUES (?,?,?)";
		PreparedStatement ps = c.prepareStatement(mysql);
		ps.setInt(1, r.getCodigo());
		ps.setString(2, r.getNome());
		ps.setInt(3, r.getQtdPaginas());
		ps.execute();
		
		// segundo: insercao na subclasse
		String mysql2 = "INSERT INTO revista VALUES (?,?)";
		ps = c.prepareStatement(mysql2);
		ps.setInt(1, r.getCodigo());
		ps.setString(2, r.getIssn());

		ps.execute();
		
		ps.close();
		c.close();
	}

	@Override
	public void update(Revista r) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		
		// primeiro: update na superclasse
		String mysql = "UPDATE exemplar SET nome = ?, qtdPaginas = ? WHERE codigo = ?";
		PreparedStatement ps = c.prepareStatement(mysql);
		ps.setString(1, r.getNome());
		ps.setInt(2, r.getQtdPaginas());
		ps.setInt(3, r.getCodigo());
		
		ps.execute();
		// segundo: update na subclasse
		String mysql2 = "UPDATE revista SET issn = ? WHERE codigo = ?";
		ps = c.prepareStatement(mysql2);
		ps.setString(1, r.getIssn());
		ps.setInt(2, r.getCodigo());

		ps.execute();
		
		ps.close();
		c.close();
		
	}

	@Override
	public void delete(Revista r) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		
		// primeiro: delete na subclasse
		String mysql = "DELETE FROM revista WHERE codigo = ?";
		PreparedStatement ps = c.prepareStatement(mysql);
		ps.setInt(1, r.getCodigo());
		
		ps.execute();
		// segundo: delete na superclasse
		String mysql2 = "DELETE FROM exemplar WHERE codigo = ?";
		ps = c.prepareStatement(mysql2);
		ps.setInt(1, r.getCodigo());

		ps.execute();
		
		ps.close();
		c.close();
		
	}

	@Override
	public Revista findOne(Revista r) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		
		String mySql = "SELECT e.codigo as codigo, e.nome as nome, e.qtdPaginas as qtdPaginas, r.issn as issn FROM exemplar e "
				+ "inner join revista r on e.codigo = r.codigo AND r.codigo = ?";
		PreparedStatement ps = c.prepareStatement(mySql);
		ps.setInt(1, r.getCodigo());
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			r.setCodigo(rs.getInt("codigo"));
			r.setNome(rs.getString("nome"));
			r.setQtdPaginas(rs.getInt("qtdPaginas"));
			r.setIssn(rs.getString("issn"));
		}
		rs.close();
		ps.close();
		c.close();
		return r;
	}

	@Override
	public List<Revista> findAll() throws SQLException, ClassNotFoundException {
		List<Revista> revistas = new ArrayList<>();
		Connection c = gDao.getConnection();
		
		String mySql = "SELECT e.codigo as codigo, e.nome as nome, e.qtdPaginas as qtdPaginas, r.issn as issn FROM exemplar e "
				+ "inner join revista r on e.codigo = r.codigo";
		PreparedStatement ps = c.prepareStatement(mySql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Revista r = new Revista();
			r.setCodigo(rs.getInt("codigo"));
			r.setNome(rs.getString("nome"));
			r.setQtdPaginas(rs.getInt("qtdPaginas"));
			r.setIssn(rs.getString("issn"));
			
			revistas.add(r);
		}
		return revistas;
	}
	
	
}
