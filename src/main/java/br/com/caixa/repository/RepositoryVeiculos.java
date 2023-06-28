package br.com.caixa.repository;

import java.util.List;

import br.com.caixa.model.Veiculo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@ApplicationScoped
public class RepositoryVeiculos {

    @Inject
    EntityManager em;

    public List<Veiculo> getAllVeiculo(){
        return em.createQuery("SELECT v FROM Veiculo v", Veiculo.class).getResultList();
    }

    public Veiculo findById(int idVeiculo){
        return em.find(Veiculo.class, idVeiculo);
    }
}
