# Padrões de Design - Singleton

O padrão de design **Singleton** restringe a instância de uma classe a somente uma
instância dessa classe durante a execução do programa. A classe ``Singleton`` fornece
um ponto de acesso global para a instância da classe.
Para implementarmos o padrão **Singleton** precisamos nos certificar de que a classe
não será instanciada tornando o construtor default, privado. A classe ``Singleton`` deve ter
um atributo privado *static* do mesmo tipo da classe e um método
*static* para acessar esse atributo. Esse método é o ponto de acesso à instância ``Singleton``
da classe. Existem várias abordagens para a criação de uma classe ``Singleton`` na linguagem **Java**.
Algumas dessas abordagens podem ser vistas abaixo:

- **Eager Initialization**. Nessa abordagem a instância da classe ``Singleton`` é criada no
  momento em que a classe é carregada em memória. Um problema que pode ser visto com essa 
abordagem é a criação de uma instância ``Singleton`` da classe mesmo que a aplicação não 
esteja a utilizando naquele momento.
````java
public class EagerSingleton {
    //Eager Initialization. A variável Instance é criada no momento de carga da classe
    private static final EagerSingleton instance = new EagerSingleton();

    //Construtor Privado para que a classe não seja instanciada
    private EagerSingleton(){}
    
    //Ponto de acesso à instância Singleton da classe EagerSingleton
    public static EagerSingleton getInstance(){
        return instance;
    }
}
````

- **Inicialização em um bloco static**. Esse modelo utiliza o bloco static como
  bloco de inicialização. Esse bloco é executado apenas uma vez, no primeiro momento
  em que a classe é carregada em memória. Isso torna esse modelo parecido com o modelo
  **Eager Initialization**. A diferença é que dentro do bloco static é possível verificar por
  exceções na inicialização da instância.
````java
 public class StaticBlockSingleton {
    //Instância da classe 
    private static final StaticBlockSingleton instance;

    //Construtor Privado para que a classe não seja instanciada
    private StaticBlockSingleton(){}

    //Bloco static
    static {
        try{
            instance = new StaticBlockSingleton();
        }catch (Exception e){
            throw new RuntimeException("Uma exceção ocorreu na criação da instância");
        }
    }

    //Ponto de acesso à instância Singleton da classe EagerSingleton
    public static StaticBlockSingleton getInstance(){
        return instance;
    }

}
````
- **Lazy Initialization**. Nesse modelo a instância é criada somente no primeiro
  momento que for requisitado o acesso à instância pelo método de acesso. Essa abordagem
  pode não funcionar muito bem se for uma implementação multi-threaded  onde várias threads
  tem acesso à mesma instância ``Singleton``.
````java
public class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton(){}

    public static LazySingleton getInstance(){
        if(instance == null)
            instance = new LazySingleton();
        
        return instance;
    }
}
````
- **Thread Safe Lazy Singleton**. Como vimos, a implementação utilizando o **Lazy
  Singleton** tem a garantia de funcionar bem para implementações single-threaded.
  Para utilizarmos o Lazy Singleton em um ambiente multi-threaded precisamos fornecer
  thread-safety para o método de acesso a instância da classe ``Singleton``. Podemos tornar
  o método de acesso ``getInstance`` thread-safe utilizando a palavra reservada
  ``synchronized``. Com isso o acesso global ao método ``getInstance`` só será feito por apenas
  uma thread por vez. O acesso a instância da classe é garantido a apenas uma thread por
  vez, mas pode se notar um problema em performance, já que cada vez que uma thread for
  acessar o método ``getInstance`` marcado como synchronized é necessário adquirir um lock
  para que a thread possa utilizar o método. Com isso, as demais threads precisam esperar que o
  lock seja liberado para também poder acessar o método. Podemos utilizar o método
  [double-checked locking](https://www.baeldung.com/java-singleton-double-checked-locking)
  para obtermos um ganho de performance nesse cenário. Esse método foi implementado
  na função ``getInstanceUsingDoubleLocking()``.
  O método double-checked locking primeiro verifica se a instância é nula e só então um bloco
  ``synchronized`` é criado para adquirir o lock para que só então seja criada uma nova
  instância da classe. Observer que ainda precisamos checar dentro do bloco se a instância
  é nula para garantir que só criaremos uma nova instância se a variável for realmente nula.

````java
public class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton(){}
    
    //Utilizando o método thread-safe
    public static synchronized ThreadSafeSingleton getInstance(){
        if(instance == null)
            instance = new ThreadSafeSingleton();
        return instance;
    }
    
    //Utilizando um double-checked locking com um bloco thread-safe
    public static ThreadSafeSingleton getInstanceUsingDoubleLocking(){
        if(instance == null){
            //Bloco thread-safe
            synchronized (ThreadSafeSingleton.class){
                //Precisa chegar uma segunda fez dentro do bloco para garantir
                //que a instância é realmente null.
                if(instance == null){
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }
} 
````
Além dessas implementações, diversas outras podem ser encontradas, como o modelo
Bill Pugh utilizado em implementações utilizando versões posteriores ao java 5,
o modelo **Enum Singleton** entre outros. Para ver sobre outras implementações visite o
artigo [Java Singleton Design Pattern Best Practices with Examples](https://www.digitalocean.com/community/tutorials/java-singleton-design-pattern-best-practices-examples).

## Referências
- https://www.baeldung.com/java-singleton-double-checked-locking
- https://www.digitalocean.com/community/tutorials/java-singleton-design-pattern-best-practices-examples
- https://dzone.com/articles/java-singletons-using-enum
- https://www.callicoder.com/java-singleton-design-pattern-example/



