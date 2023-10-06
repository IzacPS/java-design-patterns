# Padrões de Design - Mediator

O padrão de design Mediator é usado quando se precisa de um meio de comunicação centralizado
entre objetos no sistema. Os objetos que precisam se comunicar devem utilizar esse meio
centralizado para trocar mensagens, como se fosse um roteador e possui sua própria lógica de
comunicação.

Como exemplo, podemos implementar uma aplicação onde usuários podem trocar mensagens em grupo.
Os usuários são identificados pelo nome e podem enviar e receber mensagens. Uma mensagem
enviada por um usuário deve ser recebida por todos os outros usuários no grupo.

Precisamos de uma interface do tipo Mediator, ``ChatMediator``.

```java
public interface ChatMediator {
    void sendMessage(String message, User user);
    void addUser(User user);
}

```
Podemos criar o usuário como uma classe abstrata. O usuário terá o nome, e um objeto do tipo
``ChatMediator`` que será necessário para se comunicar com os demais usuários que estão conecatados
ao mesmo ``ChatMediator``. No nosso exemplo será a classe ``User``.
```java
public abstract class User {
    protected ChatMediator mediator;
    protected String name;
    public User(ChatMediator mediator, String name){
        this.mediator = mediator;
        this.name = name;
    }
    public abstract void send(String message);
    public abstract void receive(String message);
}

```
Agora podemos criar a lógica de um objeto mediador implementando a interface ``ChatMediator``.
Nessa implementação teremos acesso a todos os usuários que estão conectados. Podemos também
adicionar um novo usuário para a lista de usuários e enviar uma mensagem de um usuário específico
para os demais que estão presentes na lista de usuários do mediator. Para o nosso exemplo
o nome da classe que implementa o ``ChatMediator`` é ``ChatMediatorImpl``.

```java
public class ChatMediatorImpl implements ChatMediator {

	private List<User> users;
	
	public ChatMediatorImpl(){
		this.users=new ArrayList<>();
	}
	
	@Override
	public void addUser(User user){
		this.users.add(user);
	}
	
	@Override
	public void sendMessage(String msg, User user) {
		for(User u : this.users){
			//Envia a mensagem para todos os usuários exceto para o usuário que enviou
			if(u != user){
				u.receive(msg);
			}
		}
	}

}
```

Agora podemos implementar um tipo concreto de usuário. O usuário implementa o método abstrato
``send`` e envia a mensagem para todos os usuários que estão presentes no ``mediator``.
```java
public class UserImpl extends User {

    public UserImpl(ChatMediator med, String name) {
        super(med, name);
    }

    @Override
    public void send(String msg){
        System.out.println(this.name+": Enviando mensagem="+msg);
        mediator.sendMessage(msg, this);
    }
    @Override
    public void receive(String msg) {
        System.out.println(this.name+": Mensagem recebida:"+msg);
    }

}
```

Podemos testar o padrão então criando vários usuários, adicioná los ao mediador e enviar um
“oi” de algum usuário para os demais.

```java
public class TesteMediator {

	public static void main(String[] args) {
		ChatMediator mediator = new ChatMediatorImpl();
		User user1 = new UserImpl(mediator, "José");
		User user2 = new UserImpl(mediator, "Luciana");
		User user3 = new UserImpl(mediator, "Pedro");
		User user4 = new UserImpl(mediator, "Dara");
		mediator.addUser(user1);
		mediator.addUser(user2);
		mediator.addUser(user3);
		mediator.addUser(user4);
		
		user1.send("Olá pessoal!");
		
	}
}
```


## Referências
- https://www.digitalocean.com/community/tutorials/java-design-patterns-example-tutorial


