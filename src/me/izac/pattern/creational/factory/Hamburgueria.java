package me.izac.pattern.creational.factory;

public class Hamburgueria {
    public Hamburguer fazerPedido(TipoHamburguer tipo){
        HamburguerFactory factory = new HamburguerFactory();
        Hamburguer hamburguer = factory.criarHamburger(tipo);
        hamburguer.preparar();
        return hamburguer;
    }

    public static void main(String[] args) {
        Hamburgueria hamburgueria = new Hamburgueria();
        TipoHamburguer tipo = TipoHamburguer.ARTESANAL;
        Hamburguer hamburguer = hamburgueria.fazerPedido(tipo);
        System.out.println(hamburguer.toString());
    }
}
