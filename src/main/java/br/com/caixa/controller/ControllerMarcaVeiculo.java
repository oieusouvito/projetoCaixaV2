package br.com.caixa.controller;

import java.util.List;

import br.com.caixa.model.MarcaVeiculo;
import br.com.caixa.repository.RepositoryMarcaVeiculo;
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

@Path("/marcaveiculo")
public class ControllerMarcaVeiculo {
    
    @Inject
    EntityManager em;
    @Inject
    RepositoryMarcaVeiculo rmv;

    @GET
    @Path("/listar")
    public List<MarcaVeiculo> findAll(){
        return rmv.getAllMarcaVeiculo();
    }

    @POST
    @Path("/inserir")
    @Transactional
    public Response createVeiculo(MarcaVeiculo marcaVeiculo){
        em.persist(marcaVeiculo);
        return Response.status(201).entity(marcaVeiculo).build();
    }

    @PUT
    @Path("/{idMarcaVeiculo}")
    @Transactional
    public Response updateVeiculo(@PathParam("idMarcaVeiculo") int idMarcaVeiculo, MarcaVeiculo marcaVeiculoAtualizado) {
        MarcaVeiculo marcaVeiculo = rmv.findById(idMarcaVeiculo);
        if (marcaVeiculo == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        marcaVeiculo.setDescricao(marcaVeiculoAtualizado.getDescricao());

        em.merge(marcaVeiculo);

        return Response.ok(marcaVeiculo).build();
    }
    @DELETE
    @Path("/{idMarcaVeiculo}")
    @Transactional
    public Response deleteVeiculo(@PathParam("idMarcaVeiculo") int idMarcaVeiculo){
        MarcaVeiculo marcaVeiculo = rmv.findById(idMarcaVeiculo);
        if (marcaVeiculo == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        em.remove(marcaVeiculo);
        return Response.status(202).entity(marcaVeiculo).build();
    }
}
