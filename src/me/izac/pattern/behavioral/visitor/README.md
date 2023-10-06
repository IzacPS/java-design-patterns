# Padrões de Design - Visitor

O padrão de design **Visitor** utilizamos um objeto que mudará a 
execução do algoritmo de um elemento. A execução desse algoritmo
varia então de acordo com esse objeto. Esse objeto é conhecido como 
visitor. Com isso, podemos mover logica operacional de um objeto 
para outro.

Imagine que temos um carrinho de compras que podemos adicionar 
diferentes produtos. Quando clicamos para finalizar a compra, o
valor tota dos produtos é calculado e mostrado a nós. Se pensarmos
em uma classe do tipo produto e que podem haver vários produtos do 
mesmo tipo dentro do carrinho, podemos calcular o valor total desses
produtos dentro da propria classe. Podemos mover todo esse calculo
dos valores dos produtos para uma classe separada. Essa separação,
é a ideia principal do padrão visitor.

No nosso exemplo precisamos de vários tipos diferentes de produtos.
Podemos criar uma interface ``Produto`` que possui um método ``aceitar``
que recebe um ``CarrinhoDecomprasVisitor``.

```java
public interface Produto {
	public int aceitar(CarrinhoDeComprasVisitor visitor);
}
```

Podemos criar alguns produtos concretos a partir da interface ``Produto``.
A implementação do método ``aceitar`` chama o método ``visit`` do
visitor e passa a si mesmo como argumento. A interface ``CarrinhoDeComprasVisitor``
possui um método ``visit`` para os diferentes tipos de produtos.

```java
public class Fruta implements Produto {
	private int preco;
	private int peso;
	private String nome;
	
	public Fruta(int preco, int peso, String nome){
		this.preco = preco;
		this.peso = peso;
		this.nome = nome;
	}
    
    //getters
	
	@Override
	public int aceitar(CarrinhoDeComprasVisitor visitor) {
		return visitor.visit(this);
	}
}
```

```java
public class Livro implements Produto {

	private int preco;
	private String isbn;
	
	public Livro(int preco, String isbn){
		this.preco=preco;
		this.isbn=isbn;
	}
    
    //getters
	
	public int aceitar(CarrinhoDeComprasVisitor visitor) {
		return visitor.visit(this);
	}
}
```
A nossa interface visitor ficaria então como:

```java
public interface CarrinhoDeComprasVisitor {

	int visit(Livro livro);
	int visit(Fruta fruta);
}
```

Agora podemos implementar a interface ``CarrinhoDeComprasVisitor``
onde cada método ``visit`` terá a lógica necessária para calcular
o valor de cada produto e retornar o preço.

```java
public class CarrinhoDeCompras implements CarrinhoDeComprasVisitor {

	@Override
	public int visit(Livro livro) {
		int valor = 0;
		//aplica 5$ de desconto se o livro for maior que 50
		if(livro.getPreco() > 50){
			valor = livro.getPreco() - 5;
		}else
			valor = livro.getPreco();
		System.out.println("Livro ISBN::"+ livro.getIsbn() + " valor ="+valor);
		return valor;
	}

	@Override
	public int visit(Fruta fruta) {
		int valor = fruta.getPreco()* fruta.getPeso();
		System.out.println(fruta.getNome() + " valor = "+valor);
		return valor;
	}

}
```
Para testar o padrão, podemos criar uma lista de produtos e calcular
o valor total no carrinho.

```java
public class TesteVisitor {

	public static void main(String[] args) {
		Produto[] items = new Produto[]{new Livro(20, "1234"),new Livro(100, "5678"),
				new Fruta(10, 2, "Banana"), new Fruta(5, 5, "Maçã")};

		CarrinhoDeComprasVisitor visitor = new CarrinhoDeCompras();
		
		int total=0;
		for(Produto item : items){
			total = total + item.aceitar(visitor);
		}
		System.out.println("Custo total = " + total);
	}
}
```

## Referências
- https://medium.com/xp-inc/design-patterns-parte-25-visitor-159f8fc14e56
- https://www.digitalocean.com/community/tutorials/visitor-design-pattern-java
- https://www.tutorialspoint.com/design_pattern/visitor_pattern.htm