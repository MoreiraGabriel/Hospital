/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.hospital.bean;

import br.edu.uniacademia.hospital.dao.EnderecoDAO;
import br.edu.uniacademia.hospital.model.Enderecos;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author gabriel.moreira
 */
@Named
@ViewScoped
public class EnderecoBean implements Serializable {
    Enderecos enderecos = new Enderecos();

    List enderecosList = new ArrayList();

    public EnderecoBean() {
        enderecosList = new EnderecoDAO().buscarTodas();
        enderecos = new Enderecos();
    }

    public void salvar(ActionEvent actionEvent) {
        new EnderecoDAO().persistir(enderecos);
        enderecosList = new EnderecoDAO().buscarTodas();
        enderecos = new Enderecos();
    }

    public void remover(ActionEvent actionEvent) {
        new EnderecoDAO().remover(enderecos);
        enderecosList = new EnderecoDAO().buscarTodas();
        enderecos = new Enderecos();
    }
    
    public Enderecos getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Enderecos enderecos) {
        this.enderecos = enderecos;
    }

    public List<Enderecos> getAllEnderecos() {
        return enderecosList;
    }

    public void setAllEnderecos(List enderecosList) {
        this.enderecosList = enderecosList;
    }
}