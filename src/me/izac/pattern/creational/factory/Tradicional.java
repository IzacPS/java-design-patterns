package me.izac.pattern.creational.factory;

public class Tradicional extends Hamburguer {
    Tradicional(){
        nome = "Hamburger Tradicional";
        valor = 40.0;
    }
    @Override
    public void preparar() {
        System.out.println("Preparando Hamburger Tradicional.");
    }

}
