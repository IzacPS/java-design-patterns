package me.izac.pattern.behavioral.visitor;

public interface CarrinhoDeComprasVisitor {

	int visit(Livro livro);
	int visit(Fruta fruta);
}