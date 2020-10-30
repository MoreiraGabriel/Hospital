/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.hospital.bean;

import br.edu.uniacademia.hospital.dao.EnderecoDAO;
import br.edu.uniacademia.hospital.dao.PacienteDAO;
import br.edu.uniacademia.hospital.model.Enderecos;
import br.edu.uniacademia.hospital.model.Pacientes;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author gabriel.moreira
 */
@Named
@ViewScoped
public class PacienteBean implements Serializable{
 
    Pacientes paciente = new Pacientes();

    List<Pacientes> pacientesList = new ArrayList();
    
    Long idEndereco;

    public PacienteBean() {
        pacientesList = new PacienteDAO().buscarTodos();
        paciente = new Pacientes();
        idEndereco = null;

    }

    public void salvar(ActionEvent actionEvent) {
       
        Enderecos endereco = new EnderecoDAO().findById(idEndereco);
        paciente.setEndereco(endereco);
        new PacienteDAO().persistir(paciente);
        pacientesList = new PacienteDAO().buscarTodos();
        paciente = new Pacientes();
    }

    public void remover(ActionEvent actionEvent) {
        new PacienteDAO().remover(paciente);
        pacientesList = new PacienteDAO().buscarTodos();
        paciente = new Pacientes();
    }

    public Pacientes getPaciente() {
        return paciente;
    }

    public Long getIdEndereco() {
        return idEndereco;
    }

    public List<Pacientes> getPacientesList() {
        return pacientesList;
    }

    public void setPaciente(Pacientes paciente) {
        this.paciente = paciente;
    }

    public void setIdEndereco(Long idEndereco) {
        this.idEndereco = idEndereco;
    }

    public void setPacientesList(List<Pacientes> pacientesList) {
        this.pacientesList = pacientesList;
    }

}
