package me.izac.pattern.structural.proxy;

public class TestProxy {
    public static void main(String[] args) {
        ComandoExecutor executor = new ComandoProxy("izac", "/home/izac");
        try{
            executor.executarComando("ls - ltr");
            executor.executarComando("rm - rf abc.pdf");
        }catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
