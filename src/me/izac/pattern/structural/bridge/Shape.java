package me.izac.pattern.structural.bridge;

public abstract class Shape {
    protected DrawDPI drawDPI;

    protected Shape(DrawDPI drawDPI){
        this.drawDPI = drawDPI;
    }
    public abstract void draw();
}
