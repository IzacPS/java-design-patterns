# Padrões de Design - Flyweight

O padrão de design **Flyweight** é usado quando a é preciso criar muitos objetos de uma
de uma classe. Antes de utilizar esse padrão é preciso fazer algumas observações:
- Verificar se a quantidade de objetos é muito grande.
- A classe que será criada ocupará uma grande quantidade de memória e o seu tempo de
  criação é elevado.
- As propriedades da classe podem ser dividas em intrínseco, que torna o objeto
  com características únicas, e extrínseco que podem ser adicionadas pela aplicação.

Imagine algumas formas geométricas em uma aplicação como Círculos, Linhas etc. O formato
esses objetos são características intrínsecas. Já atributos como cor ou tamanho são
características intrínsecas.

Vamos imaginar então uma implementação do padrão **Flyweight** onde precisamos retornar
vários objetos compartilhados. No exemplo vamos desenhar formas geométricas como linhas e
formas ovais. Precisaremos então de uma interface base para as formas chamada ``Shape``.
Vamos implementar essa interface para as formas ``Line`` e ``Oval``. A propriedade intrínseca
de casa forma será definida no momento em que formos desenhar as formas indicado que tipo
será desenhado, se linha ou oval. O tipo oval também terá uma característica intrínseca do tipo
se será preenchida com cor ou não.

```java
public interface Shape {
    public void draw(Graphics g, int x, int y, int width, int height, Color color);
}
```
```java
public class Line implements Shape{
    
    //Construtor
    //Delay adicionado para simular uma classe que demora muito tempo para carregar

    @Override
    public void draw(Graphics g, int x, int y, int width, int height, Color color) {
        g.setColor(color);
        //Define o tipo que será desenhado como uma linha.
        g.drawLine(x, y, width, height);
    }
}
//...
public class Oval implements Shape{
    private boolean fill;

    //Delay adicionado para simular uma classe que demora muito tempo para carregar
    public Oval(boolean fill){
        //...
    }

    @Override
    public void draw(Graphics g, int x, int y, int width, int height, Color color) {
        g.setColor(color);
        //Define as características intrínsecas
        g.drawOval(x, y, width, height);
        if(this.fill){
            g.fillOval(x, y, width, height);
        }
    }
}
```
A classe ``ShapeFactory`` mantem referências de todos os objetos que serão gerados para a
aplicação. A aplicação cliente pode fazer uma chamada para ``getShape`` e uma forma com
o tipo especificado na chamada será retornado para o cliente. Assim ficaria o código da
classe ``ShapeFactory``:

```java
public class ShapeFactory {
    private static final HashMap<ShapeType, Shape> shapes = new HashMap<>();

    public static Shape getShape(ShapeType type){
        Shape shapeImpl = shapes.get(type);
        if(shapeImpl == null){
            shapeImpl = switch (type){
                case LINE -> new Line();
                case OVAL -> new Oval(false);
                case OVAL_FILL -> new Oval(true);
            };
            shapes.put(type, shapeImpl);
        }
        return shapeImpl;
    }

    public static enum ShapeType{
        OVAL_FILL, OVAL, LINE;
    }

}
```
Observe que a classe possui um mapeamento direto de um tipo para uma classe criada.
Uma aplicação cliente que consumirá a classe ``ShapeFactory`` com o padrão **Flyweight**
ficaria da seguinte forma:

```java
public class DrawingClient extends JFrame {
    private static final long serialVersionUID = -1350200437285282550L;
    private final int WIDTH;
    private final int HEIGHT;

    private static final ShapeFactory.ShapeType[] shapes = { ShapeFactory.ShapeType.LINE, ShapeFactory.ShapeType.OVAL_FILL, ShapeFactory.ShapeType.OVAL };
    private static final Color[] colors = {Color.RED, Color.GREEN, Color.YELLOW};

    public DrawingClient(int width, int height) {
        WIDTH = width;
        HEIGHT = height;
        Container contentPane = getContentPane();

        JButton startButton = new JButton("Draw");
        final JPanel panel = new JPanel();

        contentPane.add(panel, BorderLayout.CENTER);
        contentPane.add(startButton, BorderLayout.SOUTH);
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        startButton.addActionListener(e -> {
            Graphics g = panel.getGraphics();
            for(int i = 0; i < 20; i++){
                Shape shape = ShapeFactory.getShape(getRandomShape());
                shape.draw(g, getRandomX(), getRandomY(), getRandomWidth(), getRandomHeight(), getRandomColor());
            }
        });
    }

    //getters
}
```

A classe ``ShapeFactory`` fornece então todas as formas disponíveis. Observer que a classe
só cria uma nova forma, caso ela não esteja mapeada na variável ``shapes``. Caso exista,
o objeto é retornado e somente as características extrínsecas são alteradas, como cor,
posição e tamanho.



## Referências
- https://www.digitalocean.com/community/tutorials/flyweight-design-pattern-java
- https://medium.com/xp-inc/design-patterns-parte-13-flyweight-9f96433bce05



