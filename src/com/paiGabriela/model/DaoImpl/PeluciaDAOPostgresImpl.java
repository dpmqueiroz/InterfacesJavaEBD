package com.paiGabriela.model.DaoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.paiGabriela.model.Pelucia;
import com.paiGabriela.model.Dao.DataSource;
import com.paiGabriela.model.Dao.PeluciaDao;

public class PeluciaDAOPostgresImpl implements PeluciaDao{
	
	private DataSource dataSource;
	
	public PeluciaDAOPostgresImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public ArrayList<Pelucia> pegarTodos(){
		try {
			String SQL = "SELECT * FROM peluciasGabriela";
			PreparedStatement ps = dataSource.getConnection().prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			
			ArrayList<Pelucia> pelucias = new ArrayList<Pelucia>();
			
			while(rs.next()) {
				Pelucia pelucia = new Pelucia();
				pelucia.setId(rs.getInt("id"));
				pelucia.setCor(rs.getString("cor"));
				pelucia.setNome(rs.getString("nome"));
				
				pelucias.add(pelucia);
			}
			
			ps.close();
			return pelucias;
			
		}catch( SQLException e) {
			System.err.println("Erro ao recuperar : "+e.getMessage());
		}catch(Exception e) {
			System.err.println("Erro geral :" + e.getMessage());
		}
		return null;
	}
}
