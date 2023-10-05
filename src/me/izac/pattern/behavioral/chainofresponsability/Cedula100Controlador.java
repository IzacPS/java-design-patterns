package me.izac.pattern.behavioral.chainofresponsability;

public class Cedula100Controlador implements GavetaControlador {
    private GavetaControlador cadeia;
    @Override
    public void setProximaCeculaControlador(GavetaControlador proximo) {
        this.cadeia = proximo;
    }

    @Override
    public void retirar(Dinheiro dinheiroAtual) {
        if(dinheiroAtual.getQuantidade() >= 100){
            int num = dinheiroAtual.getQuantidade()/100;
            int resto = dinheiroAtual.getQuantidade() % 100;
            System.out.println("Retirando " + num + " cédula(s) de 100R$");
            if(resto != 0) this.cadeia.retirar(new Dinheiro(resto));
        }else{
            this.cadeia.retirar(dinheiroAtual);
        }
    }
}
