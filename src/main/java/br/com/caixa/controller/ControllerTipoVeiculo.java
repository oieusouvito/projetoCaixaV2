package br.com.caixa.controller;

import java.util.List;

import br.com.caixa.model.TipoVeiculo;
import br.com.caixa.repository.RepositoryTipoVeiculo;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("/tipoveiculo")
public class ControllerTipoVeiculo {
    
    @Inject
    EntityManager em;
    @Inject
    RepositoryTipoVeiculo rtv;

    @GET
    @Path("/listar")
    public List<TipoVeiculo> findAll(){
        return rtv.getAllTipoVeiculo();
    }

    @POST
    @Path("/inserir")
    @Transactional
    public Response createVeiculo(TipoVeiculo tipoVeiculo){
        em.persist(tipoVeiculo);
        return Response.status(201).entity(tipoVeiculo).build();
    }

    @PUT
    @Path("/{idTpVeiculo}")
    @Transactional
    public Response updateVeiculo(@PathParam("idTpVeiculo") int idTpVeiculo, TipoVeiculo tipoVeiculoAtualizado) {
        TipoVeiculo tipoVeiculo = rtv.findById(idTpVeiculo);
        if (tipoVeiculo == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        tipoVeiculo.setDescricao(tipoVeiculoAtualizado.getDescricao());

        em.merge(tipoVeiculo);

        return Response.ok(tipoVeiculo).build();
    }
    @DELETE
    @Path("/{idTpVeiculo}")
    @Transactional
    public Response deleteVeiculo(@PathParam("idTpVeiculo") int idTpVeiculo){
        TipoVeiculo tipoVeiculo = rtv.findById(idTpVeiculo);
        if (tipoVeiculo == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        em.remove(tipoVeiculo);
        return Response.status(202).entity(tipoVeiculo).build();
    }
}
