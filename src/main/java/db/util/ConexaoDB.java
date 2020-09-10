/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.util;

/**
 *
 * @author amarildo.ferreira
 */
import java.sql.*;

public class ConexaoDB {
    
    public static Connection ligarDB(){
    
        String URL_DB = "jdbc:mysql://127.0.0.1:3306/gestaorh?useSSL=false&serverTimezone=UTC";
        String DRIVER8 = "com.mysql.cj.jdbc.Driver";
        String DRIVER5 = "com.mysql.jdbc.Driver";
        String USER = "root";
        String PASSWORD = "root";
        
        Connection conexao;
        
        try{
        
            Class.forName(DRIVER8);
            return conexao = DriverManager.getConnection(URL_DB,USER,PASSWORD);
            
        }catch(ClassNotFoundException | SQLException ex){
            
            System.out.println("Erro de conexao "+ex.getLocalizedMessage());
            return null;
        }
    }
}
