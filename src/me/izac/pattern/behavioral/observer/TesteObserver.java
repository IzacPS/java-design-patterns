package me.izac.pattern.behavioral.observer;

public class TesteObserver {

	public static void main(String[] args) {
		//Cria um subject
		MeuTopico topic = new MeuTopico();
		
		//create os observers
		Observer obj1 = new MeuTopicoSubscriber("Obj1");
		Observer obj2 = new MeuTopicoSubscriber("Obj2");
		Observer obj3 = new MeuTopicoSubscriber("Obj3");
		
		//registra todos os observers ao topico
		topic.register(obj1);
		topic.register(obj2);
		topic.register(obj3);
		
		//vincula o topico aos observers
		obj1.setSubject(topic);
		obj2.setSubject(topic);
		obj3.setSubject(topic);
		
		//verifica se há alguma notificação recebida
		obj1.update();
		
		//envia uma mensagem para todos os subscribers registrados
		topic.postMessage("Nova mensagem");
	}

}