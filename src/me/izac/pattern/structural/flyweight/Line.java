package me.izac.pattern.structural.flyweight;

import java.awt.*;

public class Line implements Shape{
    public Line(){
        System.out.println("Criando uma linha");
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
        g.drawLine(x, y, width, height);
    }
}
