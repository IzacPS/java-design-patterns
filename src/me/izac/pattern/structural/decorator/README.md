# Padrões de Design - Decorator

O padrão de design **Decorator** é usado para modificar a funcionalidade de um objeto
durante a execução. Ao mesmo tempo, outras instâncias da mesma classe não serão afetadas
por essa modificação.

Por exemplo, suponha que é preciso implementar diferentes modelos de carros. Podemos
criar uma interface ``Carro``. Podemos ter vários modelos de carros a partir da interface
``Carro``, como um modelo básico, esportivo e de luxo.

Para implementarmos o exemplo precisamos então tipos:

- Uma interface de componente, podendo ser uma interface ou uma classe abstrata.
  No nosso caso a interface ``Car``.
```java
public interface Car {
    public void assemble();
}
```

- O componente de implementação que irá implementar a interface do componente. No nosso
  exemplo será a classe ``BasicCar``.
```java
 public class BasicCar implements Car{
    @Override
    public void assemble() {
        System.out.println("Basic Car.");
    }
}
```
- Uma classe do tipo **Decorator** que implementa o componentes de interface e tem uma relação
  do tipo "tem um" com a interface de componente. A variável do componente deve ser acessível
  pelos filhos da classe do tipo **Decorator**.o
```java
public class CarDecorator implements Car{
    protected Car car;

    public CarDecorator(Car car){
        this.car = car;
    }

    @Override
    public void assemble() {
        this.car.assemble();
    }
}
```

- Os tipos **Decorators** concretos que estendem da classe do tipo **Decorator**, no nosso caso
  a classe ``CarDecorator`` e pode modificar o seu comportamento. No nosso exemplo temos as classes
  ``LuxuryCar`` e ``SportsCar`` como tipos **Decorator** concretos.

```java
public class LuxuryCar extends CarDecorator{
    public LuxuryCar(Car car){
        super(car);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println(" Personalizando para um carro de luxo (Luxury Car)");
    }
}

public class SportsCar extends CarDecorator{
    public SportsCar(Car car){
        super(car);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println(" Personalizando para um carro esportivo (Sports Car)");
    }
}
```
Agora podemos testar pegando um carro básico e transformando em um carro esportivo e a partir
de um carro básico, criar um esportivo de luxo.

```java
public class TesteDecorator {
    public static void main(String[] args) {
        Car sportsCar = new SportsCar(new BasicCar());
        sportsCar.assemble();
        System.out.println();
        Car sportsLuxuryCar = new SportsCar(new LuxuryCar(new BasicCar()));
        sportsLuxuryCar.assemble();
    }
}
```
## Referências

- https://www.digitalocean.com/community/tutorials/decorator-design-pattern-in-java-exampleo
- https://medium.com/xp-inc/desing-patterns-parte-11-decorator-ba348f44142f
- https://www.tutorialspoint.com/design_pattern/decorator_pattern.htm


