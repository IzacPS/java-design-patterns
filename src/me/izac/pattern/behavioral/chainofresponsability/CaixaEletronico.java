package me.izac.pattern.behavioral.chainofresponsability;

import java.util.Scanner;

public class CaixaEletronico {
    private GavetaControlador gaveta;

    public CaixaEletronico(){
         GavetaControlador cedula100 = new Cedula100Controlador();
        GavetaControlador cedula50 = new Cedula50Controlador();
        GavetaControlador cedula20 = new Cedula20Controlador();
        GavetaControlador cedula10 = new Cedula10Controlador();

        //Valor inicial da corrente
        this.gaveta = cedula100;
        cedula100.setProximaCeculaControlador(cedula50);
        cedula50.setProximaCeculaControlador(cedula20);
        cedula20.setProximaCeculaControlador(cedula10);
    }

    public GavetaControlador getGaveta() {
        return gaveta;
    }
}
