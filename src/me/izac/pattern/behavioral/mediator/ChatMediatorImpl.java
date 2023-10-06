package me.izac.pattern.behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

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