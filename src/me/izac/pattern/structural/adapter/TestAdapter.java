package me.izac.pattern.structural.adapter;

public class TestAdapter {
    public static void main(String[] args) {
        TomadaAdapter carregadorAdapter = new Carregador();

        //seleciona a voltagem atual do carregador
        int voltagemSelecionada = 12;

        Voltagem voltagem = null;
        if(voltagemSelecionada == 3){
            voltagem = carregadorAdapter.get3Volts();
        }else if(voltagemSelecionada == 12){
            voltagem = carregadorAdapter.get12Volts();
        }else if(voltagemSelecionada == 110){
            voltagem = carregadorAdapter.get110Volts();
        }
        if(voltagem != null){
            System.out.println("Voltagem sendo utilizada pelo carregador: " + voltagem.getVolts());
        }
    }
}
