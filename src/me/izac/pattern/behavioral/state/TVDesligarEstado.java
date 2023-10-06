package me.izac.pattern.behavioral.state;

public class TVDesligarEstado implements Estado {

	@Override
	public void realizarAcao() {
		System.out.println("TV desligada!");
	}

}