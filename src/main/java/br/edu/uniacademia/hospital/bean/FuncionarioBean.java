package br.edu.uniacademia.hospital.bean;

import br.edu.uniacademia.hospital.dao.EnderecoDAO;
import br.edu.uniacademia.hospital.dao.FuncionarioDAO;
import br.edu.uniacademia.hospital.dao.TipoFuncionarioDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.edu.uniacademia.hospital.model.Enderecos;
import br.edu.uniacademia.hospital.model.Funcionarios;
import br.edu.uniacademia.hospital.model.TipoFuncionario;

@Named
@ViewScoped
public class FuncionarioBean implements Serializable {   
    
    Funcionarios funcionarios = new Funcionarios();    

    List<Funcionarios> funcionariosList = new ArrayList();
    
    TipoFuncionario tpFunc = new TipoFuncionario();
    Enderecos endereco = new Enderecos();
    
    Long tipoFuncionarioId;
    Long enderecoId;
    Long idFuncionario;
    String nomeFuncionario;
            

    public FuncionarioBean() {
        funcionariosList = new FuncionarioDAO().buscarTodas();
        funcionarios = new Funcionarios();   
        tipoFuncionarioId = null;
        enderecoId = null;
        idFuncionario = null;
        nomeFuncionario = null;
    }

    public void salvar(ActionEvent actionEvent) {      
        endereco = new EnderecoDAO().findById(enderecoId);
        tpFunc =  new TipoFuncionarioDAO().findById(tipoFuncionarioId);
        
        funcionarios.setEnderecosidEnderecos(endereco);
        funcionarios.setTipoFuncionarioidtipoFuncionario(tpFunc);
        
        new FuncionarioDAO().persistir(funcionarios);
        funcionariosList = new FuncionarioDAO().buscarTodas();
        funcionarios = new Funcionarios();
    }
    
    public void remover(ActionEvent actionEvent) {;
        new FuncionarioDAO().remover(funcionarios);
        funcionariosList = new FuncionarioDAO().buscarTodas();
        funcionarios = new Funcionarios();
    }
    

    public Funcionarios getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(Funcionarios funcionarios) {
        this.funcionarios = funcionarios;
    }

    public List<Funcionarios> getAllFuncionarios() {
        return funcionariosList;
    }

    public void setAllFuncionarios(List funcionariosList) {
        this.funcionariosList = funcionariosList;
    }

    public Long getTipoFuncionarioId() {
        return tipoFuncionarioId;
    }

    public Long getEnderecoId() {
        return enderecoId;
    }

    public void setTipoFuncionarioId(Long tipoFuncionarioId) {
        this.tipoFuncionarioId = tipoFuncionarioId;
    }

    public void setEnderecoId(Long enderecoId) {
        this.enderecoId = enderecoId;
    }     
}