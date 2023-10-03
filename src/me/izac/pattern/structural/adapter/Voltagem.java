package me.izac.pattern.structural.adapter;

public class Voltagem {
    private int volts;
    public Voltagem(int volts){
        this.volts = volts;
    }

    public int getVolts(){
        return this.volts;
    }

    public void setVolts(int volts){
        this.volts = volts;
    }
}
