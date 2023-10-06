package me.izac.pattern.behavioral.visitor;

public class Fruta implements Produto {
	
	private int preco;
	private int peso;
	private String nome;
	
	public Fruta(int preco, int peso, String nome){
		this.preco = preco;
		this.peso = peso;
		this.nome = nome;
	}
	
	public int getPreco() {
		return preco;
	}


	public int getPeso() {
		return peso;
	}

	public String getNome(){
		return nome;
	}
	
	@Override
	public int aceitar(CarrinhoDeComprasVisitor visitor) {
		return visitor.visit(this);
	}

}