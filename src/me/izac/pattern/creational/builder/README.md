# Padrões de Design - Builder

O padrão de design **Builder** faz com que a criação de objetos complexos, com muitos
parâmetros sejam feitos passo a passo. Nesse padrão o objeto construído possui uma
quantidade de parâmetros padrão e demais parâmetros opcionais para cada atributo
a partir de métodos setters. Esse modelo de criação de objeto faz com que existam
várias representações de construção para o mesmo objeto.

Para implementarmos o padrão **Builder**, primeiramente precisamos de uma classe estática aninhada
chamada ``Builder`` com uma cópia de todos os argumentos da classe externa. A classe ``Builder`` deve
possuir o mesmo nome da classe externa acompanhado de ``Builder``. Por exemplo, a classe externa
de nome ``Computador`` e a classe aninhada ``ComputadorBuilder``.
A classe ``Builder`` deve possuir um construtor público com todos os atributos como parâmetro.
A classe builder deve possuir métodos setters para os parâmetros opcionais e um método que
retorna o tipo ``Builder``. E por fim, a classe ``Builder`` deve possuir um método ``build`` que retornará
o objeto da classe externa. A classe externa deve possuir um construtor privado que recebe
um objeto do tipo ``Build`` como parâmetro.

Abaixo podemos ver um exemplo de implementação **Java** utilizando o padrão **Build**.
```java
public class Computador {
    private String RAM;
    private String HDD;
    private String placaDeVideo;
    private String processador;
    private boolean placaDeVideoHabilidata;
    private boolean bluetoothHabilitado;
   
    //getters
    
    private Computador(ComputadorBuilder builder){
        this.RAM = builder.RAM;
        this.HDD = builder.HDD;
        this.processador = builder.processador;
        this.placaDeVideo = builder.placaDeVideo;
        this.bluetoothHabilitado = builder.bluetoothHabilitado;
        this.placaDeVideoHabilidata = builder.placaDeVideoHabilidata;
    }
    public static class ComputadorBuilder{
        private String RAM;
        private String HDD;
        private String placaDeVideo;
        private String processador;
        private boolean placaDeVideoHabilidata;
        private boolean bluetoothHabilitado;
        
        ComputadorBuilder(String processador, String RAM){
            this.processador = processador;
            this.RAM = RAM;
        }
        
        //Setters para os atributos opcionais
        public ComputadorBuilder setHDD(String HDD) {
            this.HDD = HDD;
            return this;
        }
        public ComputadorBuilder setPlacaDeVideo(String placaDeVideo) {
            this.placaDeVideo = placaDeVideo;
            return this;
        }
        public ComputadorBuilder setPlacaDeVideoHabilidata(boolean placaDeVideoHabilidata) {
            this.placaDeVideoHabilidata = placaDeVideoHabilidata;
            return this;
        }
        public ComputadorBuilder setBluetoothHabilitado(boolean bluetoothHabilitado) {
            this.bluetoothHabilitado = bluetoothHabilitado;
            return this;
        }
        //Método que retorna o novo objeto a ser construído
        public Computador build(){
            return new Computador(this);
        }
    }
}
```

Observe que para construir um objeto do tipo computador temos dois parametros que são 
necessários, processador e RAM. Os demais parametros são opcionais e permitem construir um
computador de várias maneiras diferentes.

Exemplo de uso do padrão **Builder**:

```java
public class TesteBuilder {
    public static void main(String[] args) {
        Computador computador = new Computador
                .ComputadorBuilder("Intel", "4 GB")
                .setHDD("1 TB")
                .setPlacaDeVideo("Nvidia")
                .setPlacaDeVideoHabilidata(true)
                .setBluetoothHabilitado(true).build();

        System.out.println(computador.toString());
    }
}
```

## Referências
- https://medium.com/xp-inc/desing-patterns-parte-6-builder-f20752fb0c35
- https://www.digitalocean.com/community/tutorials/builder-design-pattern-in-java


