package me.izac.pattern.behavioral.state;

public class TVContext implements Estado {

	private Estado tvEstado;

	public void setEstado(Estado estado) {
		this.tvEstado = estado;
	}

	public Estado getState() {
		return this.tvEstado;
	}

	@Override
	public void realizarAcao() {
		this.tvEstado.realizarAcao();
	}

}