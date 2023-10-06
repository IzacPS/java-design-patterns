package me.izac.pattern.behavioral.visitor;

public class Livro implements Produto {

	private int preco;
	private String isbn;
	
	public Livro(int preco, String isbn){
		this.preco=preco;
		this.isbn=isbn;
	}
	
	public int getPreco() {
		return preco;
	}

	public String getIsbn() {
		return isbn;
	}

	public int aceitar(CarrinhoDeComprasVisitor visitor) {
		return visitor.visit(this);
	}

}