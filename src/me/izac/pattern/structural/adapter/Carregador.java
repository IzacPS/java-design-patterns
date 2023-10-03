package me.izac.pattern.structural.adapter;

public class Carregador extends Tomada implements TomadaAdapter {
    @Override
    public Voltagem get110Volts() {
        return getVoltagem();
    }

    @Override
    public Voltagem get12Volts() {
    return converterVoltagem(getVoltagem(), 9);
    }

    @Override
    public Voltagem get3Volts() {
        return converterVoltagem(getVoltagem(), 36);
    }

    private Voltagem converterVoltagem(Voltagem v, int i){
        return new Voltagem(v.getVolts()/i);
    }
}
