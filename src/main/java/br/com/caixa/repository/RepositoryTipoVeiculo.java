package br.com.caixa.repository;

import java.util.List;

import br.com.caixa.model.TipoVeiculo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@ApplicationScoped
public class RepositoryTipoVeiculo {

    @Inject
    EntityManager em;

    public List<TipoVeiculo> getAllTipoVeiculo(){
        return em.createQuery("SELECT v FROM TipoVeiculo v", TipoVeiculo.class).getResultList();
    }

    public TipoVeiculo findById(int idTpVeiculo){
        return em.find(TipoVeiculo.class, idTpVeiculo);
    }
}
