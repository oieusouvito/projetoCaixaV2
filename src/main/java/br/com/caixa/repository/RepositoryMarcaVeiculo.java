package br.com.caixa.repository;

import java.util.List;

import br.com.caixa.model.MarcaVeiculo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@ApplicationScoped
public class RepositoryMarcaVeiculo {

    @Inject
    EntityManager em;

    public List<MarcaVeiculo> getAllMarcaVeiculo(){
        return em.createQuery("SELECT v FROM MarcaVeiculo v", MarcaVeiculo.class).getResultList();
    }

    public MarcaVeiculo findById(int idMarcaVeiculo){
        return em.find(MarcaVeiculo.class, idMarcaVeiculo);
    }
}
