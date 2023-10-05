package me.izac.pattern.structural.facade;

import java.sql.Connection;

public class MySqlHelper {
    public static Connection getMySqlDBConnection(){
        //Retorna uma conexão com a base de dados
        return null;
    }

    public void generateMySqlPDFReport(String tableName, Connection connection){
        //Busca dados de uma tabela e gera um arquivo PDF
    }

    public void generateMySqlHTMLReport(String tableName, Connection connection){
        //Busca dados de uma tabela e gera uma pagina html
    }
}
