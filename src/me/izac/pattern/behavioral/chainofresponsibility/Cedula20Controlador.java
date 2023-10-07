package me.izac.pattern.behavioral.chainofresponsibility;

public class Cedula20Controlador implements GavetaControlador {
    private GavetaControlador cadeia;
    @Override
    public void setProximaCeculaControlador(GavetaControlador proximo) {
        this.cadeia = proximo;
    }

    @Override
    public void retirar(Dinheiro dinheiroAtual) {
        if(dinheiroAtual.getQuantidade() >= 20){
            int num = dinheiroAtual.getQuantidade()/20;
            int resto = dinheiroAtual.getQuantidade() % 20;
            System.out.println("Retirando " + num + " cédula(s) de 20R$");
            if(resto != 0) this.cadeia.retirar(new Dinheiro(resto));
        }else{
            this.cadeia.retirar(dinheiroAtual);
        }
    }
}
