package me.izac.pattern.structural.facade;

import java.sql.Connection;

public class TestFacade {

    public static void main(String[] args) {
        String tableName="Employee";

        //Gerando um relatório do MySql em HTML e um relatório do Oracle em PDF sem utilizar o design Facade
        Connection con = MySqlHelper.getMySqlDBConnection();
        MySqlHelper mySqlHelper = new MySqlHelper();
        mySqlHelper.generateMySqlHTMLReport(tableName, con);

        Connection con1 = OracleHelper.getOracleDBConnection();
        OracleHelper oracleHelper = new OracleHelper();
        oracleHelper.generateOraclePDFReport(tableName, con1);

        //Gerando um relatório do MySql em HTML e um relatório do Oracle em PDF utilizando o design Facade
        HelperFacade.generateReport(HelperFacade.DBTypes.MYSQL, HelperFacade.ReportTypes.HTML, tableName);
        HelperFacade.generateReport(HelperFacade.DBTypes.ORACLE, HelperFacade.ReportTypes.PDF, tableName);
    }

}