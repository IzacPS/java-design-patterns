package me.izac.pattern.structural.proxy;

public class Comando implements ComandoExecutor {
    @Override
    public void executarComando(String cmd) throws Exception {
        //executa commando no sistema.
        System.out.println("Comando '" + cmd + "' executado.");
    }
}
