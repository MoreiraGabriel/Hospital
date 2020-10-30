/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.hospital.service;

import br.edu.uniacademia.hospital.dao.EnderecoDAO;
import br.edu.uniacademia.hospital.model.Enderecos;
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
public class ServicosEndereco {
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ServicosTipoEnderecosResource
     */
    public ServicosEndereco() {
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void atualizar(Enderecos e) {
        EnderecoDAO.getInstance().persistir(e);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void gravar(Enderecos e) {
        EnderecoDAO.getInstance().persistir(e);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Enderecos> buscarTodos() {
        return EnderecoDAO.getInstance().buscarTodas();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Enderecos buscar(Enderecos e) {
        return EnderecoDAO.getInstance().buscar(e.getLocalidade());
    }

    @DELETE
    @Path("{id}")
    public void remover(Enderecos e) {
        EnderecoDAO.getInstance().remover(e);
    }
}
