package me.izac.pattern.behavioral.strategy;

public class PixStrategy implements PagamentoStrategy {

	private String chave;

	public PixStrategy(String chave){
		this.chave=chave;
	}
	
	@Override
	public void pagamento(int valor) {
		System.out.println(valor + " Pago(s) com Pix.");
	}

}