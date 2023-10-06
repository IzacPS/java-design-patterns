# Padrões de Design - Template Method

O padrão de design **Template Method** define os passos para a execução de um algoritmo
em uma superclasse e pode fornecer uma implementação padrão comum para todas as subclasses.
As subclasses podem sobrescrever as etapas de implementação da superclasse de 
acordo com a necessidade.

Podemos exemplificar o padrão com a estrutura de um jogo qualquer. O jogo pode ser inicializado,
os jogadores então podem começar a jogar e o jogo posteriormente tem seu fim. Criamos então
uma classe abstrata ``Game`` que terá os métodos abstratos ``initialize``, ``beginPlay`` e ``endPlay``
que serão implementados pelas classes que representam um tipo concreto de jogo. A classe `` Game``
possui o método ``play`` que é responsável por executar essas ações de estado do jogo.

```java
public abstract class Game {
    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    public final void play(){
        initialize();
        startPlay();
        endPlay();
    }
}
```
Cada classe concreta terá então seu tipo de ação específica para o jogo. No nosso exemplo tempos
as classes  que representam os jogos ``Basketball``, ``Football`` e ``Tenis``.

```java
public class Basketball extends Game {

    @Override
    void endPlay() {
        System.out.println("Jogo de Basketball finalizado!");
    }

    @Override
    void initialize() {
        System.out.println("Jogo de Basketball inicializado! Comece a jogar.");
    }

    @Override
    void startPlay() {
        System.out.println("Jogo de Basketball começou. Divirta-se!");
    }
}
```
```java
public class Football extends Game {

    @Override
    void endPlay() {
        System.out.println("Jogo de Futebol finalizado!");
    }

    @Override
    void initialize() {
        System.out.println("Jogo de Futebol inicializado! Comece a jogar.");
    }

    @Override
    void startPlay() {
        System.out.println("Jogo de Futebol começou. Divirta-se!");
    }
}
```
```java
public class Tenis extends Game {

    @Override
    void endPlay() {
        System.out.println("Jogo de Tênis finalizado!");
    }

    @Override
    void initialize() {
        System.out.println("Jogo de Tênis inicializado! Comece a jogar.");
    }

    @Override
    void startPlay() {
        System.out.println("Jogo de Tênis começou. Divirta-se!");
    }
}
```

Agora podemos criar três tipos de jogos diferentes utilizando o mesmo template da classe
```Game```.

```java
public class TesteTemplateMethod {
    public static void main(String[] args) {

        Game game = new Football();
        game.play();
        System.out.println();
        game = new Basketball();
        game.play();
        System.out.println();
        game = new Tenis();
        game.play();
    }
}

```

## Referências
- https://www.tutorialspoint.com/design_pattern/template_pattern.htm
- https://medium.com/xp-inc/design-patterns-parte-24-template-method-69e3a7927dcd
- https://www.digitalocean.com/community/tutorials/template-method-design-pattern-in-java