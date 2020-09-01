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

    Funcionario funcionario1 = new Funcionario("Amarildo","Ferreira","Informatica",29,50000.00);
    Funcionario funcionario2 = new Funcionario("Abreu","Ferreira","Transportes",52, 150000.00);
    Funcionario funcionario3 = new Funcionario("Judite","Karipa","Logistica",49,70000.00);
    
    List<Funcionario> funcionarios = new ArrayList<>();

    public FuncionarioMBean() {
        
    }
    
    
    @PostConstruct
    public void init(){
    
        this.funcionarios.add(funcionario1);
        this.funcionarios.add(funcionario2);
        this.funcionarios.add(funcionario3);
        
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
