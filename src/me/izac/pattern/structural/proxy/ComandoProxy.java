package me.izac.pattern.structural.proxy;

public class ComandoProxy implements ComandoExecutor{
    private boolean ehAdmin;
    private ComandoExecutor executor;

    public ComandoProxy(String usuario, String pwd){
        if("izac".equals(usuario) && "/home/izac".equals(pwd))
            ehAdmin = true;
        executor = new Comando();
    }

    @Override
    public void executarComando(String cmd) throws Exception {
        if(ehAdmin){
            executor.executarComando(cmd);
        }else {
            throw new Exception("Usuário não tem permissão para rodar commandos");
        }
    }
}
