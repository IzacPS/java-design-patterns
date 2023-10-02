package me.izac.pattern.creational.factory;

public abstract class Hamburguer {
    protected String nome;
    protected double valor;
    abstract public void preparar();

    @Override
    public String toString() {
        return "Hamburger{" +
                "nome='" + nome + '\'' +
                ", valor=" + valor +
                '}';
    }
}
