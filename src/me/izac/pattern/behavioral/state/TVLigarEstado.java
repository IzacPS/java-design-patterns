package me.izac.pattern.behavioral.state;

public class TVLigarEstado implements Estado {

	@Override
	public void realizarAcao() {
		System.out.println("TV ligada!");
	}

}