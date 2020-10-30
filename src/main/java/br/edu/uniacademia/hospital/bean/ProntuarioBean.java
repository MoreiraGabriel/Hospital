/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.hospital.bean;

import br.edu.uniacademia.hospital.dao.FuncionarioDAO;
import br.edu.uniacademia.hospital.dao.PacienteDAO;
import br.edu.uniacademia.hospital.dao.ProntuarioDAO;
import br.edu.uniacademia.hospital.model.Funcionarios;
import br.edu.uniacademia.hospital.model.Pacientes;
import br.edu.uniacademia.hospital.model.Prontuarios;
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
public class ProntuarioBean implements Serializable{
     Prontuarios prontuario = new Prontuarios();

    List<Prontuarios> prontuariosList = new ArrayList();
    
    Long idPaciente;
    Long idFuncionario;

    public ProntuarioBean() {
        prontuariosList = new ProntuarioDAO().buscarTodas();
        prontuario = new Prontuarios();
        idPaciente = null;
        idFuncionario = null;
    }

    public void salvar(ActionEvent actionEvent) {
        Pacientes paciente = new PacienteDAO().findById(idPaciente);
        Funcionarios funcionario = new FuncionarioDAO().findById(idFuncionario);
        prontuario.setFuncionariosidFuncionario(funcionario);
        prontuario.setPacientesidPaciente(paciente);
        new ProntuarioDAO().persistir(prontuario);
        prontuariosList = new ProntuarioDAO().buscarTodas();
        prontuario = new Prontuarios();
    }

    public void remover(ActionEvent actionEvent) {
        new ProntuarioDAO().remover(prontuario);
        prontuariosList = new ProntuarioDAO().buscarTodas();
        prontuario = new Prontuarios();
    }

    public List<Prontuarios> getAll() {
        return new ProntuarioDAO().buscarTodas();
    }

    public Prontuarios getProntuario() {
        return prontuario;
    }

    public List<Prontuarios> getProntuariosList() {
        return prontuariosList;
    } 

    public void setProntuario(Prontuarios prontuario) {
        this.prontuario = prontuario;
    }

    public void setProntuariosList(List<Prontuarios> prontuariosList) {
        this.prontuariosList = prontuariosList;
    }

    public Long getIdPaciente() {
        return idPaciente;
    }

    public Long getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public void setIdFuncionario(Long idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

}
