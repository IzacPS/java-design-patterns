package me.izac.pattern.behavioral.strategy;

public class CartaoDeCreditoStrategy implements PagamentoStrategy {

	private String nome;
	private String numeroDoCartao;
	private String cvc;
	private String dataDeExpiracao;
	
	public CartaoDeCreditoStrategy(String nome, String numero, String cvc, String dataDeExpiracao){
		this.nome =nome;
		this.numeroDoCartao =numero;
		this.cvc = cvc;
		this.dataDeExpiracao =dataDeExpiracao;
	}
	@Override
	public void pagamento(int valor) {
		System.out.println(valor +" pago(s) com Cartão de Crédito/Debito");
	}

}