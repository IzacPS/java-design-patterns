package me.izac.pattern.behavioral.chainofresponsability;

import java.util.Scanner;

public class CaixaEletronico {
    private GavetaControlador gaveta;

    public CaixaEletronico(){
         GavetaControlador cedula100 = new Cedula100Controlador();
        GavetaControlador cedula50 = new Cedula100Controlador();
        GavetaControlador cedula20 = new Cedula100Controlador();
        GavetaControlador cedula10 = new Cedula100Controlador();

        this.gaveta = cedula100;
        cedula100.setProximaCeculaControlador(cedula50);
        cedula50.setProximaCeculaControlador(cedula20);
        cedula20.setProximaCeculaControlador(cedula10);
    }

    public static void main(String [] args){
        CaixaEletronico caixa = new CaixaEletronico();

        while(true){
            int quantidade = 0;
            System.out.println("Entre com a quantidade para sacar.");
            Scanner input = new Scanner(System.in);
            quantidade = input.nextInt();
            if(quantidade % 10 != 0){
                System.out.println("A quantidade deve ser um multiplo de 10.");
                return;
            }
            caixa.gaveta.retirar(new Dinheiro(quantidade));
        }
    }
}
