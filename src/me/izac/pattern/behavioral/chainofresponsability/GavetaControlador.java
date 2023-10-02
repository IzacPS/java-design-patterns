package me.izac.pattern.behavioral.chainofresponsability;

public interface GavetaControlador {

    void setProximaCeculaControlador(GavetaControlador proximo);

    void retirar(Dinheiro dinheiroAtual);
}


