
O padrão de design Adapter funciona como uma ponte entre duas interfaces com 
funcionalidades imcompatíveis. O padrão permite que duas interfaces com diferentes
funcionalidades possam funcionar juntas. O objetivo é "converter a interface de uma
classe em outra interface que o cliente precisa". O objeto que faz essa conversão
entre interfaces é conhecido como Adapter.

Um exemplo da vida real do padrão de design Adapter seria um carregador para 
dispositivos móveis. Geralmente a bateria do dispositivo precisa de 3 volts para
carregar mas as tomadas das residências fornecem faixas de voltagens diferentes, 
por exemplo 110V ou 220V. Assim, o carregador funciona como um adaptador (Adapter) 
entre a entrada de carregar o dispositivo e a tomada.
O repositório fornece um exemplo de implementação de um carregador utilizando o
padrão de design Adapter. 
A classe **Voltagem** contem a voltagem especifica vindo da tomada para o carrregador. 

````java
public class Voltagem {
    private int volts;
    public Voltagem(int volts){
        this.volts = volts;
    }
    //getter and setter
}

````

A classe **Tomada** possui o método **getVoltagem** que retorna a voltagem de entrada
da tomada. No exemplo 110 volts.

````java
public class Tomada {
    public Voltagem getVoltagem(){
        return new Voltagem(110);
    }
}
````

A interface **TomadaAdapter** possui os métodos que, a partir da voltagem especificada
pela tomada, produz diferentes saídas como 110V, 12V ou 3V.

````java
public interface TomadaAdapter {
    public Voltagem get110Volts();
    public Voltagem get12Volts();
    public Voltagem get3Volts();
}
````

A classe **Carregador** extende da classe Tomada e implementa os métodos da interface
**TomadaAdapter**. Com isso a classe **Carregador tem acesso a voltagem vinda da 
tomada faz a conversão das voltagens.

````java
public class Carregador extends Tomada implements TomadaAdapter {
    @Override
    public Voltagem get110Volts() {
        return getVoltagem();
    }

    @Override
    public Voltagem get12Volts() {
        return converterVoltagem(getVoltagem(), 9);
    }

    @Override
    public Voltagem get3Volts() {
        return converterVoltagem(getVoltagem(), 36);
    }

    //Faz a conversão para a voltagem de saída específica
    private Voltagem converterVoltagem(Voltagem v, int i){
        return new Voltagem(v.getVolts()/i);
    }
}
````
Podemos notar então que se tivessemos uma Tomada com um valor de voltagem diferente
como 220V, poderiamos criar um novo tipo de carregador extendendo dessa tomada com
voltagem de 220V e implementar a interface **TomadaAdapter** e obter as mesmas 
voltagens de saída mesmo com uma entrada de 220V.

https://www.javatpoint.com/adapter-pattern
https://www.digitalocean.com/community/tutorials/adapter-design-pattern-java
https://www.tutorialspoint.com/design_pattern/adapter_pattern.htm