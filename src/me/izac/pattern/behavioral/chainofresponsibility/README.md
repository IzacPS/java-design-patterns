# Padrões de Design - Chain Of Responsability

O padrão de design **Chain of Responsibility** é usado para evitar o acoplamento
entre objetos em uma cadeia onde esses objetos devem processar uma certa requisição.
Cada objeto na cadeia tem a capacidade de decidir se ele irá processar a solicitação
ou se  essa solicitação será enviada para o próximo na objeto na cadeia.
Como um exemplo desse padrão na linguagem **Java**.

Podemos observar como os blocos try-catch funcionam. Podemos desenvolver para
cada bloco catch uma solicitação para processar uma determinada exceção.
Se um bloco não conseguir processar a exceção, então esse bloco irá enviar essa
solicitação para o próximo bloco catch. E mesmo que nenhum dos blocos consiga
processar a exceção, a solicitação é enviada para o programa principal.

```java
public class TryCatch{
    public static void main(String[] args) {
        try{
            //Trecho que pode gerar uma exceção
        }catch (NullPointerException e){
            //Resolver NullPointerException aqui  
        }catch (ArrayIndexOutOfBoundsException e){
            //Resolver ArrayIndexOutOfBoundsException aqui  
        }
        //...
    }
}
```

Um outro exemplo que podemos pensar é uma gaveta de caixa eletrônico. Quando
o cliente solicita um saque, a gaveta faz a seleção de cédulas e entrega o valor
para o cliente. Suponha a gaveta possui repartições com cédulas de 100, 50, 20
e 10 Reais. Quando o cliente solicita por exemplo 470 reais, a gaveta irá
verificar que pode tirar das cédulas de 100 para entregar ao cliente. Nesse caso
quatro cédulas de 100 são separadas para entregar. Depois de separadas as
quatro cédulas de 100, 70 Reais ainda precisam ser distribuídos. A gaveta então
para a responsabilidade de entregar para a próxima repartição já que o valor é
menor que 100. A próxima repartição possui cédulas de 50 e nesse caso, apenas uma nota de 50 é separada.
A repartição com cédulas de 50 passa para a próxima
repartição, agora com cédulas de 20. Essa repartição irá distribuir apenas uma
nota. Ao final a gaveta irá entregar 4 cédulas de 100, uma de 50 e uma de 20.
Observe que em cada repartição quando não é possível distribuir mais as
Notas a responsabilidade é passada para a próxima. Nesse exemplo responsabilidade
é passada para a próxima repartição na cadeia não só quando as quantidades de
cédulas foram suficientes, mas quando a repartição estiver vazia também.

Podemos implementar esse sistema de saque do caixa eletrônico da seguinte forma.
Primeiro temos uma classe do tipo Dinheiro que indica a quantidade que será
trabalhado.

```java
public class Dinheiro {
    private int quantidade;

    public Dinheiro(int quantidade){
        this.quantidade = quantidade;
    }

    public int getQuantidade(){
        return this.quantidade;
    }
}
```

Precisamos agora de uma interface que irá indicar qual o próximo elemento na
corrente de responsabilidade e ao mesmo tempo executar a distribuição do valor
na repartição atual.

```java
public interface GavetaControlador {

    void setProximaCeculaControlador(GavetaControlador proximo);

    void retirar(Dinheiro dinheiroAtual);
}
```

Agora cada partição com cédulas específicas precisa implementar a interface
GavetaControlador. No método retirar verificamos se podemos retirar cédulas da partição atual.
Caso não seja possível, essa responsabilidade é então passada para a
proxima partição na corrente.

```java
public class Cedula10Controlador implements GavetaControlador {
    private GavetaControlador cadeia;
    @Override
    public void setProximaCeculaControlador(GavetaControlador proximo) {
        this.cadeia = proximo;
    }

    @Override
    public void retirar(Dinheiro dinheiroAtual) {
        if(dinheiroAtual.getQuantidade() >= 10){
            int num = dinheiroAtual.getQuantidade()/10;
            int resto = dinheiroAtual.getQuantidade() % 10;
            System.out.println("Retirando " + num + " cédulas de 10R$");
            if(resto != 0) this.cadeia.retirar(new Dinheiro(resto));
        }else{
            this.cadeia.retirar(dinheiroAtual);
        }
    }
}

//Implementação para os demais tipos de cédula
public class Cedula20Controlador implements GavetaControlador {
    //...
}
public class Cedula50Controlador implements GavetaControlador {
    //...
}
public class Cedula100Controlador implements GavetaControlador {
    //...
}
```

Agora podemos criar uma corrente de responsabilidades (Chain of Responsability)
para o nosso caixa eletrônico. Observer o método construtor da classe
``CaixaEletronico`` que cria uma corrente de responsabilidade.

```java
public class CaixaEletronico {
    private GavetaControlador gaveta;

    public CaixaEletronico(){
        GavetaControlador cedula100 = new Cedula100Controlador();
        GavetaControlador cedula50 = new Cedula50Controlador();
        GavetaControlador cedula20 = new Cedula20Controlador();
        GavetaControlador cedula10 = new Cedula10Controlador();

        this.gaveta = cedula100;
        cedula100.setProximaCeculaControlador(cedula50);
        cedula50.setProximaCeculaControlador(cedula20);
        cedula20.setProximaCeculaControlador(cedula10);
    }

    public GavetaControlador getGaveta() {
        return gaveta;
    }
}
```
Podemos testar o nosso caixa eletrônico recebendo um valor para saque que
seja múltiplo de 10 e começamos a fazer a separação das cédulas pelo
primeiro elemento na corrente de responsabilidade da gaveta.

```java
public class TesteChainOfResponsability {

    public static void main(String [] args){
        CaixaEletronico caixa = new CaixaEletronico();

        while(true){
            int quantidade = 0;
            System.out.println("Entre com a quantidade para sacar: ");
            Scanner input = new Scanner(System.in);
            quantidade = input.nextInt();
            if(quantidade % 10 != 0){
                System.out.println("A quantidade deve ser um multiplo de 10.");
                return;
            }
            caixa.getGaveta().retirar(new Dinheiro(quantidade));
        }
    }
}



```

Entrando com o valor 470 obtemos o resultado:
```text
Entre com a quantidade para sacar:
470
Retirando 4 cédula(s) de 100R$
Retirando 1 cédula(s) de 50R$
Retirando 1 cédula(s) de 20R$
```
Para o valor de 480:
```text
Entre com a quantidade para sacar: 
480
Retirando 4 cédula(s) de 100R$
Retirando 1 cédula(s) de 50R$
Retirando 1 cédula(s) de 20R$
Retirando 1 cédula(s) de 10R$
```

## Referências
- https://www.digitalocean.com/community/tutorials/chain-of-responsibility-design-pattern-in-java
- https://www.devmedia.com.br/design-patterns-entendendo-os-padroes-chain-of-responsibility-command-iterator-mediator-e-memento/29397


