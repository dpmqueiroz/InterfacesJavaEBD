package com.paiGabriela.model;

public class Pelucia {
	
	private int id;
	private String nome;
	private String cor;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		if (cor.length() <= 2) {
			System.out.println("A cor deve ter mais que 2 caracteres");
		}else {			
			this.cor = cor;
		}
	}
}
