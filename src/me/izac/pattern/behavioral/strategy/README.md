# Padrões de Design - Strategy

O padrão de design **Strategy** define uma família de algoritmos que são implementadas em diferentes
classes. A aplicação então pode escolher qual dos algoritmos irá utilizar criando um objeto do
tipo de classe específico do algoritmo. Em java, temos como exemplo o método ``sort`` em
``Collections`` que recebe como parâmetro um objeto do tipo ``Comparator``. Assim, o algoritmo
funciona de maneira diferente para cada diferente implementação do ``Comparator`` recebido.

Podemos pegar como exemplo um carrinho de compras onde temos diferentes formas de pagamento.
As diferentes formas de pagamento são as nossas estratégias. Criamos então a interface
``PagamentoStrategy`` que possui o método pagar.

```java
public interface PagamentoStrategy {

	public void pagamento(int valor);
}
```

Criamos então diferentes classes concretas com formas de pagamento como cartão de crédito,
paypal e pix.

```java
public class CartaoDeCreditoStrategy implements PagamentoStrategy {

	private String nome;
	private String numeroDoCartao;
	private String cvc;
	private String dataDeExpiracao;
	
	public CartaoDeCreditoStrategy(String nome, String numero, String cvc, String dataDeExpiracao){
		this.nome =nome;
		this.numeroDoCartao =numero;
		this.cvc = cvc;
		this.dataDeExpiracao =dataDeExpiracao;
	}
	@Override
	public void pagamento(int valor) {
		System.out.println(valor +" pago(s) com Cartão de Crédito/Debito");
	}

}
```
```java
public class PaypalStrategy implements PagamentoStrategy {

	private String emailId;
	private String password;
	
	public PaypalStrategy(String email, String pwd){
		this.emailId=email;
		this.password=pwd;
	}
	
	@Override
	public void pagamento(int valor) {
		System.out.println(valor + " Pago(s) com Paypal.");
	}

}
```

```java
public class PixStrategy implements PagamentoStrategy {

	private String chave;

	public PixStrategy(String chave){
		this.chave=chave;
	}
	
	@Override
	public void pagamento(int valor) {
		System.out.println(valor + " Pago(s) com Pix.");
	}

}
```

Criamos agora uma classe produto que terá um preço e código de barras.

```java
public class Produto {

	private String codigoDeBarras;
	private int preco;
	
	public Produto(String codigoDeBarras, int preco){
		this.codigoDeBarras = codigoDeBarras;
		this.preco = preco;
	}

	public String getCodigoDeBarras() {
		return codigoDeBarras;
	}

	public int getPreco() {
		return preco;
	}
}
```

Agora podemos criar uma classe que representa um carrinho de compras que pode adicionar e
remover produtos. a classe possui um método para calcular o valor total dos produtos e
um método para pagar o valor. Esse método recebe como parâmetro um objeto concreto como
estratégia de pagamento.

```java
public class CarrinhoDeCompras {

	//Lista de produtos
	List<Produto> produtos;
	
	public CarrinhoDeCompras(){
		this.produtos =new ArrayList<>();
	}
	
	public void adicionarProduto(Produto produto){
		this.produtos.add(produto);
	}
	
	public void removerProduto(Produto produto){
		this.produtos.remove(produto);
	}
	
	public int calculatarTotal(){
		int sum = 0;
		for(Produto produto : produtos){
			sum += produto.getPreco();
		}
		return sum;
	}
	
	public void pay(PagamentoStrategy paymentMethod){
		int valor = calculatarTotal();
		paymentMethod.pagamento(valor);
	}
}
```

Agora podemos testar o padrão criando o carrinho de compras e adicionando alguns produtos.
Depois, podemos demonstrar fazendo o pagamento com as três estratégias que temos: com cartão
de crédito, pix  ou paypal.

```java
public class TesteStrategy {
	public static void main(String[] args) {
		CarrinhoDeCompras cart = new CarrinhoDeCompras();
		
		Produto produto1 = new Produto("1234",10);
		Produto produto2 = new Produto("5678",40);
		
		cart.adicionarProduto(produto1);
		cart.adicionarProduto(produto2);
		
		//Pagar com Paypal
		cart.pay(new PaypalStrategy("meuemail@example.com", "password"));
		
		//Pagar com cartão de crédito/débito
		cart.pay(new CartaoDeCreditoStrategy("Izaias Santos", "1234567890123456", "786", "12/15"));

		//Pagar com Pix
		cart.pay(new PixStrategy("=UkLHae4t9Y047"));
	}
}
```

## Referências
- https://www.digitalocean.com/community/tutorials/strategy-design-pattern-in-java-example-tutorial
- https://www.linkedin.com/pulse/strategy-designpattern-majid-ahmadi/
- https://www.tutorialspoint.com/design_pattern/strategy_pattern.htm


