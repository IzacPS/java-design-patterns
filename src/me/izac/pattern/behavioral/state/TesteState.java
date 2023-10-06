package me.izac.pattern.behavioral.state;

public class TesteState {
	public static void main(String[] args) {
		TVContext context = new TVContext();
		Estado tvStartEstado = new TVLigarEstado();
		Estado tvStopState = new TVDesligarEstado();
		
		context.setEstado(tvStartEstado);
		context.realizarAcao();
		
		context.setEstado(tvStopState);
		context.realizarAcao();
	}
}