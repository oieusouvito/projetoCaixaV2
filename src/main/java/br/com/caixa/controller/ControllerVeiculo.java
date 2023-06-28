package br.com.caixa.controller;

import java.util.List;


import br.com.caixa.model.Veiculo;
import br.com.caixa.repository.RepositoryVeiculos;
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

@Path("/veiculo")
public class ControllerVeiculo {
    
    @Inject
    EntityManager em;
    @Inject
    RepositoryVeiculos rv;

    @GET
    @Path("/listar")
    public List<Veiculo> findAll(){
        return rv.getAllVeiculo();
    }

    @POST
    @Path("/inserir")
    @Transactional
    public Response createVeiculo(Veiculo veiculo){
        em.persist(veiculo);
        return Response.status(201).entity(veiculo).build();
    }

    @PUT
    @Path("/{idVeiculo}")
    @Transactional
    public Response updateVeiculo(@PathParam("idVeiculo") int idVeiculo, Veiculo veiculoAtualizado) {
        Veiculo veiculo = rv.findById(idVeiculo);
        if (veiculo == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        veiculo.setAno(veiculoAtualizado.getAno());
        veiculo.setCor(veiculoAtualizado.getCor());
        veiculo.setDescricao(veiculoAtualizado.getDescricao());
        veiculo.setModelo(veiculoAtualizado.getModelo());
        veiculo.setPreco(veiculoAtualizado.getPreco());
        veiculo.setQuilometragem(veiculoAtualizado.getQuilometragem());
        veiculo.setTitulo(veiculoAtualizado.getTitulo());

        em.merge(veiculo);

        return Response.ok(veiculo).build();
    }
    @DELETE
    @Path("/{idVeiculo}")
    @Transactional
    public Response deleteVeiculo(@PathParam("idVeiculo") int idVeiculo){
        Veiculo veiculo = rv.findById(idVeiculo);
        if (veiculo == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        em.remove(veiculo);
        return Response.status(202).entity(veiculo).build();
    }
}
