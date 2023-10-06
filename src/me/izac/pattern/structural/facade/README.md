# Padrões de Design - Facade

O padrão de design **Facade** facilita a interação da aplicação com o sistema. É um
padrão que fornece uma interface simplificada para uma biblioteca, estrutura ou
um conjunto complexo de classes. Nesse padrão, uma simples classe pode fornecer
métodos simplificados delegam chamadas para métodos existentes do sistema.

Por exemplo, suponha que precisamos de uma aplicação que possua crie uma interface
com um banco de dados MySql e Oracle. Essa aplicação precisa gerar diferentes tipos de
relatórios para as diferentes bases de dados. Com isso, um cliente que precise utilizar
a aplicação pode utilizar uma dessas interfaces para se conectar e gerar os relatórios.
Podemos aplicar o design **Facade** que fornecerá uma interface que envolverá as duas
interfaces existentes de cada banco de dados.

Temos então as classes:

```java
public class MySqlHelper {
    public static Connection getMySqlDBConnection(){
        //Retorna uma conexão com a base de dados
        return null;
    }

    public void generateMySqlPDFReport(String tableName, Connection connection){
        //Busca dados de uma tabela e gera um arquivo PDF
    }

    public void generateMySqlHTMLReport(String tableName, Connection connection){
        //Busca dados de uma tabela e gera uma página html
    }
}

public class OracleHelper {

    public static Connection getOracleDBConnection(){
        //Retorna uma conexão com a base de dados
        return null;
    }

    public void generateOraclePDFReport(String tableName, Connection connection){
        //Busca dados de uma tabela e gera um arquivo PDF
    }

    public void generateOracleHTMLReport(String tableName, Connection connection){
        //Busca dados de uma tabela e gera uma página html
    }
}
```
Temos então a classe que envolve as os dois objetos que representam a comunicação a
um tipo de base de dados:

```java
public class HelperFacade {

    public static void generateReport(DBTypes dbType, ReportTypes reportType, String tableName){
        Connection con = null;
        switch (dbType) {
            case MYSQL -> {
                con = MySqlHelper.getMySqlDBConnection();
                MySqlHelper mySqlHelper = new MySqlHelper();
                switch (reportType) {
                    case HTML -> mySqlHelper.generateMySqlHTMLReport(tableName, con);
                    case PDF -> mySqlHelper.generateMySqlPDFReport(tableName, con);
                }
            }
            case ORACLE -> {
                con = OracleHelper.getOracleDBConnection();
                OracleHelper oracleHelper = new OracleHelper();
                switch (reportType) {
                    case HTML -> oracleHelper.generateOracleHTMLReport(tableName, con);
                    case PDF -> oracleHelper.generateOraclePDFReport(tableName, con);
                }
            }
        }

    }

    //Definição de enums
}
```
Agora podemos utilizar o design da seguinte forma:

```java
public class TestFacade {

    public static void main(String[] args) {
        String tableName="Employee";

        //Gerando um relatório do MySql em HTML e um relatório do Oracle em PDF utilizando o design Facade
        HelperFacade.generateReport(HelperFacade.DBTypes.MYSQL, HelperFacade.ReportTypes.HTML, tableName);
        HelperFacade.generateReport(HelperFacade.DBTypes.ORACLE, HelperFacade.ReportTypes.PDF, tableName);
    }
}
```
Veja que só precisamos indicar qual a base que queremos o relatório, qual o tipo de relatório
que queremos e qual a tabela de origem.

- https://www.digitalocean.com/community/tutorials/facade-design-pattern-in-java
- https://medium.com/xp-inc/desing-patterns-parte-12-facade-ff66c68f5784
- https://www.tutorialspoint.com/design_pattern/facade_pattern.htm


