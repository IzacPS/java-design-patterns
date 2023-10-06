package me.izac.pattern.behavioral.observer;

public class MeuTopicoSubscriber implements Observer {
	
	private String name;
	private Subject topic;
	
	public MeuTopicoSubscriber(String nm){
		this.name=nm;
	}
	@Override
	public void update() {
		String msg = topic.getUpdate(this);
		if(msg == null){
			System.out.println(name+":: Nenhuma nova mensagem");
		}else
			System.out.println(name+":: Recebendo mensagem::"+msg);
	}

	@Override
	public void setSubject(Subject sub) {
		this.topic=sub;
	}

}