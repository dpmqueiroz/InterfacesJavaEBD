package com.paiGabriela.model.DaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.paiGabriela.model.Dao.DataSource;

public class DataSourcePostgresImpl implements DataSource{
	private String hostname = "localhost";
	private int port = 5433;
	private String database = "pelucias";
	private String username = "postgres";
	private String password = "dpmqueiroz";
	
	private Connection connection;
	
	public DataSourcePostgresImpl() {
		startConnection();
	}
	
	@Override
	public void startConnection() {
		try {
			String url = "jdbc:postgresql://" + hostname + ":" + port + "/" + database;
			
			 connection = DriverManager.getConnection(url, username, password);
			 
			 System.out.println("CONECTADO ao Postgres");
			
		}catch(SQLException e) {
			System.err.println("ERRO na conexão: "+e.getMessage());
		}catch(Exception e) {
			System.err.println("Erro Geral : "+e.getMessage());
		}
	}
	
	@Override
	public Connection getConnection() {
		return this.connection;
	}
	
	@Override
	public void closeDataSource() {
		try {
			connection.close();
			System.out.println("DESCONECTOU do Postgres");
		}catch(Exception e) {
			System.err.println("Erro ao desconectar" + e.getMessage());
		}
	}
}
