package me.izac.pattern.behavioral.strategy;

public class Produto {

	private String codigoDeBarras;
	private int preco;
	
	public Produto(String codigoDeBarras, int preco){
		this.codigoDeBarras = codigoDeBarras;
		this.preco = preco;
	}

	public String getCodigoDeBarras() {
		return codigoDeBarras;
	}

	public int getPreco() {
		return preco;
	}
	
}