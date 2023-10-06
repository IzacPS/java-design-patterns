package me.izac.pattern.behavioral.visitor;

public class CarrinhoDeCompras implements CarrinhoDeComprasVisitor {

	@Override
	public int visit(Livro livro) {
		int valor=0;
		//aplica 5$ de desconto se o livro for maior que 50
		if(livro.getPreco() > 50){
			valor = livro.getPreco()-5;
		}else
			valor = livro.getPreco();
		System.out.println("Livro ISBN::"+ livro.getIsbn() + " valor = "+valor);
		return valor;
	}

	@Override
	public int visit(Fruta fruta) {
		int valor = fruta.getPreco()* fruta.getPeso();
		System.out.println(fruta.getNome() + " valor = "+valor);
		return valor;
	}

}