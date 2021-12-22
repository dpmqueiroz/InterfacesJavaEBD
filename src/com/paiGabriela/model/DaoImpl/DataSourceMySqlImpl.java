package com.paiGabriela.model.DaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.paiGabriela.model.Dao.DataSource;

public class DataSourceMySqlImpl implements DataSource{

	private String hostname = "localhost";
	private String database = "pelucias3";
	private String username = "root";
	private String password = "";
	
	private Connection connection;
	
	public DataSourceMySqlImpl() {
		startConnection();
	}
	
	@Override
	public void startConnection() {
		try {
			String url = "jdbc:mysql://" + hostname + "/" + database;
			System.out.println(url);
			 connection = DriverManager.getConnection(url, username, password);
			 
			 System.out.println("CONECTADO ao MySql");
			
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
			System.out.println("DESCONECTOU do Mysql");
		}catch(Exception e) {
			System.err.println("Erro ao desconectar" + e.getMessage());
		}
	}
}








