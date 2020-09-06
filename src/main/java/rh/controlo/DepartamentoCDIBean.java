/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rh.controlo;

import dao.DepartamentoDAO;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import rh.modelo.Departamento;

/**
 *
 * @author amarildo.ferreira
 */
@Named(value = "departamentoCDIBean")
@RequestScoped
public class DepartamentoCDIBean {

    Departamento departamento = new Departamento();
    DepartamentoDAO dao = new DepartamentoDAO();

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
    
    public String save(){
    
        dao.save(departamento);
        departamento = new Departamento();
        return "departamento";
    }
    
}
