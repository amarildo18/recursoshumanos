/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rh.controlo;

import dao.DepartamentoDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
// import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import rh.modelo.Departamento;
import rh.modelo.Funcionario;
import rh.modelo.Sexo;

/**
 *
 * @author amarildo.ferreira
 */
@Named(value = "funcionarioCDIBean")
@SessionScoped
public class FuncionarioCDIBean implements Serializable{

    /*
    Funcionario funcionario1 = new Funcionario("Amarildo","Ferreira","Informatica",50000.00);
    Funcionario funcionario2 = new Funcionario("Abreu","Ferreira","Transportes", 150000.00);
    Funcionario funcionario3 = new Funcionario("Judite","Karipa","Logistica",70000.00);
    */
    Funcionario funcionario;
    private List<Funcionario> funcionarios;
    DepartamentoDAO dao;
    
    @PostConstruct
    public void init(){
        
        funcionario = new Funcionario();
        funcionarios  = new ArrayList<>();
        dao = new DepartamentoDAO();
        /*this.funcionarios.add(funcionario1);
        this.funcionarios.add(funcionario2);
        this.funcionarios.add(funcionario3);*/
    }
    
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
    
    
    /*
        Metodo para retornar os departamentos na comboBox
    */
    public List<SelectItem> getSelectDepartamentos(){
        
        List<SelectItem> lista = new ArrayList<>();
        
        for(Departamento d: dao.listaDepartamento()){
            lista.add(new SelectItem(d, d.getNome()));
        }
        return lista;
    }
    
    /*
        Metodo para retornar os Sexos na comboBox
    */
    public List<SelectItem> getSelectSexos(){
        
        List<SelectItem> lista = new ArrayList<>();
        
        for(Sexo s: Sexo.values()){
            lista.add(new SelectItem(s, s.getExtensao()));
        }
        return lista;
    }
    
    public List<Departamento> getListaDepartamentos(){
    
        List<Departamento> lista = new ArrayList<Departamento>();
        lista = dao.listaDepartamento();
        
        return lista;
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
