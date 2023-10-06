package me.izac.pattern.behavioral.visitor;

public interface Produto {

	public int aceitar(CarrinhoDeComprasVisitor visitor);
}