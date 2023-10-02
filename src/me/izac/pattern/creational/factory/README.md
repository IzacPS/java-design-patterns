# Padrões de Design - Factory

O padrão de design Factory é usado em situações onde existe uma superclasse com 
várias subiclasses e baseado em uma entrada, precisamos retornar uma dessas
subclasses. Esse padrão tira a responsabilidade criar instâncias da classe cliente
para a classe conhecida como *factory*.

Como exemplo, podemos pensar em uma Hamburgueria que possui vários tipos de hambúrguer
como artesanal, tradicional e vegano. Podemos criar uma superclasse Hamburguer e as
suas respectivas sublasses Artesanal, Tradicional e Vegano que implementam o método
abstrato **preparar()**.

Podemos criar uma classe chamada Hamburgueria repsonsável por receber o pedido de um
tipo de Hamburguer e prepará-lo.

```java
public class Hamburgueria {
    public Hamburguer fazerPedido(TipoHamburguer tipo){
       //Criação do hamburguer de acordo com o tipo especificado no perido  
        Hamburger hamburger = switch (tipo) {
            case ARTESANAL -> new Artesanal();
            case VEGANO -> new Vegano();
            case TRADICIONAL -> new Tradicional();
            default -> null;
        };
        
        //Prepara o hamburger 
        hamburguer.preparar();
        return hamburguer;
    }
}
```

Podemos serguir o Single Responsibility Principle (SRP), em português, Princípio da
Responsabilidade Única e isolarmos a criação do Hamburguer em sua propria classe. 
Aqui podemos utilizar o design Factory como a classe de criação do Hamburger de 
acordo com o tipo.

````java
public class HamburguerFactory {
    public Hamburguer criarHamburger(TipoHamburguer tipo){
        return switch (tipo) {
            case ARTESANAL -> new Artesanal();
            case VEGANO -> new Vegano();
            case TRADICIONAL -> new Tradicional();
            default -> null;
        };
    }
}
````

Agora se precisarmos fazer alguma alteração como adicionar um novo tipo de Hamburger,
não precisamos alterar nada na classe Hamburgueria. Veja como ficou abaixo o método
**fazerPedido** com as mudanças de responsabilidade. 

````java
public class Hamburgueria {
    public Hamburguer fazerPedido(TipoHamburguer tipo){
        
        //Criação de um novo Hamburguer a partir do tipo
        HamburguerFactory factory = new HamburguerFactory();
        Hamburguer hamburguer = factory.criarHamburguer(tipo);
       
        //Preparar o Hamburger
        hamburguer.preparar();
        return hamburguer;
    }
}
````

Mudando a responsabilidade de criação de um novo tipo de Hamburguer para a classe
HamburguerFactory deixou o nosso código de pedido mais limpo e mais modular, já que
as responsabilidades estão distribuídas de forma específica entre as classes.

Esse é um exemplo de utilização do padrão de design Factory. Mais informações sobre
o padrão podem ser encontradas nas referências abaixo.

## Referencias

 - https://www.digitalocean.com/community/tutorials/factory-design-pattern-in-java
 - https://www.youtube.com/watch?v=EdFq_JIThqM&t=385s