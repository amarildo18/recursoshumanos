/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.util.ConexaoDB;
import rh.modelo.Departamento;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author amarildo.ferreira
 */
public class DepartamentoDAO {
    
    String INSERT = "INSERT INTO departamento VALUES(?,?)";
    String UPDATE = "";
    String DELETE = "";
    String SELECT_ALL = "SELECT * FROM departamento";
    String SELECT_BY_NOME = "SELECT * FROM departamento d WHERE d.nome = ?";
    String SELECT_BY_SIGLA = "";
    
    public DepartamentoDAO(){}
    
    public void save(Departamento d){
    
        PreparedStatement ps = null;
        Connection conexao = null;
        
        try{
        
            conexao = ConexaoDB.ligarDB();
            ps = conexao.prepareStatement(INSERT);
            ps.setString(1, d.getSigla());
            ps.setString(2, d.getNome());
            ps.executeUpdate();
        }
        catch(SQLException e){
        
            System.err.println("Erro ao inserir dados: DepartamentoDAO:save "+e.getLocalizedMessage());
        }
    }
    
    public List<Departamento> listaDepartamento(){
    
        List<Departamento> lista = new ArrayList<>();
        PreparedStatement ps = null;
        Connection conexao = null;
        ResultSet rs = null;
        Departamento d = null;
        
        try{
        
            conexao = ConexaoDB.ligarDB();
            ps = conexao.prepareStatement(SELECT_ALL);
            rs = ps.executeQuery();
            
            while(rs.next()){
            
                d = new Departamento();
                d.setSigla(rs.getString(1));
                d.setSigla(rs.getString(2));
                lista.add(d);  
            }
        }catch(SQLException ex){
            System.err.println("Erro ao ler dados: DepartamentoDAO -lista Departamento "+ex.getLocalizedMessage());
        }
        return lista;
    }
    
    // listagemm dos departamentos por nome
    public List<Departamento> getDepartamentoByNome(String nome){
    
        List<Departamento> lista = new ArrayList<>();
        PreparedStatement ps = null;
        Connection conexao = null;
        ResultSet rs = null;
        
        Departamento d = null;
        
        try{
        
            conexao = ConexaoDB.ligarDB();
            ps = conexao.prepareStatement(SELECT_BY_NOME);
            rs = ps.executeQuery();
            
            while(rs.next()){
            
                d = new Departamento();
                d.setSigla(rs.getString(1));
                d.setSigla(rs.getString(2));
                lista.add(d);  
            }
        }catch(SQLException ex){
            System.err.println("Erro ao ler dados: DepartamentoDAO -lista Departamento "+ex.getLocalizedMessage());
        }
        return lista;
    }
}
