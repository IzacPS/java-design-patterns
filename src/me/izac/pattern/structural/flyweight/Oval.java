package me.izac.pattern.structural.flyweight;

import java.awt.*;

public class Oval implements Shape{
    private boolean fill;

    public Oval(boolean fill){
        this.fill = fill;
        System.out.println("Criando um objeto Oval " + ((this.fill) ? "com preenchimento" : "sem preenchimento"));
        //Adicionando um tempo de delay
        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){
            System.out.println("Thread erro: " + e.getMessage());
        }
    }

    @Override
    public void draw(Graphics g, int x, int y, int width, int height, Color color) {
        g.setColor(color);
        g.drawOval(x, y, width, height);
        if(this.fill){
            g.fillOval(x, y, width, height);
        }
    }
}
