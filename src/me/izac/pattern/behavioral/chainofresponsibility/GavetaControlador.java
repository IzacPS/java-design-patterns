package me.izac.pattern.behavioral.chainofresponsibility;

public interface GavetaControlador {

    void setProximaCeculaControlador(GavetaControlador proximo);

    void retirar(Dinheiro dinheiroAtual);
}


