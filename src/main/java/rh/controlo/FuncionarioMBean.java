/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rh.controlo;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import rh.modelo.Funcionario;

/**
 *
 * @author amarildo.ferreira
 */
@Named(value = "funcionarioMBean")
@RequestScoped
public class FuncionarioMBean {

   
    
    List<Funcionario> funcionarios = new ArrayList<>();

    public FuncionarioMBean() {
        
    }
    
    
    @PostConstruct
    public void init(){
    
        
    }

    public List<Funcionario> getFuncionarios() {
        return this.funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
    
    public String guardar(){
    
        return "resultado";
    }
    
}
