/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.util;

import java.sql.*;

/**
 *
 * @author amarildo.ferreira
 */
public class AppMYSQL {
    
    public static void main(String[] args){
    
        String LISTA_DEPARTAMENTO = "SELECT * FROM departamento";
        
        try{
        
            Connection conn = ConexaoDB.ligarDB();
            PreparedStatement ps = conn.prepareStatement(LISTA_DEPARTAMENTO);
            ResultSet rs = ps.executeQuery();
            
            while( rs.next()){
            
                System.out.println(rs.getInt(1)+" "+rs.getString(2));
            }
        }catch(SQLException ex){
            
            System.out.println("Erro na leitura de dados"+ex);
        }
    }
}
