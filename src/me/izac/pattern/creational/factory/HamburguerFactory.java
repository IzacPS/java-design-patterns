package me.izac.pattern.creational.factory;

public class HamburguerFactory {
    public Hamburguer criarHamburger(TipoHamburguer tipo){
        return switch (tipo) {
            case ARTESANAL -> new Artesanal();
            case VEGANO -> new Vegano();
            case TRADICIONAL -> new Tradicional();
            default -> null;
        };
    }
}
