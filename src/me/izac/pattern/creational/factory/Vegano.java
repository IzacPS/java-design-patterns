package me.izac.pattern.creational.factory;

public class Vegano extends Hamburguer {
    Vegano(){
        nome = "Hamburger Vegano";
        valor = 50.0f;
    }
    @Override
    public void preparar() {
        System.out.println("Preparando Hamburger Vegano.");
    }

}
