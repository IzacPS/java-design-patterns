# Padrões de Design - Proxy

O padrão de design **Proxy** define um substituto ou local de acesso
para que outro objeto possa ter controle. A ideia do design é
fornecer controle de acesso para uma funcionalidade a um objeto.

Suponha que exista uma classe que precisa rodar algum comando no
sistema. Agora suponha que precisamos fornecer essa classe
para um cliente que também precisa executar esse comando.
Precisamos tomar cuidado aqui pois esse comando pode conter
alguma ação de deletar alguma algo de importância no sistema,
ou fazer alguma alteração indesejada. Para isso, podemos
criar uma classe utilizando o design **Proxy** para fornecer acesso
controlado aos comandos que serão utilizados no sistema.

Podemos pensar em um usuário do sistema que precisa executar
alguns comandos. Podemos definir que somente usuários admin
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
        //Executa comando no sistema.
    }
}
```
Agora precisamos limitar o acesso ao local "/home/izac" para usuários que não sejam admin. A classe
``ComandoProxy`` implementa um ComandoExecutor e na função ``executarComando`` verifica se o
usuário é admin. Se o
usuário for admin então ele terá acesso ao local e poderá executar comandos de admin nesse local.
Caso contrário esse usuário será notificado que ele não tem permissão para executar o comando.

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
            throw new Exception("Usuário não tem permissão para rodar comandos");
        }
    }
}
```

Como pode ser visto, esse padrão é comumente utilizado em situações que é necessário dar controle
de acesso a algum recurso e é preciso uma abstração para tal.

## Referências
- https://www.digitalocean.com/community/tutorials/proxy-design-pattern



