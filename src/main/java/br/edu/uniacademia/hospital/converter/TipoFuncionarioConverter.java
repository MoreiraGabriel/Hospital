/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.hospital.converter;

import br.edu.uniacademia.hospital.dao.TipoFuncionarioDAO;
import br.edu.uniacademia.hospital.model.TipoFuncionario;
import java.io.Serializable;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;


/**
 *
 * @author gabriel.moreira
 */
@FacesConverter(value = "TipoFuncionarioConverter")
public class TipoFuncionarioConverter implements Converter, Serializable{
    
    private static final long serialVersionUID = 1L;
    
    public TipoFuncionario getAsObject(FacesContext fc, UIComponent uic, String value) {

        if (value == null || value.equals(""))
            return null;
        try {
            return new TipoFuncionarioDAO().findById(Long.parseLong(value));
        } catch (Exception ex) {
            throw new ConverterException("Não foi possível aplicar conversão de item com valor [" + value
                    + "] no componente [" + uic.getId() + "]", ex);
        }

    }

       public String getAsString(FacesContext fc, UIComponent uic, Object obj) {
        if (obj != null) {
            return obj.toString();
        } else {
            return null;
        }
    }


}
