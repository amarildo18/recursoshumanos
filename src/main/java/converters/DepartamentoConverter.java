/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converters;

import java.util.HashMap;
import java.util.Map;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import rh.modelo.Departamento;

/**
 *
 * @author amarildo.ferreira
 */
@FacesConverter("departamentoConverter")
public class DepartamentoConverter implements Converter{

    private static Map<String, Departamento> map = new HashMap<String, Departamento>();
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return map.get(string);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(t instanceof Departamento){
            Departamento dp = (Departamento)t;
            map.put(dp.getSigla(), dp);
            return dp.getSigla();
        }
        else{
            return "";
        }  
    }
    
}
