package me.izac.pattern.creational.factory;

public class Artesanal extends Hamburguer {

    Artesanal(){
        nome = "Hamburger Artesanal";
        valor = 35.0;
    }

    @Override
    public void preparar() {
        System.out.println("Preparando Hamburger Artesanal.");
    }
}
