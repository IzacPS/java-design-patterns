# Padrões de Design - Iterator

O padrão de design Iterator permite que percorrer de uma forma
padronizada uma coleção de objetos.

Suponha que uma lista de canais de rádio e precisamos percorrer
cada um deles para decidir qual iremos ouvir. Suponha que podemos
ouvir os canais em várias línguas diferentes. Agora precisamos
criar uma forma de percorrer pelos canais e selecionar
apenas aqueles com a linguagem que queremos ouvir como canais em
Português. Podemos definir então um modelo de iteração pelos
canais que sejam genéricos para cada linguagem.

Primeiro definimos os tipos de linguagens disponíveis.

```java
public enum ChannelTypeEnum {
	ENGLISH, HINDI, FRENCH, PORTUGUES, ALL;
}
```
A classe ``Channel`` possui informações da frequência e o tipo do canal.
```java
public class Channel {
	private double frequency;
	private ChannelTypeEnum TYPE;
	
	public Channel(double freq, ChannelTypeEnum type){
		this.frequency=freq;
		this.TYPE=type;
	}

	public double getFrequency() {
		return frequency;
	}

	public ChannelTypeEnum getTYPE() {
		return TYPE;
	}
	
	@Override
	public String toString(){
		return "Frequency="+this.frequency+", Type="+this.TYPE;
	}
}
```
Precisamos de uma interface que define um contrato para
a nossa coleção de canais. Essa interface fornece métodos
de adição remoção e retorna um iterador para a coleção de canais.

```java
public interface ChannelCollection {

	void addChannel(Channel c);
	
	void removeChannel(Channel c);
	
	ChannelIterator iterator(ChannelTypeEnum type);
	
}
```
Agora precisamos de uma interface com as ações comuns para
iteração em uma coleção como uma ação que indica o próximo
objeto na coleção e se possui um próximo elemento.

```java
public interface ChannelIterator {

	boolean hasNext();
	
	Channel next();
}
```
Agora criamos os o objeto que representa uma coleção de canais
e um objeto iterador para essa coleção de canais.

```java
public class ChannelCollectionImpl implements ChannelCollection {

	private List<Channel> channelsList;

	public ChannelCollectionImpl() {
		channelsList = new ArrayList<>();
	}

	public void addChannel(Channel c) {
		this.channelsList.add(c);
	}

	public void removeChannel(Channel c) {
		this.channelsList.remove(c);
	}

	@Override
	public ChannelIterator iterator(ChannelTypeEnum type) {
		return new ChannelIteratorImpl(type, this.channelsList);
	}

	private class ChannelIteratorImpl implements ChannelIterator {

		private ChannelTypeEnum type;
		private List<Channel> channels;
		private int position;

		public ChannelIteratorImpl(ChannelTypeEnum ty,
				List<Channel> channelsList) {
			this.type = ty;
			this.channels = channelsList;
		}

		@Override
		public boolean hasNext() {
			while (position < channels.size()) {
				Channel c = channels.get(position);
				if (c.getTYPE().equals(type) || type.equals(ChannelTypeEnum.ALL)) {
					return true;
				} else
					position++;
			}
			return false;
		}

		@Override
		public Channel next() {
			Channel c = channels.get(position);
			position++;
			return c;
		}

	}
}
```
Podemos testar o padrão criando uma coleção de canais e
criarmos um iterador sobre os canais em Português.

```java
public class TesteIterator {

	public static void main(String[] args) {
		ChannelCollection channels = populateChannels();
		ChannelIterator baseIterator = channels.iterator(ChannelTypeEnum.ALL);
		while (baseIterator.hasNext()) {
			Channel c = baseIterator.next();
			System.out.println(c.toString());
		}
		System.out.println("******");
		// Cria um iterador com os canais em português
		ChannelIterator englishIterator = channels.iterator(ChannelTypeEnum.PORTUGUES);
		while (englishIterator.hasNext()) {
			Channel c = englishIterator.next();
			System.out.println(c.toString());
		}
	}
    //Cria uma coleção de canais
	private static ChannelCollection populateChannels() {
		ChannelCollection channels = new ChannelCollectionImpl();
		channels.addChannel(new Channel(98.5, ChannelTypeEnum.ENGLISH));
		channels.addChannel(new Channel(99.5, ChannelTypeEnum.HINDI));
		channels.addChannel(new Channel(100.5, ChannelTypeEnum.FRENCH));
		channels.addChannel(new Channel(101.5, ChannelTypeEnum.PORTUGUES));
		channels.addChannel(new Channel(102.5, ChannelTypeEnum.HINDI));
		channels.addChannel(new Channel(103.5, ChannelTypeEnum.FRENCH));
		channels.addChannel(new Channel(104.5, ChannelTypeEnum.ENGLISH));
		channels.addChannel(new Channel(105.5, ChannelTypeEnum.PORTUGUES));
		channels.addChannel(new Channel(106.5, ChannelTypeEnum.HINDI));
		channels.addChannel(new Channel(107.5, ChannelTypeEnum.FRENCH));
		channels.addChannel(new Channel(108.5, ChannelTypeEnum.PORTUGUES));
		return channels;
	}
}
```

## Referências
- https://www.digitalocean.com/community/tutorials/iterator-design-pattern-java
- https://medium.com/xp-inc/design-patterns-parte-18-interator-c2559a462364


