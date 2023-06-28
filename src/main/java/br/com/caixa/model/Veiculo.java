package br.com.caixa.model;

import java.time.Year;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data

@Entity
public class Veiculo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVeiculo;
    @ManyToOne
    @JoinColumn
    private TipoVeiculo idTpVeiculo;
    @ManyToOne
    @JoinColumn
    private MarcaVeiculo idMarcaVeiculo;
    @Column
    private String modelo;
    @Column
    private Year ano;
    @Column
    private String cor;
    @Column
    private Long quilometragem;
    @Column
    private float preco;
    @Column
    private String titulo;
    @Column
    private String descricao; 

    
}
