# Padrões de Design - State

O padrão de design estado determina que uma classe terá seu comportamento alterado de acordo
com algum estado interno. O padrão permite um desacoplamento sistemático permitindo
implementar para estados e contextos diferentes. O objeto contexto possui uma referência
para um objeto concreto do estado. O contexto então envia uma requisição para ser processada
de acordo com o estado que ele mantém.

Vamos pensar em um simples exemplo como uma TV com uma simples função de ligar e desligar.
Primeiro precisamos definir um contrato para as implementações o nosso estado com uma interface.
Cada estado terá uma ação para realizar.

```java
public interface Estado {
	public void realizarAcao();
}
```

Agora precisamos implementar nossas ações concretas, ligar e desligar.

```java
public class TVLigarEstado implements Estado {
	@Override
	public void realizarAcao() {
		System.out.println("TV ligada!");
	}
}
```

```java
public class TVDesligarEstado implements Estado {
	@Override
	public void realizarAcao() {
		System.out.println("TV desligada!");
	}
}
```
Observe como cada implementação pode realizar uma ação específica.

Precisamos agora da nossa classe de contexto que possui o estado e realiza a sua respectiva
ação.

```java
public class TVContext implements Estado {

	private Estado tvEstado;

	public void setEstado(Estado estado) {
		this.tvEstado = estado;
	}

	public Estado getState() {
		return this.tvEstado;
	}

	@Override
	public void realizarAcao() {
		this.tvEstado.realizarAcao();
	}
}
```
Agora podemos testar o padrão da seguinte maneira:

```java
public class TesteState {
	public static void main(String[] args) {
		TVContext context = new TVContext();
		Estado tvStartEstado = new TVLigarEstado();
		Estado tvStopState = new TVDesligarEstado();
		
		context.setEstado(tvStartEstado);
		context.realizarAcao();
		
		context.setEstado(tvStopState);
		context.realizarAcao();
	}
}
```

Observe que o método ``realizarAcao`` agirá de acordo com o estádo atual informado em
``setEstado``.

## Referências
- https://www.digitalocean.com/community/tutorials/estado-design-pattern-java
- https://www.tutorialspoint.com/design_pattern/state_pattern.htm
- https://www.baeldung.com/java-estado-design-pattern


