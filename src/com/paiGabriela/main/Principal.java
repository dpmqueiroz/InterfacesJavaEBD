package com.paiGabriela.main;

import java.util.ArrayList;

import com.paiGabriela.model.Pelucia;
import com.paiGabriela.model.Dao.DataSource;
import com.paiGabriela.model.Dao.PeluciaDao;
import com.paiGabriela.model.DaoImpl.DataSourceMySqlImpl;
import com.paiGabriela.model.DaoImpl.DataSourcePostgresImpl;
import com.paiGabriela.model.DaoImpl.PeluciaDAOMySqlImpl;
import com.paiGabriela.model.DaoImpl.PeluciaDAOPostgresImpl;

public class Principal {

	public static void main(String[] args) {
		
		DataSource dataSource = new DataSourcePostgresImpl();
		PeluciaDao peluciaDAO = new PeluciaDAOPostgresImpl(dataSource);
//		DataSource dataSource = new DataSourceMySqlImpl();
//		PeluciaDao peluciaDAO = new PeluciaDAOMySqlImpl(dataSource);
		
		ArrayList<Pelucia> pelucias = peluciaDAO.pegarTodos();
		if(pelucias != null) {
			for (Pelucia pelucia : pelucias) {
				System.out.println("Oie, eu sou o(a) : "+ pelucia.getNome() +", minha cor predominante é : "+ pelucia.getCor() 
				+", e o meu identificador é o número: " + pelucia.getId());
			}
			dataSource.closeDataSource();
		}else {
			System.out.println("Gabriela não tem ursinhos de Pelúcia.");
		}
	}
}






