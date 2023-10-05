package me.izac.pattern.behavioral.chainofresponsability;

import java.util.Scanner;

public class TesteChainOfResponsability {

    public static void main(String [] args){
        CaixaEletronico caixa = new CaixaEletronico();

        while(true){
            int quantidade = 0;
            System.out.println("Entre com a quantidade para sacar: ");
            Scanner input = new Scanner(System.in);
            quantidade = input.nextInt();
            if(quantidade % 10 != 0){
                System.out.println("A quantidade deve ser um multiplo de 10.");
                return;
            }
            caixa.getGaveta().retirar(new Dinheiro(quantidade));
        }
    }
}
