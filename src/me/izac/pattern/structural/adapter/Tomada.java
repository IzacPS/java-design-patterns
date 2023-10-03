package me.izac.pattern.structural.adapter;

public class Tomada {
    public Voltagem getVoltagem(){
        return new Voltagem(110);
    }
}
