package br.com.caixa.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class TipoVeiculo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTpVeiculo; 
    @Column
    private String descricao;

}
