
O padrão de design Proxy define um substituto ou local de acesso
para que outro objeto possa ter controle. A ideia do design é
fornecer controle de acesso para uma funcionalidade a um objeto.

Suponha que exita uma classe que precisa rodar algum comando no 
sistema. Agora suponha que precisamos fornecer essa classe
para um cliente que também precisa executar esse comando. 
Precisamos tomar cuidado aqui pois esse comando pode conter
alguma ação de deletar alguma algo de importância no sistema,
ou fazer alguma alteração indesejada. Para isso, podemos 
criar uma classe utilizando o design Proxy para fornecer acesso
controlado aos comandos que serão utilizados no sistema.

Podemos pensar em um usuário do sistema que precisa executar
alguns comando. Podemos definir que somente usuários admin
em um certo diretório podem executar comandos.

```java
public interface ComandoExecutor {
    public void executarComando(String cmd) throws Exception;
}
```

```java
public class Comando implements ComandoExecutor {
    @Override
    public void executarComando(String cmd) throws Exception {
        //executa commando no sistema.
    }
}
```

```java
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
```

## Referências
https://www.digitalocean.com/community/tutorials/proxy-design-pattern
