package com.paiGabriela.model.DaoImpl;
import java.sql.*;

public class ModuloConexao {

	private Connection conexao;
	
	public void MetodoParaIniciarConexao() {
       
        String url = "jdbc:mysql://localhost:3306/seguradora?characterEncoding=utf-8";
        String user = "root";
        String password = "";

        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            System.out.println(conexao);
            System.out.println("Banco de dados Conectado");
        } catch (Exception e) {
            System.out.println(e + " Houve algum erro"); 
        }  
    }
	
}
