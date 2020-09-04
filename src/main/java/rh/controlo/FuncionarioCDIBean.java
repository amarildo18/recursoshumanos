/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rh.controlo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
// import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import rh.modelo.Funcionario;

/**
 *
 * @author amarildo.ferreira
 */
@Named(value = "funcionarioCDIBean")
@SessionScoped
public class FuncionarioCDIBean implements Serializable{

    /**
     * Creates a new instance of FuncionarioCDIBean
     */
    Funcionario funcionario1 = new Funcionario("Amarildo","Ferreira","Informatica",50000.00);
    Funcionario funcionario2 = new Funcionario("Abreu","Ferreira","Transportes", 150000.00);
    Funcionario funcionario3 = new Funcionario("Judite","Karipa","Logistica",70000.00);
    
    Funcionario funcionario = new Funcionario();
    
    private List<Funcionario> funcionarios = new ArrayList<>();

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
    
    @PostConstruct
    public void init(){
        
        this.funcionarios.add(funcionario1);
        this.funcionarios.add(funcionario2);
        this.funcionarios.add(funcionario3);
    }
    
    public String salvar(){
    
        this.funcionarios.add(funcionario);
        FacesContext faceContext = FacesContext.getCurrentInstance();
        
        FacesMessage facesMessages = new FacesMessage(null, "funcionario guardado com sucesso");
        
        faceContext.addMessage(null, facesMessages);
        
        funcionario = new Funcionario();
        return "lista-funcionarios";
    }
    
    public String guardar(){
    
        return "resultado";
    }
}
