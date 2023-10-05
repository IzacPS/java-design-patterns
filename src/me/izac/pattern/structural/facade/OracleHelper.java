package me.izac.pattern.structural.facade;

import java.sql.Connection;

public class OracleHelper {

    public static Connection getOracleDBConnection(){
        //Retorna uma conexão com a base de dados
        return null;
    }

    public void generateOraclePDFReport(String tableName, Connection connection){
        //Busca dados de uma tabela e gera um arquivo PDF
    }

    public void generateOracleHTMLReport(String tableName, Connection connection){
        //Busca dados de uma tabela e gera uma pagina html
    }
}
