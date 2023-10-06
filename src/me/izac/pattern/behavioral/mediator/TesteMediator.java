package me.izac.pattern.behavioral.mediator;

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