/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.hospital.service;

import br.edu.uniacademia.hospital.dao.FuncionarioDAO;
import br.edu.uniacademia.hospital.model.Funcionarios;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author gabriel.moreira
 */
public class ServicosFuncionario {
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ServicosTipoFuncionarioResource
     */
    public ServicosFuncionario() {
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void atualizar(Funcionarios f) {
        FuncionarioDAO.getInstance().persistir(f);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void gravar(Funcionarios f) {
        FuncionarioDAO.getInstance().persistir(f);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Funcionarios> buscarTodos() {
        return FuncionarioDAO.getInstance().buscarTodas();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Funcionarios buscar(Funcionarios f) {
        return FuncionarioDAO.getInstance().buscar(f.getNomeFuncionario());
    }

    @DELETE
    @Path("{id}")
    public void remover(Funcionarios funcionario) {
        FuncionarioDAO.getInstance().remover(funcionario);
    }
}
