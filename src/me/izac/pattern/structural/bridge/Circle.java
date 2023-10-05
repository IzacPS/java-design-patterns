package me.izac.pattern.structural.bridge;

public class Circle extends Shape{
    private int x, y, radius;

    public Circle(int x, int y, int radius, DrawDPI drawDPI){
        super(drawDPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw() {
        drawDPI.drawCircle(radius, x, y);
    }
}
