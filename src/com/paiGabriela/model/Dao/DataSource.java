package com.paiGabriela.model.Dao;

import java.sql.Connection;

public interface DataSource {
	
	public void startConnection();
	public Connection getConnection();
	public void closeDataSource();
	
}
