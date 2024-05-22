package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Jogador;
import model.Time;

public class JogadorDao implements ICrud<Jogador>{

	private GenericDao gDao;
	
	public JogadorDao(GenericDao gDao) {
		this.gDao = gDao;
	}
	
	@Override
	public void inserir(Jogador j) throws ClassNotFoundException, SQLException {
		Connection c = gDao.getConnection();
		String mySql = "INSERT INTO jogador VALUES (?,?,?,?,?,?)";
		PreparedStatement ps = c.prepareStatement(mySql);
		ps.setInt(1, j.getId());
		ps.setString(2, j.getNome());
		ps.setDate(3, java.sql.Date.valueOf(j.getDataNasc()));
		ps.setFloat(4, j.getAltura());
		ps.setFloat(5, j.getPeso());
		ps.setInt(6, j.getTime().getCodigo());
		ps.execute();
		ps.close();
		c.close();
	}

	@Override
	public void atualizar(Jogador j) throws ClassNotFoundException, SQLException {
		Connection c = gDao.getConnection();
		String mySql = "UPDATE jogador SET nome = ?, dataNasc = ?, altura = ?, peso = ?, timeCodigo = ? WHERE id=?";
		PreparedStatement ps = c.prepareStatement(mySql);
		ps.setString(1, j.getNome());
		ps.setDate(2, java.sql.Date.valueOf(j.getDataNasc()));
		ps.setFloat(3, j.getAltura());
		ps.setFloat(4, j.getPeso());
		ps.setInt(5, j.getTime().getCodigo());
		ps.setInt(6, j.getId());
		ps.execute();
		ps.close();
		c.close();
	}

	@Override
	public void excluir(Jogador j) throws ClassNotFoundException, SQLException {
		Connection c = gDao.getConnection();
		String mySql = "DELETE FROM jogador WHERE id = ?";
		PreparedStatement ps = c.prepareStatement(mySql);
		ps.setInt(1, j.getId());
		ps.execute();
		ps.close();
		c.close();
	}

	@Override
	public Jogador consultar(Jogador j) throws ClassNotFoundException, SQLException {
		Connection c = gDao.getConnection();
		StringBuffer mySql = new StringBuffer();
		mySql.append("SELECT j.id AS codJog, j.nome AS nomeJog, ");
		mySql.append("j.dataNasc AS dataNasc, j.altura AS alturaJog, ");
		mySql.append("j.peso AS pesoJog,  ");
		mySql.append("t.codigo AS codTime, t.nome AS nomeTime, t.cidade AS cidadeTime ");
		mySql.append("FROM time t, jogador j ");
		mySql.append("WHERE t.codigo = j.timeCodigo ");
		mySql.append("AND j.id = ?");
		PreparedStatement ps = c.prepareStatement(mySql.toString());
		ps.setInt(1, j.getId());
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Time t = new Time();
			t.setCodigo(rs.getInt("codTime"));
			t.setNome(rs.getString("nomeTime"));
			t.setCidade(rs.getString("cidadeTime"));
			
			j.setId(rs.getInt("codJog"));
			j.setNome(rs.getString("nomeJog"));
			j.setDataNasc(rs.getDate("dataNasc").toLocalDate());
			j.setAltura(rs.getFloat("alturaJog"));
			j.setPeso(rs.getFloat("pesoJog"));
			j.setTime(t);
		}
		rs.close();
		ps.close();
		c.close();
		return j;
	}

	@Override
	public List<Jogador> listar() throws ClassNotFoundException, SQLException {
		List<Jogador> jogadores = new ArrayList<>();
		Connection c = gDao.getConnection();
		StringBuffer mySql = new StringBuffer();
		mySql.append("SELECT j.id AS codJog, j.nome AS nomeJog, ");
		mySql.append("j.dataNasc AS dataNasc, j.altura AS alturaJog, ");
		mySql.append("j.peso AS pesoJog,  ");
		mySql.append("t.codigo AS codTime, t.nome AS nomeTime, t.cidade AS cidadeTime ");
		mySql.append("FROM time t, jogador j ");
		mySql.append("WHERE t.codigo = j.timeCodigo ");
		PreparedStatement ps = c.prepareStatement(mySql.toString());
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Time t = new Time();
			t.setCodigo(rs.getInt("codTime"));
			t.setNome(rs.getString("nomeTime"));
			t.setCidade(rs.getString("cidadeTime"));
			
			Jogador j = new Jogador();
			j.setId(rs.getInt("codJog"));
			j.setNome(rs.getString("nomeJog"));
			j.setDataNasc(rs.getDate("dataNasc").toLocalDate());
			j.setAltura(rs.getFloat("alturaJog"));
			j.setPeso(rs.getFloat("pesoJog"));
			j.setTime(t);
			
			jogadores.add(j);
		}
		rs.close();
		ps.close();
		c.close();
		return jogadores;
	}

}
