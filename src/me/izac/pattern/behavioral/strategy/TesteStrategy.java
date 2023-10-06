package me.izac.pattern.behavioral.strategy;

public class TesteStrategy {

	public static void main(String[] args) {
		CarrinhoDeCompras cart = new CarrinhoDeCompras();
		
		Produto produto1 = new Produto("1234",10);
		Produto produto2 = new Produto("5678",40);
		
		cart.adicionarProduto(produto1);
		cart.adicionarProduto(produto2);
		
		//Pagar com Paypal
		cart.pay(new PaypalStrategy("meuemail@example.com", "password"));
		
		//Pagar com cartão de crédito/débito
		cart.pay(new CartaoDeCreditoStrategy("Izaias Santos", "1234567890123456", "786", "12/15"));

		//Pagar com Pix
		cart.pay(new PixStrategy("=UkLHae4t9Y047"));
	}

}