package me.izac.pattern.behavioral.strategy;

public class PaypalStrategy implements PagamentoStrategy {

	private String emailId;
	private String password;
	
	public PaypalStrategy(String email, String pwd){
		this.emailId=email;
		this.password=pwd;
	}
	
	@Override
	public void pagamento(int valor) {
		System.out.println(valor + " Pago(s) com Paypal.");
	}

}