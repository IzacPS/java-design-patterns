package me.izac.pattern.structural.composite;

public class Circulo implements Forma{
    @Override
    public void mover(int x, int y) {
        System.out.println("Circulo movento " + x + " em x e " + y + " em y");
    }
}
