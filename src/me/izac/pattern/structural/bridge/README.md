# Padrões de Design - Bridge

O padrão de design **Bridge** é um padrão que permite dividir uma classe ou um grande
conjunto de classes estreitamente relacionadas nas hierarquias de abstração e
implementação onde os dois podem variar de forma independente. O padrão traz a ideia
de utilizar composição sobre herança.

O padrão possui uma interface que age como uma ponte que torna a funcionalidade de
classes concretas, independente das classes que implementam a interface.

Podemos exemplificar com uma interface ``DrawDPI`` que age como uma ponte que implementa
as classes ``RedCircle``, ``GreenCircle``. ``Shape`` é uma classe abstrata que usará
o objeto do tipo ``DrawDPI``.

```java
public interface DrawDPI {
    public void drawCircle(int radius, int x, int y);
}
```

```java
public class GreenCircle implements DrawDPI{
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: green, radius: " + radius + ", x: " + x + ", " + y + "]");
    }
}

```

```java
public class RedCircle implements DrawDPI{
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: red, radius: " + radius + ", x: " + x + ", " + y + "]");
    }
}
```

Criamos agora uma classe ``Shape`` que irá utilizar a ponte ``DrawApi``:

```java
public abstract class Shape {
    protected DrawDPI drawDPI;

    protected Shape(DrawDPI drawDPI){
        this.drawDPI = drawDPI;
    }
    public abstract void draw();
}
```

Agora criamos um objeto concreto ``Circle`` que irá implementar a classe ``Shape``:
```java
public class Circle extends Shape{
    private int x, y, radius;

    public Circle(int x, int y, int radius, DrawDPI drawDPI){
        super(drawDPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw() {
        drawDPI.drawCircle(radius, x, y);
    }
}
```
Agora podemos criar tipos de círculos diferentes utilizando como ponte ``DrawApi`` implementada
pelas classes ``RedCircle`` e ``GreenCircle``:

```java
public class TesteBridge {
    public static void main(String[] args) {
        Shape redCircle = new Circle(100, 100, 10, new RedCircle());
        Shape greenCircle = new Circle(100, 100, 10, new GreenCircle());

        redCircle.draw();
        greenCircle.draw();
    }
}

```
## Referências

- https://www.tutorialspoint.com/design_pattern/bridge_pattern.htm
- https://medium.com/xp-inc/desing-patterns-parte-9-bridge-5ca127f72de
- https://www.digitalocean.com/community/tutorials/bridge-design-pattern-java


