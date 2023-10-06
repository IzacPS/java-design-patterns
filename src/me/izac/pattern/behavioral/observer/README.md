# Padrões de Design - Observer

O padrão de design **Observer** é usado quando os objetos precisam se comunicar uma mudança
de estado e precisa notificar essa mudança para os demais objetos. Nesse padrão, os objetos
que observam as mudanças de estado são conhecidos como **Observer**. Os objetos que estão sendo
"observados" são conhecidos como **Subject**. Os **Subject** possuem uma lista com objetos
do tipo **Observer**. Esses objetos podem notificar mudanças que possam ocorrer no seu estado.
O **Subject** possui métodos para registrar e remover registros dessas notificações. Possui também
um método que pode ser utilizado para notificar todas as mudanças para os **Observer**'s. O
**Observer** possui um método para notificar se há mudanças e outro que deve ser utilizado pelo
**Subject** para notificar de alguma atualização.

Como exemplo, podemos implementar um sistema que possui alguns observers que irão se registrar
para receber mensagens de um topico específico. Quando uma mensagem for postada para esse tópico,
todos os usuários que se registraram para esse tópico serão notificados e eles podem então
utilizar essa mensagem.
A interface ``Subject`` define os métodos que devem ser implementados.

```java
public interface Subject {
    void register(Observer obs);
    void unregister(Observer obs);

    void notifyObservers();

    <T> T getUpdate(Observer obs);
}

```

Agora podemos definir a nossa interface ``Observer`` com os seguintes métodos.
```java
public interface Observer {
    void update();
    void setSubject(Subject sub);
}
```
Agora fazemos o nosso tópico como uma classe que implementa a interface ``Subject``.

```java
public class MeuTopico implements Subject {

    private List<Observer> observers;
    private String message;
    private boolean changed;
    private final Object MUTEX= new Object();

    public MeuTopico(){
        this.observers=new ArrayList<>();
    }
    @Override
    public void register(Observer obj) {
        if(obj == null) throw new NullPointerException("Null Observer");
        synchronized (MUTEX) {
            if(!observers.contains(obj)) observers.add(obj);
        }
    }

    @Override
    public void unregister(Observer obj) {
        synchronized (MUTEX) {
            observers.remove(obj);
        }
    }

    @Override
    public void notifyObservers() {
        List<Observer> observersLocal = null;
        synchronized (MUTEX) {
            if (!changed)
                return;
            observersLocal = new ArrayList<>(this.observers);
            this.changed=false;
        }
        for (Observer obj : observersLocal) {
            obj.update();
        }

    }

    @Override
    public Object getUpdate(Observer obj) {
        return this.message;
    }

    public void postMessage(String msg){
        System.out.println("Mensagem postada pelo topico: "+msg);
        this.message=msg;
        this.changed=true;
        notifyObservers();
    }

}
```
Agora implementamos a interface **Subscriber**.

```java
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


```

É por fim, podemos criar vários subscribers, registrá los para receber notificações
do tópico e enviar uma mensagem de teste para todos os subscribers.

```java
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
```

## Referências
- https://www.digitalocean.com/community/tutorials/observer-design-pattern-in-java
- https://www.tutorialspoint.com/design_pattern/observer_pattern.htm
- https://medium.com/xp-inc/design-patterns-parte-21-observer-e2260412011a
- https://sourcemaking.com/design_patterns/observer