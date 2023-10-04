package me.izac.pattern.structural.composite;

public class Triangulo implements Forma{
    @Override
    public void mover(int x, int y) {
        System.out.println("Triangulo movento " + x + " em x e " + y + " em y");
    }
}
