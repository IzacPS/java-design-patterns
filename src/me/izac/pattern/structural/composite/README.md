# Padrões de Design - Composite

O padrão de design **Composite** é usado quando precisamos representar uma operação
para uma hierarquia de objetos como uma parte só, ou seja, quando objetos em uma
estrutura precisam se comportar da mesma maneira.

Imagina um software com um diagrama que possui várias objetos com formas diferentes,
como círculos, quadrados, triângulos, linhas etc. Imagina que precisamos mover vários
objetos de uma só vez. Geralmente, precisamos selecionar todos os objetos que precisamos
mover e após selecioná-los, podemos fazer o movimento dos mesmos. Essa ação de mover
os objetos é comum entre todos os objetos selecionados. Aqui nesse caso, podemos
utilizar o padrão de design Composite, já que vários objetos na hierarquia irão realizar
a mesma função.

O padrão Composite é formado pelos objetos **Base Component**, **Leaf** e **Composite**.

O objeto **Base Component** é a interface comum entre todos os objetos na composição.
No nosso exemplo o **Base Component** é a nossa interface ``Forma``.

````java
public interface Forma {
    public void mover(int x, int y);
}
````
O objeto **Leaf** define o comportamento dos elementos na composição. Esses objetos
são os alicerces do padrão e são os objetos que implementam a interface ``Forma``.
Esses objetos não possuem referências para outros componentes. No nosso exemplo,
as classes ``Circulo``, ``Quadrado`` e ``Triangulo`` são os objetos **Leaf**.

````java
public class Circulo implements Forma{
    @Override
    public void mover(int x, int y) {
        //Código para mover o Círculo
    }
}

public class Quadrado implements Forma{
    @Override
    public void mover(int x, int y) {
        //Código para mover o Quadrado
    }
}

public class Triangulo implements Forma{
    @Override
    public void mover(int x, int y) {
        //Código para mover o Triângulo
    }
}
````
O objeto **Composite** possui todos os elementos **Leaf** e também implementa as
operações da interface ``Forma``. No nosso exemplo a classe ``FormasSelecionadas`` é
o nosso objeto **Composite**.

````java
public class FormasSelecionadas implements Forma{
    private List<Forma> formas = new ArrayList<>();
    @Override
    public void mover(int x, int y) {
        //Move todas as formas
        for (Forma forma : formas){
            forma.mover(x, y);
        }
    }
}
````

Agora podemos adicionar todas as formas selecionadas a classe ``FormasSelecionadas`` e mover
todas as formas de uma vez só.

```java
public class TesteComposite {
    public static void main(String[] args) {
        Forma circulo = new Circulo();
        Forma quadrado = new Quadrado();
        Forma triangulo = new Triangulo();

        FormasSelecionadas formasSelecionadas = new FormasSelecionadas();
        formasSelecionadas.adicionarForma(circulo);
        formasSelecionadas.adicionarForma(quadrado);
        formasSelecionadas.adicionarForma(triangulo);

        formasSelecionadas.mover(10, 20);

        formasSelecionadas.removerTudo();
        formasSelecionadas.adicionarForma(quadrado);
        formasSelecionadas.adicionarForma(triangulo);

        formasSelecionadas.mover(-15, 10);

    }
}
```

## Referências
- https://www.digitalocean.com/community/tutorials/composite-design-pattern-in-java
- https://medium.com/xp-inc/desing-patterns-parte-10-composite-f7600cb3aad7
- https://www.tutorialspoint.com/design_pattern/composite_pattern.htm



