package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GenericDao {

	private Connection c;
	
	public GenericDao() {
		super();
	}
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		String hostName = "localHost"; //IP da máquina do servidor
		String dbName = "mysql"; //nome da database
		String user = "root"; //nome do usuário do mysql
		String senha = "P4$sw0rd"; //senha do usuario do mysql
		
		Class.forName("com.mysql.cj.jdbc.Driver"); //Referência da classe da lib de conexão
		//Configuração da String de conexão com Mysql
		c = DriverManager.getConnection(
				String.format("jdbc:mysql://%s:3306/%s", hostName, dbName), user, senha
				);
		
		return c;
	}
	
}
