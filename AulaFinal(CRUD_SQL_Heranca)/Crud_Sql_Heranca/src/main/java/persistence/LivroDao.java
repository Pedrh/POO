package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Livro;

public class LivroDao implements ICRUDDAO<Livro> {
	private GenericDao gDao;

	public LivroDao(GenericDao gDao) {
		this.gDao = gDao;
	}

	@Override
	public void insert(Livro l) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		
		// primeiro: insercao na superclasse
		String mysql = "INSERT INTO exemplar VALUES (?,?,?)";
		PreparedStatement ps = c.prepareStatement(mysql);
		ps.setInt(1, l.getCodigo());
		ps.setString(2, l.getNome());
		ps.setInt(3, l.getQtdPaginas());
		
		ps.execute();
		// segundo: insercao na subclasse
		String mysql2 = "INSERT INTO livro VALUES (?,?,?)";
		ps = c.prepareStatement(mysql2);
		ps.setInt(1, l.getCodigo());
		ps.setString(2, l.getIsbn());
		ps.setInt(3, l.getEdicao());

		ps.execute();
		
		ps.close();
		c.close();
	}

	@Override
	public void update(Livro l) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		
		// primeiro: update na superclasse
		String mysql = "UPDATE exemplar SET nome = ?, qtdPaginas = ? WHERE codigo = ?";
		PreparedStatement ps = c.prepareStatement(mysql);
		ps.setString(1, l.getNome());
		ps.setInt(2, l.getQtdPaginas());
		ps.setInt(3, l.getCodigo());
		ps.execute();
		
		// segundo: update na subclasse
		String mysql2 = "UPDATE livro SET isbn = ?, edicao = ? WHERE codigo = ?";
		ps = c.prepareStatement(mysql2);
		ps.setString(1, l.getIsbn());
		ps.setInt(2, l.getEdicao());
		ps.setInt(3, l.getCodigo());

		ps.execute();
		
		ps.close();
		c.close();

	}

	@Override
	public void delete(Livro l) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		
		// primeiro: delete na sublasse
		String mysql = "DELETE FROM livro WHERE codigo = ?";
		PreparedStatement ps = c.prepareStatement(mysql);
		ps.setInt(1, l.getCodigo());
		
		ps.execute();
		// segundo: delete na superclasse
		String mysql2 = "DELETE FROM exemplar WHERE codigo = ?";
		ps = c.prepareStatement(mysql2);
		ps.setInt(1, l.getCodigo());

		ps.execute();
		
		ps.close();
		c.close();
	}

	@Override
	public Livro findOne(Livro l) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String mysql = "SELECT e.codigo as codigo, e.nome as nome, e.qtdPaginas as qtdPaginas, l.isbn as isbn"
				+ ", l.edicao as edicao FROM exemplar e inner join livro l on e.codigo = l.codigo AND l.codigo = ?";
		PreparedStatement ps = c.prepareStatement(mysql);
		ps.setInt(1, l.getCodigo());
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			l.setCodigo(rs.getInt("codigo"));
			l.setNome(rs.getString("nome"));
			l.setQtdPaginas(rs.getInt("qtdPaginas"));
			l.setIsbn(rs.getString("isbn"));
			l.setEdicao(rs.getInt("edicao"));
		}
		rs.close();
		ps.close();
		c.close();
		
		return l;
	}

	@Override
	public List<Livro> findAll() throws SQLException, ClassNotFoundException {
		List<Livro> livros = new ArrayList<>();
		
		Connection c = gDao.getConnection();
		String mysql = "SELECT e.codigo as codigo, e.nome as nome, e.qtdPaginas as qtdPaginas, l.isbn as isbn"
				+ ", l.edicao as edicao FROM exemplar e inner join livro l on e.codigo = l.codigo";
		PreparedStatement ps = c.prepareStatement(mysql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Livro l = new Livro();
			l.setCodigo(rs.getInt("codigo"));
			l.setNome(rs.getString("nome"));
			l.setQtdPaginas(rs.getInt("qtdPaginas"));
			l.setIsbn(rs.getString("isbn"));
			l.setEdicao(rs.getInt("edicao"));
			
			livros.add(l);
		}
		rs.close();
		ps.close();
		c.close();
		return livros;
	}	
	
	
}
