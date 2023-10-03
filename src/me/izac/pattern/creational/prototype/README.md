
O padrão de design Prototype é usado quando a criação de um objeto tem um custo muito
elevado e pode consumir muito tempo e recursos e você possui objetos similares que já 
foram criados. O padrão propõe que você tenha um mecanismo que você faça copia do objeto
original para um novo objeto e modifique essa cópia de acordo com a necessidade.
Uma forma de implementação é criar uma interface comum para os objetos que serão 
copiados com um único método chamado **clone**. Podemos definir dois tipos de clonagem.

Uma analogia que podemos fazer com o design Prototype  seria  uma compania que fabrica
telefones móveis que faz o lançamento em vários seguimentos. Cada telefone possui
funcionalidades básicas em comum com algumas varições. Nesse caso a compania utilizará
o software da compania e fará um clone de acordo com os demais telefones.

Um outro exemplo seria um objeto que faz conexão com um baco de dados e faz a
busca desses dados. Imagina que precisamos modificar esse objeto várias vezes durante 
a execução do programa, então não seria uma boa ideia criar um novo objeto sempre
que precisarmos nos conectar a base de dados com um objeto diferente e fazer a busca
desses dados na base de dados. O ideal seria clonar esse objeto já existente com 
a conexão e então fazer a manipulação dos dados.

O codigo abaixo apresenta um exemplo de uma classe Empregados que utiliza o padrão
Prototype para buscar dados de empregados em uma base de dados. Podemos utilizar a
interface **Cloneable** da linguagem java e impolementar o método clone na classe 
**Empregado**.

````java
public class Empregados implements Cloneable{
    //Lista com o nome dos empregados
    private List<String> empList;

    //...

    public void buscaDadosEmpregados(){
        //busca os dados dos empregados da base de dados
    }

    //...
    
    @Override
    public Empregados clone() throws CloneNotSupportedException{
        //copia todos os elementos de empList para emp
        List<String> temp = new ArrayList<>(this.getEmpList());
        return new Empregados(temp);
    }
}
````

Observer que estamos fazendo uma cópia de todos os dados do atributo empList da
classe Empregados. Agora podemos testar nossa classe para demonstrar como funciona
o padrão Prototype.

`````java
public class TestPrototype {
    public static void main(String[] args) throws CloneNotSupportedException {
        Empregados empregados = new Empregados();

        empregados.buscaDadosEmpregados();

        Empregados empregados1 = (Empregados) empregados.clone();
        Empregados empregados2 = (Empregados) empregados.clone();
        List<String> list = empregados1.getEmpList();
        list.add("Marcelo");
        List<String> list1 = empregados2.getEmpList();
        list1.remove("Isaac");

        System.out.println("lista original de empregados: " + empregados.getEmpList());
        System.out.println("lista modificada com adição de empregado: " + list);
        System.out.println("lista modificada com remoção de empregado: " + list1);
    }
}
`````

Observer o método **buscaDadosEmpregados** responsável por trazer os dados 
da base de dados. Observer que se **Empregado** não fosse clonável precisaríamos 
nos conectar a base de dados e buscar os dados todas as vezes que fosse preciso de
um novo objeto da classe Empregados.

## Referências
https://www.digitalocean.com/community/tutorials/prototype-design-pattern-in-java
https://medium.com/xp-inc/desing-patterns-parte-7-prototype-98962514728f
https://www.scaler.com/topics/design-patterns/prototype-design-pattern/