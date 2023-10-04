package me.izac.pattern.structural.composite;

public class Quadrado implements Forma{
    @Override
    public void mover(int x, int y) {
        System.out.println("Quadrado movento " + x + " em x e " + y + " em y");
    }
}
