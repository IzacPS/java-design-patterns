package me.izac.pattern.behavioral.visitor;

public class TesteVisitor {

	public static void main(String[] args) {
		Produto[] items = new Produto[]{new Livro(20, "1234"),new Livro(100, "5678"),
				new Fruta(10, 2, "Banana"), new Fruta(5, 5, "Maçã")};

		CarrinhoDeComprasVisitor visitor = new CarrinhoDeCompras();

		int total=0;
		for(Produto item : items){
			total = total + item.aceitar(visitor);
		}
		System.out.println("Custo total = " + total);
	}

}